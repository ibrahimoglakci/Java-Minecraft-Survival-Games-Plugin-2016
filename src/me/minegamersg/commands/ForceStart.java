package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;

public class ForceStart implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("forcestart")) {
			if(p.hasPermission("Game.forcestart")) {
				if(args.length == 0) {
					if(p.getName().equalsIgnoreCase("WalkingUcak_")) {
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §fThe game has been forcestarted by §r" + MessageAPI.setColouredString("WalkingUcak_"));
					}else {
						
						Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §fThe game has been forcestarted by §r" + p.getDisplayName());
						
					}
					Games.setLobbyTime(2);
					
					
				}
			}
				
		}
	
		return false;
	}

}
