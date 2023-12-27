package me.minegamersg.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;

import me.minegamersg.Main.Main;

public class BoatDamageListener implements Listener{
	
	
	@EventHandler
	  public void onBoatDamage(VehicleDamageEvent paramVehicleDamageEvent)
	  {
	    if ((paramVehicleDamageEvent.getAttacker() instanceof Player))
	    {
	      Player localPlayer = (Player)paramVehicleDamageEvent.getAttacker();
	      if (Main.getSGAPI().Spectators.contains(localPlayer)) {
	        paramVehicleDamageEvent.setCancelled(true);
	      }
	    }
	  }

}
