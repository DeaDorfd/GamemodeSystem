package me.deadorfd.gamemodesystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.deadorfd.gamemodesystem.commands.Gamemode_Command;
import me.deadorfd.gamemodesystem.listeners.Join_Listener;

/**
 * @Author DeaDorfd
 * @Project gamemodesystem
 * @Package me.deadorfd.gamemodesystem
 * @Date 03.06.2023
 * @Time 17:44:21
 */
public class GamemodeSystem extends JavaPlugin {

	private static GamemodeSystem instance;

	@Override
	public void onEnable() {
		instance = this;
		getDataFolder().mkdir();
		saveDefaultConfig();
		getCommand("Gamemode").setExecutor(new Gamemode_Command());
		getCommand("Gamemode").setTabCompleter(new Gamemode_Command());
		Bukkit.getPluginManager().registerEvents(new Join_Listener(), instance);
	}

	public static GamemodeSystem getInstance() {
		return instance;
	}
}