package me.MaxCode.NetworkBanSystem;

import org.bukkit.plugin.java.JavaPlugin;

public class NetworkBanSystem extends JavaPlugin {

	@Override
	public void onEnable() {
		
		FileManager fm = new FileManager();
		fm.checkFile();
		fm.load();
		
		DBManager.connect();
		DBManager.checkAndCreateTable();
		
		
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
}
