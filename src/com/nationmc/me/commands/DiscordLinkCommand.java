package com.nationmc.me.commands;

import com.nationmc.me.functions.F;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordLinkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(F.main("Discord", "Hey there! Our discord link is" + F.value("https://discord.gg/sEA2ctF", ".")));
        F.ping((Player) sender);
        return false;
    }
}
