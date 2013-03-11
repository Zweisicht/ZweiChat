package me.zweisicht.zweichat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComExec
  implements CommandExecutor
{

  private ZweiChat plugin;
  private ZweiModChat modChat;
  private ZweiVipChat VIPChat;
  private ZweiIpBlocker IpBlocker;

   ComExec(ZweiChat plugin, ZweiModChat modChat, ZweiVipChat VIPChat, ZweiIpBlocker IpBlocker)
  {
    this.plugin = plugin;
    this.modChat = modChat;
    this.VIPChat = VIPChat;
    this.IpBlocker = IpBlocker;
  }

  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] params)
  {
    if ((sender instanceof Player)) {
      Player player = (Player)sender;

      
      //Befehl für q Chat
      if (cmd.getName().equalsIgnoreCase("q")) {
        if (player.hasPermission("ZweiChat.mod"))
        {
          this.modChat.commandQ(player, params);
        }
        else
        {
          player.sendMessage("Du hast nicht die nötigen Rechte!");
        }

        return true;
      }

    }
    else
    {
      sender.sendMessage("You must be a player!");
      return false;
    }

    return false;
  }
}