package me.liamhbest.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class CreatePlatform {

    public static void createPlatform(Location startLoc, Location endLoc, Player p, String name, double speed){

        startLoc.getBlock().setType(Material.GOLD_BLOCK);
        endLoc.getBlock().setType(Material.GOLD_BLOCK);
    }

}
