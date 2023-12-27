package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;
import me.minegamersg.api.SBAPI;

public class Sidebar implements CommandExecutor{

	public static void setSidebar(Player p, String style) {
		
		try {
			MySQLAPI.updateSidebar(p, style);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("sidebar")) {
			if(args.length == 0) {
				p.sendMessage("§3Use §b/sidebar styleName §3to change the sidebar style§8.");
				p.sendMessage("§aAvailable styles: §f2014§8, §f2015§8, §fdefault§8, §fminimized§8.");
			}else if(args.length == 1) {
				if(args[0].equalsIgnoreCase("2014")) {
					setSidebar(p, "2014");
					SBAPI.scoreBoardManager(p);
					p.sendMessage(MessageAPI.getServerPrefix() + " §aYour sidebar style has been changed§8.");
				}
				if(args[0].equalsIgnoreCase("2015")) {
					setSidebar(p, "2015");
					SBAPI.scoreBoardManager(p);
					p.sendMessage(MessageAPI.getServerPrefix() + " §aYour sidebar style has been changed§8.");
				}
				if(args[0].equalsIgnoreCase("default")) {
					setSidebar(p, "default");
					SBAPI.scoreBoardManager(p);
					p.sendMessage(MessageAPI.getServerPrefix() + " §aYour sidebar style has been changed§8.");
				}
				if(args[0].equalsIgnoreCase("minimized")) {
					setSidebar(p, "minimized");
					SBAPI.scoreBoardManager(p);
					p.sendMessage(MessageAPI.getServerPrefix() + " §aYour sidebar style has been changed§8.");
				}
			}
		}
		return false;
	}

}
