package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.MySQLAPI;

public class Stats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("stats")) {
			if(args.length == 0) {
				p.sendMessage(MessageAPI.getServerPrefix() + " §r" + p.getDisplayName() + "§f's Records");
				try {
					p.sendMessage(MessageAPI.getServerPrefix() + " §fPoints§8: §e" + MySQLAPI.getBounty(p));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					p.sendMessage(MessageAPI.getServerPrefix() + " §fGames (Won/Total)§8: §e" + MySQLAPI.getGamesWon(p) + "§8/§e" + MySQLAPI.getGamesTotal(p));
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				try {
					p.sendMessage(MessageAPI.getServerPrefix() + " §fKills§8/§fDeaths§8: §e" + MySQLAPI.getKills(p) + "§8/§e" + MySQLAPI.getDeaths(p));
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				try {
					p.sendMessage(MessageAPI.getServerPrefix() + " §fChests (Tier1/Tier2/All)§8: §e" + MySQLAPI.getTier1ChestOpen(p) + "§8/§e" + MySQLAPI.getTier2ChestOpen(p) + "§8/§e" + MySQLAPI.getAllChestOpen(p));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if(target != null) {
					if(target.isOnline()) {
						
						p.sendMessage(MessageAPI.getServerPrefix() + " §r" + target.getDisplayName() + "§f's Records");
						try {
							p.sendMessage(MessageAPI.getServerPrefix() + " §fPoints§8: §e" + MySQLAPI.getBounty(target));
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						try {
							p.sendMessage(MessageAPI.getServerPrefix() + " §fGames (Won/Total)§8: §e" + MySQLAPI.getGamesWon(target) + "§8/§e" + MySQLAPI.getGamesTotal(target));
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						try {
							p.sendMessage(MessageAPI.getServerPrefix() + " §fKills§8: §e" + MySQLAPI.getKills(target));
						} catch (SQLException e) {
						
							e.printStackTrace();
						}
						try {
							p.sendMessage(MessageAPI.getServerPrefix() + " §fChests (Tier1/Tier2/All)§8: §e" + MySQLAPI.getTier1ChestOpen(target) + "§8/§e" + MySQLAPI.getTier2ChestOpen(target) + "§8/§e" + MySQLAPI.getAllChestOpen(target));
						} catch (SQLException e) {
							e.printStackTrace();
						}
						
					}else {
						p.sendMessage(MessageAPI.getServerPrefix() + " §cPlayer is not online!");
					}
					
				}else {
					p.sendMessage(MessageAPI.getServerPrefix() + " §cPlayer is not found!");
				}
				
			}
		}
		return false;
	}
	
	
	

}
