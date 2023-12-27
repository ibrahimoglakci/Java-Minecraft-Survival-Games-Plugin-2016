package me.minegamersg.commands;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;

public class SGList implements CommandExecutor{

	@SuppressWarnings({ "unused", "rawtypes", "deprecation" })
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("list")) {
			if(args.length == 0) {
				/*/p.sendMessage(MessageAPI.getServerPrefix() + " &fThere are &8[&6".replace("&", "§") + Bukkit.getOnlinePlayers().length + "&8/&624&8] &fplayers online".replace("&", "§"));
				p.sendMessage(MessageAPI.getServerPrefix() + " §f§lIngame§8:§r " );
				if(Games.getGameState() != GameState.Lobby) {
					if(Main.getSGAPI().Spectators.isEmpty()) {
						p.sendMessage(MessageAPI.getServerPrefix() + " §f§lWatching§8:§r ");
						
					}else {
						p.sendMessage(MessageAPI.getServerPrefix() + " §f§lWatching§8:§r " + Main.getSGAPI().Spectators.iterator().next().getDisplayName());
					}
				}/*/
				  Player localPlayer = p;
			      String str1 = "";
			      Integer localInteger1 = Integer.valueOf(0);
			      String str2 = "";
			      Integer localInteger2 = Integer.valueOf(0);
			      Player localOfflinePlayer;
			      for (Iterator localIterator = Main.getSGAPI().Players.iterator(); localIterator.hasNext();)
			      {
			        localOfflinePlayer = (Player)localIterator.next();
			        if (localOfflinePlayer.isOnline()) {
			          if (Main.getSGAPI().Players.size() > localInteger1.intValue()) {
			            str1 = str1 + localOfflinePlayer.getDisplayName() + "§f, ";
			          } else {
			            str1 = str1 + localOfflinePlayer.getDisplayName() + " ";
			          }
			        }
			        localInteger1 = Integer.valueOf(localInteger1.intValue() + 1);
			      }
			      
			      for (Iterator localIterator = Main.getSGAPI().Spectators.iterator(); localIterator.hasNext();)
			      {
			        localOfflinePlayer = (Player)localIterator.next();
			        if (localOfflinePlayer.isOnline()) {
			          if (Main.getSGAPI().Spectators.size() > localInteger2.intValue()) {
			            str2 = str2 + localOfflinePlayer.getDisplayName() + "§f, ";
			          } else {
			            str2 = str2 + localOfflinePlayer.getDisplayName() + " ";
			          }
			        }
			        localInteger2 = Integer.valueOf(localInteger2.intValue() + 1);
			      }
			      
			      p.sendMessage(MessageAPI.getServerPrefix() + " &fThere are &8[&6".replace("&", "§") + Bukkit.getOnlinePlayers().length + "&8/&624&8] &fplayers online".replace("&", "§"));
			      p.sendMessage(MessageAPI.getServerPrefix() + " §f§lIngame§8:§r " + str1 );
			      p.sendMessage(MessageAPI.getServerPrefix() + " §f§lWatching§8:§r " + str2 );
			}
			
		}
		return false;
	}
	
	
	

}
