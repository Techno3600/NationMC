package com.nationmc.me;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.nationmc.me.commands.Annnounce;
import com.nationmc.me.commands.Debug;
import com.nationmc.me.commands.EventCommands;
import com.nationmc.me.commands.Gamemode;
import com.nationmc.me.commands.LockdownCommand;
import com.nationmc.me.commands.QueuePvPCommand;
import com.nationmc.me.commands.Rank;
import com.nationmc.me.commands.RawCommand;
import com.nationmc.me.commands.ServerCommand;
import com.nationmc.me.commands.StaffChat;
import com.nationmc.me.commands.StaffChatReply;
import com.nationmc.me.commands.Updater;
import com.nationmc.me.commands.WinEffect;
import com.nationmc.me.listeners.DeathListener;
import com.nationmc.me.listeners.DisconnectEvent;
import com.nationmc.me.listeners.InteractListener;
import com.nationmc.me.listeners.JoinEvent;
import com.nationmc.me.listeners.MovementListener;
import com.nationmc.me.listeners.PlayerJoin;
import com.nationmc.me.listeners.WeatherListener;



public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.println("[NationMC] NationMC Core: Enabled");
        //Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        getCommand("setrank").setExecutor(new Rank());
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("announce").setExecutor(new Annnounce());
        getCommand("sa").setExecutor(new StaffChat());
        getCommand("sar").setExecutor(new StaffChatReply());
        getCommand("won").setExecutor(new WinEffect());
        getCommand("pvp").setExecutor(new QueuePvPCommand());
        getCommand("updater").setExecutor(new Updater(this));
        getCommand("debug").setExecutor(new Debug());
        getCommand("e").setExecutor(new EventCommands());
        getCommand("raw").setExecutor(new RawCommand());
        getCommand("server").setExecutor(new ServerCommand());
        getCommand("lockdown").setExecutor(new LockdownCommand(this));
        //getCommand("scoreboard").setExecutor(new ScoreboardMessage());
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new WeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new DisconnectEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new MovementListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		if (Bukkit.getServer().getPluginManager().getPlugin("TitleAPI").isEnabled()) {
			System.out.println("Detected TitleAPI. Using as Hook.");
		}
		if (Bukkit.getServer().getPluginManager().getPlugin("WorldGuard").isEnabled()) {
			System.out.println("Detected WorldGuard. Using as Hook.");
		}
		if (Bukkit.getServer().getPluginManager().getPlugin("WorldEdit").isEnabled()) {
			System.out.println("Detected WorldEdit. Using as Hook.");
		}
		QueuePvPCommand.PvPState = "IDLE";
		EventCommands.blockBreak = false;
		EventCommands.blockPlace = false;
		EventCommands.movement = true;
		LockdownCommand.lockdown = false;
    }
    @Override
    public void onDisable() {
        System.out.println("NationMC Core: Disabled");
    }
}