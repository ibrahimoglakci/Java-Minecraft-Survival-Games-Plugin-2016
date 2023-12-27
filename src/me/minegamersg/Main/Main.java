package me.minegamersg.Main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.minegamersg.Enum.GameState;
import me.minegamersg.api.Chest;
import me.minegamersg.api.ChestSystem;
import me.minegamersg.api.Games;
import me.minegamersg.api.MySQLAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.NMS;
import me.minegamersg.commands.Bounty;
import me.minegamersg.commands.Build;
import me.minegamersg.commands.ChangeSegments;
import me.minegamersg.commands.ChatColorCommand;
import me.minegamersg.commands.ChestSelector;
import me.minegamersg.commands.Disguise;
import me.minegamersg.commands.FlyandGamemodes;
import me.minegamersg.commands.ForceStart;
import me.minegamersg.commands.HubConnect;
import me.minegamersg.commands.InfoCommands;
import me.minegamersg.commands.Kill;
import me.minegamersg.commands.ReloadConfig;
import me.minegamersg.commands.SGList;
import me.minegamersg.commands.SetLocations;
import me.minegamersg.commands.SetMapMenu;
import me.minegamersg.commands.Sidebar;
import me.minegamersg.commands.Spectator;
import me.minegamersg.commands.Sponsor;
import me.minegamersg.commands.Stats;
import me.minegamersg.commands.TeleportWorld;
import me.minegamersg.commands.Vote;
import me.minegamersg.listener.BlockBreakListener;
import me.minegamersg.listener.ChatListener;
import me.minegamersg.listener.DamageListener;
import me.minegamersg.listener.DeathListener;
import me.minegamersg.listener.JoinListener;
import me.minegamersg.listener.MoveListener;
import me.minegamersg.listener.QuitListener;

public class Main extends JavaPlugin{
	
	
	public HashMap<Player, Integer> playerNumber = new HashMap<>();
	public ArrayList<String> previousMaps = new ArrayList<>();
	public ArrayList<Player> Players = new ArrayList<>();
	public ArrayList<Player> Spectators = new ArrayList<>();
	public ArrayList<String> tributes = new ArrayList<>();
	public ArrayList<Player> voted = new ArrayList<>();
	public ArrayList<String> dm_spawns = new ArrayList<>();
	public String serverMotd;
	public Chest chest;
	public Logger log = Logger.getLogger("Minecraft");
	public String mapName;
	public int LobbySecond = 1;
	public int LobbyMinute = 3;
	public int PreGameSecond = 31;
	public int PreGameMinute = 0;
	public int LiveDeathMatchSecond = 60;
	public int LiveDeathMatchMinute = 0; //TODO
	public int LiveGameSecond = 2;
	public int LiveGameMinute = 30; //TODO 30
	public int PreDeathmatchSecond = 11;
	public int PreDeathmatchMinute = 0;
	public int DeathmatchSecond = 1;
	public int DeathmatchMinute = 3;
	public int CleanupSecond = 15;
	public int CleanupMinute = 0;
	public int EndGameSecond = 16;
	public int EndGameMinute = 0;
	public int lobbyTime = 181;
	public int gameTime = 1801;
	public int preGameTime = 31;
	public int deathMatchTime = 181;
	public int preDeathmatchTime = 11;
	public int cleanUpTime = 15;
	public int endGameTime = 16;
	public int tick;
	public int playerNumberr;
	public boolean allowToMove = false;
	public boolean forcestart = false;
	public boolean canChange = false;
	public ChestSystem cs;
	public List<Location> used_chests = new ArrayList<>();
	  public List<Location> tier2_chests = new ArrayList<Location>();

	
	public ArrayList<Location> tier1chest = new ArrayList<Location>();
	
	
	
	public static Main minegamersg;
	public GameState gameState;
	public static NMS nmsclass;
	
