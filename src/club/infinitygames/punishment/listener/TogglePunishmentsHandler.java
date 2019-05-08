package club.infinitygames.punishment.listener;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import club.infinitygames.punishment.menu.TogglePunishments;
import net.md_5.bungee.api.ChatColor;

public class TogglePunishmentsHandler implements Listener {
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		if(inv == null) {
			return;
		}
		if(!inv.getTitle().equals("Enable/Disable Punishments")) return;
		ItemStack item;
		try {
			item = e.getCurrentItem();
		}
		catch(NullPointerException ex) {
			return;
		}
		if(item == null) return;
		if(item.getItemMeta() == null) return;
		
		if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Allow Bans (ON)")) {
			TogglePunishments.AllowBans = false;
			player.closeInventory();
			player.openInventory(TogglePunishments.main());
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
			player.sendMessage(ChatColor.RED + "You have disallowed player bans!");
			return;
		}
		if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Allow Bans (OFF)")) {
			TogglePunishments.AllowBans = true;
			player.closeInventory();
			player.openInventory(TogglePunishments.main());
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
			player.sendMessage(ChatColor.GREEN + "You have allowed player bans!");
			return;
		}
		
		if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Allow Mutes (ON)")) {
			TogglePunishments.AllowMutes = false;
			player.closeInventory();
			player.openInventory(TogglePunishments.main());
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
			player.sendMessage(ChatColor.RED + "You have disallowed player mutes!");
			return;
		}
		if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Allow Mutes (OFF)")) {
			TogglePunishments.AllowMutes = true;
			player.closeInventory();
			player.openInventory(TogglePunishments.main());
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
			player.sendMessage(ChatColor.GREEN + "You have allowed player mutes!");
			return;
		}
		
		if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Allow Blacklists (ON)")) {
			TogglePunishments.AllowBlacklists = false;
			player.closeInventory();
			player.openInventory(TogglePunishments.main());
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
			player.sendMessage(ChatColor.RED + "You have disallowed player blacklists!");
			return;
		}
		if(item.getItemMeta().getDisplayName().equalsIgnoreCase("Allow Blacklists (OFF)")) {
			TogglePunishments.AllowBlacklists = true;
			player.closeInventory();
			player.openInventory(TogglePunishments.main());
			player.playSound(player.getLocation(), Sound.ENTITY_ENDERDRAGON_GROWL, 1f, 1f);
			player.sendMessage(ChatColor.GREEN + "You have allowed player blacklists!");
			return;
		}
	}

}
