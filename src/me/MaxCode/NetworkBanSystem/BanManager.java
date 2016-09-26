package me.MaxCode.NetworkBanSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.entity.Player;

public class BanManager {

	
	public void banPlayer(Player p, String grund, Integer zeit) {
		
		
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
	
	
	
}
