package me.MaxCode.NetworkBanSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	public static Connection con;
	
	
	
	public static void connect() {
		
		String host = FileManager.dbConfig.getString("DB." + "Host");
		String port = FileManager.dbConfig.getString("DB." + "Port");
		String database = FileManager.dbConfig.getString("DB." + "Database");
		String username = FileManager.dbConfig.getString("DB." + "Username");
		String password = FileManager.dbConfig.getString("DB." + "Password");
		
		
		if (!isConnected()) {
			
			try {
				con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
				System.out.println("[NetworkBanSystem] Verbindng zur MySQL aufgebaut!");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
	
	public static void disconnect() {
		
		if (isConnected()) {
			
			try {
				con.close();
				System.out.println("[NetworkBanSystem] Verbindng zur MySQL geschlossen!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void checkAndCreateTable() {
		if (!tableExists()) {
			createTable();
		}
	}
	
	public static void createTable() {
		try {
			PreparedStatement ps = DBManager.getConnection().prepareStatement("CREATE TABLE BannedPlayers (UUID VARCHAR(100), Spielername VARCHAR(100), Grund VARCHAR(100), Zeit INT)");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean tableExists() {
		try {
			PreparedStatement ps = DBManager.getConnection().prepareStatement("SELECT * FROM BannedPlayers");
			ResultSet rs = ps.executeQuery();
			rs.next();
			return true;
		} catch (SQLException e) {
			return false;
		}
		
		
	}
	
	
	public static boolean isConnected() {
		return (con == null ? false : true);
	
	}
	
	
	public static Connection getConnection() {
		return con;
	}
	
	
	
	
}
