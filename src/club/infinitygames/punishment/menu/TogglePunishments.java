package club.infinitygames.punishment.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

import net.angusbeefgaming.api.inventory.ItemUtil;

public class TogglePunishments {
	
	public static boolean AllowBans;
	public static boolean AllowMutes;
	public static boolean AllowBlacklists;
	
	public static Inventory main() {
		Inventory inv = Bukkit.createInventory(null, 9, "Enable/Disable Punishments");
		
		if(AllowBans) {
			inv.setItem(2, ItemUtil.nameItem(Material.EMERALD_BLOCK, "Allow Bans (ON)"));
		} else {
			inv.setItem(2, ItemUtil.nameItem(Material.REDSTONE_BLOCK, "Allow Bans (OFF)"));
		}
		
		if(AllowMutes) {
			inv.setItem(4, ItemUtil.nameItem(Material.EMERALD_BLOCK, "Allow Mutes (ON)"));
		} else {
			inv.setItem(4, ItemUtil.nameItem(Material.REDSTONE_BLOCK, "Allow Mutes (OFF)"));
		}
		
		if(AllowBlacklists) {
			inv.setItem(6, ItemUtil.nameItem(Material.EMERALD_BLOCK, "Allow Blacklists (ON)"));
		} else {
			inv.setItem(6, ItemUtil.nameItem(Material.REDSTONE_BLOCK, "Allow Blacklists (OFF)"));
		}
		
		return inv;
	}
	
	public static void init() {
		AllowBans = true;
		AllowMutes = true;
		AllowBlacklists = true;
	}
}
