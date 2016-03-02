package me.FinnT730.redstone.emitters;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.material.RedstoneWire;

import com.avaje.ebeaninternal.server.core.OnBootupClassSearchMatcher;

public class Block extends RedstoneWire {

	public Block() {
		// TODO Auto-generated constructor stub
	}

	public Block(Material type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	
	public void onBlockPlace(BlockPlaceEvent event) {		
		if(event.getBlock().getLocation().subtract(0,1,0).getBlock().getType() == Material.AIR) {
			event.getBlock().getWorld().spawnFallingBlock(event.getBlock().getLocation(), event.getBlock().getType(), event.getBlock().getData());
			event.getBlock().setType(Material.AIR);
			
			return;
		}
	}

}
