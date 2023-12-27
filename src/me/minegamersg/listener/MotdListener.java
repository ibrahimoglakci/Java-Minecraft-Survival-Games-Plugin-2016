package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.api.Games;

public class MotdListener implements Listener{
	
	
	@EventHandler
	public void setMotd(ServerListPingEvent e) {
		if(Games.getGameState() == GameState.Lobby) {
			e.setMotd("§aLOBBY");	
		}
		if(Games.getGameState() == GameState.PreGame) {
			e.setMotd("§6PREGAME");
		}
		if(Games.getGameState() == GameState.LiveGame) {
			e.setMotd("§cLIVEGAME");
		}
		if(Games.getGameState() == GameState.PreDeathMatch) {
			e.setMotd("§5PREDEATHMATCH");
		}
		if(Games.getGameState() == GameState.DeathMatch) {
			e.setMotd("§4DEATHMATCH");
		}
		if(Games.getGameState() == GameState.EndGame) {
			e.setMotd("§9ENDGAME");
		}
		if(Games.getGameState() == GameState.Cleanup) {
			e.setMotd("§3CLEANUP");
		}
		
	}

}
