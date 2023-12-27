package me.minegamersg.api;

import java.io.File;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.minegamersg.listener.JoinListener;

public class TeleportManager {
	

	public static void teleporter(Player p, String map, String type) {
		File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "SurvivalGames Maps");
		File f = new File(data, File.separator + map + ".yml");
		FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
		if(type.equalsIgnoreCase("lobby")) {
			if(Bukkit.getWorlds().contains(Bukkit.getWorld(map))) {
				if(f.exists()) {
					World w = Bukkit.getServer().getWorld(map);
					double x = locationData.getDouble("Lobby.X");
					double y = locationData.getDouble("Lobby.Y");
					double z = locationData.getDouble("Lobby.Z");
					Location sglocation = new Location(w, x, y, z);
					p.teleport(sglocation);
						
				}else {
					Bukkit.broadcastMessage("§f[SGController§f] §cCouldn't find teleport locations please select locations!");
				}
			}else {
				Bukkit.broadcastMessage("§f[SGController§f] §cCouldn't find map please load map in the server!");
			}
		}else if(type.equalsIgnoreCase("livegame")) {
			if(Bukkit.getWorlds().contains(Bukkit.getWorld(map))) {
				if(f.exists()) {
					World w = Bukkit.getServer().getWorld(map);
					if(JoinListener.getPlayerNumber(p) != null) {
						double x = locationData.getDouble(map + "." + JoinListener.getPlayerNumber(p) + ".X");
						double y = locationData.getDouble(map + "." + JoinListener.getPlayerNumber(p) + ".Y");
						double z = locationData.getDouble(map + "." + JoinListener.getPlayerNumber(p) + ".Z");
						Location sglocation = new Location(w, x, y, z);
						p.teleport(sglocation);
					}else if(JoinListener.getPlayerNumber(p) == null) {
						int randomjoinnumber = new Random().nextInt(24);
						double x = locationData.getDouble(map + "." + randomjoinnumber + ".X");
						double y = locationData.getDouble(map + "." + randomjoinnumber + ".Y");
						double z = locationData.getDouble(map + "." + randomjoinnumber + ".Z");
						Location sglocation = new Location(w, x, y, z);
						p.teleport(sglocation);
					}
						
				}else {
					Bukkit.broadcastMessage("§f[SGController§f] §cCouldn't find teleport locations please select locations!");
				}
			}else {
				Bukkit.broadcastMessage("§f[SGController§f] §cCouldn't find map please load map in the server!");
			}
		}else if(type.equalsIgnoreCase("specspawn")) {
			
			World w = Bukkit.getServer().getWorld(map);
			double x = locationData.getDouble(map + "deatmatch-center.X");
			double y = locationData.getDouble(map + "deatmatch-center.Y");
			double z = locationData.getDouble(map + "deatmatch-center.Z");
			Location sglocation = new Location(w, x, y, z);
			p.teleport(sglocation);
			
			
		}else if(type.equalsIgnoreCase("deathmatch")) {
			if(Bukkit.getWorlds().contains(Bukkit.getWorld(map))) {
				if(f.exists()) {
					
					
					World w = Bukkit.getServer().getWorld(map);
					if(JoinListener.getPlayerNumber(p) != null) {
						double x = locationData.getDouble(map + "." + JoinListener.getPlayerNumber(p) + ".X");
						double y = locationData.getDouble(map + "." + JoinListener.getPlayerNumber(p) + ".Y");
						double z = locationData.getDouble(map + "." + JoinListener.getPlayerNumber(p) + ".Z");
						Location sglocation = new Location(w, x, y, z);
						p.teleport(sglocation);
					}else if(JoinListener.getPlayerNumber(p) == null) {
						int randomjoinnumber = new Random().nextInt(24);
						double x = locationData.getDouble(map + "." + randomjoinnumber + ".X");
						double y = locationData.getDouble(map + "." + randomjoinnumber + ".Y");
						double z = locationData.getDouble(map + "." + randomjoinnumber + ".Z");
						Location sglocation = new Location(w, x, y, z);
						p.teleport(sglocation);
					}
					
					
					
					
					/*/Iterator localIterator;
					localIterator = Main.getSGAPI().dm_spawns.iterator();
					String str;
					if (localIterator.hasNext())
					{
						str = (String)localIterator.next();
						p.teleport(new Location(Bukkit.getWorld(Games.getMapName()), locationData.getDouble(Games.getMapName() + ".deathmatch." + str + ".X"), locationData.getDouble(Games.getMapName() + ".deathmatch." + str + ".Y"), locationData.getDouble(Games.getMapName() + ".deathmatch." + str + ".Z")));
					        Main.getSGAPI().dm_spawns.remove(str);
					}
					
					/*/
					/*/int randomloc = new Random().nextInt(3);
					
					if(randomloc == 1) {
						ArrayList<Player> notpermplayers = new ArrayList<Player>();
						notpermplayers.add(Main.getSGAPI().Players.iterator().next());
						int rand = new Random().nextInt(notpermplayers.size());
						Player selectplayer = notpermplayers.get(rand);
						double x = locationData.getDouble(map + ".deathmatch.1.X");
						double y = locationData.getDouble(map + ".deathmatch.1.Y");
						double z = locationData.getDouble(map + ".deathmatch.1.Z");
						Location sglocation = new Location(w, x, y, z);
						selectplayer.teleport(sglocation);
						notpermplayers.remove(selectplayer);
					}
					if(randomloc == 2) {
						ArrayList<Player> notpermplayers = new ArrayList<Player>();
						notpermplayers.add(Main.getSGAPI().Players.iterator().next());
						int rand = new Random().nextInt(notpermplayers.size());
						Player selectplayer = notpermplayers.get(rand);
						double x = locationData.getDouble(map + ".deathmatch.2.X");
						double y = locationData.getDouble(map + ".deathmatch.2.Y");
						double z = locationData.getDouble(map + ".deathmatch.2.Z");
						Location sglocation = new Location(w, x, y, z);
						selectplayer.teleport(sglocation);
						notpermplayers.remove(selectplayer);
					}
					if(randomloc == 3) {
						ArrayList<Player> notpermplayers = new ArrayList<Player>();
						notpermplayers.add(Main.getSGAPI().Players.iterator().next());
						int rand = new Random().nextInt(notpermplayers.size());
						Player selectplayer = notpermplayers.get(rand);
						double x = locationData.getDouble(map + ".deathmatch.3.X");
						double y = locationData.getDouble(map + ".deathmatch.3.Y");
						double z = locationData.getDouble(map + ".deathmatch.3.Z");
						Location sglocation = new Location(w, x, y, z);
						selectplayer.teleport(sglocation);
						notpermplayers.remove(selectplayer);
					}/*/
						
				}else {
					Bukkit.broadcastMessage("§f[SGController§f] §cCouldn't find teleport locations please select locations!");
				}
			}else {
				Bukkit.broadcastMessage("§f[SGController§f] §cCouldn't find map please load map in the server!");
			}
		}
	}

}
