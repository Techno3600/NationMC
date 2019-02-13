package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RawCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		StringBuilder sb = new StringBuilder();
		String message;
		for(int i = 0; i < args.length; i++)
		{
		  sb.append(args[i]).append(" ");
		}
		message = sb.toString();
		Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
		return false;
	}

}
