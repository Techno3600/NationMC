package com.nationmc.me.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.nationmc.me.commands.EventCommands;

public class MovementListener implements Listener {
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e)
	{
		//System.out.println("Archimedes is your dad");
		if (!EventCommands.movement)
		{
			if (!(e.getPlayer().hasPermission("group.admin")))
			{
				e.setCancelled(true);
			}
		}
	}

}
