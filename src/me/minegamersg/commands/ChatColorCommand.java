package me.minegamersg.commands;

import java.sql.SQLException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.MySQLAPI;

public class ChatColorCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("chatcolor")) {
			try {
				if(!(MySQLAPI.getRank(player).equalsIgnoreCase("regular"))) {
					if (args.length == 0)
			        {
			          player.sendMessage(MessageAPI.getServerPrefix() + " §f You have the following options§8:");
			          player.sendMessage(MessageAPI.getServerPrefix() + " §c &c, §e&e, §9&9, §a&a, §b&b, §fOFF§8.");
			          player.sendMessage("§c/chatcolor <ColorCode:Off>");
			        }else if(args.length ==1) {
			        	if(args[0].equalsIgnoreCase("&c")) {
			        		MySQLAPI.updateChatColor(player, "c");
			        		player.sendMessage(MessageAPI.getServerPrefix() + " §f You have selected your chat color as §cRed§8!");
			        	}
			        	if(args[0].equalsIgnoreCase("&e")) {
			        		MySQLAPI.updateChatColor(player, "e");
			        		player.sendMessage(MessageAPI.getServerPrefix() + " §f You have selected your chat color as §eYellow§8!");
			        	}
			        	if(args[0].equalsIgnoreCase("&9")) {
			        		MySQLAPI.updateChatColor(player, "9");
			        		player.sendMessage(MessageAPI.getServerPrefix() + " §f You have selected your chat color as §9Blue§8!");
			        	}
			        	if(args[0].equalsIgnoreCase("&a")) {
			        		MySQLAPI.updateChatColor(player, "a");
			        		player.sendMessage(MessageAPI.getServerPrefix() + " §f You have selected your chat color as §aLight Green§8!");
			        	}
			        	if(args[0].equalsIgnoreCase("&b")) {
			        		MySQLAPI.updateChatColor(player, "b");
			        		player.sendMessage(MessageAPI.getServerPrefix() + " §f You have selected your chat color as §bAqua§8!");
			        	}
			        	if(args[0].equalsIgnoreCase("off")) {
			        		MySQLAPI.updateChatColor(player, "f");
			        		player.sendMessage(MessageAPI.getServerPrefix() + " §f You have selected your chat color as §fReset§8!");
			        	}
			        }
				}else {
					player.sendMessage(MessageAPI.getNoPermMessage());
					player.sendMessage(MessageAPI.getbuyDonatorMessage());
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return false;
	}
	

}
