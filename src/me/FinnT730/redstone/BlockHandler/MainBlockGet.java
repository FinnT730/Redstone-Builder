package me.FinnT730.redstone.BlockHandler;

import java.awt.HeadlessException;
import java.awt.List;
import java.util.HashMap;

import org.bukkit.block.Block;

public class MainBlockGet extends List {
	
	
	static HashMap<Block, String> BlockList = new HashMap<>();
	
	
	public static final void BlockHandMain() {
		try {
			BlockList.get(Block.class.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	public MainBlockGet() throws HeadlessException {
		// TODO Auto-generated constructor stub
	}

	public MainBlockGet(int arg0) throws HeadlessException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public MainBlockGet(int arg0, boolean arg1) throws HeadlessException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
