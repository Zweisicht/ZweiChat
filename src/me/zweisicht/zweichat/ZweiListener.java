package me.zweisicht.zweichat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ZweiListener implements Listener{
	
	
	public ZweiListener(ZweiChat plugin){
		
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);		
		
	}

	
	@EventHandler
	public void onPlayerWrite(AsyncPlayerChatEvent event){
	
	

	boolean MOD_Check = plugin.ModChat.checkON(event.getPlayer().getName(), event.getMessage());
	boolean VIP_Check = plugin.VIPChat.checkON(event.getPlayer().getName(), event.getMessage());
	boolean ipBlocker = plugin.IpBlocker.checkTextAtIp(event.getPlayer().getName(), event.getMessage());	
	
	
	
	if(MOD_Check == true || VIP_Check == true || ipBlocker == true) event.setCancelled(true);

		if(event.isCancelled() == false){
		//Prüft ob 51% vom Text kleingeschrieben ist.
		event.setCancelled(caps.ZweiCapsCheck(event.getMessage(), event.getPlayer()));
			
		}

		
	}
	
	private ZweiChat plugin;
	private ZweiCaps caps = new ZweiCaps();
}
