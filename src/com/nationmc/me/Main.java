package com.nationmc.me;

import com.nationmc.me.commands.*;
import com.nationmc.me.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;


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
        getCommand("won").setExecutor(new WinEffect(this));
        getCommand("pvp").setExecutor(new QueuePvPCommand());
        getCommand("updater").setExecutor(new Updater(this));
        getCommand("e").setExecutor(new EventCommands());
        getCommand("raw").setExecutor(new RawCommand());
        getCommand("server").setExecutor(new ServerCommand());
        getCommand("server").setTabCompleter(new ServerCommand());
        getCommand("lock").setExecutor(new LockdownCommand(this));
        getCommand("motd").setExecutor(new MOTDCommand());
        getCommand("discord").setExecutor(new DiscordLinkCommand());
        //getCommand("scoreboard").setExecutor(new ScoreboardMessage());
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        Bukkit.getPluginManager().registerEvents(new WeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new DisconnectEvent(), this);
        Bukkit.getPluginManager().registerEvents(new InteractListener(), this);
        Bukkit.getPluginManager().registerEvents(new MovementListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new WorldMove(), this);
        Bukkit.getPluginManager().registerEvents(new PingEvent(), this);
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
		LockdownCommand.lockdown = false;
		for (World w : Bukkit.getWorlds())
        {
            if (w.getName().equalsIgnoreCase("NationMC"))
            {
                EventCommands.flags.put(w, Arrays.asList(false, false, true));
            } else
            {
                EventCommands.flags.put(w, Arrays.asList(true, true, true));
            }
        }
    }
    @Override
    public void onDisable() {
        System.out.println("NationMC Core: Disabled");
    }
}