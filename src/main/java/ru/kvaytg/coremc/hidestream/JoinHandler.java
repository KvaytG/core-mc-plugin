package ru.kvaytg.coremc.hidestream;

import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.kvaytg.coremc.CoreMc;

public class JoinHandler extends HideStreamHandler {

    public JoinHandler(CoreMc plugin) {
        super(plugin, "join");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
    }

}