package com.nationmc.me.commands;

import com.nationmc.me.Main;
import com.nationmc.me.functions.NewsCode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NewsCommand implements CommandExecutor {
    private Main main;

    public NewsCommand(Main main)
    {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        NewsCode.newsCode((Player) sender, main);

        return false;
    }
}
