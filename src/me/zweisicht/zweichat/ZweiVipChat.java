package me.zweisicht.zweichat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZweiVipChat {

	Player player;
	World world;
	
	String text = "";
	
	CommandSender sender;
	Command cmd;
	String label;
	String[] args;
	
	ArrayList<String> playerON = new ArrayList<String>();
	
void checkPlayerCommands(CommandSender sender, Command cmd, String label, String[] args){
		
		this.sender = sender;
		this.cmd = cmd;
		this.label = label;
		this.args = args;
		
		
		if(sender instanceof Player){
			player = (Player) sender;
			world = player.getWorld();
				
			
			if(sender instanceof Player){
				player = (Player) sender;
				world = player.getWorld();
					
			//Prüft ob er schreiben darf.
			if(player.hasPermission("zweichat.VIPchat") == true){
				
				//Konsolenbefehle	
				if(cmd.getName().equalsIgnoreCase("vchat")){
					commandChat();
				}
				
			}
			

		}
		}
	}
boolean checkON(String name, String msg){
	
	
	
	boolean ifON = false;
	
	Server server = Bukkit.getServer();
	Player[] online = server.getOnlinePlayers();
	Player player;
	Player playerCheck;
	player = server.getPlayer(name);
	//Prüft ob er schreiben darf.
	

	if(player.hasPermission("zweichat.VIPchat") == true){

			if(playerON.contains(name)){
			
				ifON = true;
				for (int i1=0; i1 < online.length; i1++){
					playerCheck = server.getPlayer(online[i1].getName());
				if (playerCheck.hasPermission("zweichat.VIPchat") == true){
					online[i1].sendMessage(ChatColor.GOLD + "<VIP>"+ ChatColor.WHITE + "<" + name + "> " + msg);
				}
		
	}
	
		}
			
		
	}
	
	
	return ifON;
}
	
	void commandChat(){

				if(playerON.contains(player.getName())){
					player.sendMessage(ChatColor.GOLD + "<ZweiChat><VIP> AUS");
					playerON.remove(playerON.indexOf(player.getName()));	
					return;
			}
		
			playerON.add(player.getName());
			player.sendMessage(ChatColor.GOLD + "<ZweiChat><VIP>"+ ChatColor.GREEN + "AN");

		}
		

	
}
