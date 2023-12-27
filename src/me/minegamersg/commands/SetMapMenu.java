package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class SetMapMenu implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setmapmenu")) {
			if(p.hasPermission("Game.setmapmenu")) {
				
				Inventory mapinv = Bukkit.createInventory(null, 27, "§e§lSelect the Map");
				
				ItemStack sgmap = new ItemStack(Material.MAP);
				ItemMeta sgmapm = sgmap.getItemMeta();
				sgmapm.setDisplayName("§3SurvivalGames4");
				sgmap.setItemMeta(sgmapm);
				mapinv.setItem(0, sgmap);
				
				p.openInventory(mapinv);
				
				
			}
		}
		
		
		return false;
	}

}
