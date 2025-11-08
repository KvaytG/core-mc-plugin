package ru.kvaytg.coremc.perks;

import ru.kvaytg.coremc.RichWorld;
import ru.kvaytg.coremc.component.AutoConfigurableHandler;
import ru.kvaytg.coremc.config.constants.ConfigSection;

public abstract class PerkHandler extends AutoConfigurableHandler {

    public PerkHandler(RichWorld plugin, String configSection) {
        super(plugin, ConfigSection.PERKS.getDotPath().add(configSection));
    }

}