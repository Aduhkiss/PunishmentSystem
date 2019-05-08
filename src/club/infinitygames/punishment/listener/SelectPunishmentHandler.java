package club.infinitygames.punishment.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import club.infinitygames.punishment.Punishment;

public class SelectPunishmentHandler implements Listener
{
	@EventHandler
	public void onGuiClick(InventoryClickEvent e) {
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		if(inv == null) {
			return;
		}
		if(!inv.getTitle().equals("Select Punishment")) return;
		ItemStack item;
		try {
			item = e.getCurrentItem();
		}
		catch(NullPointerException ex) {
			return;
		}
		if(item == null) return;
		if(item.getItemMeta() == null) return;
		
		PunishmentType type = null;
		
		// Get who we are doing this too
		String target = Punishment.punisher.get(player);
		
		// Also get if its a silent punishment or not
		String append = "";
		if(Punishment.silent.get(player) == true) {
			append = " -s";
		}
		
		if(item.getType() == Material.FEATHER || item.getType() == Material.DIAMOND_SWORD
				|| item.getType() == Material.TNT || item.getType() == Material.ANVIL
				|| item.getType() == Material.CACTUS || item.getType() == Material.ARROW || item.getType() == Material.BEDROCK) {
			type = PunishmentType.BAN;
		}
		
		if(item.getType() == Material.BARRIER) {
			type = PunishmentType.BLACKLIST;
		}
		
		if(item.getType() == Material.BOOK || item.getType() == Material.EYE_OF_ENDER) {
			type = PunishmentType.CHECK;
		}
		
		if(item.getType() == Material.APPLE || item.getType() == Material.BLAZE_POWDER) {
			type = PunishmentType.MUTE;
		}
		
		String iName = item.getItemMeta().getDisplayName();
		
		// We know what it is, now do the actions
		
		if(type == PunishmentType.BAN) {
			if(iName.equals("Fly Hacking")) {
				lightningIfOnline(target);
				Bukkit.dispatchCommand(player, "ban " + target + " 10d Fly Hacking" + append);
				player.closeInventory();
				return;
			}
			if(iName.equals("Kill Aura Hacking")) {
				lightningIfOnline(target);
				Bukkit.dispatchCommand(player, "ban " + target + " 30d Kill Aura/Forcefield" + append);
				player.closeInventory();
				return;
			}
			if(iName.equals("Glitching/Exploiting")) {
				lightningIfOnline(target);
				Bukkit.dispatchCommand(player, "ban " + target + " 7d Glitching/Exploiting" + append);
				player.closeInventory();
				return;
			}
			if(iName.equals("Advertising")) {
				lightningIfOnline(target);
				Bukkit.dispatchCommand(player, "ban " + target + " Advertising" + append);
				player.closeInventory();
				return;
			}
			if(iName.equals("Threats (Death/DDoS)")) {
				lightningIfOnline(target);
				Bukkit.dispatchCommand(player, "ban " + target + " Threats (DDoS/Death)" + append);
				player.closeInventory();
				return;
			}
			if(iName.equals("Impersonation (Staff/Famous)")) {
				lightningIfOnline(target);
				Bukkit.dispatchCommand(player, "ban " + target + " 2d Impersonation (Staff/Famous)" + append);
				player.closeInventory();
				return;
			}
		}
		
		if(type == PunishmentType.MUTE) {
			if(iName.equals("Spamming")) {
				Bukkit.dispatchCommand(player, "mute " + target + " 1h Spamming" + append);
				player.closeInventory();
				return;
			}
			if(iName.equals("Targeted Disrespect")) {
				Bukkit.dispatchCommand(player, "mute " + target + " 1d Targeted Disrespect" + append);
				player.closeInventory();
				return;
			}
		}
		
		if(type == PunishmentType.BLACKLIST) {
			Bukkit.dispatchCommand(player, "ipban " + target + " You have been blacklisted " + append);
			player.closeInventory();
			return;
		}
		
		if(type == PunishmentType.CHECK) {
			if(iName.equals("Show History")) {
				Bukkit.dispatchCommand(player, "hist " + target);
				player.closeInventory();
				return;
			}
			if(iName.equals("Show Alts")) {
				Bukkit.dispatchCommand(player, "dupeip " + target);
				player.closeInventory();
				return;
			}
		}
	}
	
	public void lightningIfOnline(String target) {
		if(Bukkit.getPlayer(target) != null) {
			Bukkit.getPlayer(target).getWorld().strikeLightningEffect(Bukkit.getPlayer(target).getLocation());
		}
	}
	
	public enum PunishmentType {
		BAN,
		BLACKLIST,
		MUTE,
		CHECK,
	}
}
