package ru.kvaytg.coremc.hidestream;

import ru.kvaytg.coremc.RichWorld;
import ru.kvaytg.coremc.component.AutoConfigurableHandler;
import ru.kvaytg.coremc.config.constants.ConfigSection;

public abstract class HideStreamHandler extends AutoConfigurableHandler {

    public HideStreamHandler(RichWorld plugin, String enablingParameter) {
        super(plugin, ConfigSection.HIDE_STREAM.getDotPath(), enablingParameter);
    }

}