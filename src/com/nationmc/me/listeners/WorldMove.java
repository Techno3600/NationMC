package com.nationmc.me.listeners;

import com.nationmc.me.functions.PlayerScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldMove implements Listener {

    @EventHandler
    public void onPlayerWorld(PlayerChangedWorldEvent e)
    {
        PlayerScoreboardManager.PlayerScoreboard(e.getPlayer(), " ");
    }
}
