package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiniAnnounce implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player p = (Player) sender;
        if (args.length == 0)
        {
            p.sendMessage(ChatColor.GOLD + "/miniannounce (message)" + ChatColor.GRAY + "Send server message.");
        } else
        {
            StringBuilder sb = new StringBuilder();
            String message;
            for (int i = 0; i < args.length; i++)
            {
                sb.append(args[i]).append(" ");
            }
            message = sb.toString().trim();
            Bukkit.broadcastMessage(ChatColor.BLUE + "Announcement> " + ChatColor.AQUA + ChatColor.translateAlternateColorCodes('&', message));
            F.pingAll();
        }
        return false;
    }
}
