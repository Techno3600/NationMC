package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nationmc.me.functions.F;



public class StaffChat implements CommandExecutor {
	public static Player target;
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player)
		{
			if (args.length == 0)
			{
				sender.sendMessage(F.error("Staff Chat", "Please enter a message."));
			} else
			{
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < args.length; i++)
				{
				  sb.append(args[i]).append(" ");
				}
				sender.sendMessage(F.main("Staff", "Your message to staff has been sent!"));
				String message = sb.toString().trim();
				target = (Player) sender;
				for(Player mod : Bukkit.getOnlinePlayers())
				{
					if (mod.hasPermission("group.tmod"))
					{
						mod.sendMessage(F.staff((Player) sender, message));
						mod.playSound(mod.getLocation(), Sound.NOTE_PLING, 1F, 1F);
					}
				}
			}
		}
		return false;
	}

}
