package me.FinnT730.redstone;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.libs.jline.internal.Log.Level;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import me.FinnT730.redstone.loop.RedstoneLoopSmall;
import net.minecraft.server.v1_8_R3.Blocks;

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
		logger.log(null);
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
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBreakBlock(BlockBreakEvent event) {
		
		
		try {
			File file = new File("TESTFILE.txt");
			FileWriter fileWr = new FileWriter(file);
			
			file.isDirectory();
			
			fileWr.write("" + event.getPlayer());
			fileWr.flush();
			fileWr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		if(event.getBlock().getLocation().add(0,1,0).getBlock().getType() != Material.AIR) {
			if(event.getBlock().getLocation().subtract(0,1,0).getBlock().getType() == Material.AIR) {
				event.getBlock().getWorld().spawnFallingBlock(event.getBlock().getLocation(), event.getBlock().getType(), event.getBlock().getData());
				event.getBlock().setType(Material.AIR);
				return;
		}
	}
}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		for(Block b : event.blockList()) {

			float x = (float) -1 + (float) (Math.random()* ((1 - -1) + 1));
			float y = (float) -2 + (float) (Math.random()* ((2 - -2) + 1));
			float z = (float) -1 + (float) (Math.random()* ((1 - -1) + 1));
			
			FallingBlock fallingBlock = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
			fallingBlock.setDropItem(false);
			fallingBlock.setVelocity(new Vector(x,y,z));
			
			b.setType(Material.AIR);
		}
	}
	
	
	@Override
	public void onDisable() {
		
	}

}
