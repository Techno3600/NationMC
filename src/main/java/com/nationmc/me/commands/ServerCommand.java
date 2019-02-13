package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;

public class ServerCommand implements CommandExecutor {

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
                if (targetServer != null) {
                    p.sendMessage(F.error("Portal", "Please enter a valid world."));
                    StringBuilder sb = new StringBuilder();
                    for (World w : Bukkit.getWorlds()) {
                        sb.append(F.main("", w.getName()) + "\n");
                    }
                    p.sendMessage(F.main("Portal", "Avaliable Worlds: \n") + sb.toString());
                } else {
                    p.sendMessage(F.main("Portal", "You have been sent from" + F.value(p.getWorld().getName(), "to") + F.value(targetServer.getName(), ".")));
                    p.teleport(new Location(targetServer, targetServer.getSpawnLocation().getX(), targetServer.getSpawnLocation().getY(), targetServer.getSpawnLocation().getZ()));
                }

            } else {
                sender.sendMessage(F.help("Portal Commands", Collections.singletonList("/srver <targetServer>"), Collections.singletonList("Connect to a server")));
            }
        }
        return false;
    }
}
