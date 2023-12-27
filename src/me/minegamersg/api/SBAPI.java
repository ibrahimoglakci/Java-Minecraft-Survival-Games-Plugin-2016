package me.minegamersg.api;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;

public class SBAPI {
	
	public static void scoreBoardManager(Player p)
	  {
	    Date now = new Date();
	    SimpleDateFormat format = new SimpleDateFormat("dd MMM yyyy", new Locale("en"));
	    Date saat = new Date();
	    SimpleDateFormat saatformat = new SimpleDateFormat("hh:mm a z");
	    
		SimpleScoreboard scoreboard = new SimpleScoreboard(" §f"); 
		try {
			if(MySQLAPI.getSidebar(p).equalsIgnoreCase("2015")){
				scoreboard.add("§7§l» §fYou", 15);
			    scoreboard.add(p.getName(), 14);
			    scoreboard.add(" §f", 13);
			    scoreboard.add("§7§l» §fTime", 12);
			    scoreboard.add("§b" + format.format(now), 11);
			    scoreboard.add("§b" + saatformat.format(saat), 10);
			    scoreboard.add("§c§e§r ", 9);
			    scoreboard.add("§7§l» §fServer", 8);
			    scoreboard.add("§3EU: §b" + Integer.valueOf(Main.getSGAPI().getConfig().getInt("Server-Name-Number")), 7);
			    scoreboard.add("§8§9§e ", 6);
			    scoreboard.add("§7§l» §fPlayers", 5);
			    scoreboard.add("§3Playing: §b" + Main.getSGAPI().Players.size(), 4);
			    if(Games.getGameState() != GameState.Lobby) {
			    	scoreboard.add("§3Watching: §b" + Main.getSGAPI().Spectators.size(), 3);
			    }
			    scoreboard.add("§d§lMineGamer.Net", 2);
			    
			 
			    scoreboard.build();
			   
			   
			    scoreboard.send(p);
			    
			    
			    
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getSGAPI(), new Runnable()
			    {
			      public void run()
			      {
			    	  scoreBoardManager(p);
			      }
			    }, 1200L);
			  }
			else if(MySQLAPI.getSidebar(p).equalsIgnoreCase("2014")){
			    scoreboard.add("§6§l» Time", 12);
			    scoreboard.add("§b" + format.format(now), 11);
			    scoreboard.add("§b" + saatformat.format(saat), 10);
			    scoreboard.add("§c§e§r ", 9);
			    scoreboard.add("§6§l» Server", 8);
			    scoreboard.add("§3EU: §b" + Integer.valueOf(Main.getSGAPI().getConfig().getInt("Server-Name-Number")), 7);
			    scoreboard.add("§8§9§e ", 6);
			    scoreboard.add("§6§l» Players", 5);
			    scoreboard.add("§3Playing: §b" + Main.getSGAPI().Players.size(), 4);
			    if(Games.getGameState() != GameState.Lobby) {
			    	scoreboard.add("§3Watching: §b" + Main.getSGAPI().Spectators.size(), 3);
			    }
			    scoreboard.add("§d§lMineGamer.Net", 2);
			    
			 
			    scoreboard.build();
			   
			   
			    scoreboard.send(p);
			    
			    
			    
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getSGAPI(), new Runnable()
			    {
			      public void run()
			      {
			    	  scoreBoardManager(p);
			      }
			    }, 1200L);
			  }else if(MySQLAPI.getSidebar(p).equalsIgnoreCase("minimized")){
				  
			    scoreboard.add("§7EU: §7" + Integer.valueOf(Main.getSGAPI().getConfig().getInt("Server-Name-Number")), 3);
			    scoreboard.add("§7" + format.format(now), 2);
			    scoreboard.add("§7" + saatformat.format(saat), 1);
			    scoreboard.add("§b§lMineGamer.Net", 0);
			    
			 
			    scoreboard.build();
			   
			   
			    scoreboard.send(p);
			    
			    
			    
			    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getSGAPI(), new Runnable()
			    {
			      public void run()
			      {
			    	  scoreBoardManager(p);
			      }
			    }, 1200L);
			  }else if(MySQLAPI.getSidebar(p).equalsIgnoreCase("default")){
				  
			        scoreboard.add("§7EU: §7" + Integer.valueOf(Main.getSGAPI().getConfig().getInt("Server-Name-Number")), 6);
			        scoreboard.add("§7" + format.format(now), 5);
			        scoreboard.add("§7" + saatformat.format(saat), 4);
			        scoreboard.add("§7§s ", 3);
			        scoreboard.add("§fPlaying: §f" + Main.getSGAPI().Players.size(), 2);
			        if(Games.getGameState() != GameState.Lobby) {
			        	scoreboard.add("§fWatching: §f" + Main.getSGAPI().Spectators.size(), 1);
			        }
			        scoreboard.add("§b§lMineGamer.Net", 0);
			        
			     
			        scoreboard.build();
			       
			       
			        scoreboard.send(p);
			        
			        
			        
			        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getSGAPI(), new Runnable()
				    {
				      public void run()
				      {
				    	  scoreBoardManager(p);
				      }
				    }, 1200L);
				  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
