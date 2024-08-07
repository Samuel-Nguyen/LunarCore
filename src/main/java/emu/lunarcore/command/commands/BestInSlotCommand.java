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
import emu.lunarcore.game.inventory.tabs.InventoryTabType;
import emu.lunarcore.game.player.Player;
import emu.lunarcore.util.Utils;

import java.util.ArrayList;
import java.util.List;

@Command(label = "bestinslot", aliases = {
    "bis" }, permission = "player.give", requireTarget = true, desc = "/bis [character id]. Gives the targeted player items.")
public class BestInSlotCommand implements CommandHandler {

  @Override
  public void execute(CommandArgs args) {
    Player target = args.getTarget();
    int id = Utils.parseSafeInt(args.get(0));

    if (id != 0) {
      args.sendMessage("Input id " + id);

      for (var excel : GameData.getAvatarExcelMap().values()) {
        // Get avatar id
        GameAvatar avatar = target.getAvatarById(id);
        args.sendMessage(target.getName() + " get the id " + id + " of characters: " + avatar.getAvatarId());
      }
    }

    // Sanity check materials
    var inventory = args.getTarget().getInventory();
    if (inventory.getTab(InventoryTabType.RELIC).getAvailableCapacity() <= 0
        || inventory.getTab(InventoryTabType.EQUIPMENT).getAvailableCapacity() <= 0) {
      args.sendMessage("Error: The targeted player does not has enough space in their relic/lightcone inventory");
      return;
    }

  }

}
