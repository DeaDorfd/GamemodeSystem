package me.deadorfd.gamemodesystem.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.deadorfd.gamemodesystem.utils.Check;
import me.deadorfd.gamemodesystem.utils.Config;

/**
 * @Author DeaDorfd
 * @Project gamemodesystem
 * @Package me.deadorfd.gamemodesystem.listeners
 * @Date 04.06.2023
 * @Time 10:22:33
 */
public class Join_Listener implements Listener {

	@EventHandler
	private static void JoinListener(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (!Config.getBoolean("Check for Updates")) return;
		if (Check.isUpdated()) return;
		if (player.hasPermission(Config.getPermission("Admin"))) {
			player.sendMessage(Config.getMessage("Notify on Join").replaceAll("%link%",
					"https://www.spigotmc.org/resources/" + Check.getResourceID() + "/"));
		}
	}
}