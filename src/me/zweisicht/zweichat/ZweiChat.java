package me.zweisicht.zweichat;


import org.bukkit.plugin.java.JavaPlugin;

public class ZweiChat extends JavaPlugin{
	
	ZweiListener ChatListener;
	ZweiModChat ModChat = new ZweiModChat();
	ZweiVipChat VIPChat = new ZweiVipChat();
	ZweiIpBlocker IpBlocker = new ZweiIpBlocker();
	BanCheck bancheck = new BanCheck();
	

	
	@Override
	public void onDisable(){
		System.out.println("ZweiChat deaktiviert.");
	}
	
	@Override
	public void onEnable(){
		System.out.println("ZweiChat aktiviert.");

		//Commands abfangen und auslagern 
		
		getCommand("q").setExecutor(new ComExec(this, ModChat, VIPChat, IpBlocker, bancheck));
		getCommand("qq").setExecutor(new ComExec(this, ModChat, VIPChat, IpBlocker, bancheck));
		getCommand("isbanned").setExecutor(new ComExec(this, ModChat, VIPChat, IpBlocker, bancheck));



		
		//Events laden
		registerEvent();
		
	}
	
	
	
	private void registerEvent(){
		//Event-Teil		
		ChatListener = new ZweiListener(this);
	}



}
