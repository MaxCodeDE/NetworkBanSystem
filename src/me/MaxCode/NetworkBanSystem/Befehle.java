package me.MaxCode.NetworkBanSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Befehle implements CommandExecutor {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "NetworkBanSystem" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("nbs")) {
			if (args.length == 0) {
				p.sendMessage(str + "NetworkBanSystem Befehle:");
				p.sendMessage("");
				p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Befehle:");
				p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "/nbs ban -> " + ChatColor.GRAY + "Bannt einen Spieler.");
				p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "/nbs info <name> -> " + ChatColor.GRAY + "Zeigt Info über Spieler.");
			}
		
		
		
		if (args.length >= 2) {
			
			if (args[0].equalsIgnoreCase("ban")) {
			String spielername = args[1].toLowerCase();
			if (args[1].equalsIgnoreCase(spielername)) {
				
				BanManager bm = new BanManager();
				bm.banPlayer(spielername, null, null);
				
				p.sendMessage(str + "Spieler " + spielername + " wurde gebannt!");
				
			}
			}
		}
		
		if (args.length == 2) {
			
			if (args[0].equalsIgnoreCase("info")) {
			String spielername = args[1].toLowerCase();
			if (args[1].equalsIgnoreCase(spielername)) {
				
				BanManager bm = new BanManager();
				
				if (bm.getGrund(spielername) == null) {
					p.sendMessage(str + "Es wurde kein Spieler mit dem Namen " + ChatColor.BOLD + spielername + ChatColor.GRAY + " gebannt");
				} else {
					p.sendMessage(str + "Spieler " + ChatColor.BOLD + spielername + ChatColor.GRAY + " wurde aus folgenden Grund gebannt:");
					p.sendMessage(ChatColor.GRAY + bm.getGrund(spielername));
				}
				
			}
			}
		}
		
		}
		
		
		return false;
	}

}
