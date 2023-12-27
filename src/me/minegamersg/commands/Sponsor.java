package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;

public class Sponsor implements CommandExecutor{
	
	public static Inventory sponsorinv = Bukkit.createInventory(null, 9, "");

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("sponsor")) {
			if(args.length == 0) {
				if(Main.getSGAPI().Spectators.contains(p)) {
					
					p.sendMessage(MessageAPI.getServerPrefix() + " §c/sponsor <player>");
					
				}else {
					p.sendMessage(MessageAPI.getServerPrefix() + " §cYou are not use command right now!");
				}
			}else if(args.length == 1) {
				p.openInventory(sponsorinv);
				
				
			}
		}
		
		return false;
	} 

}