	public void onDisable() {
		Bukkit.unloadWorld("SurvivalGames4", false);
		Bukkit.unloadWorld("AlaskanVillage", false);
		Bukkit.unloadWorld("Par72", false);
		Bukkit.unloadWorld("Turbulence", false);
		Bukkit.unloadWorld("BreezeIsland2", false);
		Bukkit.unloadWorld("SurvivalGames4", false);
		Bukkit.unloadWorld("AlaskanVillage", false);
		Bukkit.unloadWorld("Par72", false);
		Bukkit.unloadWorld("Turbulence", false);
		Bukkit.unloadWorld("BreezeIsland2", false);
		Bukkit.unloadWorld("SurvivalGamesAdrenaline", false);
		Bukkit.unloadWorld("Zone85", false);
		Bukkit.unloadWorld("DemonsBreeze", false);
	}
	
	
	@SuppressWarnings("deprecation")
	public void onEnable() {
		Build.buildmode = false;
		minegamersg = this;
		
		getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		
		Bukkit.unloadWorld("SurvivalGames4", false);
		Bukkit.unloadWorld("AlaskanVillage", false);
		Bukkit.unloadWorld("Par72", false);
		Bukkit.unloadWorld("Turbulence", false);
		Bukkit.unloadWorld("BreezeIsland2", false);
		Bukkit.unloadWorld("SurvivalGamesAdrenaline", false);
		Bukkit.unloadWorld("Zone85", false);
		Bukkit.unloadWorld("DemonsBreeze", false);
		getConfig().options().copyDefaults(true);
		if(!getConfig().isSet("Server-Name-Number")) {
			getConfig().set("Server-Name-Number", 1453);
		}
		if(!getConfig().isSet("Starting-Player")) {
			getConfig().set("Starting-Player", 6);
		}
		getConfig().set("DeathMatch-Lightning-Around", Integer.valueOf(30));
	    saveConfig();
	 
	   loadChests();
	   
	   try {
		MySQLAPI.setDefaultServerData();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   
	   for(Player all : Bukkit.getOnlinePlayers()) {
		   all.setGameMode(GameMode.ADVENTURE);
		   all.setFoodLevel(30);
		   Players.remove(all);
		   Players.add(all);
	   }
	    
		File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "MySQL");
		File f = new File(data, File.separator + "MySQL.yml");
		FileConfiguration mysqlData = YamlConfiguration.loadConfiguration(f);
		if(!f.exists()) {
			mysqlData.set("MySQL.HostName", "localhost");
        	mysqlData.set("MySQL.Port", "3306");
        	mysqlData.set("MySQL.Database", "xemegamer");
        	mysqlData.set("MySQL.UserName", "root");
        	mysqlData.set("MySQL.Password", "");
        }
        try {
        	mysqlData.save(f);
        }catch(IOException ex) {
        	ex.printStackTrace();
        }
		/*/for(Player all : Bukkit.getOnlinePlayers()) {
			all.showPlayer(all);
			PlayerManager.preparePlayer(all);
			all.setGameMode(GameMode.ADVENTURE);
			all.getActivePotionEffects().clear();
			all.removePotionEffect(PotionEffectType.INVISIBILITY);
			File datas = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "SurvivalGames Maps");
			File ff = new File(datas, File.separator + "Lobby.yml");
			FileConfiguration locationDataa = YamlConfiguration.loadConfiguration(ff);
			all.teleport(new Location(Bukkit.getWorld("Lobby"), locationDataa.getDouble("Lobby.X"), locationDataa.getDouble("Lobby.Y"), locationDataa.getDouble("Lobby.Z")));
			try {
				MySQLAPI.setSGDefaultStats(all);
				MySQLAPI.setChestStatsOptions(all);
				MySQLAPI.setGamesWinOptions(all);
				MySQLAPI.setPluginOption();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}/*/
		/*/try {
			MySQLAPI.setPluginOption();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}/*/
		//try {
			//if(MySQLAPI.getPluginOptions().equalsIgnoreCase("true")) {
			//------------------------ Register Events ----------------------//
			
				PluginManager pm = (PluginManager) Bukkit.getPluginManager();
				pm.registerEvents(new JoinListener(), this);
				pm.registerEvents(new QuitListener(), this);
				pm.registerEvents(new ChatListener(), this);
				pm.registerEvents(new DeathListener(), this);
				pm.registerEvents(new MoveListener(), this);
				pm.registerEvents(new BlockBreakListener(), this);
				pm.registerEvents(new DamageListener(), this);
				/*/pm.registerEvents(new LoginListener(), this);
				
				pm.registerEvents(new JoinListener(), this);
				pm.registerEvents(new ChatListener(), this);
				pm.registerEvents(new MotdListener(), this);
				pm.registerEvents(new DeathListener(), this);
				//pm.registerEvents(new ChunkLoadListener(), this);
				pm.registerEvents(new RespawnListener(), this);
				pm.registerEvents(new DamageListener(), this);
				pm.registerEvents(new BlockBreakListener(), this);
				pm.registerEvents(new BlockPlaceListener(), this);
				pm.registerEvents(new PlayerInteractListener(), this);
				pm.registerEvents(new QuitListener(), this);
				pm.registerEvents(new BoatDamageListener(), this);
				pm.registerEvents(new ExplodeListener(), this);
				pm.registerEvents(new ItemDropListener(), this);
				pm.registerEvents(new ItemPickUpListener(), this);
				pm.registerEvents(new FoodChangeListener(), this);/*/
				
			//------------------------ Register Events -----------------------//
			//****************************************************************
			//****************************************************************
			//****************************************************************
			//****************************************************************
			//****************************************************************
			//------------------------ Command Executor ----------------------//
			
				getCommand("chatcolor").setExecutor(new ChatColorCommand());
				getCommand("fly").setExecutor(new FlyandGamemodes());
				getCommand("setmapmenu").setExecutor(new SetMapMenu());
				getCommand("vote").setExecutor(new Vote());
				getCommand("mgsgsetloc").setExecutor(new SetLocations());
				getCommand("list").setExecutor(new SGList());
				getCommand("chestselection").setExecutor(new ChestSelector());
				getCommand("hub").setExecutor(new HubConnect());
				getCommand("minegamersgreload").setExecutor(new ReloadConfig());
				getCommand("stats").setExecutor(new Stats());
				getCommand("spectator").setExecutor(new Spectator());
				getCommand("info").setExecutor(new InfoCommands());
				getCommand("bounty").setExecutor(new Bounty());
				getCommand("game").setExecutor(new ChangeSegments());
				getCommand("forcestart").setExecutor(new ForceStart());
				getCommand("sponsor").setExecutor(new Sponsor());
				getCommand("tpworld").setExecutor(new TeleportWorld());
				getCommand("kill").setExecutor(new Kill());
				getCommand("build").setExecutor(new Build());
				getCommand("disguise").setExecutor(new Disguise());
				getCommand("sidebar").setExecutor(new Sidebar());
			//------------------------ Command Executor ----------------------//
			//****************************************************************
			//****************************************************************
			//------------------------ Start Game ----------------------------//
				
				Games.setGameState(GameState.Lobby);
				Games.startGame();				
				
			//------------------------ Start Game ----------------------//
			//}else if(MySQLAPI.getPluginOptions().equalsIgnoreCase("false")) {
				//Bukkit.getServer().shutdown();
			//}
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
	
	
	
	/*/private void loadChestConfigs()
	  {
		File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
		File f = new File(data, File.separator + "chest.yml");
		FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
	    try {
	    	locationData.save(f);
	    	
	    }catch(IOException ex) {
	    	ex.printStackTrace();
	    }
	  }/*/
	

	
	Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable()
    {
      public void run()
      {
    	  /*try {
				if(MySQLAPI.getPluginOptions().equalsIgnoreCase("false")) {
					Bukkit.getServer().shutdown();
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}*/
    	 
      }
    }, 0L, 100L);
	}


	
	private void loadChests()
	  {
		File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
		File f = new File(data, File.separator + "chest.yml");
		FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
	    if (locationData.isConfigurationSection("Custom-Chests.tier2-chests")) {
	      for (String str : locationData.getConfigurationSection("Custom-Chests.tier2-chests").getKeys(false)) {
	        if (deserializeLoc(str).getWorld() != null) {
	          this.tier2_chests.add(deserializeLoc(str));
	        }
	      }
	    }else {
	    	return;
	    }
	  }
	
	
	  private Location deserializeLoc(String paramString)
	  {
		  File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
		  File f = new File(data, File.separator + "chest.yml");
		  FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
		  return new Location(Bukkit.getWorld(locationData.getString("Custom-Chests.tier2-chests." + paramString + ".WORLD")), locationData.getDouble("Custom-Chests.tier2-chests." + paramString + ".X"), locationData.getDouble("Custom-Chests.tier2-chests." + paramString + ".Y"), locationData.getDouble("Custom-Chests.tier2-chests." + paramString + ".Z"));
	  }

	
	public static Main getSGAPI() {
		
		return minegamersg;
	}

}
