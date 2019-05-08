package club.infinitygames.punishment.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import net.angusbeefgaming.api.inventory.ItemUtil;

public class SelectPunishment {
	public static Inventory main() {
		
		Inventory inv = Bukkit.createInventory(null, 36, "Select Punishment");
		
		if(TogglePunishments.AllowBans) {
			inv.setItem(0, ItemUtil.nameItem(Material.FEATHER, "Fly Hacking"));
			inv.setItem(1, ItemUtil.nameItem(Material.DIAMOND_SWORD, "Kill Aura Hacking"));
			inv.setItem(2, ItemUtil.nameItem(Material.TNT, "Glitching/Exploiting"));
			inv.setItem(3, ItemUtil.nameItem(Material.ANVIL, "Advertising"));
			inv.setItem(4, ItemUtil.nameItem(Material.CACTUS, "Threats (Death/DDoS)"));
			inv.setItem(5, ItemUtil.nameItem(Material.ARROW, "Impersonation (Staff/Famous)"));
			inv.setItem(34, ItemUtil.nameItem(Material.BEDROCK, "Permanent Ban"));
		}

		if(TogglePunishments.AllowMutes) {
			inv.setItem(9, ItemUtil.nameItem(Material.APPLE, "Spamming"));
			inv.setItem(10, ItemUtil.nameItem(Material.BLAZE_POWDER, "Targeted Disrespect"));
		}
		
		if(TogglePunishments.AllowBlacklists) {
			inv.setItem(35, ItemUtil.nameItem(Material.BARRIER, "Blacklist"));
		}
		
		inv.setItem(7, ItemUtil.nameItem(Material.BOOK, "Show History"));
		inv.setItem(8, ItemUtil.nameItem(Material.EYE_OF_ENDER, "Show Alts"));
		
		return inv;
	}
}
