package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class WorldManagementCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        /* /worldmanage load <world>
           /worldmanage unload <world>
         */
        if (args[0].equalsIgnoreCase("load"))
        {
            try {
                World targetWorld = Bukkit.getWorld(args[0]);
            } catch (Exception e)
            {
                sender.sendMessage(F.error("World Manager", F.getValueColor() + args[0] + " " + F.getBodyColor() + "does not exist."));
            }
        }
        if (args[0].equalsIgnoreCase("unload"))
        {
            try {
                World targetWorld = Bukkit.getWorld(args[0]);
            } catch (Exception e)
            {
                sender.sendMessage(F.error("World Manager", F.getValueColor() + args[0] + " " + F.getBodyColor() + "does not exist."));
            }


        } else
        {
            sender.sendMessage(F.help("World Management Command", Arrays.asList("/worldmanage load <World targetWorld>", "/worldmanage unload <World targetWorld>")
                    , Arrays.asList("Load world from the database.", "Unload world from the database.")));
        }







        return false;
    }
}
