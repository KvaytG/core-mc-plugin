package ru.kvaytg.coremc.world;

public enum DisabledGameRule {

    DAYLIGHT("doDaylightCycle", "false"),
    WEATHER("doWeatherCycle", "false"),
    ADVANCEMENTS("announceAdvancements", "false"),
    TICK_SPEED("randomTickSpeed", "0");

    private final String ruleName;
    private final String value;

    DisabledGameRule(String ruleName, String value) {
        this.ruleName = ruleName;
        this.value = value;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getValue() {
        return value;
    }

}