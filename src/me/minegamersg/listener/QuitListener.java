package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.SBAPI;
import me.minegamersg.commands.Vote;

public class QuitListener implements Listener{
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void playerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage(p.getDisplayName() + " §6has left");
		if(Main.getSGAPI().Players.equals(p)) {
			try {
				MySQLAPI.removePlayingPlayers();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		for(Player all : Bukkit.getOnlinePlayers()) {
			SBAPI.scoreBoardManager(all);
		}
		if(Games.getGameState() != GameState.Lobby) {
			if(Main.getSGAPI().Players.equals(p)) {
				Main.getSGAPI().Players.remove(p);
				p.getLocation().getWorld().strikeLightning(p.getLocation());
				Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aOnly §8[§6" + Main.getSGAPI().Players.size() + "§8]§a tributes remain!");
				for(Player all : Bukkit.getOnlinePlayers()) {
					SBAPI.scoreBoardManager(all);
				}
			}else if(Main.getSGAPI().Spectators.equals(p)) {
				Main.getSGAPI().Spectators.remove(p);
				try {
					MySQLAPI.removeWatchingPlayers();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(Player all : Bukkit.getOnlinePlayers()) {
					SBAPI.scoreBoardManager(all);
				}
			}
		}else if(Games.getGameState() == GameState.Lobby){
			if(Main.getSGAPI().Players.equals(p)) {
				Main.getSGAPI().Players.remove(p);
				try {
					MySQLAPI.removePlayingPlayers();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for(Player all : Bukkit.getOnlinePlayers()) {
					SBAPI.scoreBoardManager(all);
				}
			}else {
				Main.getSGAPI().Players.remove(p);
				for(Player all : Bukkit.getOnlinePlayers()) {
					SBAPI.scoreBoardManager(all);
				}
			}
		}
		if(Vote.usingvote.equals(p)) {
			Vote.usingvote.add(p);
		}
	}

}
