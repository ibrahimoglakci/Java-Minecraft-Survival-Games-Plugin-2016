package me.minegamersg.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;

public class MoveListener implements Listener{
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	List<String> runners = new ArrayList();
	 
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "SurvivalGames Maps");
		File f = new File(data, File.separator + e.getPlayer().getWorld().getName() + ".yml");
		FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
		if(!Main.getSGAPI().Spectators.contains(e.getPlayer())) {
			if(Main.getSGAPI().Players.contains(e.getPlayer())) {
				if(Games.getGameState() == GameState.PreGame || Games.getGameState() == GameState.PreDeathMatch)  {
					if (e.getTo().getBlockX() != e.getFrom().getBlockX()) {
					       e.getPlayer().teleport(e.getFrom());
					 }
					   if (e.getTo().getBlockZ() != e.getFrom().getBlockZ()) {
					       e.getPlayer().teleport(e.getFrom());
					   }
				}
			}
			if(Games.getGameState() == GameState.DeathMatch) {
				Player localPlayer = e.getPlayer();
			      if (Main.getSGAPI().Players.contains(localPlayer))
			      {
			        Location localLocation = new Location(Bukkit.getWorld(e.getPlayer().getWorld().getName()), locationData.getDouble(e.getPlayer().getWorld().getName() + ".deatmatch-center.X"), locationData.getDouble(e.getPlayer().getWorld().getName() + ".deatmatch-center.Y"), locationData.getDouble(e.getPlayer().getWorld().getName() + ".deatmatch-center.Z"));
			        
			        if ((localPlayer.getLocation().distance(localLocation) > Main.getSGAPI().getConfig().getInt("DeathMatch-Lightning-Around")) && 
			          (!this.runners.contains(localPlayer.getName())))
			        {
			          this.runners.add(localPlayer.getName());
			          localPlayer.getWorld().strikeLightning(localPlayer.getLocation());
			          delayLightning(localPlayer.getName());
			        }
			      }
			}
		}
	}
	
	
	private void delayLightning(final String paramString)
	  {
	    Bukkit.getScheduler().runTaskLater(Main.getSGAPI(), new Runnable()
	    {
	      public void run()
	      {
	        runners.remove(paramString);
	      }
	    }, 60L);
	  }
	

}
