package me.minegamersg.listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;
import me.minegamersg.commands.Build;

public class BlockBreakListener implements Listener{
	
	
	
	@EventHandler
	public void blockBreakListener(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if(Games.getGameState() == GameState.Lobby) {
			if(Build.buildmode == true){
				if(p.hasPermission("asd.as")) {
					e.setCancelled(false);
				}
			}else if(Build.buildmode == false) {
				if(p.isOp() || p.hasPermission("asdasd.asd") || !p.isOp() || !p.hasPermission("asdasd.asd")) {
					e.setCancelled(true);
				}
			}
		}else if(Games.getGameState() != GameState.Lobby){
			if(Main.getSGAPI().Spectators.contains(p)) {
				e.setCancelled(true);
				
			}else {
				if(e.getBlock().getType() != Material.LEAVES) {
						e.setCancelled(true);
				}else {
					e.setCancelled(false);
				}
				
			}
		}
		
	}

}
