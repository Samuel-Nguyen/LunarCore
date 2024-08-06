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

    if (id == 0) {
      
    }

    for (var excel : GameData.getAvatarExcelMap().values()) {
      // Get avatar id
      GameAvatar avatar = target.getAvatarById(excel.getAvatarID());
      args.sendMessage(target.getName() + " get the id of characters: " + avatar.getAvatarId());
    }
  }

}
