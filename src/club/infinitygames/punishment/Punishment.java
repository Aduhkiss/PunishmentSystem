package club.infinitygames.punishment;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import club.infinitygames.punishment.command.ManagePunishCommand;
import club.infinitygames.punishment.command.PunishCommand;
import club.infinitygames.punishment.listener.SelectPunishmentHandler;
import club.infinitygames.punishment.listener.TogglePunishmentsHandler;
import club.infinitygames.punishment.menu.TogglePunishments;

public class Punishment extends JavaPlugin {
	
	public static Map<Player, String> punisher = new HashMap<Player, String>();
	public static Map<Player, Boolean> silent = new HashMap<Player, Boolean>();
	
	@Override
	public void onEnable() {
		
		getCommand("punish").setExecutor(new PunishCommand());
		getCommand("managepunish").setExecutor(new ManagePunishCommand());
		Bukkit.getPluginManager().registerEvents(new SelectPunishmentHandler(),	this);
		Bukkit.getPluginManager().registerEvents(new TogglePunishmentsHandler(), this);
		
		TogglePunishments.init();
	}

}
