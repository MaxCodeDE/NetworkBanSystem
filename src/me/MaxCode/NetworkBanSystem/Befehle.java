package me.MaxCode.NetworkBanSystem;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Befehle implements CommandExecutor {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "NetworkBanSystem" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("nbs")) {
			p.sendMessage(str + "NetworkBanSystem Befehle:");
			p.sendMessage("");
			p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Befehle:");
			p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "/nbs ban -> " + ChatColor.GRAY + "Bannt einen Spieler.");
			p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "/nbs info <name> -> " + ChatColor.GRAY + "Zeigt Info über Spieler.");
		}
		
		
		
		
		if (cmd.getName().equalsIgnoreCase("nbs") && args.length >= 2) {
			
			if (args[0].equalsIgnoreCase("ban")) {
			String spielername = args[1].toLowerCase();
			if (args[1].equalsIgnoreCase(spielername)) {
				
				//Integer zeit = Integer.valueOf(args[3].toLowerCase());
				// TO-DO Timeban
				
				BanManager bm = new BanManager();
				bm.banPlayer(Bukkit.getPlayer(spielername), args[2].toLowerCase(), null);
				
				p.sendMessage(str + "Spieler " + spielername + " wurde gebannt!");
				
			}
			}
		}
		
		
		return false;
	}

}
