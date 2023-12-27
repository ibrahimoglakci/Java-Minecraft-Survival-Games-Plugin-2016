package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;
//import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.MySQLAPI;

public class Bounty implements CommandExecutor{
	

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("bounty")) {
			if(Main.getSGAPI().Spectators.contains(p)) {
				if(args.length == 0) {
					
					p.sendMessage(MessageAPI.getServerPrefix() + " §c/bounty <player> <bounty>");
					
				}else if(args.length == 1){
					p.sendMessage(MessageAPI.getServerPrefix() + " §cPlease enter bounty number!");
					
				}else if(args.length == 2) {
					Player target = Bukkit.getPlayer(args[0]);
					int bounty = Integer.parseInt(args[1]);
					try {
						if(MySQLAPI.getBounty(p) < 10) {
							p.sendMessage(MessageAPI.getServerPrefix() + " §cYou can send minimum §8[§e10§8] §cbounty!");
						}else if(MySQLAPI.getBounty(p) >= 10) {
							if(MySQLAPI.getBounty(p) >= bounty) {
								
								MySQLAPI.addBounty(target, bounty);
								MySQLAPI.removeBounty(p, bounty);
								Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §3Bounty has been set on " + target.getDisplayName() + " §3of " + p.getDisplayName() + " §3for §8[§e" + bounty +  "§8] §3points§8.");
								
							}else {
								p.sendMessage(MessageAPI.getServerPrefix() + " §cYou need more §8[§e" + bounty + "§8] §cbounty!");
							}
						}
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
			}
		}
		
		return false;
	} 
	
	


}
