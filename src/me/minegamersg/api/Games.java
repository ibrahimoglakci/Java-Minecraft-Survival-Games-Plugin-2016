package me.minegamersg.api;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.WorldCreator;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.UnknownDependencyException;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.commands.Vote;

public class Games {
	
	
	
	
	
	public static void startGame() {
		Main.getSGAPI().tick = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getSGAPI(), new Runnable() {
			@SuppressWarnings({ "deprecation", "rawtypes" })
			public void run() {
				switch(Main.getSGAPI().gameState) {
				case Lobby:
					
					Main.getSGAPI().lobbyTime -= 1;
					try {
						MySQLAPI.updateCurrentState("Lobby");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.setLevel(Main.getSGAPI().lobbyTime);
							}
							if(Main.getSGAPI().lobbyTime == 178) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									SBAPI.scoreBoardManager(all);
								}
							}
							if(Main.getSGAPI().lobbyTime == 60) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									SBAPI.scoreBoardManager(all);
								}
							}
							if(Main.getSGAPI().lobbyTime == 28) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									SBAPI.scoreBoardManager(all);
								}
							}
							if(Main.getSGAPI().lobbyTime == 20) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									SBAPI.scoreBoardManager(all);
								}
							}
							if(Main.getSGAPI().lobbyTime > 120) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									int seconds = Main.getSGAPI().lobbyTime-120;
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b02:" + seconds);
								}
							}
							if(Main.getSGAPI().lobbyTime > 120 && Main.getSGAPI().lobbyTime <130) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									int seconds = Main.getSGAPI().lobbyTime-120;
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b02:0" + seconds);
								}
							}
							if(Main.getSGAPI().lobbyTime == 120) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									int seconds = 00;
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b02:" + seconds);
								}
							}
							if(Main.getSGAPI().lobbyTime > 60 && Main.getSGAPI().lobbyTime < 120) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									int seconds = Main.getSGAPI().lobbyTime-60;
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b01:" + seconds);
								}
							}
							if(Main.getSGAPI().lobbyTime > 60 && Main.getSGAPI().lobbyTime < 120 && Main.getSGAPI().lobbyTime < 70) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									int seconds = Main.getSGAPI().lobbyTime-60;
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b01:0" + seconds);
								}
							}
							if(Main.getSGAPI().lobbyTime < 60 && Main.getSGAPI().lobbyTime > 10) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									int seconds = Main.getSGAPI().lobbyTime;
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:" + seconds);
								}
							}
							if(Main.getSGAPI().lobbyTime < 60 && Main.getSGAPI().lobbyTime < 10) {
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:0" + Main.getSGAPI().lobbyTime);
								}
							}
							if(Main.getSGAPI().lobbyTime == 180) {
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e3§8] §bminutes until lobby ends!");
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().lobbyTime);
								}
							}
							if(Main.getSGAPI().lobbyTime == 120) {
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e2§8] §bminutes until lobby ends!");
							}
							if(Main.getSGAPI().lobbyTime == 60) {
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e1§8] §bminute until lobby ends!");
							}
							if(Main.getSGAPI().lobbyTime == 30) {
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e30§8] §bseconds until lobby ends!");
							}
							if(Main.getSGAPI().lobbyTime == 10) {
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e10§8] §bseconds until lobby ends!");
							}
							if(Main.getSGAPI().lobbyTime == 5 || Main.getSGAPI().lobbyTime == 4 || Main.getSGAPI().lobbyTime == 3 || Main.getSGAPI().lobbyTime == 2) {
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e" + Main.getSGAPI().lobbyTime + "§8] §bseconds until lobby ends!");					    
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 10, 1);
								}
							}
							if(Main.getSGAPI().lobbyTime == 1) {
								Vote.selectVotes();
								for(Player all : Bukkit.getOnlinePlayers()) {
									all.playSound(all.getLocation(), Sound.NOTE_PLING, 10, 1);
								}
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e" + Main.getSGAPI().lobbyTime + "§8] §bseconds until lobby ends!");
							}
							if(Main.getSGAPI().lobbyTime == 0) {
								if(Bukkit.getOnlinePlayers().length < Main.getSGAPI().getConfig().getInt("Starting-Player")) {
									Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §4Not enough players, restarting timer..");
									Main.getSGAPI().lobbyTime = 181;
									setGameState(GameState.Lobby);
									for(Player all : Bukkit.getOnlinePlayers()) {
										Vote.sg4 = 0;
										Vote.alaskanvillage = 0;
										Vote.turbulence = 0;
										Vote.breezeisland2 = 0;
										Vote.par72 = 0;
										
										Vote.sendVoteMessage(all);
									}
								}
								else {
									setGameState(GameState.PreGame);
									
									setPreGameTime(31);
									setMoveCancelled(true);
									
									Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §eMap Name: §2" + getMapName());
									Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §eMap author: §2MCGamer NetWork");
									Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §eMap Link: §2(None)");
									File data = new File(Bukkit.getPluginManager().getPlugin("MineGamerSG").getDataFolder(), File.separator + "Chest");
									File f = new File(data, File.separator + "chest.yml");
									FileConfiguration locationData = YamlConfiguration.loadConfiguration(f);
									for(Player all : Bukkit.getOnlinePlayers()) {
										Main.getSGAPI().Players.clear();
										Main.getSGAPI().Players.add(all);
										all.getInventory().clear();
										PlayerManager.preparePlayer(all);
										all.setGameMode(GameMode.SURVIVAL);
										all.setFlying(false);
										all.getActivePotionEffects().clear();
										all.removePotionEffect(PotionEffectType.INVISIBILITY);
										if(!Bukkit.getWorlds().contains(getMapName())) {
											Bukkit.createWorld(WorldCreator.name(getMapName()));
											TeleportManager.teleporter(all, getMapName(), "livegame");
											
											for (Chunk localChunk : Bukkit.getWorld(getMapName()).getLoadedChunks()) {
										    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
											        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
											        {
											          localBlockState.getBlock().setType(Material.CHEST);
											          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
											          int i = 1;
												      if(!f.exists()) {
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".X", localBlockState.getX());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localBlockState.getY());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localBlockState.getZ());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localBlockState.getWorld().getName());
												    	 try {
													    	  locationData.save(f);
													      }catch (IOException ex) {
													    	  ex.printStackTrace();
													      }
												      }else {
												    	  if(locationData.isConfigurationSection("Custom-Chests.tier2-chests")) {
												    		  i = locationData.getConfigurationSection("Custom-Chests.tier2-chests").getKeys(false).size() + 1;
												    	  }
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".X", localBlockState.getX());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localBlockState.getY());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localBlockState.getZ());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localBlockState.getWorld().getName());
												    	  try {
											    	    	  locationData.save(f);
											    	      }catch (IOException ex) {
											    	    	  ex.printStackTrace();
											    	      }
												    	  
												      }
												      locationData.set("Custom-Chests.tier2-chests." + i + ".X", localBlockState.getX());
											    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localBlockState.getY());
											    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localBlockState.getZ());
											    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localBlockState.getWorld().getName());
												      
												      try {
												    	  locationData.save(f);
												      }catch (IOException ex) {
												    	  ex.printStackTrace();
												      }
												      
											          
											        }
										    	  }
											}
										}else {
											TeleportManager.teleporter(all, getMapName(), "livegame");
											
											for (Chunk localChunk : Bukkit.getWorld(getMapName()).getLoadedChunks()) {
										    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
											        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
											        {
											          localBlockState.getBlock().setType(Material.CHEST);
											          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
											          int i = 1;
												      if(!f.exists()) {
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".X", localBlockState.getX());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localBlockState.getY());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localBlockState.getZ());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localBlockState.getWorld().getName());
												    	 try {
													    	  locationData.save(f);
													      }catch (IOException ex) {
													    	  ex.printStackTrace();
													      }
												      }else {
												    	  if(locationData.isConfigurationSection("Custom-Chests.tier2-chests")) {
												    		  i = locationData.getConfigurationSection("Custom-Chests.tier2-chests").getKeys(false).size() + 1;
												    	  }
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".X", localBlockState.getX());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localBlockState.getY());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localBlockState.getZ());
												    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localBlockState.getWorld().getName());
												    	  try {
											    	    	  locationData.save(f);
											    	      }catch (IOException ex) {
											    	    	  ex.printStackTrace();
											    	      }
												    	  
												      }
												      locationData.set("Custom-Chests.tier2-chests." + i + ".X", localBlockState.getX());
											    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Y", localBlockState.getY());
											    	  locationData.set("Custom-Chests.tier2-chests." + i + ".Z", localBlockState.getZ());
											    	  locationData.set("Custom-Chests.tier2-chests." + i + ".WORLD", localBlockState.getWorld().getName());
												      
												      try {
												    	  locationData.save(f);
												      }catch (IOException ex) {
												    	  ex.printStackTrace();
												      }
												      
											          
											        }
										    	  }
											}
										}
										/*/if(Vote.selectedvotes.contains("SurvivalGames4")) {
											if(Bukkit.getWorlds().contains("SurvivalGames4")) {
												TeleportManager.teleporter(all, "SurvivalGames4", "livegame");
												setMapName("SurvivalGames4");
												for (Chunk localChunk : Bukkit.getWorld("SurvivalGames4").getLoadedChunks()) {
											    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
												        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
												        {
												          localBlockState.getBlock().setType(Material.CHEST);
												          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
												        }
											    	  }
												}
											}else {
											
												Bukkit.createWorld(WorldCreator.name("SurvivalGames4"));
												TeleportManager.teleporter(all, "SurvivalGames4", "livegame");
												setMapName("SurvivalGames4");
												for (Chunk localChunk : Bukkit.getWorld("SurvivalGames4").getLoadedChunks()) {
											    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
												        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
												        {
												          localBlockState.getBlock().setType(Material.CHEST);
												          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
												        }
											    	  }
												}
												
											}
										}
										if(Vote.selectedvotes.contains("AlaskanVillage")) {
											Bukkit.createWorld(WorldCreator.name("AlaskanVillage"));
											TeleportManager.teleporter(all, "AlaskanVillage", "livegame");
											setMapName("AlaskanVillage");
											for (Chunk localChunk : Bukkit.getWorld("AlaskanOVillage").getLoadedChunks()) {
										    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
											        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
											        {
											          localBlockState.getBlock().setType(Material.CHEST);
											          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
											        }
										    	  }
											}
											
											
										}
										if(Vote.selectedvotes.contains("Turbulence")) {
											Bukkit.createWorld(WorldCreator.name("Turbulence"));
											TeleportManager.teleporter(all, "Turbulence", "livegame");
											setMapName("Turbulence");
											for (Chunk localChunk : Bukkit.getWorld("Turbulence").getLoadedChunks()) {
										    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
											        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
											        {
											          localBlockState.getBlock().setType(Material.CHEST);
											          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
											        }
										    	  }
											}
											//ChestAPI.fillTier1Chest(Bukkit.getWorld("Turbulence")); //TODO
											//ChestAPI.fillTier2Chest(Bukkit.getWorld("Turbulence"));
										}
										if(Vote.selectedvotes.contains("BreezeIsland2")) {
											Bukkit.createWorld(WorldCreator.name("BreezeIsland2"));
											TeleportManager.teleporter(all, "BreezeIsland2", "livegame");
											setMapName("BreezeIsland2");
											for (Chunk localChunk : Bukkit.getWorld("BreezeIsland2").getLoadedChunks()) {
										    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
											        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
											        {
											          localBlockState.getBlock().setType(Material.CHEST);
											          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
											        }
										    	  }
											}
											//ChestAPI.fillTier1Chest(Bukkit.getWorld("BreezeIsland2")); //TODO
											//ChestAPI.fillTier2Chest(Bukkit.getWorld("BreezeIsland2"));
										}
										if(Vote.selectedvotes.contains("Par72")) {
											Bukkit.createWorld(WorldCreator.name("Par72"));
											TeleportManager.teleporter(all, "Par72", "livegame");
											setMapName("Par72");
											for (Chunk localChunk : Bukkit.getWorld("Par72").getLoadedChunks()) {
										    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
											        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
											        {
											          localBlockState.getBlock().setType(Material.CHEST);
											          Main.getSGAPI().tier2_chests.add(localBlockState.getLocation());
											        }
										    	  }
											}
											
											
										}/*/
									}
									
								}
							}
							break;
					
				case PreGame:
					
					Main.getSGAPI().preGameTime -=1;
					try {
						MySQLAPI.updateCurrentState(Games.getGameState().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for(Player all : Bukkit.getOnlinePlayers()) {
						int seconds = Main.getSGAPI().preGameTime;
						if(Main.getSGAPI().preGameTime <= 30) {
							all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:" + seconds);
					
						}
					}
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.setLevel(Main.getSGAPI().preGameTime);
					}
					if(Main.getSGAPI().preGameTime == 30) {
						
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §bPlease wait §8[§e30§8] §bseconds before the games begin.");
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e30§8] §bseconds until the games begin!");
						
					}
					if(Main.getSGAPI().preGameTime == 10) {
						
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e10§8] §bseconds until the games begin!");
					}
					if(Main.getSGAPI().preGameTime < 10 && Main.getSGAPI().preGameTime > 5) {
						
					}
					if(Main.getSGAPI().preGameTime == 5 || Main.getSGAPI().preGameTime == 4 || Main.getSGAPI().preGameTime == 3 || Main.getSGAPI().preGameTime == 2) {
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.NOTE_PLING, 10, 3);
						}
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e" + Main.getSGAPI().preGameTime + "§8] §bseconds until the games begin!");
					}
					if(Main.getSGAPI().preGameTime == 1) {
						
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e1§8] §bsecond until the games begin!");
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.playSound(all.getLocation(), Sound.NOTE_PLING, 10, 3);
						}
					}
					if(Main.getSGAPI().preGameTime == 0) {
						setGameState(GameState.LiveGame);
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							Bukkit.getWorld(all.getWorld().getName()).setWeatherDuration(0);
							Bukkit.getWorld(all.getWorld().getName()).setTime(0);
							all.playSound(all.getLocation(), Sound.LEVEL_UP, 10, 1);
							all.sendMessage(MessageAPI.getServerPrefix() + " §bThe games have begun!");
						}
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							int seconds = Main.getSGAPI().preGameTime;
							all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:0" + seconds);
						}
						setMoveCancelled(false);
						
					}
					break;
				case LiveGame:
					
					setMoveCancelled(false);
					try {
						MySQLAPI.updateCurrentState(Games.getGameState().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(Main.getSGAPI().Players.size() == 1) {
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThe games have ended!");
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §r" + Main.getSGAPI().Players.iterator().next().getDisplayName() + " §ahas won the Survival Games!");
						setGameState(GameState.EndGame);
						//Player winnerplayer = Main.getSGAPI().Players.iterator().next();
						/*try {
							MySQLAPI.addGamesWon(winnerplayer);
						} catch (SQLException e) {
							
							e.printStackTrace();
						}*/
						
					
						
					}
					else if(Main.getSGAPI().Players.size() <= 3 & Main.getSGAPI().Players.size() > 1) {
						if(Main.getSGAPI().LiveDeathMatchSecond > 0 && Main.getSGAPI().LiveDeathMatchMinute == 0) {
							Main.getSGAPI().LiveDeathMatchSecond -= 1;
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.setLevel(Main.getSGAPI().LiveDeathMatchSecond);
								if(Main.getSGAPI().LiveDeathMatchSecond > 10) {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveDeathMatchMinute + ":" + Main.getSGAPI().LiveDeathMatchSecond);
								}else {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveDeathMatchMinute + ":0" + Main.getSGAPI().LiveDeathMatchSecond);
								}
							}
						}
					
						
						if(Main.getSGAPI().LiveDeathMatchSecond == 59) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e60§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 30) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e30§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 15) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e15§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 10) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e10§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 5) {
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e5§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 4) {
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e4§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 3) {
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e3§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 2) {
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e2§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 1) {
							
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §8[§e1§8] §bseconds until deathmatch begin!");
							}
						}
						if(Main.getSGAPI().LiveDeathMatchSecond == 0) {
							setGameState(GameState.PreDeathMatch);
							setMoveCancelled(true);
							Object localObject2;
							Object localObject4;
							for(Iterator spec = Main.getSGAPI().Spectators.iterator(); spec.hasNext();) {
								
								localObject4 = (Player)((Iterator)spec).next();
								
								TeleportManager.teleporter((Player) localObject4, getMapName(), "specspawn");
							}
							
							 for (localObject2 = Main.getSGAPI().Players.iterator(); ((Iterator)localObject2).hasNext();) {
							
								Object localObject3 = (Player)((Iterator)localObject2).next();
								TeleportManager.teleporter((Player) localObject3, getMapName(), "deathmatch");
								
								/*/
							
								if(Vote.selectedvotes.contains("SurvivalGames4")) {
								
									TeleportManager.teleporter((Player) all, "SurvivalGames4", "deathmatch");
									//ChestAPI.fillTier1Chest(Bukkit.getWorld("SurvivalGames4")); //TODO
								}
								if(Vote.selectedvotes.contains("AlaskanVillage")) {
									TeleportManager.teleporter((Player) all, "AlaskanVillage", "deathmatch");
									
								}
								if(Vote.selectedvotes.contains("Turbulence")) {
									TeleportManager.teleporter((Player) all, "Turbulence", "deathmatch");
									//ChestAPI.fillTier1Chest(Bukkit.getWorld("Turbulence")); //TODO
								}
								if(Vote.selectedvotes.contains("BreezeIsland2")) {
									TeleportManager.teleporter((Player) all, "BreezeIsland2", "deathmatch");
									//ChestAPI.fillTier1Chest(Bukkit.getWorld("BreezeIsland2")); //TODO
								}
								if(Vote.selectedvotes.contains("Par72")) {
									TeleportManager.teleporter((Player) all, "Par72", "deathmatch");
									//ChestAPI.fillTier1Chest(Bukkit.getWorld("Par72")); //TODO
								}/*/
							}
							
							
						}
						break;
					}else {
						
						if(Main.getSGAPI().LiveGameMinute > 0 && Main.getSGAPI().LiveGameSecond > 0) {
							Main.getSGAPI().LiveGameSecond -= 1;
							for(Player all : Bukkit.getOnlinePlayers()) {
								if(Main.getSGAPI().LiveGameSecond > 10) {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":" + Main.getSGAPI().LiveGameSecond);
								}else {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":0" + Main.getSGAPI().LiveGameSecond);
								}
							}
						}
						if(Main.getSGAPI().LiveGameMinute == 16 && Main.getSGAPI().LiveGameSecond == 58) {
							Main.getSGAPI().used_chests.clear();
							for(Player all : Bukkit.getOnlinePlayers()) {
								all.sendMessage(MessageAPI.getServerPrefix() + " §bSponsors have refilled the chests.");
								all.sendMessage(MessageAPI.getServerPrefix() + " §fSponsor Staff: " + MessageAPI.setColouredString("WalkingUcak_") + " " + MessageAPI.setColouredString("NightBladeYasuo") + " " + MessageAPI.setColouredString("Qwe2380") + " " + MessageAPI.setColouredString("iSpeedy_HD") + " " + MessageAPI.setColouredString("PvpciMuz"));
								
							}
						}
						if(Main.getSGAPI().LiveGameSecond == 0 && Main.getSGAPI().LiveGameMinute > 0) {
							Main.getSGAPI().LiveGameMinute -= 1;
							Main.getSGAPI().LiveGameSecond = 59;
							for(Player all : Bukkit.getOnlinePlayers()) {
								if(Main.getSGAPI().LiveGameSecond > 10) {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":" + Main.getSGAPI().LiveGameSecond);
								}else {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":0" + Main.getSGAPI().LiveGameSecond);
								}
							}
						}
						if(Main.getSGAPI().LiveGameMinute == 0 && Main.getSGAPI().LiveGameSecond > 0) {
								Main.getSGAPI().LiveGameSecond -= 1;
								for(Player all : Bukkit.getOnlinePlayers()) {
									if(Main.getSGAPI().LiveGameSecond > 10) {
										all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":" + Main.getSGAPI().LiveGameSecond);
									}else {
										all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":0" + Main.getSGAPI().LiveGameSecond);
									}
								}
						}
						if(Main.getSGAPI().LiveGameMinute == 0 && Main.getSGAPI().LiveGameSecond == 0) {
							setGameState(GameState.PreDeathMatch);
							setPreDeathmatchTime(11);
							Main.getSGAPI().allowToMove = true;
							for(Player all : Bukkit.getOnlinePlayers()) {
								if(Main.getSGAPI().LiveGameSecond > 10) {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":" + Main.getSGAPI().LiveGameSecond);
								}else {
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().LiveGameMinute + ":0" + Main.getSGAPI().LiveGameSecond);
								}
							}
						}
					}
					
					
					break;
				case PreDeathMatch:
					
					Main.getSGAPI().preDeathmatchTime -=1;
					try {
						MySQLAPI.updateCurrentState(Games.getGameState().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(Main.getSGAPI().preDeathmatchTime > 0) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.setLevel(Main.getSGAPI().preDeathmatchTime);
							int seconds = Main.getSGAPI().preDeathmatchTime;
							all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:" + seconds);
						}
					}					
					if(Main.getSGAPI().preDeathmatchTime == 10) {
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §4Please allow §8[§e10§8] §4seconds for all players load the map.");
					}
					if(Main.getSGAPI().preDeathmatchTime == 5 || Main.getSGAPI().preDeathmatchTime == 4 || Main.getSGAPI().preDeathmatchTime == 3 || Main.getSGAPI().preDeathmatchTime == 2) {
						
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e" + Main.getSGAPI().preDeathmatchTime + "§8] §bseconds until the deathmatch!");
						for(Player all : Bukkit.getOnlinePlayers()) {
							int seconds = Main.getSGAPI().preGameTime;
							all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:0" + seconds);
						}
					}
					if(Main.getSGAPI().preDeathmatchTime == 1) {
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e1§8] §bsecond until the deathmatch!");

					}
					if(Main.getSGAPI().preDeathmatchTime == 0) {
						setGameState(GameState.DeathMatch);
						Main.getSGAPI().DeathmatchMinute = 3;
						Main.getSGAPI().DeathmatchSecond = 1;
						setMoveCancelled(false);
						
					}
					break;
				case DeathMatch:
					
					
					try {
						MySQLAPI.updateCurrentState(Games.getGameState().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(Main.getSGAPI().Players.size() == 1) {
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThe games have ended!");
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §r" + Main.getSGAPI().Players.iterator().next().getDisplayName() + " §ahas won the Survival Games!");
						setGameState(GameState.EndGame);
						Main.getSGAPI().endGameTime = 15;
						//Player winnerplayer = Main.getSGAPI().Players.iterator().next();
						/*try {
							MySQLAPI.addGamesWon(winnerplayer);
						} catch (SQLException e) {
							
							e.printStackTrace();
						}*/
						
						
					
					}else if(Main.getSGAPI().Players.size() > 1) {
						if(Main.getSGAPI().DeathmatchSecond == 0 && Main.getSGAPI().DeathmatchMinute > 0) {
							Main.getSGAPI().DeathmatchMinute -= 1;
							Main.getSGAPI().DeathmatchSecond = 59;
							
							
						}
						if(Main.getSGAPI().DeathmatchMinute > 0 && Main.getSGAPI().DeathmatchSecond > 0) {
							
							Main.getSGAPI().DeathmatchSecond -=1;
							for(Player all : Bukkit.getOnlinePlayers()) {
								if(Main.getSGAPI().DeathmatchSecond < 10 ) {
								
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().DeathmatchMinute + "§b:0" + Main.getSGAPI().DeathmatchSecond);
								
								}else if(Main.getSGAPI().DeathmatchSecond >= 10) {
									
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().DeathmatchMinute + "§b:" + Main.getSGAPI().DeathmatchSecond);
									
								}
							}
							if(Main.getSGAPI().DeathmatchSecond == 0 && Main.getSGAPI().DeathmatchMinute > 0) {
								Main.getSGAPI().DeathmatchMinute -= 1;
								Main.getSGAPI().DeathmatchSecond = 59;
								
								
							}
						}else if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond > 0) {
							
							Main.getSGAPI().DeathmatchSecond -=1;
							for(Player all : Bukkit.getOnlinePlayers()) {
								if(Main.getSGAPI().DeathmatchSecond < 10 ) {
								
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().DeathmatchMinute + "§b:0" + Main.getSGAPI().DeathmatchSecond);
								
								}else if(Main.getSGAPI().DeathmatchSecond >= 10) {
									
									all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b" + Main.getSGAPI().DeathmatchMinute + "§b:" + Main.getSGAPI().DeathmatchSecond);
									
								}
							}
							
						}else if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond == 0) {
							if(Main.getSGAPI().Players.size() > 1) {
								setGameState(GameState.EndGame);
								Main.getSGAPI().endGameTime = 15;
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThe games have ended!");
								
							}
						}
						
						
						
						
						/*/
					
						if(Main.getSGAPI().deathMatchTime <= 180 && Main.getSGAPI().deathMatchTime > 120) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								int seconds = Main.getSGAPI().deathMatchTime-120;
								all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b02:" + seconds);
							}
						}
						if(Main.getSGAPI().deathMatchTime > 120 && Main.getSGAPI().deathMatchTime <130) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								int seconds = Main.getSGAPI().deathMatchTime-120;
								all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b02:0" + seconds);
							}
						}
						if(Main.getSGAPI().deathMatchTime == 120) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								int seconds = 00;
								all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b02:" + seconds);
							}
						}
						if(Main.getSGAPI().deathMatchTime > 60 && Main.getSGAPI().lobbyTime < 120) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								int seconds = Main.getSGAPI().lobbyTime-60;
								all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b01:" + seconds);
							}
						}
						if(Main.getSGAPI().deathMatchTime > 60 && Main.getSGAPI().deathMatchTime < 120 && Main.getSGAPI().deathMatchTime < 70) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								int seconds = Main.getSGAPI().lobbyTime-60;
								all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b01:0" + seconds);
							}
						}
						if(Main.getSGAPI().deathMatchTime < 60 && Main.getSGAPI().deathMatchTime < 120) {
							for(Player all : Bukkit.getOnlinePlayers()) {
								int seconds = Main.getSGAPI().lobbyTime;
								all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:" + seconds);
							}
						}/*/
						if(Main.getSGAPI().DeathmatchMinute == 2 && Main.getSGAPI().DeathmatchSecond == 59) {
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e3§8] §bminutes until deathmatch ends!");
						}
						if(Main.getSGAPI().DeathmatchMinute == 1 && Main.getSGAPI().DeathmatchSecond == 59) {
							Main.getSGAPI().getConfig().set("DeathMatch-Lightning-Around", 20);
							Main.getSGAPI().saveConfig();
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e2§8] §bminutes until deathmatch ends!");
						}
						if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond == 59) {
							Main.getSGAPI().getConfig().set("DeathMatch-Lightning-Around", 15);
							Main.getSGAPI().saveConfig();
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e1§8] §bminute until deathmatch ends!");
						}
						if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond == 30) {
							Main.getSGAPI().getConfig().set("DeathMatch-Lightning-Around", 10);
							Main.getSGAPI().saveConfig();
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e30§8] §bseconds until deathmatch ends!");
						}
						if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond == 10) {
							Main.getSGAPI().getConfig().set("DeathMatch-Lightning-Around", 5);
							Main.getSGAPI().saveConfig();
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e10§8] §bseconds until deathmatch ends!");
						}
						//if(Main.getSGAPI().DeathmatchMinute < 1 && Main.getSGAPI().DeathmatchSecond == 5 || Main.getSGAPI().DeathmatchSecond == 4 || Main.getSGAPI().DeathmatchSecond == 3 || Main.getSGAPI().DeathmatchSecond ==2) {
							//Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e" + Main.getSGAPI().DeathmatchSecond + "§8] §bseconds until deathmatch ends!");
						//}
						if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond == 1) {
							Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §8[§e1§8] §bsecond until deathmatch ends!");
						}
						if(Main.getSGAPI().DeathmatchMinute == 0 && Main.getSGAPI().DeathmatchSecond == 0) {
							setGameState(GameState.EndGame);
						}
					}
					break;
				case EndGame:
					try {
						MySQLAPI.updateCurrentState(Games.getGameState().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Main.getSGAPI().endGameTime -=1;
					Player winnerplayer = Main.getSGAPI().Players.iterator().next();
					FireWorkAPI.spawnFireworks(winnerplayer, winnerplayer.getLocation());
					if(Main.getSGAPI().endGameTime > 0) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.setLevel(Main.getSGAPI().endGameTime);
							int seconds = Main.getSGAPI().endGameTime;
							all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:" + seconds);
						}
					}
					for(Player all : Bukkit.getOnlinePlayers()) {
						all.setLevel(Main.getSGAPI().endGameTime);
					}
					if(Main.getSGAPI().endGameTime == 0) {
						setGameState(GameState.Cleanup);
					}
					break;
				case Cleanup:
					try {
						MySQLAPI.updateCurrentState(Games.getGameState().toString());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Main.getSGAPI().cleanUpTime -=1;
					if(Main.getSGAPI().cleanUpTime > 0) {
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.setLevel(Main.getSGAPI().cleanUpTime);
							int seconds = Main.getSGAPI().cleanUpTime;
							all.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName("§a" + Main.getSGAPI().gameState + " §b00:" + seconds);
						}
					}
					if(Main.getSGAPI().cleanUpTime == 1) {
						
						for(Player all : Bukkit.getOnlinePlayers()) {
							all.sendMessage("§fSending you to a hub...");
							connectHUB(all);
							Bukkit.unloadWorld(Bukkit.getWorld("SurvivalGames4"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("AlaskanVillage"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("Turbulence"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("Par72"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("BreezeIsland2"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("SurvivalGamesAdrenaline"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("Zone85"), true);
							Bukkit.unloadWorld(Bukkit.getWorld("DemonsBreeze"), true);
							
							
						}
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload");
						Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getSGAPI(), new Runnable() {
							public void run() {
								Main.getSGAPI().reloadConfig();
								Plugin p = Bukkit.getPluginManager().getPlugin("MineGamerSG");
								Bukkit.getServer().getPluginManager().disablePlugin(p);
								try {
									Bukkit.getPluginManager().loadPlugin(new File("plugins/MineGamerSG.jar"));
								} catch (UnknownDependencyException | InvalidPluginException| InvalidDescriptionException e) {
									((Throwable) e).printStackTrace();
								}
									p = Bukkit.getPluginManager().getPlugin("MineGamerSG");
									Bukkit.getPluginManager().enablePlugin(p);
								 
								for(Player all : Bukkit.getOnlinePlayers()) {
									SBAPI.scoreBoardManager(all);
								}

							}
						}, 60L);
					}
					
					break;
				default:
					Bukkit.getScheduler().cancelTask(Main.getSGAPI().tick);
				}
			}
		}, 0L, 20L);
	}
	
	public static void connectHUB(Player p) { 
		 
	 ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF("EU-27");
       p.sendPluginMessage((Plugin) Main.getSGAPI(), "BungeeCord", out.toByteArray());
	}
	
	public static String getMapName() {
		return Main.getSGAPI().mapName;
	}
	
	public static void setMapName(String mapName) {
		Main.getSGAPI().mapName = mapName;
	}
	
	public static void setGameState(GameState gameState) {
		Main.getSGAPI().gameState = gameState;
	}
	
	public static GameState getGameState() {
		
		return Main.getSGAPI().gameState;
	}
	
	
	public static void setLobbyTime(int lobbyTime) {
		Main.getSGAPI().lobbyTime = lobbyTime;
	}
		
	public static Integer getLobbyTime() {
		return Main.getSGAPI().lobbyTime;
	}
		
	public static void setPreGameTime(int preGameTime) {
		Main.getSGAPI().preGameTime = preGameTime;
	}
		
	public static Integer getPreGameTime() {
		return Main.getSGAPI().preGameTime;
	}
	
	public static void setLiveGameTime(int gameTime) {
		Main.getSGAPI().gameTime = gameTime;
	}
	
	public static Integer getLiveGameTime() {
		return Main.getSGAPI().gameTime;
	}
	
	public static void setPreDeathmatchTime(int preDeathmatchTime) {
		Main.getSGAPI().preDeathmatchTime = preDeathmatchTime;
	}
	
	public static Integer getPreDeathmatchTime() {
		return Main.getSGAPI().deathMatchTime;
	}
	
	public static void setDeathmatchTime(int deathMatchTime) {
		Main.getSGAPI().deathMatchTime = deathMatchTime;
	}
	
	public static Integer getDeathMatchTime() {
		return Main.getSGAPI().deathMatchTime;
	}
	
	public static void setCleanUpTime(int cleanUpTime) {
		Main.getSGAPI().cleanUpTime = cleanUpTime;
	}
	
	public static void setMoveCancelled(boolean movecancelled) {
		
		Main.getSGAPI().allowToMove = movecancelled;
		
	}
	
	public static boolean getMoveCancelled() {
		
		return Main.getSGAPI().allowToMove;
	}

}
