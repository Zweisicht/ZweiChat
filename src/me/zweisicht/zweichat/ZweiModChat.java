package me.zweisicht.zweichat;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ZweiModChat {
	

	private Player player;

	String text = "";
	
	ArrayList<String> playerON = new ArrayList<String>();
	
	

	boolean checkON(String name, String msg){
	
		boolean ifON = false;
	
		Server server = Bukkit.getServer();

		Player playerCheck;
	
		//Prüft ob er schreiben darf.
		if(server.getPlayer(name).hasPermission("zweichat.MODchat") == true){

			if(playerON.contains(name)){
			
				ifON = true;
				for (Player player: server.getOnlinePlayers()){
					
					playerCheck =  server.getPlayer(player.getName());
				
					if (playerCheck.hasPermission("zweichat.MODchat") == true){
					player.sendMessage(ChatColor.RED + "----<MOD>"+ ChatColor.AQUA + "<" + name + "> " + msg);
					}
		
				}
	
			}
				
		}
	
		return ifON;
	}
	//Command /qq
	void commandQQ(Player player){

		if(playerON.contains(player.getName())){
			
			player.sendMessage(ChatColor.RED + "<ZweiChat><MOD> AUS");
			playerON.remove(playerON.indexOf(player.getName()));	
			return;
		}
		
		playerON.add(player.getName());
		player.sendMessage(ChatColor.RED + "<ZweiChat><MOD>"+ ChatColor.GREEN + "AN");

	}
		
	
	//Command /q

	public void commandQ(Player sender, String[] params){
		
		//Parameter abfangen und in textvariable schreiben
	    for (int i = 0; i < params.length; i++)
	    {
	    	this.text = (this.text + " " + params[i]);
	    }
	    //Solange Text nicht leer ist
	    if (!this.text.equals("")){
	    	
	    	//An jedes Playerobjekt in der Rückgabe von getOnlinePlayers Nachricht schicken
	        for (Player player : sender.getServer().getOnlinePlayers())
	        {
	        	if (player.hasPermission("ZweiChat.MODchat"))
	        	{
	        		player.sendMessage(ChatColor.RED + "----<MOD>" + ChatColor.AQUA + "<" + sender.getName() + ">" + this.text);
	        	}

	        }

	    }

	    this.text = "";
	}
	
}
