package com.nationmc.me.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.connorlinfoot.titleapi.TitleAPI;
import com.nationmc.me.Main;
import com.nationmc.me.functions.F;
import org.bukkit.event.EventHandler;

public class LockdownCommand implements CommandExecutor {
	private Main main;
	public LockdownCommand(Main main)
	{
		this.main = main;
	}
	public static boolean lockdown;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (Bukkit.hasWhitelist())
		{
			lockdown = false;
			Bukkit.broadcastMessage(F.miniAnnouncement("Server Lockdown", "Server lockdown has ended"));
			for (Player p : Bukkit.getOnlinePlayers())
			{
				F.ping(p);
				TitleAPI.sendTitle(p, 20, 100, 40, ChatColor.GOLD + "Announcement", ChatColor.translateAlternateColorCodes('&', "&c&lSERVER LOCKDOWN HAS ENDED"));
			}
			Bukkit.setWhitelist(false);
		} else
		{
			lockdown = true;
			Bukkit.broadcastMessage(F.miniAnnouncement("Server Lockdown", "Server lockdown has taken effect."));
			for (Player p : Bukkit.getOnlinePlayers())
			{
				TitleAPI.sendTitle(p, 20, 100, 40, ChatColor.GOLD + "Announcement", ChatColor.translateAlternateColorCodes('&', "&c&lSERVER LOCKDOWN HAS BEEN INITIATED"));
				p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 2F, 1F);
			}

			Bukkit.getScheduler().runTaskLater(main, new Runnable() {

				@Override
				public void run() {
					for (Player p : Bukkit.getOnlinePlayers())
					{
						if (!(p.hasPermission("group.admin")))
						{
							p.kickPlayer("SERVER LOCKDOWN");
						} else
						{
							Bukkit.getWhitelistedPlayers().add(p);
						}
					}
					Bukkit.setWhitelist(true);
					
				}
				
			}, 80L);
		}
		return false;
	}
	

}
