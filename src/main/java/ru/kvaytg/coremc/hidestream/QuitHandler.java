package ru.kvaytg.coremc.hidestream;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.kvaytg.coremc.CoreMc;

public class QuitHandler extends HideStreamHandler{

    public QuitHandler(CoreMc plugin) {
        super(plugin, "exit");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
    }

}