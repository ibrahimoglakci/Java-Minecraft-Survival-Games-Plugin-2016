package me.minegamersg.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.minegamersg.Main.Main;

public class BlockPlaceListener implements Listener{
	
	
	@EventHandler
	public void blockBreakListener(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if(Main.getSGAPI().Spectators.contains(p)) {
			e.setCancelled(true);
		}else {
			if(p.hasPermission("break.bypass")) {
				e.setCancelled(false);
			}else {
				e.setCancelled(true);
				
			}
		}
	}

}
