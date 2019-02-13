package com.nationmc.me.listeners;

import org.bukkit.entity.Player;
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
