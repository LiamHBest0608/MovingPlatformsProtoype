package me.liamhbest.utils;

import me.liamhbest.MovingPlatforms;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class SavePlatform {

    public static void savePlatform(Location startLoc, Location endLoc, String platformName, double platformSpeed, Plugin plugin) throws IOException {
        File f = new File(plugin.getDataFolder() + "/platforms", platformName + ".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("start_location", startLoc);
        c.set("end_location", endLoc);
        c.set("name", platformName);
        c.set("speed", platformSpeed);
        c.save(f);
    }

}







