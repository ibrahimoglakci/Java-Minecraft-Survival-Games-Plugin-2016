package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.SpectatorManager;

public class Kill implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("kill") || cmd.getName().equalsIgnoreCase("murder")) {
			p.spigot().respawn();
			p.setHealth(0);
			SpectatorManager.addSpectator(p);
			p.getWorld().strikeLightning(p.getLocation());
			Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aOnly §8[§6" + Main.getSGAPI().Players.size() + "§8]§a tributes remain!");
			Bukkit.broadcastMessage(MessageAPI.getServerPrefix() + " §aThere are §8[§6" + Main.getSGAPI().Spectators.size() + "§8]§a spectators watching the game.");
			Bukkit.broadcastMessage("§6A cannon can be heard in the distance");
			Main.getSGAPI().Players.remove(p);
			//MySQLAPI.addKills(attacker);
			//MySQLAPI.addDeaths(p);
			p.sendMessage(MessageAPI.getServerPrefix() + " §4You must be a participant to use this command.");
			p.sendMessage(MessageAPI.getServerPrefix() + " §4You must be ingame to use this command.");
			
		}
		return false;
	}

}
