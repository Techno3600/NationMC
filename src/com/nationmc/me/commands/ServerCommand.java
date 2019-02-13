	package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //server <worldName>
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                World targetServer = null;
                for (World w : Bukkit.getWorlds()) {
                    if (w.getName().equalsIgnoreCase(args[0])) {
                        targetServer = w;
                    }
                }
                if (targetServer == null) {
                    p.sendMessage(F.error("Portal", "Please enter a valid world."));
                    StringBuilder sb = new StringBuilder();
                    for (World w : Bukkit.getWorlds()) {
                        sb.append(F.main("", w.getName()) + "\n");
                    }
                    p.sendMessage(F.main("Portal", "Avaliable Worlds: \n") + sb.toString());
                } else {
                	if (targetServer.equals(p.getWorld()))
                	{
                		p.sendMessage(F.error("Portal", "You are already on " + targetServer.getName() + "."));
                	} else
                	{
                		 p.sendMessage(F.main("Portal", "You have been sent from" + F.value(p.getWorld().getName(), "to") + F.value(targetServer.getName(), ".")));
                         p.teleport(new Location(targetServer, targetServer.getSpawnLocation().getX(), targetServer.getSpawnLocation().getY(), targetServer.getSpawnLocation().getZ()));
                	}
                }

            } else {
                sender.sendMessage(F.help("Portal Commands", Collections.singletonList("/srver <targetServer>"), Collections.singletonList("Connect to a server")));
            }
        }
        return false;
    }

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length == 1)
		{
			List<String> worlds = new ArrayList<>();
			List<String> worldNames = new ArrayList<>();
			if (args[0].isEmpty() || args[0] == null)
			{
				for (World w : Bukkit.getWorlds())
				{
					worldNames.add(w.getName());
				}
				return worldNames;
			} else
			{
				//For some reason the second item in the Bukkit#getWorlds list won't loop correctly. EX: NationMC (beng first in the list) will work but Skywars won't.
				for (World w : Bukkit.getWorlds())
				{
					if (w.getName().toLowerCase().startsWith(args[0].toLowerCase()))
					{
						worlds.add(w.getName());
					} else if (args[0].toLowerCase().startsWith(w.getName().toLowerCase()))
					{
						worlds.add(w.getName());
					}
					return worlds;
				}
			}
		}
		return Collections.emptyList();
	}
}
