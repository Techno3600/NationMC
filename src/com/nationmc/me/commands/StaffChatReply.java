package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nationmc.me.functions.F;
import com.nationmc.me.listeners.PlayerScoreboardManager;

public class StaffChatReply implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player staff = (Player) sender;
		Player target = StaffChat.target;
		if (target == null)
		{
			staff.sendMessage(F.error("Staff", "There is no message for which to reply."));
		} else
		{
			if (args.length == 0)
			{
				staff.sendMessage(F.error("Staff", "Please enter a reply."));
			} else
			{
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < args.length; i++)
				{
				  sb.append(args[i]).append(" ");
				}
				String message = sb.toString().trim();
				String staffPrefix = PlayerScoreboardManager.getRole(staff) + " " + staff.getName();
				String targetPrefix = PlayerScoreboardManager.getRole(target) + " " + target.getName();
				target.sendMessage(F.main("Staff", ChatColor.DARK_GRAY + "[" + staffPrefix + " --> " + targetPrefix + ChatColor.DARK_GRAY + "]" + " " + ChatColor.LIGHT_PURPLE + message));
				target.playSound(target.getLocation(), Sound.NOTE_PLING, 1F, 1F);
				target.playSound(target.getLocation(), Sound.NOTE_PLING, 1F, 1F);
				
				for(Player mod : Bukkit.getOnlinePlayers())
				{
					if (mod.hasPermission("group.tmod"))
					{
						mod.sendMessage(F.main("Staff (Reply)", ChatColor.DARK_GRAY + "[" + staffPrefix + " --> " + targetPrefix + ChatColor.DARK_GRAY + "]" + " " + ChatColor.LIGHT_PURPLE + message));
					}
				}
			}
		}
		return false;
	}
}
