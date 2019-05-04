package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WorldTeleport implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        List<String> commands = new ArrayList<>();
        commands.add("/wtp <world>");
        commands.add("/wtp <player> <world>");
        commands.add("/wtp <current> <world>");
        commands.add("/wtp <all> <world>");

        List<String> commandDesc = new ArrayList<>();

        commandDesc.add("Send yourself to a target world.");
        commandDesc.add("Send target player to target world.");
        commandDesc.add("Send all players in a world to target world");
        commandDesc.add("Send all players on a server to target world");
        Player p;
        if (sender instanceof Player)
        {
            p = (Player) sender;
        } else {
            return false;
        }
        String HELP = F.help("World Teleport", commands, commandDesc);
        //wtp <player/world> <world> <-ns>

        //wtp <world>

        //wtp <player> <world>
        //wtp <current> <world>
        //wtp <all> <world>


        if (!(args.length != 1) || !(args.length != 2))
        {
            p.sendMessage(HELP);
        }

        if (args.length == 1)
        {
            Boolean task = false;
            for (World w : Bukkit.getWorlds())
            {
                if (args[0].equalsIgnoreCase(w.getName()))
                {
                    if (!task)
                    {
                        sendPlayer(p, w);
                        message(w);
                        task = true;
                    }
                }
                if (!task)
                {
                    p.sendMessage(F.error("Server", "Invalid world name."));
                    return false;
                }
            }
        } else if (args.length == 2)
        {
            Boolean task = false;
            for (Player player : Bukkit.getOnlinePlayers())
            {
                if (!task)
                {
                    if (player.getName().equalsIgnoreCase(args[0]))
                    {
                        Boolean task2 = false;
                        for (World world : Bukkit.getWorlds())
                        {
                            if (!task2)
                            {
                                sendPlayer(player, world);
                                player.sendMessage(message(world));
                                p.sendMessage(adminMessageSingle(world, player));
                                task2 = true;
                            }
                        }
                        if (!task2)
                        {
                            p.sendMessage(F.error("Server", "That world does not exist."));
                            return false;
                        }
                        task = true;
                    }
                }
            }
            if (!task)
            {
                if (args[0].equalsIgnoreCase("all"))
                {
                    Boolean task3 = false;
                    for (World world : Bukkit.getWorlds())
                    {
                        if (args[1].equalsIgnoreCase(world.getName()))
                        {
                            if (!task3)
                            {
                                for (Player player : Bukkit.getOnlinePlayers())
                                {
                                    if (player.getWorld() != world)
                                    {
                                        player.sendMessage(message(world));
                                        sendPlayer(player, world);
                                        p.sendMessage(F.adminAction("Server", "Sent ALL players to" + F.value(world.getName(), ".")));
                                        task3 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (!task3)
                    {
                        p.sendMessage(F.error("Server", "That world does not exist."));
                    }
                } else if (args[0].equalsIgnoreCase("current"))
                {
                    for (World world : Bukkit.getWorlds())
                    {
                        Boolean task4 = false;
                        if (args[1].equalsIgnoreCase(world.getName()))
                        {
                            if (!task4)
                            {
                                for (Player player : Bukkit.getOnlinePlayers())
                                {
                                    if (player.getWorld() == p.getWorld())
                                    {
                                        player.sendMessage(message(world));
                                        sendPlayer(player, world);
                                        p.sendMessage(F.adminAction("Server", "Sent ALL CURRENT players to" + F.value(world.getName(), ".")));
                                        task4 = true;
                                    }
                                }
                            }
                        }
                        if (!task4)
                        {
                            p.sendMessage(F.error("Server", "That world does not exist."));
                        }
                    }
                } else
                {
                    p.sendMessage(F.error("Server", "That player is not online."));
                }
            }
        }
        return false;
    }
    private void sendPlayer(Player p, World world)
    {
        p.teleport(new Location(world, world.getSpawnLocation().getX(), world.getSpawnLocation().getY(), world.getSpawnLocation().getZ()));
    }
    private String message(World targetWorld)
    {
        return F.main("Server", "You have been teleported to" + F.value(targetWorld.getName(), "."));

    }
    private String adminMessageSingle(World targetWorld, Player targetPlayer)
    {
        return F.adminAction("Server", "Sent" + F.value(targetPlayer.getName(), "to" + F.value(targetWorld.getName(), ".")));
    }
}
