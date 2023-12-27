package me.minegamersg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Enum.GameState;
import me.minegamersg.Main.Main;
import me.minegamersg.api.Games;
import me.minegamersg.api.MessageAPI;

public class InfoCommands implements CommandExecutor{
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("info")) {
			if(args.length == 0) {
				p.sendMessage("§6-=SERVER §3EU§f" + Main.getSGAPI().getConfig().getInt("Server-Name-Number") + " §6INFO=-");
				if(Games.getGameState() != GameState.Lobby) {
					p.sendMessage("§fParticipants/Spectator§8: §e" + Main.getSGAPI().Players.size() + "§8/§e" + Main.getSGAPI().Spectators.size());
				}
				p.sendMessage("§fCurrent State§8: §e" + Games.getGameState());
				if(Games.getGameState() == GameState.Lobby) {
					if(Games.getLobbyTime() >= 60){
						int lobbytime = Math.round(Games.getLobbyTime()/60);
						p.sendMessage("§fTime Left§8: §8[§e" + lobbytime + "§8] §eminutes");
						
					}else if(Games.getLobbyTime() < 60) {
						p.sendMessage("§fTime Left§8: §8[§e" + Games.getLobbyTime()+ "§8] §eseconds");
						
					}
				}else if(Games.getGameState() == GameState.PreGame) {
					
					p.sendMessage("§fTime Left§8: §8[§e" + Games.getPreGameTime()+ "§8] §eseconds");
				}
				if(Games.getGameState() == GameState.Lobby) {
					p.sendMessage("§fCurrent Map§8: §eUnknown Map (Lobby)");
					p.sendMessage("§fCurrent Author§8 §eUnknown Author");
					p.sendMessage("§fMap Link§8: §e(None)");
					
				}else if(Games.getGameState() != GameState.Lobby) {
					p.sendMessage("§fCurrent Map§8: §e" + Games.getMapName());
					p.sendMessage("§fCurrent Author§8 §eMCGamer NetWork");
					p.sendMessage("§fMap Link§8: §e(None)");
					
				}
				p.sendMessage("§fDevelopers, past and present§8:§r " + MessageAPI.setColouredString("WalkingUcak_"));
				p.sendMessage("§fRunning the §aXeme §av3 §fengine§8.");
			
			}
		}
		
		return false;
	} 

}
