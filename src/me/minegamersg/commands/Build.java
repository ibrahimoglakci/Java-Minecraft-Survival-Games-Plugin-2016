package me.minegamersg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;

public class Build implements CommandExecutor{
	
	public static boolean buildmode;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("build")) {
			if(p.hasPermission("asd.asd")) {
				if(args.length == 0){
					p.sendMessage(MessageAPI.getServerPrefix() + " §cUsage: /build <on:off>");
				}else {
					if(args[0].equalsIgnoreCase("on")) {
						if(buildmode != true){
							buildmode = true;
							p.sendMessage(MessageAPI.getServerPrefix() + " §bYou have enabled §eBuild §bmode§8.");
							p.sendMessage(MessageAPI.getServerPrefix() + " §cBlocks in Survival Games will not save§8.");
							p.sendMessage(MessageAPI.getServerPrefix() + " §cPlease get an admin if you wish to do this§8.");
							p.sendMessage(MessageAPI.getServerPrefix() + " §bUse §e/build off §bto leave this mode§8.");
						
						}else if(buildmode == true){
							p.sendMessage(MessageAPI.getServerPrefix() + " §cAlready enabled §eBuild §cmode this server§8.");
						}
					}
					if(args[0].equalsIgnoreCase("off")) {
						if(buildmode != false){
							buildmode = false;
							p.sendMessage(MessageAPI.getServerPrefix() + " §bYou have disabled §eBuild §bmode§8.");
						}else if(buildmode == false){
							p.sendMessage(MessageAPI.getServerPrefix() + " §cAlready disabled §eBuild §cmode this server§8.");
						}
						
					}
				}
			}else {
				p.sendMessage(MessageAPI.getNoPermMessage());
			}
		} 
		return false;
	}

}
