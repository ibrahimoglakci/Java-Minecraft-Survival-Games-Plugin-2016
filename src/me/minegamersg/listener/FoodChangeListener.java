package me.minegamersg.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;

public class FoodChangeListener implements Listener{
	
	
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		if(Main.getSGAPI().Spectators.contains(e.getEntity())) {
			e.setCancelled(true);
			e.setFoodLevel(20);
		}else {
			e.setCancelled(false);
		}
		if(Games.getGameState() == GameState.Lobby) {
			e.setCancelled(true);
			e.setFoodLevel(20);
		}else {
			e.setCancelled(false);
		}
		
	}

}
