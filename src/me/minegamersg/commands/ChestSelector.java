package me.minegamersg.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ChestSelector implements CommandExecutor{
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("chestselection")) {
			if(p.hasPermission("sg.chestselector")) {
				if(args.length == 0) {
					ItemStack selector = new ItemStack(Material.BLAZE_ROD);
					ItemMeta sm = selector.getItemMeta();
					sm.setDisplayName("Tier 2 Chest Selector");
					selector.setItemMeta(sm);
					p.getInventory().addItem(selector);
				}
			}
			
		}
		return false;
	}

}
