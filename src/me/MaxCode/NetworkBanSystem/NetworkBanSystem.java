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
		
		this.getCommand("nbs").setExecutor(new Befehle());
		
		
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
}
