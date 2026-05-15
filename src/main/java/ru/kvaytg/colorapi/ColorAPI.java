package ru.kvaytg.colorapi;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;

public class ColorAPI {

    public static String colorize(@NotNull String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}