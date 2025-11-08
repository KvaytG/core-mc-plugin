package ru.kvaytg.coremc.limits;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;
import ru.kvaytg.coremc.RichWorld;
import ru.kvaytg.coremc.utils.BukkitUtils;

public class DisableEntityAiHandler extends LimitHandler {

    public DisableEntityAiHandler(RichWorld plugin) {
        super(plugin, "mobAi");
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if (getWorlds().contains(entity.getWorld())) {
            BukkitUtils.disableAI(entity);
        }
    }

}