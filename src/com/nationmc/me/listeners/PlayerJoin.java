package com.nationmc.me.listeners;

import com.nationmc.me.functions.PlayerScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener
{

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		PlayerScoreboardManager.PlayerScoreboard(e.getPlayer(), " ");
	}
	
	
}
