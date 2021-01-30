package me.liamhbest;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;

public class Color {

    public static String color(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String colorConfig(String message){
        return ChatColor.translateAlternateColorCodes('&', message).replace("§", "&");
    }

    public static String prefix(Plugin plugin){
        return ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("prefix") + " ");
    }

}
