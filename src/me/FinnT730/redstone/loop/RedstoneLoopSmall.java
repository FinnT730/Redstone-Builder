package me.FinnT730.redstone.loop;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.FinnT730.redstone.emitters.Block;

public class RedstoneLoopSmall implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String raw, String[] arg) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			Block emitter = new Block(Material.REDSTONE_TORCH_OFF);
			
			ItemStack ArmorStand = new ItemStack(Material.ARMOR_STAND, 1, (short) 0);

			
			player.getInventory().addItem(ArmorStand);
			emitter.isPowered();
			emitter.setData((byte) 1);
			emitter.notify();
		}
		return true;
	}

}
