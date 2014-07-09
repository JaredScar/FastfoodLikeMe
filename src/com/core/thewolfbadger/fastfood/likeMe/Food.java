package com.core.thewolfbadger.fastfood.likeMe;

import org.bukkit.Material;

/**
 * Created by Jared on 7/4/14.
 */
public enum Food {
    STEAK(Material.COOKED_BEEF),
    PORK(Material.GRILLED_PORK),
    BREAD(Material.BREAD),
    CARROT(Material.CARROT),
    APPLE(Material.APPLE),
    STEW(Material.MUSHROOM_SOUP),
    CHICKEN(Material.COOKED_CHICKEN),
    BAKED_POTATO(Material.BAKED_POTATO),
    CAKE(Material.CAKE),
    PUMP_PIE(Material.PUMPKIN_PIE),
    COOKIE(Material.COOKIE),
    FISH(Material.COOKED_FISH),
    MELON(Material.MELON);
    private Material food;
    Food(Material food) {
        this.food = food;
    }
    public Material material() {
        return this.food;
    }
}
