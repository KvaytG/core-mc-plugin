package ru.kvaytg.coremc.warp;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Warp {

    private final String name;
    private final Location location;

    public Warp(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void teleport(Player player) {
        player.teleport(location);
    }

}