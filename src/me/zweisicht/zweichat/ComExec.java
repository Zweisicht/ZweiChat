package me.zweisicht.zweichat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ComExec implements CommandExecutor {

  private ZweiChat plugin;
  private ZweiModChat modChat;
  private ZweiVipChat VIPChat;
  private ZweiIpBlocker IpBlocker;
  private BanCheck bancheck;

   ComExec(ZweiChat plugin, ZweiModChat modChat, ZweiVipChat VIPChat, ZweiIpBlocker IpBlocker, BanCheck bancheck)
  {
    this.plugin = plugin;
    this.modChat = modChat;
    this.VIPChat = VIPChat;
    this.IpBlocker = IpBlocker;
    this.bancheck = bancheck;

  }







public boolean onCommand(CommandSender sender, Command cmd, String label, String[] params)
  {
    if ((sender instanceof Player)) {
    	
      Player player = (Player)sender;

      //Befehl auswerten und übergeben
      switch (cmd.getName()) {
      
      	case "q":
      		if (player.hasPermission("ZweiChat.MODchat"))
      		{
      			modChat.commandQ(player, params);
      		}
      		else
    	    {
      			player.sendMessage("Du hast nicht die nötigen Rechte!");
    	    }

    	    return true;
  
      	case "qq":
      		if (player.hasPermission("ZweiChat.MODchat"))
      		{
      			modChat.commandQQ(player);
      		}
      		else
      		{
      			player.sendMessage("Du hast nicht die nötigen Rechte!");
      		}

      		return true;
      		
      	case "isbanned":

      			bancheck.IsBanned(player, params);
      			
      		
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