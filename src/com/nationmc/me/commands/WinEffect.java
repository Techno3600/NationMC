package com.nationmc.me.commands;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.nationmc.me.Main;

public class WinEffect implements CommandExecutor {
	Main main;
	public static Player p;
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		p = Bukkit.getPlayer(args[0]);
		Code code = new Code();
		code.run();
		return false;
	}

}


class Code extends Thread {
	private Player p = WinEffect.p;
	@Override
	public void run()
	{
		for (int i=0; i < 30; i++)
		{
			Entity f = p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
			f.setVelocity(new Vector(0, new Random().nextInt(3), 0));
			try {
				Thread.sleep(150L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "___" + ChatColor.RESET + " " + ChatColor.AQUA + ChatColor.BOLD + p.getName() + " has completed a parkour challenge! " + ChatColor.GOLD + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "___");
		try {
			Thread.sleep(100L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		p.chat("/spawn");
	}
}
