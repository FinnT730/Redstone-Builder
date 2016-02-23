package me.FinnT730.redstone.loop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.FinnT730.redstone.RedstoneBuilder;

public class RedstoneLoopSmall implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String raw, String[] arg) {
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			ItemStack diamond = new ItemStack(0);
			
			player.getInventory().addItem(diamond);
		}
		return true;
	}

}
