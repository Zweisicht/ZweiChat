package me.zweisicht.zweichat;

import org.bukkit.entity.Player;

public class BanCheck {
	
	

	public void IsBanned(Player player, String[] params) {
		
		//Nur bei Eingabe von genau einem Parameter
		if (params.length == 1) {
			
		 //Alle gebannten Spieler auslesen und dann prüfen ob vorhanden
			if (player.getServer().getBannedPlayers().contains(player.getServer().getOfflinePlayer(params[0])))
			{
		
				player.sendMessage("Der Spieler "+params[0]+ " ist gebannt");
			}
			else {
			
			player.sendMessage("Der Spieler "+params[0]+ " ist nicht gebannt");
			}

		}	
	}
}
