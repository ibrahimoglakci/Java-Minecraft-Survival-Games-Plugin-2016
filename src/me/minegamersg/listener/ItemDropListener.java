package me.minegamersg.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;

public class ItemDropListener implements Listener{
	
	@EventHandler
	public void onItemDropEvent(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if(Main.getSGAPI().Spectators.contains(p)) {
			e.setCancelled(true);
		}else {
			if(Games.getGameState() == GameState.PreDeathMatch || Games.getGameState() == GameState.PreGame) {
				e.setCancelled(true);
			}else {
				e.setCancelled(false);
			}
		}
	}
	

}
