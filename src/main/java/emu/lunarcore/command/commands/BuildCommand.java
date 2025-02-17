package emu.lunarcore.command.commands;

import java.io.FileReader;
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

        String message = parseBuildData(args);
        args.getSender()
                .sendMessage(message);

    }

    private String parseBuildData(CommandArgs args) {
        String message = "";
        int total = 0;
        String name = args.get(0).toLowerCase();
        String buildName = args.get(1).equals("") ? "normal" : args.get(1).toLowerCase();
        Boolean build = false;

        try (FileReader fileReader = new FileReader(LunarCore.getConfig().getDataDir() + "/BuildDetails.json")) {
            List<BuildInformation> buildInformation = JsonUtils.loadToList(fileReader, BuildInformation.class);
            for (BuildInformation buildInfo : buildInformation) {
                switch (name) {
                    case "all", "a" -> {
                        build = generateBuild(args, buildInfo, args.getTarget(), buildName, build);
                        total++;
                    }
                    default -> {
                        if (!buildInfo.getAvatarName().equals(name)) {
                            continue;
                        }
                        build = generateBuild(args, buildInfo, args.getTarget(), buildName, build);
                        // Get the character name
                        message = "Give " + buildInfo.getFullName() + " relics for " + buildName.toUpperCase()
                                + " build.";

                        if (!build) {
                            message = "There is no " + buildName.toUpperCase() + " for " + buildInfo.getFullName()
                                    + ".";
                        }
                    }
                }
            }
            if (total > 0) {
                message = "Give " + total + " characters relics for BEST build.";
            }
        } catch (Exception e) {
            // TODO: handle exception
            args.sendMessage("Something wrong!!");
        }

        return message;
    }

    public Boolean generateBuild(CommandArgs args, BuildInformation buildInfo, Player player, String buildName,
            Boolean build) {
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
            if (!buildDetail.getBuildName().equals(buildName)) {
                continue;
            }

            build = true;

            // Set avatar eidolons
            avatar.setRank(buildDetail.getEidolon());

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
                    if (subAffixData.getCnt() <= 0)
                        continue;

                    var subAffix = GameData.getRelicSubAffixExcel(
                            relic.getExcel().getRelicExcel().getSubAffixGroup(), subAffixData.getAffixId());
                    if (subAffix == null)
                        continue;

                    int count = Math.min(subAffixData.getCnt(), 6);

                    relic.getSubAffixes().add(new GameItemSubAffix(subAffix, count));
                }

                // Apply sub stat upgrades to the relic
                int upgrades = relic.getMaxNormalSubAffixCount() - relic.getCurrentSubAffixCount();
                if (upgrades > 0) {
                    relic.addSubAffixes(upgrades);
                }

                if (args.hasFlag("-max")) {
                    if (relic.getSubAffixes() == null) {
                        relic.resetSubAffixes();
                    }

                    relic.getSubAffixes().forEach(subAffix -> subAffix.setStep(subAffix.getCount() * 2));
                }

                // Add to player
                player.getInventory().addItem(relic);
                avatar.equipItem(relic);
            }
        }
        // Save
        avatar.save();

        return true;
    }
}
