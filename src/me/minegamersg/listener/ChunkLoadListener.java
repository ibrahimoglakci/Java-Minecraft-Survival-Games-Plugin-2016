package me.minegamersg.listener;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import me.minegamersg.Main.Main;

public class ChunkLoadListener implements Listener{
	
	Main plugin;
	
	
	  @EventHandler
	  public void onChunk(ChunkLoadEvent paramChunkLoadEvent)
	  {
		  
	      for (Chunk localChunk : paramChunkLoadEvent.getWorld().getLoadedChunks()) {
	    	  for (BlockState localBlockState : localChunk.getTileEntities()) {
		        if (localBlockState.getBlock().getType() == Material.ENDER_CHEST)
		        {
		          localBlockState.getBlock().setType(Material.CHEST);
		          this.plugin.tier2_chests.add(localBlockState.getLocation());
		        }
	    	  }
	      }
	    
	  }

}
