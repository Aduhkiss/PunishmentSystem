package club.infinitygames.punishment.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import club.infinitygames.punishment.menu.TogglePunishments;
import net.md_5.bungee.api.ChatColor;

public class ManagePunishCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must run this command in-game!");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("infinitygames.punishmentadmin")) {
			player.sendMessage(ChatColor.RED + "If YOU had access to this, that would be bad...");
			return false;
		}
		
		player.openInventory(TogglePunishments.main());
		return true;
	}

}
