package com.core.thewolfbadger.fastfood.likeMe;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Jared on 7/4/14.
 */
public class Main extends JavaPlugin implements Listener {
    private FileConfiguration settings;
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        this.settings = getConfig();
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    public void onDisable() {}
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(e.getItem() !=null) {
            for(Enum foods : Food.values()) {
                String name = foods.name();
                if(Food.valueOf(name).material().equals(e.getItem().getType())) {
                    if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                    if(this.settings.getDouble("HealValues."+name.toUpperCase())+p.getHealth() <= 20.0) {
                        p.setHealth(this.settings.getDouble("HealValues."+name.toUpperCase())+p.getHealth());
                        e.getItem().setAmount(e.getItem().getAmount()-1);
                    } else
                        if(this.settings.getDouble("HealValues."+name.toUpperCase())+p.getHealth() > 20.0 && !(p.getHealth() == 20.0)) {
                            p.setHealth(20.0);
                            e.getItem().setAmount(e.getItem().getAmount()-1);
                        }
                    }
                }
            }
        }
    }
}
