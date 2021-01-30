package me.liamhbest.commands;

import me.liamhbest.Color;
import me.liamhbest.MovingPlatforms;
import me.liamhbest.data.PlatformsData;
import me.liamhbest.utils.CreatePlatform;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlatformCommand implements CommandExecutor {

    MovingPlatforms plugin;
    public PlatformCommand(MovingPlatforms plugin){
        this.plugin = plugin;
    }

    public static boolean setPos1;

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
                            setPos1=true;
                            p.sendMessage("set pos 1");
                            Location loc = new Location(
                                    p.getWorld(),
                                    p.getLocation().getX(),
                                    p.getLocation().getY()-1,
                                    p.getLocation().getZ()
                            );
                            loc.getBlock().setType(Material.GOLD_BLOCK);

                        } else if (args[1].equalsIgnoreCase("pos2")){
                            if (!setPos1){
                                p.sendMessage("you have to set pos1 first!");
                            } else {
                                //create the platform
                                p.sendMessage("you have now set both positions");
                                setPos1 = false;
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









