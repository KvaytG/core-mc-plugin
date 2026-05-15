package ru.kvaytg.coremc.vanish;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.kvaytg.coremc.CoreMc;
import ru.kvaytg.coremc.component.AbstractHandler;
import ru.kvaytg.coremc.permission.Permissions;

public class VanishHandler extends AbstractHandler {

    private final VanishManager vanishManager;

    public VanishHandler(CoreMc plugin, VanishManager vanishManager) {
        super(plugin, true);
        this.vanishManager = vanishManager;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        vanishManager.hideVanishedFor(player);
    }

    @EventHandler
    public void onExit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (vanishManager.isVanished(player)) {
            vanishManager.show(player);
        }
    }

    @EventHandler
    public void onEntityClick(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!vanishManager.isVanished(player)
                || Permissions.VANISH_INVENTORY.hasNo(player)) return;
        if (event.getRightClicked() instanceof Player) {
            Player target = (Player) event.getRightClicked();
            player.openInventory(target.getInventory());
        }
    }

}