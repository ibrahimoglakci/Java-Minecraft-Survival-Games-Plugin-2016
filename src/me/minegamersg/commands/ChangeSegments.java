package me.minegamersg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Enum.GameState;
import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;

public class ChangeSegments implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("game")) {
			if(p.hasPermission("Game.args[1]")) {
				if(args.length == 0) {
					p.sendMessage(MessageAPI.getServerPrefix() + " §c/game <nextsegment/changesegment> <segment>");
				}else if(args.length == 1) {
					if(args[0].equalsIgnoreCase("nextsegment")) {
						if(Games.getGameState() == GameState.Lobby) {
							Games.setGameState(GameState.PreGame);
							
						}
						else if(Games.getGameState() == GameState.PreGame) {
							Games.setGameState(GameState.LiveGame);
						}
						else if(Games.getGameState() == GameState.LiveGame) {
							Games.setGameState(GameState.PreDeathMatch);
						}
						else if(Games.getGameState() == GameState.PreDeathMatch) {
							Games.setGameState(GameState.DeathMatch);
						}
						else if(Games.getGameState() == GameState.DeathMatch) {
							Games.setGameState(GameState.EndGame);
						}
						else if(Games.getGameState() == GameState.EndGame) {
							Games.setGameState(GameState.Cleanup);
						}
						else if (Games.getGameState() == GameState.Cleanup) {
							Games.setGameState(GameState.Lobby);
						}
						p.sendMessage(MessageAPI.getServerPrefix() + " §fThe Segment has been changed to " + Games.getGameState() + " §fby " + p.getDisplayName());
					}
				}else if(args.length == 2) {
					if(args[0].equalsIgnoreCase("changesegment")) {
						
						/*if(!args[1].equalsIgnoreCase("Lobby") || !args[1].equalsIgnoreCase("PreGame") || !args[1].equalsIgnoreCase("LiveGame") || !args[1].equalsIgnoreCase("PreDeathMatch") || !args[1].equalsIgnoreCase("DeathMatch") || !args[1].equalsIgnoreCase("EndGame") || !args[1].equalsIgnoreCase("Cleanup")) {
							p.sendMessage(MessageAPI.getServerPrefix() + " §e" + args[1] + "§c Segment not found!");
						}else*/ if(args[1].equalsIgnoreCase("Lobby") || args[1].equalsIgnoreCase("PreGame") || args[1].equalsIgnoreCase("LiveGame") || args[1].equalsIgnoreCase("PreDeathMatch") || args[1].equalsIgnoreCase("DeathMatch") || args[1].equalsIgnoreCase("EndGame") || args[1].equalsIgnoreCase("Cleanup")) {
							
							Games.setGameState(GameState.valueOf(args[1]));
							p.sendMessage(MessageAPI.getServerPrefix() + " §fThe Segment has been changed to " + Games.getGameState() + " §fby " + p.getDisplayName());
						}
						
					}
				}
			}
			
		}
	
		return false;
	}
	
	
	

}
