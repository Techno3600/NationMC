package com.nationmc.me.listeners;


import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.nationmc.me.commands.QueuePvPCommand;
import com.sk89q.worldguard.bukkit.WGBukkit;

public class DisconnectEvent implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		if (e.getPlayer() == QueuePvPCommand.QueueOne)
		{
			
			if (QueuePvPCommand.PvPState.equalsIgnoreCase("ACTIVE"))
			{
				QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueTwo);
			} else
			{
				QueuePvPCommand.QueueOne = null;
			}
			
		} else if (e.getPlayer() == QueuePvPCommand.QueueTwo)
		{
			QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueOne);
		}
	}
	
	

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e)
	{
		Player p = (Player) e.getPlayer();
		if (QueuePvPCommand.PvPState.equalsIgnoreCase("ACTIVE"))
		{
			try {
				if (p == QueuePvPCommand.QueueOne)
				{


					if (!(WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation()).getRegions().contains(WGBukkit.getRegionManager(p.getWorld()).getRegion("pvp"))))
					{
						QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueTwo);
					}
				} else if (p == QueuePvPCommand.QueueTwo) {
					if (!(WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation()).getRegions().contains(WGBukkit.getRegionManager(p.getWorld()).getRegion("pvp"))))
					{
						QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueOne);
					}
				}
			} catch (NullPointerException n)
			{
			}
		}
		if (WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation()).getRegions().contains(WGBukkit.getRegionManager(p.getWorld()).getRegion("bottom")))
		{
			Location sp = p.getWorld().getSpawnLocation();
			p.teleport(new Location(p.getWorld(), sp.getX(), sp.getY(), sp.getZ()));
		}
	}
}
