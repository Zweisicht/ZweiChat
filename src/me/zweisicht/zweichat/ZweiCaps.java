package me.zweisicht.zweichat;

import java.util.regex.Pattern;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ZweiCaps {
	
boolean ZweiCapsCheck(String msg, Player player){

    int max = msg.length();
	int isUpper = 0;
	
	for(int i = 0; i < msg.length();i++){
		
		
		if(player.hasPermission("zweichat.modchat") == false){
			
			if(Pattern.matches( "[A-Z]*", String.valueOf(msg.charAt(i)))){
			isUpper =isUpper +1;
		
		}
			
		}
		
		
		
	}


	if((isUpper * 100 / max) <= 51){
		return false;
	}else{
		player.sendMessage(ChatColor.RED +  "<ZweiCAPS> Deine Nachricht enthält zu viele Grossbuchstaben.");
		return true;
	}
	
}



}
