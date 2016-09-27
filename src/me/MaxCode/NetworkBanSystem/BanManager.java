package me.MaxCode.NetworkBanSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BanManager {

	
	public void banPlayer(String spielername, String grund, Integer zeit) {
		
		Player p = Bukkit.getPlayer(spielername);
		
		if (grund == null) {
			grund = "Kein Grund angegben.";
		}
		if (zeit == null) {
			zeit = 0;
		}
		
		
		
		try {
			PreparedStatement ps = DBManager.getConnection().prepareStatement("INSERT INTO BannedPlayers (UUID, Spielername, Grund, Zeit) VALUES (?, ?, ?, ?)");
			ps.setString(1, p.getUniqueId().toString());
			ps.setString(2, p.getName());
			ps.setString(3, grund);
			ps.setInt(4, zeit);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		p.kickPlayer(grund);
		
		
	}
	
	
	public String getGrund(String spielername) {
		
		Player p = Bukkit.getPlayer(spielername);
		
		try {
			PreparedStatement ps = DBManager.getConnection().prepareStatement("SELECT Grund FROM BannedPlayers WHERE UUID = ?");
			ps.setString(1, p.getUniqueId().toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				return rs.getString("Grund");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Keine Grund vorhanden!";
	}
	
	
}
