package me.zweisicht.zweichat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ZweiChat extends JavaPlugin{
	

	
	@Override
	public void onDisable(){
		System.out.println("ZweiChat deaktiviert.");
	}
	
	@Override
	public void onEnable(){
		System.out.println("ZweiChat aktiviert.");
		
		//Events laden
		registerEvent();
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		boolean succeed = false;

			VIPChat.checkPlayerCommands(sender, cmd, label, args);
			ModChat.checkPlayerCommands(sender, cmd, label, args);
			BanCheck.IsBanned(sender, cmd, args);
			
		return succeed;
	}
	
private void registerEvent(){//Event-Teil
		
		ChatListener = new ZweiListener(this);
		
	}

@SuppressWarnings("unused")
private ZweiListener ChatListener;
ZweiModChat ModChat = new ZweiModChat();
ZweiVipChat VIPChat = new ZweiVipChat();
ZweiIpBlocker IpBlocker = new ZweiIpBlocker();
}
