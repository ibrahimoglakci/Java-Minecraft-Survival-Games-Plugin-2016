package me.minegamersg.listener;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;

public class DamageListener implements Listener{
	
	@EventHandler
	public void acikma(FoodLevelChangeEvent e) {
		if(Games.getGameState() == GameState.Lobby) {
			e.setCancelled(true);
		}
		
		
	}
	
	@EventHandler
	public void onDamageEvent(EntityDamageEvent e) {
		Entity victim = e.getEntity();
		 if(Main.getSGAPI().Spectators.contains(victim)) {
				e.setCancelled(true);
		 }
		 if(Games.getGameState() == GameState.Lobby || Games.getGameState() == GameState.PreGame || Games.getGameState() == GameState.PreDeathMatch || Games.getGameState() == GameState.EndGame || Games.getGameState() == GameState.Cleanup ){
			 e.setCancelled(true);
		 }
	}
	
	
	@EventHandler
	public void onPlayerHurt(EntityDamageByEntityEvent e) {
		Entity localEntity1 = e.getDamager();
	    Entity localEntity2 = e.getEntity();
	    if(Main.getSGAPI().Spectators.contains(localEntity1)) {
	    	e.setCancelled(true);
	    }
	    if(Main.getSGAPI().Spectators.contains(localEntity2)) {
	    	e.setCancelled(true);
	    }
	    
	    if(Games.getGameState() == GameState.Lobby || Games.getGameState() == GameState.PreGame || Games.getGameState() == GameState.PreDeathMatch || Games.getGameState() == GameState.EndGame || Games.getGameState() == GameState.Cleanup ){
			 e.setCancelled(true);
		 }

	    
	}

}
