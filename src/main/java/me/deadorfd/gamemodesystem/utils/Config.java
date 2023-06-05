package me.deadorfd.gamemodesystem.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import me.deadorfd.gamemodesystem.GamemodeSystem;

/**
 * @Author DeaDorfd
 * @Project gamemodesystem
 * @Package me.deadorfd.gamemodesystem.utils
 * @Date 03.06.2023
 * @Time 19:33:49
 */
public class Config {

	public static FileConfiguration cfg = GamemodeSystem.getInstance().getConfig();

	public static String getMessage(String path) {
		return cfg.getString("Messages." + path).replaceAll("&", "§");
	}

	public static String getMessagePlayer(String path, String playername) {
		return getMessage(path).replaceAll("%player%", playername);
	}

	public static String getGamemodeMessage(String gamemode) {
		return getMessage("GamemodeSet").replaceAll("%gamemode%", getString("Gamemodes." + gamemode));
	}

	public static String getGamemodeOtherPlayerMessage(String gamemode, Player target) {
		return getMessage("GamemodeSetOther").replaceAll("%gamemode%", getString("Gamemodes." + gamemode))
				.replaceAll("%player%", target.getName());
	}

	public static String getPermission(String path) {
		return cfg.getString("Permissions." + path);
	}

	public static String getString(String path) {
		return cfg.getString(path).replaceAll("&", "§");
	}

	public static boolean getBoolean(String path) {
		return cfg.getBoolean(path);
	}

}
