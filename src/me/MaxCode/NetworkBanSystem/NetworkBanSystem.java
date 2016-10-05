package me.MaxCode.NetworkBanSystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
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
		this.getCommand("nbsui").setExecutor(new BefehleUI());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new UIEvents(), this);
		
		
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	
}
