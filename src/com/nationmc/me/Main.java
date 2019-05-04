package com.nationmc.me;

import com.nationmc.me.commands.*;
import com.nationmc.me.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {


    /*private File newsFile;
    private YamlConfiguration modifynewsFile;*/
    public static World mainWorld;

    @Override
    public void onEnable()
    {
        System.out.println("[NationMC] NationMC Core: Enabled");
        //Bukkit.getPluginManager().registerEvents(new JoinEvent(this), this);
        getCommand("setrank").setExecutor(new Rank());
        getCommand("gm").setExecutor(new Gamemode());
        getCommand("announce").setExecutor(new Annnounce());
        getCommand("miniannounce").setExecutor(new MiniAnnounce());
        getCommand("sa").setExecutor(new StaffChat());
        getCommand("sar").setExecutor(new StaffChatReply());
        getCommand("updater").setExecutor(new Updater(this));
        getCommand("raw").setExecutor(new RawCommand());
        getCommand("server").setExecutor(new ServerCommand());
        getCommand("server").setTabCompleter(new ServerCommand());
        getCommand("lock").setExecutor(new LockdownCommand(this));
        //getCommand("motd").setExecutor(new MOTDCommand());
        getCommand("discord").setExecutor(new DiscordLinkCommand());
        getCommand("news").setExecutor(new NewsCommand(this));
        getCommand("worldtp").setExecutor(new WorldTeleport());
        //getCommand("scoreboard").setExecutor(new ScoreboardMessage());
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new WeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new WorldMove(), this);
        Bukkit.getPluginManager().registerEvents(new PingEvent(), this);


        QueuePvPCommand.PvPState = "IDLE";
        if (Bukkit.hasWhitelist())
        {
            LockdownCommand.lockdown = true;
        } else
        {
            LockdownCommand.lockdown = false;
        }

        /*try
        {
            initiateFile();
        } catch (IOException e)
        {
            e.printStackTrace();
        }*/
        mainWorld = Bukkit.getWorld("world");

    }

    @Override
    public void onDisable()
    {
        System.out.println("NationMC Core: Disabled");
    }

    /*private void initiateFile() throws IOException
    {
        newsFile = new File(Bukkit.getServer().getPluginManager().getPlugin("NationMC").getDataFolder(), "news.yml");
        if (!newsFile.exists())
        {
            newsFile.createNewFile();
        }
    }

    public YamlConfiguration getModifynewsFile()
    {
        return modifynewsFile;
    }

    public File getNewsFile()
    {
        return newsFile;
    }*/
}