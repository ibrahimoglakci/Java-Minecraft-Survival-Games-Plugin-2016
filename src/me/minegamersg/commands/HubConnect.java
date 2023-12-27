package me.minegamersg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.Games;

public class HubConnect implements CommandExecutor{
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("hub")) {
			if(args.length == 0) {
				Games.connectHUB(p);
				p.sendMessage("§fSending you to a hub...");
			}
			
			
		}
		return false;
	}

}
