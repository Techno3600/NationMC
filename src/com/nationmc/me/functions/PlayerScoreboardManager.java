package com.nationmc.me.functions;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerScoreboardManager {
    public static void PlayerScoreboard(Player p, String s) {
        //o.getScore(ChatColor.translateAlternateColorCodes('&', "")).setScore(9);
        ScoreboardManager m = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard b = m.getNewScoreboard();

        //Scoreboard Naming
        Objective o = b.registerNewObjective("Scoreboard", "");
        o.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8● &e&lTheNationMC &8●"));
        o.setDisplaySlot(DisplaySlot.SIDEBAR);


        o.getScore(ChatColor.translateAlternateColorCodes('&', "     ")).setScore(13);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&dServer &8●")).setScore(12);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &e" + p.getWorld().getName())).setScore(11);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "  ")).setScore(10);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&aDiscord &8●")).setScore(9);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &ehttps://discord.gg/sEA2ctF")).setScore(8);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&3     ")).setScore(7);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&bWebsite &8●")).setScore(6);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&8» &eComing Soon!")).setScore(5);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&8   ")).setScore(4);
        o.getScore(ChatColor.translateAlternateColorCodes('&', "&eRank &8●")).setScore(3);
        o.getScore(ChatColor.GRAY + "» " + getRole(p)).setScore(2);
        o.getScore(ChatColor.translateAlternateColorCodes('&', s)).setScore(1);
        p.setScoreboard(b);
    }

    public static String getRole(Player p) {
        if (p.hasPermission("nation.owner")) {
            return ChatColor.DARK_RED + "Owner";
        } else if (p.hasPermission("nation.leader")) {
            return ChatColor.DARK_RED + "Leader";
        } else if (p.hasPermission("nation.dev")) {
            return ChatColor.GOLD + "Dev";
        } else if (p.hasPermission("nation.admin")) {
            return ChatColor.RED + "Admin";
        } else if (p.hasPermission("nation.mod")) {
            return ChatColor.GOLD + "Mod";
        } else if (p.hasPermission("nation.tmod")) {
            return ChatColor.DARK_AQUA + "T.Mod";
        } else if (p.hasPermission("nation.builder")) {
            return ChatColor.BLUE + "Builder";
        }
        {
            return ChatColor.GRAY + "Default";
        }
    }
}
