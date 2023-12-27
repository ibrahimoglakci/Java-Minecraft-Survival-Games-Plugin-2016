package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TeleportWorld implements CommandExecutor{
	
	public static Inventory sponsorinv = Bukkit.createInventory(null, 9, "");

	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("tpworld")) {
			if(args.length == 1) {
				p.teleport((Location) Bukkit.getWorld("Hub"));
				
				
			}
		}
		
		return false;
	} 

}
