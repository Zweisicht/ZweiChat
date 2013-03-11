package me.zweisicht.zweichat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZweiModChat {
	
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
			if(player.hasPermission("zweichat.MODchat") == true){
				
				//Konsolenbefehle
				if(cmd.getName().equalsIgnoreCase("q")){
					commandQ();
				}
				
				
				
				if(cmd.getName().equalsIgnoreCase("qq")){
					commandQQ();
				}
				
			}
			

		}
		}
	}
boolean checkON(String name, String msg){
	
	
boolean ifON = false;
	
	Server server = Bukkit.getServer();
	Player[] online = server.getOnlinePlayers();

	Player playerCheck;
	
	//Prüft ob er schreiben darf.
	if(server.getPlayer(name).hasPermission("zweichat.MODchat") == true){

			if(playerON.contains(name)){
			
				ifON = true;
				for (int i1=0; i1 < online.length; i1++){
					playerCheck =  server.getPlayer(online[i1].getName());
				
				if (playerCheck.hasPermission("zweichat.MODchat") == true){
					online[i1].sendMessage(ChatColor.RED + "----<MOD>"+ ChatColor.AQUA + "<" + name + "> " + msg);
				}
		
	}
	
		}
			
		
	}
	
	
	return ifON;
}
	
	void commandQQ(){

				if(playerON.contains(player.getName())){
					player.sendMessage(ChatColor.RED + "<ZweiChat><MOD> AUS");
					playerON.remove(playerON.indexOf(player.getName()));	
					return;
			}
		
			playerON.add(player.getName());
			player.sendMessage(ChatColor.RED + "<ZweiChat><MOD>"+ ChatColor.GREEN + "AN");

		}
		
	
	//Command /q
	void commandQ(){
		
		Server server = Bukkit.getServer();
		Player[] online = server.getOnlinePlayers();
		Player playerToSend;		
				for (int i=0; i < args.length; i++){
					
					text = text + " " + args[i];
					
				}
				
				if(text == ""){
					
					for (int i=0; i <  playerON.size(); i++){
						
						if(playerON.get(i) == player.getName()){
							player.sendMessage(ChatColor.RED + "<ZweiChat><MOD>"+ ChatColor.GREEN + "Der Chat ist an!");
							return;
						}
					}
					
				}else{
				
				for (int i=0; i <  online.length; i++){

					playerToSend =  server.getPlayer(online[i].getName());
					
					if (playerToSend.hasPermission("zweichat.MODchat") == true){
						playerToSend.sendMessage(ChatColor.RED + "----<MOD>"+ ChatColor.AQUA + "<" + player.getName() + ">" + text);
					}
			
			
			}
			text = "";
		}

		
	}
	
}
