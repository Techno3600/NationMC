package com.nationmc.me.commands;

import com.nationmc.me.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nationmc.me.functions.F;

public class Updater implements CommandExecutor {
	private Main main;
	public Updater(Main main)
	{
		this.main = main;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		//0 seconds in
		if (sender instanceof Player)
		{
			sender.sendMessage(F.main("Updater", "You have initiated a network restart."));
		} else
		{
			System.out.println("Initiating network restart.");
		}
		Bukkit.getScheduler().runTaskLater(main, new Runnable() {
			public void run() {
				for (World w : Bukkit.getWorlds())
				{
					for (Player p : w.getPlayers())
					{
						for (int i = 0; i < 6; i++)
						{
							p.playSound(p.getLocation(), Sound.NOTE_PLING, 1F, 1F);
						}
						p.sendMessage(F.miniAnnouncement("Updater", ChatColor.GOLD + w.getName() + ChatColor.AQUA + " is restarting for an update. You are getting sent to a main lobby."));
					}
				}
				
			}
		}, 20L);
		//1 in second in
		Bukkit.getScheduler().runTaskLater(main, new Runnable() {
			public void run() {
				for (World w : Bukkit.getWorlds())
				{
					for (Player p : w.getPlayers())
					{
						if (!(p.getWorld().equals(Bukkit.getWorld("NationMC"))))
						{
							p.teleport(new Location(Bukkit.getWorld("NationMC"), Bukkit.getWorld("NationMC").getSpawnLocation().getX(), Bukkit.getWorld("NationMC").getSpawnLocation().getY(), Bukkit.getWorld("NationMC").getSpawnLocation().getZ()));
							Bukkit.broadcastMessage(ChatColor.RED + "The server you were previously on went down. You have been connected to a default or fallback server.");
						}
					}
				}
				
			}
			
		}, 120L);
		//6 seconds in.
		
		Bukkit.getScheduler().runTaskLater(main, new Runnable() {
			public void run() {
				
				for (World w : Bukkit.getWorlds())
				{
					for (Player p : w.getPlayers())
					{
						p.playSound(p.getLocation(), Sound.ENDERDRAGON_GROWL, 2F, 1F);
					}
				}
				
			}
			
		}, 220L);
		//11 seconds in
		
		Bukkit.getScheduler().runTaskLater(main, new Runnable() {
			public void run() {
				Bukkit.shutdown();
			}
		}, 260L);
		return false;
	}
}
