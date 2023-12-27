package me.minegamersg.api;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.minegamersg.Main.Main;

public class SpectatorManager {
	
	
	
	@SuppressWarnings("deprecation")
	public static void addSpectator(Player p) {
		
		if(Main.getSGAPI().Players.contains(p)) {
			if(!Main.getSGAPI().Spectators.contains(p)) {
				Main.getSGAPI().Players.remove(p);
				
				Main.getSGAPI().Spectators.add(p);
			}else {
				
				Main.getSGAPI().Players.remove(p);
				Main.getSGAPI().Spectators.remove(p);
				Main.getSGAPI().Spectators.add(p);
			}
			
		}else {
			
			Main.getSGAPI().Players.remove(p);
			Main.getSGAPI().Spectators.remove(p);
			Main.getSGAPI().Spectators.add(p);
		}
		for(Player all : Bukkit.getOnlinePlayers()) {
			SBAPI.scoreBoardManager(all);
			SBAPI.scoreBoardManager(p);
			
			
		}
		
		p.getInventory().clear();
		
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1), true);
		p.setFoodLevel(20);
		p.setHealth(20);
		p.spigot().respawn();
		p.setAllowFlight(true);
		p.setGameMode(GameMode.ADVENTURE);
		p.setFlying(true);
		p.setFireTicks(0);
		p.getLocation().getWorld().strikeLightning(p.getLocation());
		p.teleport(p.getLocation().add(0, 3, 0));
		
		for(Player all : Bukkit.getOnlinePlayers()) {
			all.hidePlayer(p);
			
		}
		SBAPI.scoreBoardManager((Player)p);;
		p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1), true);
		p.getLocation().getWorld().strikeLightning(p.getLocation());
		
		
		
	}

}
