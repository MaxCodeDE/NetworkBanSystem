package me.MaxCode.NetworkBanSystem;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UIManager {

	public String str = ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "NetworkBanSystem" + ChatColor.DARK_GRAY + "] " + ChatColor.GRAY;
	
	public void showOnlinePlayer(Player p) {
		
		Inventory inv = Bukkit.createInventory(p, 36, str + "Spieler");
		Integer i = 0;
		
		for (Player op : Bukkit.getOnlinePlayers()) {
			
			ItemStack bannedPlayer = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			ItemMeta bannedPlayerMeta = bannedPlayer.getItemMeta();
			bannedPlayerMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + op.getDisplayName());
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "UUID: " + ChatColor.GRAY + op.getUniqueId());
			lore.add(ChatColor.GRAY + " ");
			lore.add(ChatColor.GRAY + "Klicke auf den Spieler um ihn zu bannen.");
			bannedPlayerMeta.setLore(lore);
			bannedPlayer.setItemMeta(bannedPlayerMeta);
			inv.setItem(i, bannedPlayer);
			i++;
			
		}
		
		p.openInventory(inv);
		
		
	}
	
	
	
	
}
