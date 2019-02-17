package com.nationmc.me.listeners;

import com.nationmc.me.commands.QueuePvPCommand;
import com.sk89q.worldguard.bukkit.WGBukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.nationmc.me.commands.EventCommands;

public class MovementListener implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {



		if (!EventCommands.flags.get(e.getPlayer().getWorld()).get(2)) {
			if (!(e.getPlayer().hasPermission("group.admin"))) {
				e.setCancelled(true);
			}
		}





		Player p = e.getPlayer();
		if (QueuePvPCommand.PvPState.equalsIgnoreCase("ACTIVE")) {
			try {
				if (p == QueuePvPCommand.QueueOne) {
					if (!(WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation()).getRegions().contains(WGBukkit.getRegionManager(p.getWorld()).getRegion("pvp")))) {
						QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueTwo);
					}
				} else if (p == QueuePvPCommand.QueueTwo) {
					if (!(WGBukkit.getRegionManager(p.getWorld()).getApplicableRegions(p.getLocation()).getRegions().contains(WGBukkit.getRegionManager(p.getWorld()).getRegion("pvp")))) {
						QueuePvPCommand.endpvp(QueuePvPCommand.QueueOne, QueuePvPCommand.QueueTwo, QueuePvPCommand.QueueOne);
					}
				}
			} catch (NullPointerException n) {
			}
		}
		if (p.getLocation().getY() < -19) {
			if (!(p.getGameMode().equals(GameMode.CREATIVE)))
			{
				if (e.getPlayer().getWorld().getName().equalsIgnoreCase("NationMC"))
				{
					Location sp = p.getWorld().getSpawnLocation();
					p.teleport(new Location(p.getWorld(), sp.getX(), sp.getY(), sp.getZ()));
				}
			}
		}
	}
}
