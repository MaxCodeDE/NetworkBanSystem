package me.MaxCode.NetworkBanSystem;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BefehleUI implements CommandExecutor {

	
	public String str = MessageManager.str;
	
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("nbsui")) {
			
			if (args.length == 0) {
				p.sendMessage(str + "NetworkBanSystem UI Befehle:");
				p.sendMessage("");
				p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Befehle:");
				p.sendMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "/nbsui spieler -> " + ChatColor.GRAY + "Zeigt Online Spieler an um zu bannen.");
			}
			
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("spieler")) {
					
					UIManager uim = new UIManager();
					uim.showOnlinePlayer(p);
					
					
				}
				
			}
			
			
			
			
			
			
		}
		
		
		
		return false;
	}

}
