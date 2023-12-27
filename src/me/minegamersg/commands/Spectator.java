package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;

public class Spectator implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spectator")) {
			if(Main.getSGAPI().Spectators.contains(p)) {
				if(args.length == 0) {
					p.sendMessage(MessageAPI.getServerPrefix() + " §c/spec <playername>");
				}else if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(target.isOnline()) {
							if(Main.getSGAPI().Players.contains(target)) {
								p.teleport(target);
								p.sendMessage(MessageAPI.getServerPrefix() + " §fTeleporting to §r" + target.getDisplayName());
							}else {
								p.sendMessage(MessageAPI.getServerPrefix() + " §r" + target.getDisplayName() + " §cis already dead!");
							}
						}else {
							p.sendMessage(MessageAPI.getServerPrefix() + " §cPlayer is not online!");
						}
					}else {
						p.sendMessage(MessageAPI.getServerPrefix() + " §cPlayer is not found!");
					}
				}
			}else {
				p.sendMessage(MessageAPI.getServerPrefix() + " §cYou are not Spectator!");
			}
		}
		return false;
	}
	
	
	

}
