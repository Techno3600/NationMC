package com.nationmc.me.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.nationmc.me.commands.LockdownCommand;

import net.md_5.bungee.api.ChatColor;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e)
	{
		if (LockdownCommand.lockdown)
		{
			e.setKickMessage(ChatColor.RED + "Kicked whilist joining NationMC \n" + ChatColor.WHITE + "Server lockdown is in effect.");
		}
	}
}
