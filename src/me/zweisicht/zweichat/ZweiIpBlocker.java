package me.zweisicht.zweichat;

import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ZweiIpBlocker {

	boolean checkTextAtIp(String name, String msg){
		
		boolean contains = Pattern.compile("(([0-9]{1,3}.){3})([0-9]{1,3}):([0-9]{1,4})", Pattern.CASE_INSENSITIVE ).matcher(msg).find();
		Player[] online = Bukkit.getServer().getOnlinePlayers();
		Player playerMOD;
		
		if(contains == true && Bukkit.getPlayer(name).hasPermission("zweichat.MODchat") == false){
			
			System.out.println("<ZweiIpBlocker>" +  " Der Spieler " + name + " wollte folgenden Text ausgeben: " + msg);
			
		for (int i=0; i < online.length; i++){
			
		playerMOD =  Bukkit.getServer().getPlayer(online[i].getName());
		
		if (playerMOD.hasPermission("zweichat.MODchat") == true){
			playerMOD.sendMessage(ChatColor.RED + "<ZweiIpBlocker>"+ ChatColor.AQUA + " Der Spieler " + name + " wollte folgenden Text ausgeben: " + msg);
		}
			
		}
			
			Bukkit.getPlayer(name).kickPlayer("Du wurdest gekickt Grund: Werbung!");
		}else{
			contains = false;
		}
		
		

		
		
		return contains;   
	}
	
}
