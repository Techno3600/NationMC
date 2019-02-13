package com.nationmc.me.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.nationmc.me.commands.QueuePvPCommand;

public class DeathListener implements Listener
{
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e)
	{
		if (e.getEntity() instanceof Player)
		{
			Player p = (Player) e.getEntity();
			if (QueuePvPCommand.QueueOne == p || QueuePvPCommand.QueueTwo == p)
			{
				QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, p.getKiller());
			}
		}
	}
}
