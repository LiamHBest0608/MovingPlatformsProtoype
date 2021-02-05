package me.liamhbest.utils;

import me.liamhbest.MovingPlatforms;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class CreatePlatform {

    MovingPlatforms plugin;
    public CreatePlatform(MovingPlatforms plugin){
        this.plugin = plugin;
    }

    public static void createPlatform(Location startLoc, Location endLoc, Player p, String name, double speed, Plugin plugin){
        startLoc.getBlock().setType(Material.GOLD_BLOCK);
        endLoc.getBlock().setType(Material.GOLD_BLOCK);

         Location loc1 = new Location(p.getWorld(),
                 startLoc.getBlockX()-1,
                 startLoc.getBlockY(),
                 startLoc.getBlockZ());
         loc1.getBlock().setType(Material.GOLD_BLOCK);

        Location loc2 = new Location(p.getWorld(),
                startLoc.getBlockX()+1,
                startLoc.getBlockY(),
                startLoc.getBlockZ());
        loc2.getBlock().setType(Material.GOLD_BLOCK);

        Location loc3 = new Location(p.getWorld(),
                startLoc.getBlockX(),
                startLoc.getBlockY(),
                startLoc.getBlockZ()-1);
        loc3.getBlock().setType(Material.GOLD_BLOCK);

        Location loc4 = new Location(p.getWorld(),
                startLoc.getBlockX(),
                startLoc.getBlockY(),
                startLoc.getBlockZ()+1);
        loc4.getBlock().setType(Material.GOLD_BLOCK);

        Location loc5 = new Location(p.getWorld(),
                startLoc.getBlockX()+1,
                startLoc.getBlockY(),
                startLoc.getBlockZ()+1);
        loc5.getBlock().setType(Material.GOLD_BLOCK);

        Location loc6 = new Location(p.getWorld(),
                startLoc.getBlockX()-1,
                startLoc.getBlockY(),
                startLoc.getBlockZ()-1);
        loc6.getBlock().setType(Material.GOLD_BLOCK);

        Location loc7 = new Location(p.getWorld(),
                startLoc.getBlockX()-1,
                startLoc.getBlockY(),
                startLoc.getBlockZ()+1);
        loc7.getBlock().setType(Material.GOLD_BLOCK);

        Location loc8 = new Location(p.getWorld(),
                startLoc.getBlockX()+1,
                startLoc.getBlockY(),
                startLoc.getBlockZ()-1);
        loc8.getBlock().setType(Material.GOLD_BLOCK);

        new BukkitRunnable(){

            @Override
            public void run(){




            }

        }.runTaskTimer(plugin, 60L, 20L);

    }

}
