package me.liamhbest.commands;

import me.liamhbest.Color;
import me.liamhbest.MovingPlatforms;
import me.liamhbest.data.PlatformsData;
import me.liamhbest.utils.CreatePlatform;
import me.liamhbest.utils.SavePlatform;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class PlatformCommand implements CommandExecutor {

    MovingPlatforms plugin;
    public PlatformCommand(MovingPlatforms plugin){
        this.plugin = plugin;
    }

    public static boolean setPos1 = false;
    public static Location locPos1;
    public static Location locPos2;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player){
            final Player p = (Player) sender;

            if (args.length ==0){
                //platform
                p.sendMessage(Color.prefix(plugin) + Color.color("&aPlease perform the right command! " +
                        "/platform create and /platform remove."));
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 1);
                return true;
            }
            if (args.length>=1){
                if (args[0].equalsIgnoreCase("create")){
                    //create platform
                    if (args.length>1){
                        //more
                        if (args[1].equalsIgnoreCase("pos1")){
                            if (setPos1){
                                p.sendMessage("you have already set position 1");
                            } else {
                                setPos1=true;
                                p.sendMessage("set pos 1");
                                locPos1 = new Location(
                                        p.getWorld(),
                                        p.getLocation().getX(),
                                        p.getLocation().getY()-1,
                                        p.getLocation().getZ()
                                );

                                locPos1.getBlock().setType(Material.LAPIS_BLOCK);
                            }

                        } else if (args[1].equalsIgnoreCase("pos2")){
                            if (!setPos1){
                                p.sendMessage("you have to set pos1 first!");
                            } else {
                                //create the platform
                                locPos2 = new Location(
                                        p.getWorld(),
                                        p.getLocation().getX(),
                                        p.getLocation().getY()-1,
                                        p.getLocation().getZ()
                                );

                                if (locPos2.getBlockX()==locPos1.getBlockX()||locPos1.getBlockZ()==locPos2.getBlockZ()){
                                    if (locPos1.getY()==locPos2.getY()){
                                        //correct
                                        p.sendMessage("you have now set both positions");
                                        locPos2.getBlock().setType(Material.LAPIS_BLOCK);
                                        setPos1 = false;

                                        try {
                                            SavePlatform.savePlatform(locPos1, locPos2, "name", 0.1D, plugin);
                                            CreatePlatform.createPlatform(locPos1, locPos2,p, "name", 0.1D, plugin);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                    } else {
                                        p.sendMessage("they have to be on the same y level!");
                                    }

                                } else {
                                    p.sendMessage("you have to be able to draw a STRAIGHT line between the locations. you can not do diagonal!");
                                }
                            }

                        } else {
                            p.sendMessage("please perform the right arguments!");
                        }

                    } else {
                        p.sendMessage("please add");
                    }

                } else if (args[0].equalsIgnoreCase("remove")) {
                    //remove platform
                    p.sendMessage("working remove command");

                } else {
                    //just do /platform command
                    p.sendMessage(Color.prefix(plugin) + Color.color("&aPlease perform the right command! " +
                            "/platform create and /platform remove."));
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 10, 1);
                }
            }

        }

        return false;
    }
}









