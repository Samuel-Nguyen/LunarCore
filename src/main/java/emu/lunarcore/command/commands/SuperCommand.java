package emu.lunarcore.command.commands;

import emu.lunarcore.command.Command;
import emu.lunarcore.command.CommandArgs;
import emu.lunarcore.command.CommandHandler;
import emu.lunarcore.data.GameData;
import emu.lunarcore.data.excel.ItemExcel;
import emu.lunarcore.game.avatar.GameAvatar;
import emu.lunarcore.game.enums.ItemMainType;
import emu.lunarcore.game.enums.ItemSubType;
import emu.lunarcore.game.inventory.GameItem;
import emu.lunarcore.game.player.Player;

import java.util.ArrayList;
import java.util.List;

@Command(label = "super", aliases = {
    "super" }, permission = "player.give", requireTarget = true, desc = "/super. Gives the targeted player items.")
public class SuperCommand implements CommandHandler {

  @Override
  public void execute(CommandArgs args) {
    Player target = args.getTarget();
    target.setLevel(80);

    List<GameItem> items = new ArrayList<>();

    // Character/Relic/Lightcone upgrade materials
    for (ItemExcel excel : GameData.getItemExcelMap().values()) {
      int purpose = excel.getPurposeType();
      if ((purpose >= 1 && purpose <= 7) || purpose == 10) {
        items.add(new GameItem(excel, 10_000));
      }
    }

    // Credits
    items.add(new GameItem(2, 100_000_000));

    // Add to target's inventory
    target.getInventory().addItems(items, true);

    // Send message
    args.sendMessage("Giving " + target.getName() + " " + items.size() + " items");

    // Make sure we dont go over the inventory limit
    var tab = args.getTarget().getInventory().getTabByItemType(ItemMainType.Equipment);
    if (tab.getSize() >= tab.getMaxCapacity()) {
      args.sendMessage(target.getName() + " has too many of this item type");
      return;
    }

    // Get lightcones
    int[] freelc = { 20000, 20001, 20002, 20003, 20004, 20005, 20006, 20007, 20008, 20009, 20010, 20011, 20012, 20013,
        20014, 20015, 20016, 20017, 20018, 20019, 20020, 21000, 21001, 21002, 21003, 21004, 21005, 21006, 21007,
        21008, 21009, 21010, 21011, 21012, 21013, 21014, 21015, 21016, 21017, 21018, 21019, 21020, 21021, 21022,
        21023, 21024, 21025, 21026, 21027, 21028, 21029, 21030, 21031, 21032, 21033, 21034, 21035, 21036, 21037,
        21038, 21039, 21040, 21041, 21042, 21043, 21044, 21045, 21046, 22000, 22001, 22002, 24000, 24001, 24002,
        24003, 24004 };

    List<GameItem> lightcones = GameData.getItemExcelMap().values()
        .stream()
        .filter(ItemExcel::isEquipment)
        .map(excel -> {
          var item = new GameItem(excel, 1);
          item.setPromotion(6);
          item.setLevel(80);
          for (int ele : freelc) {
            if (item.getItemId() == ele) {
              item.setRank(5);
            }
          }
          return item;
        })
        .toList();

    // Add to target's inventory
    target.getInventory().addItems(lightcones, true);

    // Send message
    args.sendMessage("Giving " + target.getName() + " " + lightcones.size() + " light cones");

    // All avatars
    int[] fourstar = { 1002, 1008, 1009, 1013, 1103, 1105, 1106, 1108, 1109, 1110, 1111, 1201, 1202, 1206, 1207, 1210,
        1214, 1215, 1301, 1312 };

    for (var excel : GameData.getAvatarExcelMap().values()) {
      // Get avatar id
      GameAvatar avatar = target.getAvatarById(excel.getAvatarID());

      // Add avatar
      if (avatar == null) {
        // Add avatar
        avatar = new GameAvatar(excel);
        avatar.setPromotion(6);
        avatar.setLevel(80);

        for (int ele : fourstar) {
          if (avatar.getAvatarId() == ele) {
            avatar.setRank(6);
          }
        }

        for (int pointId : avatar.getExcel().getSkillTreeIds()) {
          var skillTree = GameData.getAvatarSkillTreeExcel(pointId, 1);
          if (skillTree == null)
            continue;

          int minLevel = skillTree.isDefaultUnlock() ? 1 : 0;
          int pointLevel = Math.max(Math.min(8, skillTree.getMaxLevel()), minLevel);

          avatar.getSkills().put(pointId, pointLevel);
        }
        avatar.setRewards(0b00101010);

        target.getAvatars().addAvatar(avatar);
      }
    }

    // Send message
    args.sendMessage("Giving " + target.getName() + " all avatars");

    // Add head icons - Duplicates are handled automatically
    for (var excel : GameData.getPlayerIconExcelMap().values()) {
      target.getUnlocks().addHeadIcon(excel.getId());
    }

    // Add chat bubbles - Duplicates are handled automatically
    for (var excel : GameData.getChatBubbleExcelMap().values()) {
      target.getUnlocks().addChatBubble(excel.getId());
    }

    // Add phone themes - Duplicates are handled automatically
    for (var excel : GameData.getPhoneThemeExcelMap().values()) {
      target.getUnlocks().addPhoneTheme(excel.getId());
    }

    // Send message
    args.sendMessage("Added all icons/chat bubbles/phone themes to " + target.getName());

    // Get consumables
    List<GameItem> consumables = GameData.getItemExcelMap().values()
        .stream()
        .filter(excel -> excel.getItemSubType() == ItemSubType.Food)
        .map(excel -> new GameItem(excel, 1000))
        .toList();

    // Add to target's inventory
    target.getInventory().addItems(consumables, true);

    // Send message
    args.sendMessage("Added all consumables to " + target.getName());
  }

}
