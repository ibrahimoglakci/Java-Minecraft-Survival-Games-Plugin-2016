package me.minegamersg.listener;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffectType;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.PlayerManager;
import me.minegamersg.api.SBAPI;
import me.minegamersg.commands.Sidebar;

public class JoinListener implements Listener{
	
	
	public static void setPlayerNumber(Player player) {
		
		 if(Main.getSGAPI().Players.isEmpty()) {
			 if(!Main.getSGAPI().playerNumber.containsKey(player)) {
				 int numberplayer = Main.getSGAPI().Players.size() + 1;
				 Main.getSGAPI().playerNumber.put(player, numberplayer);
			 }else if(Main.getSGAPI().playerNumber.containsKey(player)) {
				 return;
			 
			 }
		 }else if(Main.getSGAPI().Players.size() < 24) {
			 if(!Main.getSGAPI().playerNumber.containsKey(player)) {
				 int numberplayer = Main.getSGAPI().Players.size() + 1;
				 Main.getSGAPI().playerNumber.put(player, numberplayer);
			 }else if(Main.getSGAPI().playerNumber.containsKey(player)) {
				 return;
			 }
		  }else {
			  Main.getSGAPI().playerNumber.put(player, null);
				
		  }
		 
		  
	}
		 
	
		 public static Integer getPlayerNumber(Player player) {
			
			 return Main.getSGAPI().playerNumber.get(player);
			 
		 }
		 
	public void setPlayerDisplayName(Player p) {
		
		try {
			if(MySQLAPI.getRank(p).equalsIgnoreCase("regular")) {
				p.setDisplayName("§2" + p.getName());
				p.setPlayerListName("§2" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("gold")) {
				p.setDisplayName("§6" + p.getName());
				p.setPlayerListName("§6" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("diamond")) {
				p.setDisplayName("§3" + p.getName());
				p.setPlayerListName("§3" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("platinum")) {
				p.setDisplayName("§b" + p.getName());
				p.setPlayerListName("§b" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("yt")) {
				p.setDisplayName("§5" + p.getName());
				p.setPlayerListName("§5" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("moderator")) {
				p.setDisplayName("§c" + p.getName());
				p.setPlayerListName("§c" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("builder")) {
				p.setDisplayName("§d" + p.getName());
				p.setPlayerListName("§d" + p.getName());
			}
			if(MySQLAPI.getRank(p) == "dev") {
				p.setDisplayName(MessageAPI.setColouredString(p.getName()));
				p.setDisplayName(MessageAPI.setColouredString(p.getName()));
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("leaddev")) {
				p.setDisplayName(MessageAPI.setColouredString(p.getName()));
				p.setDisplayName(MessageAPI.setColouredString(p.getName()));
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("admin")) {
				p.setDisplayName("§4" + p.getName());
				p.setPlayerListName("§4" + p.getName());
			}
			if(MySQLAPI.getRank(p).equalsIgnoreCase("Owner")) {
				p.setDisplayName("§4§l" + p.getName());
				p.setPlayerListName("§4§l" + p.getName());
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
			
}
		 
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage("");
		setPlayerDisplayName(p);
	//	File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "SurvivalGames Maps");
		//File f = new File(data, File.separator + "Lobby.yml");
		//FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
		
		try {
			
			MySQLAPI.setSGDefaultStats(p);
			MySQLAPI.setDefaultPlayerData(p);
			MySQLAPI.setChestStatsOptions(p);
			MySQLAPI.setGamesWinOptions(p);
			MySQLAPI.updatePlayingPlayers();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setPlayerNumber(p);
		
		p.performCommand("vote");
		Sidebar.setSidebar(p, "2015");
		Main.getSGAPI().Players.add(p);
		SBAPI.scoreBoardManager(p);
		p.teleport(p.getWorld().getSpawnLocation());
		for(Player all : Bukkit.getOnlinePlayers()) {
			SBAPI.scoreBoardManager(all);
			//MySQLAPI.setSGDefaultStats(all);
			//MySQLAPI.setChestStatsOptions(all);
			all.removePotionEffect(PotionEffectType.INVISIBILITY);
			//MySQLAPI.setGamesWinOptions(all);
			all.showPlayer(p);
			p.showPlayer(all);
				
		}
		p.setAllowFlight(false);
		PlayerManager.preparePlayer(p);
		Bukkit.broadcastMessage(p.getDisplayName() + " §6has joined");
		//p.teleport(new Location(Bukkit.getWorld("Lobby"), locationData.getDouble("Lobby.X"), locationData.getDouble("Lobby.Y"), locationData.getDouble("Lobby.Z")));
		
	}

}
