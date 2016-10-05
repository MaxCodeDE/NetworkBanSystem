package me.MaxCode.NetworkBanSystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType.SlotType;

public class UIEvents implements Listener {

	public String str = MessageManager.str;
	
	@EventHandler
	public void ItemKlickVoid(InventoryClickEvent e) {
		
		Bukkit.broadcastMessage("TEST");
		
		if (e.getInventory().getName().equals(str + "Spieler")) {
			Bukkit.broadcastMessage("TEST2");
		if (e.getSlotType() != SlotType.OUTSIDE) {
			
			Player p = (Player) e.getWhoClicked();
			String spielername= p.getDisplayName();
			p.closeInventory();
			
			BanManager bm = new BanManager();
			bm.banPlayer(spielername, null, null);
			
			p.sendMessage(str + "Spieler " + spielername + " wurde gebannt!");
			
		}
		}
	}
	
	
	
	
	
}
