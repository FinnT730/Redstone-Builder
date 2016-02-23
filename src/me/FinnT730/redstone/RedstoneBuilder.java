package me.FinnT730.redstone;

import org.bukkit.plugin.java.JavaPlugin;

import me.FinnT730.redstone.BlockHandler.MainBlockGet;
import me.FinnT730.redstone.loops.RedstoneLoopSmall;
import net.minecraft.server.v1_8_R3.Blocks;
import net.minecraft.server.v1_8_R3.Item;

public class RedstoneBuilder extends JavaPlugin {
	
	
	static MainBlockGet BlockList = new MainBlockGet();
	
	@Override
	public void onEnable() {
		
		this.getCommand("loop").setExecutor(new RedstoneLoopSmall());
		
		try {
			BlockList.add(Item.REGISTRY.toString());
		} catch (Exception e) {
			e.equals(Blocks.REDSTONE_WIRE.I);
		}
		
		
		
	}
	
	@Override
	public void onDisable() {
		
	}

}
