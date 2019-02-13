package com.nationmc.me.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.nationmc.me.functions.F;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.nationmc.me.listeners.PlayerScoreboardManager;

public class Rank implements CommandExecutor, TabCompleter
{
	private static List<String> granks;
	private static Player p;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		List<String> ranks = new ArrayList<>();
		ranks.add("OWNER");
		ranks.add("LEADER");
		ranks.add("DEV");
		ranks.add("ADMIN");
		ranks.add("MOD");
		ranks.add("TMOD");
		ranks.add("BUILDER");
		ranks.add("DEFAULT");
		granks = ranks;
		// /setrank <player> <rank> 
		if (args.length == 2)
		{
			try {
				p = sender.getServer().getPlayer(args[0].toUpperCase());
			} catch (Exception e)
			{
				sender.sendMessage(F.error("Rank Manager", F.getHeaderColor() + args[0] + F.getErrorColor() + " is not a valid player."));
			}
			
			if (ranks.contains(args[1].toUpperCase()))
			{

				sender.sendMessage(F.main("Rank Manager", F.value(p.getName(), "'s rank has been updated to" + F.value(args[1], "."))));
				if (p.isOnline())
				{
					p.sendMessage(F.main("Rank Manager", "Your rank has been updated to" + F.value(args[1].toUpperCase(), ".")));
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 1, 1);
				}
				Bukkit.dispatchCommand(sender.getServer().getConsoleSender(), "perm user " + p.getName() + " group set " + args[1].toUpperCase());
				try {
					Thread.sleep(40L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (p.isOnline())
				{
					PlayerScoreboardManager.PlayerScoreboard(p, " ");
				}
			} else
			{
				sender.sendMessage(ChatColor.BLUE + "Rank Manager> " + ChatColor.GRAY + "Incorrect Usage. Correct Usage: " + ChatColor.GOLD + "/setrank <player> <rank> " + ChatColor.GRAY + "- Set user's rank. " + ChatColor.DARK_RED + "(Admin)\n" + 
						ChatColor.GRAY + "List of Ranks: " + ChatColor.YELLOW + "OWNER, LEADER, DEV, ADMIN, MOD, TMOD, BUILDER, DEFAULT" + ChatColor.GRAY + ".");
			}
			
		} else
		{
			sender.sendMessage(ChatColor.BLUE + "Rank Manager> " + ChatColor.GRAY + "Incorrect Usage. Correct Usage: " + ChatColor.GOLD + "/setrank <player> <rank> " + ChatColor.GRAY + "- Set user's rank. " + ChatColor.DARK_RED + "(Admin)\n" + 
					ChatColor.GRAY + "List of Ranks: " + ChatColor.YELLOW + "OWNER, LEADER, DEV, ADMIN, MOD, TMOD, BUILDER, DEFAULT" + ChatColor.GRAY + ".");
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1)
		{
			List<String> tc1 = new ArrayList<>();
			for (Player p : Bukkit.getOnlinePlayers())
			{
				if (p.getName().contains(args[0]))
				{
					tc1.add(p.getName());
				}
			}
			return tc1;
		} else if (args.length == 2)
		{
			List<String> tc2 = new ArrayList<>();
			for (String rank : granks)
			{
				if (rank.contains(args[1]))
				{
					tc2.add(rank);
				}
			}
			return tc2;
		}
		return Collections.emptyList();
	}
}
