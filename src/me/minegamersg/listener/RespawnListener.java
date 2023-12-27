package me.minegamersg.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.minegamersg.Main.Main;

public class RespawnListener implements Listener{
	
	
	
	@EventHandler
	  public void onRespawn(PlayerRespawnEvent paramPlayerRespawnEvent)
	  {
	      Player localPlayer = paramPlayerRespawnEvent.getPlayer();
	      if (Main.getSGAPI().Spectators.contains(localPlayer))
	      { 
	        paramPlayerRespawnEvent.setRespawnLocation(paramPlayerRespawnEvent.getPlayer().getLocation());
	     
	      }
	    
	  }

}
