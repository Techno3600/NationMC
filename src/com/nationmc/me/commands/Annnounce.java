package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;

public class Annnounce implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (args.length == 0) {
			p.sendMessage(ChatColor.GOLD + "/announce (message)" + ChatColor.GRAY + "Send server message.");
		} else {
			StringBuilder sb = new StringBuilder();
			String message;
			for(int i = 0; i < args.length; i++)
			{
			  sb.append(args[i]).append(" ");
			}
				message = sb.toString().trim();
				Bukkit.broadcastMessage(ChatColor.BLUE + "Announcement> " + ChatColor.AQUA + ChatColor.translateAlternateColorCodes('&', message));
				
				for (Player lp : Bukkit.getOnlinePlayers())
	        	{
		        	lp.playSound(p.getLocation(), Sound.NOTE_PLING, 1F, 1F);
		        	TitleAPI.sendTitle(lp, 20, 100, 40, ChatColor.GOLD + "Announcement", ChatColor.translateAlternateColorCodes('&', message));
	        	}
	          }	
		return false;
	}
}
