package me.minegamersg.commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;

public class Vote implements CommandExecutor{

	
	
	public static int sg4 = 0;
	public static int alaskanvillage = 0;
	public static int turbulence = 0;
	public static int breezeisland2 = 0;
	public static int par72 = 0;
	public static int adrenaline = 0;
	public static int zone85 = 0;
	public static int demonsbreeze = 0;
	
	public static ArrayList<String> selectedvotes = new ArrayList<String>();
	
	public static ArrayList<Player> usingvote = new ArrayList<Player>();
	
	

	

	public static void selectVotes() {
		

		if(Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1453 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 1674 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 2655 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 2999 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 1985) {
			if(sg4 > alaskanvillage && sg4 > turbulence && sg4 > breezeisland2 && sg4 > par72) {
				selectedvotes.clear();
				selectedvotes.add("SurvivalGames4");
				Games.setMapName("SurvivalGames4");
				
				
			}else if(alaskanvillage > sg4 && alaskanvillage > turbulence && alaskanvillage > breezeisland2 && alaskanvillage > par72) {
				selectedvotes.clear();
				selectedvotes.add("AlaskanVillage");
				Games.setMapName("AlaskanVillage");

				
			}else if(turbulence > sg4 && turbulence > alaskanvillage && turbulence > breezeisland2 && turbulence > par72) {
				selectedvotes.clear();
				selectedvotes.add("Turbulence");
				Games.setMapName("Turbulence");

				
			}else if(breezeisland2 > sg4 && breezeisland2 > alaskanvillage && breezeisland2 > turbulence && breezeisland2 > par72) {
				selectedvotes.clear();
				selectedvotes.add("BreezeIsland2");
				Games.setMapName("BreezeIsland2");

				
			}else if(par72 > sg4 && par72 > alaskanvillage && par72 > breezeisland2 && par72 > turbulence) {
				selectedvotes.clear();
				selectedvotes.add("Par72");
				Games.setMapName("Par72");
				
			}else {
				ArrayList<String> selectingvote = new ArrayList<String>();
				if(selectingvote.isEmpty()) {
					selectingvote.add("SurvivalGames4");
					selectingvote.add("AlaskanVillage");
					selectingvote.add("Turbulence");
					selectingvote.add("BreezeIsland2");
					selectingvote.add("Par72");
					int rand = new Random().nextInt(selectingvote.size());
					String selectvote = selectingvote.get(rand);
					selectedvotes.clear();
					selectedvotes.add(selectvote);
					Games.setMapName(selectvote);
					
				}
			}
		}else if(Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1674 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 2655 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 2999 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1985) {
			if(adrenaline > zone85 && adrenaline > demonsbreeze && sg4 > breezeisland2 && adrenaline > par72) {
				selectedvotes.clear();
				selectedvotes.add("SurvivalGames:Adrenaline");
				Games.setMapName("SurvivalGames:Adrenaline");
				
			}else if(zone85 > adrenaline && zone85 > demonsbreeze && zone85 > breezeisland2 && zone85 > par72) {
				selectedvotes.clear();
				selectedvotes.add("Zone85");
				Games.setMapName("Zone85");
				
			}else if(demonsbreeze > adrenaline && demonsbreeze > zone85 && demonsbreeze > breezeisland2 && demonsbreeze > par72) {
				selectedvotes.clear();
				selectedvotes.add("DemonsBreeze");
				Games.setMapName("DemonsBreeze");
				
			}else if(breezeisland2 > adrenaline && breezeisland2 > zone85 && breezeisland2 > demonsbreeze && breezeisland2 > par72) {
				selectedvotes.clear();
				selectedvotes.add("BreezeIsland2");
				Games.setMapName("SurvivalGames:Adrenaline");
				
			}else if(par72 > adrenaline && par72 > zone85 && par72 > breezeisland2 && par72 > demonsbreeze) {
				selectedvotes.clear();
				selectedvotes.add("Par72");
				Games.setMapName("Par72");
				
			}else {
				ArrayList<String> selectingvote = new ArrayList<String>();
				if(selectingvote.isEmpty()) {
					selectingvote.add("SurvivalGames:Adrenaline");
					selectingvote.add("Zone85");
					selectingvote.add("DemonsBreeze");
					selectingvote.add("BreezeIsland2");
					selectingvote.add("Par72");
					int rand = new Random().nextInt(selectingvote.size());
					String selectvote = selectingvote.get(rand);
					selectedvotes.clear();
					selectedvotes.add(selectvote);
					Games.setMapName(selectvote);
					
				}
			}
		}
		
	}
	
	
	public static void sendVoteMessage(Player p) {
		if(Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1453 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 1674 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 2655 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 2999 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 1985) {
			
			
			int sg4chance = (int) Math.round(sg4 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
			
			int alaskanchance = (int) Math.round(alaskanvillage * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
				 
			int turbulencechance = (int) Math.round(turbulence * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
				
			int breezechance = (int) Math.round(breezeisland2 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
				
			int par72chance = (int) Math.round(par72 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 + par72));
			if(sg4chance == 0 && alaskanchance == 0 && turbulencechance == 0 && breezechance == 0 && par72chance == 0){
				sg4chance = 20;
				alaskanchance = 20;
				turbulencechance = 20;
				breezechance = 20;
				par72chance = 20;
				
			}else {
				sg4chance = (int) Math.round(sg4 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
				
				alaskanchance = (int) Math.round(alaskanvillage * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
					 
				turbulencechance = (int) Math.round(turbulence * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
					
				breezechance = (int) Math.round(breezeisland2 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 +par72));
					
				par72chance = (int) Math.round(par72 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 + par72));
			}
			
			p.sendMessage(MessageAPI.getServerPrefix() + " §2Players waiting§8 [§6" + Main.getSGAPI().Players.size() + "§6/24§8]. §2Game requires §8[§66§8] §2to play§8.");
			p.sendMessage(MessageAPI.getServerPrefix() + " §2Vote using §8[§a/vote #§8].");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a1 §8§l> §8| §e" + sg4 + " §7Votes §8| §e" + sg4chance + "% §7Chance §8| §2Survival Games 4");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a2 §8§l> §8| §e" + alaskanvillage + " §7Votes §8| §e" + alaskanchance + "% §7Chance §8| §2AlaskanVillage");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a3 §8§l> §8| §e" + turbulence + " §7Votes §8| §e" + turbulencechance + "% §7Chance §8| §2Turbulence");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a4 §8§l> §8| §e" + breezeisland2 + " §7Votes §8| §e" + breezechance + "% §7Chance §8| §2Breeze Island 2");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a5 §8§l> §8| §e" + par72 + " §7Votes §8| §e" + par72chance + "% §7Chance §8| §2Par72");
		}else if(Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1483 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1674 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 2655 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 2999 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1985) {
			
			int adrenalinechance = (int) Math.round(adrenaline * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
			
			int zone85chance = (int) Math.round(alaskanvillage * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
				 
			int demonsbreezechance = (int) Math.round(turbulence * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
				
			int breezechance = (int) Math.round(breezeisland2 * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
				
			int par72chance = (int) Math.round(par72 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 + par72));
			
			if(adrenalinechance == 0 && zone85chance == 0 && demonsbreezechance == 0 && breezechance == 0 && par72chance == 0){
				adrenalinechance = 20;
				zone85chance = 20;
				demonsbreezechance = 20;
				breezechance = 20;
				par72chance = 20;
				
			}else {
				adrenalinechance = (int) Math.round(adrenaline * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
				
				zone85chance = (int) Math.round(alaskanvillage * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
					 
				demonsbreezechance = (int) Math.round(turbulence * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
					
				breezechance = (int) Math.round(breezeisland2 * 100D / (adrenaline + zone85 + demonsbreeze + breezeisland2 +par72));
					
				par72chance = (int) Math.round(par72 * 100D / (sg4 + alaskanvillage + turbulence + breezeisland2 + par72));
			}
			
			p.sendMessage(MessageAPI.getServerPrefix() + " §2Players waiting§8 [§6" + Main.getSGAPI().Players.size() + "§6/24§8]. §2Game requires §8[§66§8] §2to play§8.");
			p.sendMessage(MessageAPI.getServerPrefix() + " §2Vote using §8[§a/vote #§8].");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a1 §8§l> §8| §e" + adrenaline + " §7Votes §8| §e" + adrenalinechance + "% §7Chance §8| §2Survival Games: Adrenaline");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a2 §8§l> §8| §e" + zone85 + " §7Votes §8| §e" + zone85chance + "% §7Chance §8| §2Zone 85");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a3 §8§l> §8| §e" + demonsbreeze + " §7Votes §8| §e" + demonsbreezechance + "% §7Chance §8| §2Demons Breeze");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a4 §8§l> §8| §e" + breezeisland2 + " §7Votes §8| §e" + breezechance + "% §7Chance §8| §2Breeze Island 2");
			p.sendMessage(MessageAPI.getServerPrefix() + " §a5 §8§l> §8| §e" + par72 + " §7Votes §8| §e" + par72chance + "% §7Chance §8| §2Par72");
			
		}
	}
	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("vote")) {
			if(Games.getGameState() == GameState.Lobby ) {
				if(args.length == 0) {
					sendVoteMessage(p);
				}else if(args.length == 1){
					if(Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1453 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 1674 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 2655 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 2999 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") != 1985) {
						if(args[0].equalsIgnoreCase("1")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = sg4 + 120;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = sg4 + 90;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = sg4 + 7;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = sg4 + 6;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = sg4 + 5;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = sg4 + 5;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = sg4 + 4;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = sg4 + 3;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = sg4 + 2;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = sg4 + 2;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = sg4 + 1;
									sg4 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + sg4 + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("2")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 120;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 90;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 7;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 6;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 5;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 5;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 4;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 3;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 2;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = alaskanvillage + 2;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = alaskanvillage + 1;
									alaskanvillage = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + alaskanvillage + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("3")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = turbulence + 120;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = turbulence + 90;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = turbulence + 7;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = turbulence + 6;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = turbulence + 5;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = turbulence + 5;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = turbulence + 4;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = turbulence + 3;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = turbulence + 2;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = turbulence + 2;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = turbulence + 1;
									turbulence = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + turbulence + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("4")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 120;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 90;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 7;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 6;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 5;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 5;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 4;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 3;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 2;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 2;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = breezeisland2 + 1;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("5")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = par72 + 120;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = par72 + 90;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = par72 + 7;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = par72 + 6;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = par72 + 5;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = par72 + 5;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = par72 + 4;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = par72 + 3;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = par72 + 2;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = par72 + 2;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = par72 + 1;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}
							}
						}
					}else if(Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1674 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 2655 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 2999 || Main.getSGAPI().getConfig().getInt("Server-Name-Number") == 1985) {
						
						if(args[0].equalsIgnoreCase("1")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = adrenaline + 120;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = adrenaline + 90;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = adrenaline + 7;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = adrenaline + 6;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = adrenaline + 5;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = adrenaline + 5;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = adrenaline + 4;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = adrenaline + 3;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = adrenaline + 2;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = adrenaline + 2;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = adrenaline + 1;
									adrenaline = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + adrenaline + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("2")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = zone85 + 120;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = zone85 + 90;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = zone85 + 7;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = zone85 + 6;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = zone85 + 5;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = zone85 + 5;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = zone85 + 4;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = zone85 + 3;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = zone85 + 2;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = zone85 + 2;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = zone85 + 1;
									zone85 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + zone85 + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("3")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 120;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 90;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 7;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 6;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 5;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 5;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 4;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 3;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 2;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = demonsbreeze + 2;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = demonsbreeze + 1;
									demonsbreeze = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + demonsbreeze + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("4")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 120;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 90;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 7;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 6;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 5;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 5;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 4;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 3;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 2;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = breezeisland2 + 2;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = breezeisland2 + 1;
									breezeisland2 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + breezeisland2 + "§8] §fvotes");
								}
							}
						}else if(args[0].equalsIgnoreCase("5")) {
							if(usingvote.contains(p)) {
								p.sendMessage(MessageAPI.getServerPrefix() + " §4You have already using vote.");
							}else {
								if(p.hasPermission("vote.owner")) {
									usingvote.add(p);
									int addvote = par72 + 120;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.admin")) {
									usingvote.add(p);
									int addvote = par72 + 90;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.srmoderator")) {
									usingvote.add(p);
									int addvote = par72 + 7;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.moderator")) {
									usingvote.add(p);
									int addvote = par72 + 6;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.mapmaker")) {
									usingvote.add(p);
									int addvote = par72 + 5;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.vip")) {
									usingvote.add(p);
									int addvote = par72 + 5;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.quantum")) {
									usingvote.add(p);
									int addvote = par72 + 4;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.platinum")) {
									usingvote.add(p);
									int addvote = par72 + 3;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.diamond")) {
									usingvote.add(p);
									int addvote = par72 + 2;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else if(p.hasPermission("vote.gold")) {
									usingvote.add(p);
									int addvote = par72 + 2;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}else {
									usingvote.add(p);
									int addvote = par72 + 1;
									par72 = addvote;
									p.sendMessage(MessageAPI.getServerPrefix() + " §fYour map now has §8[§6" + par72 + "§8] §fvotes");
								}
							}
						}
						
					}
				}
			}else{
				p.sendMessage(MessageAPI.getServerPrefix() + " §cVote is currently disabled right now!");
			}
		}
		return false;
	}
	
	

}
