package club.infinitygames.punishment.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import club.infinitygames.punishment.Punishment;
import club.infinitygames.punishment.menu.SelectPunishment;
import net.md_5.bungee.api.ChatColor;

public class PunishCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "You must be a player to run this command!");
			return false;
		}
		
		Player player = (Player) sender;
		
		if(!player.hasPermission("infinitygames.punish")) {
			player.sendMessage(ChatColor.RED + "Haha! You think im going to let you do that!");
			return false;
		}
		if(args == null || args.length == 0) {
			player.sendMessage(ChatColor.RED + "Usage: /punish <Player> [-S]");
			return false;
		}
		
		String target = args[0];
		
		if(args.length >= 2 && args[1].equalsIgnoreCase("-S")) {
			// Silent
			Punishment.punisher.put(player, target);
			Punishment.silent.put(player, true);
			player.openInventory(SelectPunishment.main());
			return true;
		} else {
			// Normal
			Punishment.punisher.put(player, target);
			Punishment.silent.put(player, false);
			player.openInventory(SelectPunishment.main());
			return true;
		}
	}

}
