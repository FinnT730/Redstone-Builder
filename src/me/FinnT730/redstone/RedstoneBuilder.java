package me.FinnT730.redstone;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import me.FinnT730.redstone.loop.RedstoneLoopSmall;

public class RedstoneBuilder extends JavaPlugin implements Listener {
	
	
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
	
	@Override
	public void onDisable() {
		
	}

}
