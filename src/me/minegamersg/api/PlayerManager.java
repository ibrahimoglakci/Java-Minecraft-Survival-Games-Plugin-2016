package me.minegamersg.api;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class PlayerManager {
	
	
	@SuppressWarnings("deprecation")
	public static void preparePlayer(Player paramPlayer)
	  {
	    paramPlayer.setFireTicks(0);
	    paramPlayer.setFoodLevel(20);
	    paramPlayer.setHealth(20);
	    paramPlayer.getInventory().clear();
	    paramPlayer.setGameMode(GameMode.SURVIVAL);
	    ItemStack air = new ItemStack(Material.AIR);
	    paramPlayer.getInventory().setHelmet(air);
	    paramPlayer.getInventory().setChestplate(air);
	    paramPlayer.getInventory().setLeggings(air);
	    paramPlayer.getInventory().setBoots(air);
	    paramPlayer.removePotionEffect(PotionEffectType.INVISIBILITY);
	    for (PotionEffect localPotionEffect : paramPlayer.getActivePotionEffects()) {
	      paramPlayer.removePotionEffect(localPotionEffect.getType());
	    }
	    paramPlayer.setLevel(0);
	    
	 
		
	    
	  }

}
