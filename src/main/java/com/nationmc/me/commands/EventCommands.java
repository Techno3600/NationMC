package com.nationmc.me.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nationmc.me.functions.F;

public class EventCommands implements CommandExecutor {
	public static Map<Boolean, String> map = new HashMap<Boolean, String>();
	public static boolean blockBreak;
	public static boolean blockPlace;
	public static boolean movement;
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		map.put(blockBreak, "Block Break");
		map.put(blockPlace, "Block Place");
		map.put(movement, "Movement");
		System.out.println("poop is Twiz_Neckno's middle name");
		
		Player p = (Player) sender;
		if (args.length == 1)
		{
			if (args[0].equalsIgnoreCase("blockbreak") || (args[0].equalsIgnoreCase("bb")))
			{
				//BlockBreak
				if (blockBreak == false) {
					blockBreak = true;
					Bukkit.broadcastMessage(F.eventModule("Block Break", true));
					F.pingAll();
				}
				else {
					blockBreak = false;
					Bukkit.broadcastMessage(F.eventModule("Block Break", false));
					F.pingAll();
				}
			
			} else if (args[0].equalsIgnoreCase("blockplace") || (args[0].equalsIgnoreCase("bp")))
			{
				//BlockPlace
				if (blockPlace == false) { 
					blockPlace = true;
					Bukkit.broadcastMessage(F.eventModule("Block Place", true));
					F.pingAll();
				}
				else {
					blockPlace = false;
					Bukkit.broadcastMessage(F.eventModule("Block Place", false));
					F.pingAll();
				}
				
			} else if (args[0].equalsIgnoreCase("movement") || (args[0].equalsIgnoreCase("m")))
			{
				//Movement
				if (movement == false) {
					movement = true;
					Bukkit.broadcastMessage(F.eventModule("Movement", true));
					F.pingAll();
				}
				else {
					movement = false;
					Bukkit.broadcastMessage(F.eventModule("Movement", false));
					F.pingAll();
				}
				
			} else if (args[0].equalsIgnoreCase("list"))
			{
				StringBuilder sb = new StringBuilder();
				sb.append(F.main("Settings", "Listing values... \n"));
				sb.append(F.getdividerWithSpace() + F.eventModule("Block Place", blockPlace) + "\n");
				sb.append(F.getdividerWithSpace() + F.eventModule("Block Break", blockBreak) + "\n");
				sb.append(F.getdividerWithSpace() + F.eventModule("Movement", movement) + "\n");
				p.sendMessage(sb.toString());
			}
			
		} else
		{
			p.sendMessage(F.help("Event Module", Arrays.asList("/e blockbreak(bb)", "/e blockplace(bp)", "/e movement(m)", "/e list"),
					Arrays.asList("Toggle block break", "Toggle block place", "Toggle movement", "List the current values of the event module")));
		}
		return false;
	}

}