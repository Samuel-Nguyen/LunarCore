package emu.lunarcore.command.commands;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import emu.lunarcore.data.custom.BuildInformation;
import emu.lunarcore.LunarCore;
import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.inventory.GameItem;
import emu.lunarcore.game.inventory.GameItemSubAffix;
import emu.lunarcore.game.inventory.tabs.InventoryTabType;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.util.JsonUtils;

@Command(label = "build", aliases = {
        "b" }, permission = "player.give", requireTarget = true, desc = "/build [character id]")
public class BuildCommand implements CommandHandler {

    public void execute(CommandArgs args) {
        // Sanity check materials
        var inventory = args.getTarget().getInventory();
        if (inventory.getTab(InventoryTabType.RELIC).getAvailableCapacity() <= 0
                || inventory.getTab(InventoryTabType.EQUIPMENT).getAvailableCapacity() <= 0) {
            args.sendMessage("Error: The targeted player does not has enough space in their relic/lightcone inventory");
            return;
        }

        String type = args.get(0).toLowerCase();

        switch (type) {
            case "all", "a" -> {
                int count = parseAllData(args);
                args.getSender()
                        .sendMessage("Give " + count + " characters relics for BEST build.");
            }
            default -> {
                String message = parseUserData(args);
                args.getSender()
                        .sendMessage(message);
            }
        }
    }

    private String getBuildData() {
        return LunarCore.getConfig().getDataDir() + "/BuildDetails.json";
    }

