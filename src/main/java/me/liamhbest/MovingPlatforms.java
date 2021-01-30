package me.liamhbest;

import me.liamhbest.data.PlatformsData;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MovingPlatforms extends JavaPlugin {

    private static MovingPlatforms instance;
    public static MovingPlatforms getInstance(){return instance;}

    FileConfiguration config;
    File cfile;

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("MovingPlatforms is being enabled!");

        commands();
        listeners();

        PlatformsData.setup();
        PlatformsData.get().options().copyDefaults(true);
        PlatformsData.save();

        getConfig().options().copyDefaults(true);
        cfile = new File(getDataFolder(), "config.yml");
        instance = this;
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("MovingPlatforms is being disabled!");
    }

    public void listeners(){
        PluginManager manager = getServer().getPluginManager();
    }

    public void commands(){ }
}







