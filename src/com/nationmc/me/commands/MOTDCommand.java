package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MOTDCommand implements CommandExecutor {
    public static String customMOTD;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (customMOTD == null)
        {
            if (args.length > 0)
            {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < args.length; i++)
                {
                    sb.append(args[i]);
                }
                customMOTD = ChatColor.translateAlternateColorCodes('&', sb.toString().trim());
                sender.sendMessage(F.main("Server Settings", "Set custom MOTD to: " + customMOTD + F.getBodyColor() + "."));
            } else
            {
                sender.sendMessage(F.error("Server Settings", "Enter an MOTD to be used."));
            }

        } else
        {
            sender.sendMessage(F.main("Server Settings", "Unset custom MOTD."));
            customMOTD = null;
        }



        return false;
    }
}
