package me.MaxCode.NetworkBanSystem;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {

	public static FileConfiguration dbConfig;

	public void load() {

		File file = new File("plugins/NetworkBanSystem/Datenbank.yml");
		dbConfig = YamlConfiguration.loadConfiguration(file);

	}

	public void checkFile() {
		File file = new File("plugins/NetworkBanSystem/Datenbank.yml");
		dbConfig = YamlConfiguration.loadConfiguration(file);
		
		if (!file.exists()) {
			dbConfig.set("DB." + "Host", "localhost");
			dbConfig.set("DB." + "Port", "3306");
			dbConfig.set("DB." + "Database", "wirtschaftssystem");
			dbConfig.set("DB." + "Username", "root");
			dbConfig.set("DB." + "Password", "");
			try {
				dbConfig.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
