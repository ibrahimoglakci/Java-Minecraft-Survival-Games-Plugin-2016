package me.minegamersg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.minegamersg.Main.Main;
import me.minegamersg.api.MessageAPI;
import me.minegamersg.api.SBAPI;

public class ReloadConfig implements CommandExecutor{

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("minegamersgreload")) {
			Main.getSGAPI().reloadConfig();
			for(Player all : Bukkit.getOnlinePlayers()) {
				SBAPI.scoreBoardManager(all);
			}
			p.sendMessage(MessageAPI.getServerPrefix() + " §aReloaded Config!");
		}
		
		
		
		return false;
	}
	

}
