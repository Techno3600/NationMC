/*package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nationmc.me.functions.PlayerScoreboardManager;

public class ScoreboardMessage implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		String message;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < args.length; i++)
		{
		  sb.append(args[i]).append(" ");
		}
		message = sb.toString().trim();
		for (Player p : Bukkit.getOnlinePlayers())
		{
			PlayerScoreboardManager.PlayerScoreboard(p, message);
		}
		return false;
	}
}*/