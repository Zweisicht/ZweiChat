package me.zweisicht.zweichat;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCheck {

	public static boolean IsBanned(CommandSender sender, Command cmd, String[] args) {
		
	Server server = sender.getServer();
			
			if(sender instanceof Player){
				if(cmd.getName().equalsIgnoreCase("isBanned")){
					
					if(args.length >=1){
						
						if(server.getBannedPlayers().toString().toLowerCase().indexOf("[name=" + args[0].toLowerCase() + "]") >= 0 ){
							
							sender.sendMessage("Der Spieler: " + args[0] + " wurde gebannt.");
							
						}else{
					sender.sendMessage("Der Spieler: " + args[0] + " wurde nicht gebannt.");
					
					
				}
				}
		
					}
					
				return true;
			}
				
			
			return false;
		}	
	
	
}
