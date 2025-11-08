package ru.kvaytg.coremc.component;

import ru.kvaytg.coremc.RichWorld;
import ru.kvaytg.coremc.utils.StringUtils;

public abstract class AutoRegistered extends Enabling {

    private final RichWorld plugin;
    private final String name;

    public RichWorld getPlugin() {
        return plugin;
    }

    public String getName() {
        return StringUtils.isNullOrBlank(name) ? null : name;
    }

    public AutoRegistered(RichWorld plugin, boolean enabled, String name) {
        super(enabled);
        this.plugin = plugin;
        this.name = name;
        if (isEnabled()) {
            init();
        }
    }

    public void init() {}

    public abstract void register(RichWorld plugin);

}