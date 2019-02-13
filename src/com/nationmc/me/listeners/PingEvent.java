package com.nationmc.me.listeners;

import com.nationmc.me.commands.MOTDCommand;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class PingEvent implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e)
    {
        if (MOTDCommand.customMOTD != null)
        {
            e.setMotd(MOTDCommand.customMOTD);
        }
    }

    /* Oh my f**cking god I just spent 40 minutes doing this and find out I could just use ChatColor I quit.
    private String translate(String s)
    {
        s.replace("&4", "\u00A74");
        s.replace("&c", "\u00A7c");
        s.replace("&6", "\u00A76");
        s.replace("&e", "\u00A7e");
        s.replace("&2", "\u00A72");
        s.replace("&a", "\u00A7a");
        s.replace("&b", "\u00A7b");
        s.replace("&3", "\u00A73");
        s.replace("&1", "\u00A71");
        s.replace("&9", "\u00A79");
        s.replace("&d", "\u00A7d");
        s.replace("&5", "\u00A75");
        s.replace("&f", "\u00A7f");
        s.replace("&7", "\u00A77");
        s.replace("&8", "\u00A78");
        s.replace("&0", "\u00A70");
        s.replace("&r", "\u00A7r");
        s.replace("&l", "\u00A7l");
        s.replace("&o", "\u00A7o");
        s.replace("&n", "\u00A7n");
        s.replace("&m", "\u00A7m");
        //kill me now it's been like 40 minutes I can't keep doing this my mind
        s.replace("&k", "\u00A7k");


        return s;
    }*/
}
