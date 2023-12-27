package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;
import me.minegamersg.api.MySQLAPI;

public class ChatListener implements Listener{
	

	
	@SuppressWarnings({ "deprecation" })
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) throws SQLException {
		Player p = e.getPlayer();
		e.setCancelled(true);
		for(Player all : Bukkit.getOnlinePlayers()) {
			if(Main.getSGAPI().Players.contains(p)) {
				if(Games.getGameState() == GameState.Lobby) {
					all.sendMessage("§8[§e" + MySQLAPI.getBounty(p) + "§8]§4" + "§c" + JoinListener.getPlayerNumber(p) + "§8|§r" + p.getDisplayName() + "§8:§" + MySQLAPI.getChatColor(p) + "" + e.getMessage());
				}else if(Games.getGameState() != GameState.Lobby) {
					all.sendMessage("§8[§e" + MySQLAPI.getBounty(p) + "§8]§4" + "§c" + JoinListener.getPlayerNumber(p) + "§8|§r" + p.getDisplayName() + "§8:§" + MySQLAPI.getChatColor(p) + "" + e.getMessage());
				}
			}
		}
		if(Main.getSGAPI().Spectators.contains(p)) {
			e.setCancelled(true);
			for(Player specs : Bukkit.getOnlinePlayers()) {
				if(Main.getSGAPI().Spectators.contains(specs)) {
					specs.sendMessage("§8[§e"+ MySQLAPI.getBounty(p)+ "§8] §4SPEC§8:" + p.getDisplayName() + "§8: §" + MySQLAPI.getChatColor(p) + "" + e.getMessage());
					
				}
			}
			
		}

	}
}
