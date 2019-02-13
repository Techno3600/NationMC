package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Gamemode implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (args.length == 0)
		{
			Player p = (Player) sender;
			if ((p.getGameMode().equals(GameMode.SURVIVAL)))
			{
				p.setGameMode(GameMode.CREATIVE);
				p.setFlying(true);
				p.setVelocity(new Vector(0, .7, 0));
				p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GRAY + "Your gamemode has been updated to: " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + ".");
			} else if (p.getGameMode().equals(GameMode.CREATIVE))
			{
				p.setGameMode(GameMode.SURVIVAL);
				p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GRAY + "Your gamemode has been updated to: " + ChatColor.YELLOW + "Survival" + ChatColor.GRAY + ".");
			} else
			{
				p.setGameMode(GameMode.CREATIVE);
				p.setFlying(true);
				p.setVelocity(new Vector(0, .7, 0));
				p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GRAY + "Your gamemode has been updated to: " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + ".");
			}
		} else if (args.length == 1)
		{
			Player p = Bukkit.getPlayer(args[0]);
			if (p.isOnline())
			{
				if ((p.getGameMode().equals(GameMode.SURVIVAL)))
				{
					p.setGameMode(GameMode.CREATIVE);
					p.setFlying(true);
					p.setVelocity(new Vector(0, .7, 0));
					sender.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.YELLOW + p.getName() + ChatColor.GRAY + "'s gamemode has been updated to: " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + ".");
					p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GRAY + "Your gamemode has been updated to: " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + ".");
				} else if (p.getGameMode().equals(GameMode.CREATIVE))
				{
					p.setGameMode(GameMode.SURVIVAL);
					sender.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.YELLOW + p.getName() + ChatColor.GRAY + "'s gamemode has been updated to: " + ChatColor.YELLOW + "Survival" + ChatColor.GRAY + ".");
					p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GRAY + "Your gamemode has been updated to: " + ChatColor.YELLOW + "Survival" + ChatColor.GRAY + ".");
				} else
				{
					p.setGameMode(GameMode.CREATIVE);
					p.setFlying(true);
					p.setVelocity(new Vector(0, .7, 0));
					sender.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.YELLOW + p.getName() + ChatColor.GRAY + "'s gamemode has been updated to: " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + ".");
					p.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.GRAY + "Your gamemode has been updated to: " + ChatColor.YELLOW + "Creative" + ChatColor.GRAY + ".");
				}
			} else
			{
				sender.sendMessage(ChatColor.BLUE + "Gamemode> " + ChatColor.RED + "Error. That player is not online.");
			}
		}
		return false;
	}
}