    @SuppressWarnings("deprecation")
    private int parseAllData(CommandArgs args) {
        int count = 0;
        var player = args.getTarget();
        String flag = "best";

        try (FileReader fileReader = new FileReader(getBuildData())) {
            List<BuildInformation> buildInformation = JsonUtils.loadToList(fileReader, BuildInformation.class);
            for (BuildInformation buildInfo : buildInformation) {
                int id = buildInfo.getAvatarId();
                GameAvatar avatar = player.getAvatarById(id);

                if (avatar != null) {
                    // Delete old relics/equips
                    List<GameItem> unequipList = new ArrayList<>();

                    // Force unequip all items
                    int[] slots = avatar.getEquips().keySet().toIntArray();
                    for (int slot : slots) {
                        var item = avatar.unequipItem(slot);
                        if (item != null) {
                            unequipList.add(item);
                        }
                    }
                    player.getInventory().removeItems(unequipList);
                } else {
                    // Validate avatar excel (In case we are using an older version of the server)
                    var excel = GameData.getAvatarExcelMap().get(id);

                    // Create avatar
                    avatar = new GameAvatar(excel);

                    // Gives the avatar to player
                    player.addAvatar(avatar);
                }

                // Set avatar basic data
                avatar.setLevel(80);
                avatar.setExp(0);
                avatar.setRank(buildInfo.getEidolon());
                avatar.setPromotion(6);
                avatar.setRewards(0b00101010);

                // Set avatar skills
                for (int pointId : avatar.getExcel().getSkillTreeIds()) {
                    var skillTree = GameData.getAvatarSkillTreeExcel(pointId, 1);
                    if (skillTree == null)
                        continue;

                    int minLevel = skillTree.isDefaultUnlock() ? 1 : 0;
                    int pointLevel = Math.max(Math.min(buildInfo.getSkill(), skillTree.getMaxLevel()), minLevel);

                    avatar.getSkills().put(pointId, pointLevel);
                }

                // Get build information
                var buildList = buildInfo.getBuildList();
                for (var buildDetail : buildList) {
                    if (!buildDetail.getBuildName().equals(flag)) {
                        continue;
                    }

                    // Set equipment
                    var equipmentData = buildDetail.getEquipment();
                    if (equipmentData != null) {
                        // Validate equipment excel (In case we are using an older version of the
                        // server)
                        var excel = GameData.getItemExcelMap().get(equipmentData.getTid());
                        if (excel != null) {
                            // Create equipment
                            var equipment = new GameItem(excel);

                            // Set equipment props
                            equipment.setLevel(80);
                            equipment.setExp(0);
                            equipment.setPromotion(6);
                            equipment.setRank(equipmentData.getImposition());

                            // Add to player
                            player.getInventory().addItem(equipment);
                            avatar.equipItem(equipment);
                        }
                    }

                    // Set relics
                    for (var relicData : buildDetail.getRelicList()) {
                        // Validate relic excel (In case we are using an older version of the server)
                        var excel = GameData.getItemExcelMap().get(relicData.getTid());
                        if (excel == null)
                            continue;

                        // Create relic
                        var relic = new GameItem(excel);

                        // Set relic props
                        relic.setLevel(15);
                        relic.setExp(0);
                        relic.setMainAffix(relicData.getMainAffixId());
                        relic.resetSubAffixes();

                        for (var subAffixData : relicData.getSubAffixList()) {
                            var subAffix = new GameItemSubAffix();
                            subAffix.setCount(subAffixData.getCnt());
                            // Max-steps the affix
                            subAffix.setStep(subAffixData.getCnt() * 2);

                            // Hacky way to set id field since its private
                            try {
                                Field field = subAffix.getClass().getDeclaredField("id");
                                field.setAccessible(true);
                                field.setInt(subAffix, subAffixData.getAffixId());
                            } catch (Exception e) {
                                // TODO handle
                            }

                            relic.getSubAffixes().add(subAffix);
                        }

                        // Add to player
                        player.getInventory().addItem(relic);
                        avatar.equipItem(relic);
                    }
                }

                // Save
                avatar.save();
                // Increment count
                count++;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return count;
    }

    @SuppressWarnings("deprecation")
    private String parseUserData(CommandArgs args) {
        String message = "";
        var player = args.getTarget();
        String name = args.get(0).toLowerCase();
        String buildName = args.get(1).equals("") ? "best" : args.get(1).toLowerCase();
        Boolean build = false;

        try (FileReader fileReader = new FileReader(getBuildData())) {
            List<BuildInformation> buildInformation = JsonUtils.loadToList(fileReader, BuildInformation.class);
            for (BuildInformation buildInfo : buildInformation) {
                if (name.equals(buildInfo.getAvatarName())) {
                    int id = buildInfo.getAvatarId();
                    GameAvatar avatar = player.getAvatarById(id);

                    if (avatar != null) {
                        // Delete old relics/equips
                        List<GameItem> unequipList = new ArrayList<>();

                        // Force unequip all items
                        int[] slots = avatar.getEquips().keySet().toIntArray();
                        for (int slot : slots) {
                            var item = avatar.unequipItem(slot);
                            if (item != null) {
                                unequipList.add(item);
                            }
                        }
                        player.getInventory().removeItems(unequipList);
                    } else {
                        // Validate avatar excel (In case we are using an older version of the server)
                        var excel = GameData.getAvatarExcelMap().get(id);

                        // Create avatar
                        avatar = new GameAvatar(excel);

                        // Gives the avatar to player
                        player.addAvatar(avatar);
                    }

                    // Set avatar basic data
                    avatar.setLevel(80);
                    avatar.setExp(0);
                    avatar.setRank(buildInfo.getEidolon());
                    avatar.setPromotion(6);
                    avatar.setRewards(0b00101010);

                    // Set avatar skills
                    for (int pointId : avatar.getExcel().getSkillTreeIds()) {
                        var skillTree = GameData.getAvatarSkillTreeExcel(pointId, 1);
                        if (skillTree == null)
                            continue;

                        int minLevel = skillTree.isDefaultUnlock() ? 1 : 0;
                        int pointLevel = Math.max(Math.min(buildInfo.getSkill(), skillTree.getMaxLevel()),
                                minLevel);

                        avatar.getSkills().put(pointId, pointLevel);
                    }

                    // Get build information
                    var buildList = buildInfo.getBuildList();
                    for (var buildDetail : buildList) {
                        if (!buildDetail.getBuildName().equals(buildName)) {
                            continue;
                        }

                        // Got the build
                        build = true;
                        // Set equipment
                        var equipmentData = buildDetail.getEquipment();
                        if (equipmentData != null) {
                            // Validate equipment excel (In case we are using an older version of the
                            // server)
                            var excel = GameData.getItemExcelMap().get(equipmentData.getTid());
                            if (excel != null) {
                                // Create equipment
                                var equipment = new GameItem(excel);

                                // Set equipment props
                                equipment.setLevel(80);
                                equipment.setExp(0);
                                equipment.setPromotion(6);
                                equipment.setRank(equipmentData.getImposition());

                                // Add to player
                                player.getInventory().addItem(equipment);
                                avatar.equipItem(equipment);
                            }
                        }

                        // Set relics
                        for (var relicData : buildDetail.getRelicList()) {
                            // Validate relic excel (In case we are using an older version of the server)
                            var excel = GameData.getItemExcelMap().get(relicData.getTid());
                            if (excel == null)
                                continue;

                            // Create relic
                            var relic = new GameItem(excel);

                            // Set relic props
                            relic.setLevel(15);
                            relic.setExp(0);
                            relic.setMainAffix(relicData.getMainAffixId());
                            relic.resetSubAffixes();

                            for (var subAffixData : relicData.getSubAffixList()) {
                                var subAffix = new GameItemSubAffix();
                                subAffix.setCount(subAffixData.getCnt());
                                // Max-steps the affix
                                subAffix.setStep(subAffixData.getCnt() * 2);

                                // Hacky way to set id field since its private
                                try {
                                    Field field = subAffix.getClass().getDeclaredField("id");
                                    field.setAccessible(true);
                                    field.setInt(subAffix, subAffixData.getAffixId());
                                } catch (Exception e) {
                                    // TODO handle
                                    args.sendMessage("Something wrong!!");
                                }

                                relic.getSubAffixes().add(subAffix);
                            }

                            // Add to player
                            player.getInventory().addItem(relic);
                            avatar.equipItem(relic);
                        }
                    }

                    // Save
                    avatar.save();
                    // Get the character name
                    message = "Give " + buildInfo.getFullName() + " relics for " + buildName.toUpperCase() + " build.";

                    if (!build) {
                        message = "There is no " + buildName.toUpperCase() + " for " + buildInfo.getFullName() + ".";
                    }
                } else {
                    message = "No build data for " + name;
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
            args.sendMessage("Something wrong!!");
        }

        return message;
    }
}
