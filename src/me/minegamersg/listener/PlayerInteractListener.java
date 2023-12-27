package me.minegamersg.listener;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.ChestAPI;
import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;

public class PlayerInteractListener implements Listener{
	

	
	 @SuppressWarnings("rawtypes")
	@EventHandler(priority=EventPriority.HIGHEST)
	  public void onInteract(PlayerInteractEvent e) throws SQLException
	  {
		File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
		File f = new File(data, File.separator + "chest.yml");
		FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
	    Player localPlayer = e.getPlayer();
	    if(Main.getSGAPI().Spectators.contains(localPlayer)) {
    		e.setCancelled(true);
    	}
	    if (((e.getAction().equals(Action.LEFT_CLICK_BLOCK))) && 
	      (localPlayer.getItemInHand() != null) && (localPlayer.getItemInHand().hasItemMeta()) && (localPlayer.getItemInHand().getItemMeta().hasDisplayName()) && 
	      (localPlayer.getItemInHand().getItemMeta().getDisplayName().contains("Tier 2 Chest Selector")) && (
	      (e.getClickedBlock().getType().equals(Material.CHEST)) || (e.getClickedBlock().getType().equals(Material.TRAPPED_CHEST))))
	    {
	      Location localObject = e.getClickedBlock().getLocation();
	      
	      int i = 1;
	      if(!f.exists()) {
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".X", localObject.getX());
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localObject.getY());
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localObject.getZ());
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localObject.getWorld().getName());
	    	 try {
		    	  locationData.save(f);
		      }catch (IOException ex) {
		    	  ex.printStackTrace();
		      }
	      }else {
	    	  if(locationData.isConfigurationSection("Custom-Chests.tier2-chests")) {
	    		  i = locationData.getConfigurationSection("Custom-Chests.tier2-chests").getKeys(false).size() + 1;
	    	  }
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".X", localObject.getX());
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localObject.getY());
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localObject.getZ());
	    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localObject.getWorld().getName());
	    	  try {
    	    	  locationData.save(f);
    	      }catch (IOException ex) {
    	    	  ex.printStackTrace();
    	      }
	    	  
	      }
	      locationData.set("Custom-Chests.tier2-chests." + i + ".X", localObject.getX());
    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localObject.getY());
    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localObject.getZ());
    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localObject.getWorld().getName());
	      
	      try {
	    	  locationData.save(f);
	      }catch (IOException ex) {
	    	  ex.printStackTrace();
	      }
	      
	      e.setCancelled(true);
	      localPlayer.sendMessage(MessageAPI.getServerPrefix() + " §aThe Tier2 Chest has been saved on " + ChatColor.AQUA + ((Location)localObject).getX() + "," + ((Location)localObject).getY() + "," + ((Location)localObject).getZ() + ChatColor.GREEN + " location");
	    }
	    
	    if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && 
	    		(Games.getGameState() != GameState.Lobby))
	    {
	
	    	if ((e.getClickedBlock().getState() instanceof org.bukkit.block.Chest))
	    	{
	    	        Object localObject = (org.bukkit.block.Chest)e.getClickedBlock().getState();
	    	        if (!Main.getSGAPI().used_chests.contains(((org.bukkit.block.Chest)localObject).getLocation()))
	    	        {
	    	          ((org.bukkit.block.Chest)localObject).getBlockInventory().clear();
	    	          
	    	            if (Main.getSGAPI().tier2_chests.contains(e.getClickedBlock().getLocation())) {
	    	              ChestAPI.fillTier2Chest(((org.bukkit.block.Chest)localObject).getBlockInventory(), false);
	    	            
	    	            } else {
	    	            	   ChestAPI.fillTier1Chest(((org.bukkit.block.Chest)localObject).getBlockInventory(), false);
	    	            
	    	            }
	    	        }
	    	       
	    	        Main.getSGAPI().used_chests.add(((org.bukkit.block.Chest)localObject).getLocation());
	    	       
	    	      //  MySQLAPI.addAllOpenChest(localPlayer);
	    	}
	    	if ((e.getClickedBlock().getType().equals(Material.ENDER_CHEST)) && 
			        (!Main.getSGAPI().used_chests.contains(e.getClickedBlock().getLocation())))
	    	{
		 			Object localObject;
			      
		 			localObject = e.getPlayer().getEnderChest();
		 			
			        ((Inventory)localObject).clear();
			        ChestAPI.fillTier2Chest((Inventory) localObject, true);
			        Main.getSGAPI().used_chests.add(e.getClickedBlock().getLocation());
			        
	    	}
	    	if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
	    		if(Main.getSGAPI().Spectators.contains(localPlayer)) {
	    			
	    			for(Iterator living = Main.getSGAPI().Players.iterator(); living.hasNext();) {
	    				ArrayList<Player> randomallplayer = new ArrayList<Player>();
		    			Player players = (Player) living.next();
						randomallplayer.add(players);
						int rand = new Random().nextInt(randomallplayer.size());
						Player selectplayer = randomallplayer.get(rand);
						localPlayer.teleport(selectplayer);
						localPlayer.sendMessage(MessageAPI.getServerPrefix() + " §fTeleporting to §r" + selectplayer.getDisplayName());
						randomallplayer.remove(selectplayer);
	    			}
	    		}
	    	}
	    	
	    	
	    }
	  }
	 
	 		

}
