package com.nationmc.me.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Debug implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage(QueuePvPCommand.QueueOne.toString());
		sender.sendMessage(QueuePvPCommand.QueueTwo.toString());
		return false;
	}
}
