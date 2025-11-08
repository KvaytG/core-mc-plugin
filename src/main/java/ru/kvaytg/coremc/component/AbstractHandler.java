package ru.kvaytg.coremc.component;

import org.bukkit.event.Listener;
import ru.kvaytg.coremc.RichWorld;
import ru.kvaytg.coremc.utils.BukkitUtils;

public abstract class AbstractHandler extends AutoRegistered implements Listener {

    public AbstractHandler(RichWorld plugin, boolean enabled) {
        super(plugin, enabled, null);
    }

    @Override
    public void register(RichWorld plugin) {
        BukkitUtils.registerHandler(this, plugin);
    }

}