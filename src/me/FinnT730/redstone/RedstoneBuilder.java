package me.FinnT730.redstone;

import java.io.File;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.libs.jline.internal.Configuration;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.FinnT730.redstone.loop.RedstoneLoopSmall;

public class RedstoneBuilder extends JavaPlugin implements Listener {
	
	
	static Random rand;
	
	
	public void onEnable() {
		
		
		
		/*Command section
		*/	
		this.getCommand("loop").setExecutor(new RedstoneLoopSmall());
		//End Command Section
		
		getServer().getPluginManager().registerEvents(this, this);		
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = Logger.getLogger("Minecraft");
		logger.info(pdfFile.getName() + "has been enabled " + pdfFile.getVersion());		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		if(event.getBlock().getLocation().subtract(0,1,0).getBlock().getType() == Material.AIR) {
			event.getBlock().getWorld().spawnFallingBlock(event.getBlock().getLocation(), event.getBlock().getType(), event.getBlock().getData());
			event.getBlock().setType(Material.AIR);
			
			return;
		}
	}
	
	
	/*@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreakBlock(BlockBreakEvent event) {
		for(int m = 0;m != event.getBlock().getLocation().getBlockY(); m++) {
			
		if(event.getBlock().getLocation().add(0,1,0).getBlock().getType() != Material.AIR) {
			if(event.getBlock().getLocation().subtract(0,1,0).getBlock().getType() == Material.AIR) {
				event.getBlock().getWorld().spawnFallingBlock(event.getBlock().getLocation(), event.getBlock().getType(), event.getBlock().getData());
				event.getBlock().setType(Material.AIR);
				return;
			}
		}
	}
}*/
	
	
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		for(Block b : event.blockList()) {
			float x = (float) -1 + (float) (Math.random()* ((1 - -1) + 1));
			float y = (float) -2 + (float) (Math.random()* ((2 - -2) + 1));
			float z = (float) -1 + (float) (Math.random()* ((1 - -1) + 1));
			
			FallingBlock fallingBlock = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
			fallingBlock.setDropItem(false);
			//fallingBlock.setVelocity(new Vector(x,y,z));
			
			b.setType(Material.AIR);
		}
	}
	
	
	@Override
	public void onDisable() {
		
	}

}
