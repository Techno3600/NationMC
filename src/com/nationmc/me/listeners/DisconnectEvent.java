package com.nationmc.me.listeners;


import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.nationmc.me.commands.QueuePvPCommand;

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
		LocalPlayer wp = WorldGuardPlugin.inst().wrapPlayer(p);
		RegionContainer region = WorldGuard.getInstance().getPlatform().getRegionContainer();
		if (QueuePvPCommand.PvPState.equalsIgnoreCase("ACTIVE"))
		{
			try {
				if (p == QueuePvPCommand.QueueOne)
				{


					if (!(region.get(wp.getWorld()).getApplicableRegions(BlockVector3.at(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())).getRegions().contains(region.get(wp.getWorld()).getRegion("pvp"))))
					{
						QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueTwo);
					}
				} else if (p == QueuePvPCommand.QueueTwo) {
					if (!(region.get(wp.getWorld()).getApplicableRegions(BlockVector3.at(p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ())).getRegions().contains(region.get(wp.getWorld()).getRegion("pvp")))) {
						QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueOne);
					}
				}
			} catch (NullPointerException n)
			{
			}
		}
	}
}
