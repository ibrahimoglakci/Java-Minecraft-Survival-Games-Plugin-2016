package me.minegamersg.api;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;



public class ChestAPI {
	/*/public static void fillTier1Chest(World world) {
	
		for(Chunk chunk : world.getLoadedChunks()) {
			for(BlockState bs : chunk.getTileEntities()) {
				if(bs instanceof Chest) {
					if(Main.getSGAPI().tier1chest.contains(bs.getLocation())) {
						Chest tier1chest = (Chest) bs;
						Inventory inv = tier1chest.getBlockInventory();
						Random r = new Random();
			            int numItems = r.nextInt(5) + 1;
			            Material[] items1 = new Material[] { Material.WOOD_AXE, Material.LEATHER_BOOTS, Material.GOLD_HELMET, Material.STRING, Material.APPLE, Material.ARROW };
			            for (int i = 0; i < numItems; i++) {
			            	Material tier1items = items1[r.nextInt(items1.length)];
			            	
			            	ItemStack item = new ItemStack(tier1items, 1);
			            	
			            	int index;
			                do {
			                        index = r.nextInt(tier1chest.getInventory().getSize());
			                } while (tier1chest.getInventory().getItem(index) != null);
			                
			                inv.setItem(index, item);
			            	Bukkit.broadcastMessage("§bChest has been refilled !");
			            	
			            }
					}else {
						
						Chest tier1chest = (Chest) bs;
						Inventory inv = tier1chest.getBlockInventory();
						Random r = new Random();
			            int numItems = 2+ r.nextInt(7);
			            //List<Material> tier1item = (List<Material>) chestData.getList("SurvivalGames.Chest.tier1.items");
			            Material[] items1 = new Material[] { Material.IRON_CHESTPLATE, Material.LEATHER_BOOTS, Material.GOLD_HELMET, Material.DIAMOND, Material.APPLE, Material.ARROW };
			          
			            for (int i = 0; i < numItems; i++) {
			            	  Material tier1items = items1[r.nextInt(items1.length)];
			            	  ItemStack item = new ItemStack(tier1items, 1);
			            	
			            	int index = r.nextInt(tier1chest.getInventory().getSize());
			            	if(!inv.contains(item)) {
			            	
				                inv.setItem(index, item);
				            	Bukkit.broadcastMessage("§cChest has been refilled !");
			            	}
			            	
			            }
						
						
					}
				}
			}
		}
		
	}/*/

	//--------------------------------------------------------------------------------//
	/*/ Tier 2 REfill
	 
	 if(locationData.get(world + ".chestlocation.tier2") == bs.getLocation()) {
						Chest tier1chest = (Chest) bs.getWorld().getBlockAt(bs.getLocation());
						Inventory inv = tier1chest.getBlockInventory();
						Random r = new Random();
			            int numItems = 2+ r.nextInt(7);
			            //List<Material> tier1item = (List<Material>) chestData.getList("SurvivalGames.Chest.tier1.items");
			            Material[] items1 = new Material[] { Material.IRON_CHESTPLATE, Material.IRON_HELMET, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.DIAMOND, Material.GOLDEN_APPLE, Material.FLINT_AND_STEEL, Material.STONE_SWORD, Material.BOW, Material.IRON_INGOT};
			          
			            for (int i = 0; i < numItems; i++) {
			            	  Material tier2items = items1[r.nextInt(items1.length)];
			            	  ItemStack item = new ItemStack(tier2items, 1);
			            	
			            	int index = r.nextInt(tier1chest.getInventory().getSize());
			            	if(!inv.contains(item)) {
				                inv.setItem(index, item);
				            	
			            	}
			            	
			            }
			            /*/
	//--------------------------------------------------------------------------------//
	
	public static void fillTier1Chest(Inventory inv, boolean paramboolean) {
		//File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
		//File f = new File(data, File.separator + world + ".yml");
		//FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
			
		inv.clear();
		Random r = new Random();
		int numItems = r.nextInt(7) + 4;
		
		Material[] items1 = new Material[] { Material.WOOD_AXE, Material.LEATHER_BOOTS, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.WOOD_SWORD, Material.STONE_SWORD, Material.STONE_SWORD, Material.APPLE, Material.ARROW, Material.COOKIE, Material.RAW_FISH, Material.RAW_BEEF, Material.RAW_CHICKEN, Material.FLINT, Material.GOLD_INGOT, Material.CARROT, Material.PUMPKIN_PIE, Material.BREAD, Material.BAKED_POTATO, Material.STICK, Material.FEATHER, Material.FISHING_ROD, Material.BOW};
		for (int i = 0; i < numItems; i++) {
			Material tier1items = items1[r.nextInt(items1.length)];
			
			if(tier1items == Material.APPLE || tier1items == Material.COOKIE || tier1items == Material.RAW_FISH || tier1items == Material.RAW_BEEF || tier1items == Material.RAW_CHICKEN || tier1items == Material.FLINT || tier1items == Material.GOLD_INGOT || tier1items == Material.CARROT || tier1items == Material.PUMPKIN_PIE || tier1items == Material.BREAD || tier1items == Material.BAKED_POTATO || tier1items == Material.FEATHER || tier1items == Material.STICK) {
				Random rand = new Random();
				int randomamount = rand.nextInt(5);
				if(randomamount == 0) {
					ItemStack item = new ItemStack(Material.AIR, 1);
					int index = r.nextInt(27);
					inv.setItem(index, item);
					
				}else {
					ItemStack item = new ItemStack(tier1items, randomamount);
					int index = r.nextInt(27);
					if(!inv.contains(item)) {
						inv.setItem(index, item);
						
					}else {
						return;
					}
				}
			}else if(tier1items == Material.ARROW ) {
				
				ItemStack item = new ItemStack(tier1items, 5);
				int index = r.nextInt(27);
				if(!inv.contains(item)) {
					
					inv.setItem(index, item);
					
				}else {
					return;
				}
				
				
			}else {
				ItemStack item = new ItemStack(tier1items, 1);
				
				int index = r.nextInt(27);
				if(!inv.contains(item)) {
					
					inv.setItem(index, item);
					
				}else {
					return;
				}
			}   
			
		}
					
						
	}
			
	
	public static void fillTier2Chest(Inventory inv, boolean paramboolean) {
		//File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
		//File f = new File(data, File.separator + world + ".yml");
		//FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);

					
		inv.clear();
		Random r = new Random();
		int numItems = r.nextInt(7) + 2;
		Material[] items1 = new Material[] { Material.IRON_CHESTPLATE, Material.IRON_HELMET, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.DIAMOND, Material.GOLDEN_APPLE, Material.FLINT_AND_STEEL, Material.STONE_SWORD, Material.BOW, Material.IRON_INGOT};
		
		for (int i = 0; i < numItems; i++) {
			Material tier2items = items1[r.nextInt(items1.length)];
			ItemStack item = new ItemStack(tier2items, 1);
			
			int index = r.nextInt(inv.getSize());
			if(!inv.contains(item)) {
				inv.setItem(index, item);
				
			}else {
				return;
			}
			
		}	
		
	}						
	
}	
