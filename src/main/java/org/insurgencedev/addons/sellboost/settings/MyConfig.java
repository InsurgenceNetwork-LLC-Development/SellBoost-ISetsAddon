package org.insurgencedev.addons.sellboost.settings;

import org.insurgencedev.insurgencesets.api.addon.AddonConfig;

import java.util.ArrayList;
import java.util.List;

public class MyConfig extends AddonConfig {

    public static MyConfig instance = new MyConfig();
    private static List<String> supportedPlugins = new ArrayList<>();

    private MyConfig() {
        loadAddonConfig("config.yml", "config.yml");
    }

    @Override
    protected void onLoad() {
        supportedPlugins = getStringList("Supported_Plugins");
    }

    public static boolean shouldBoost(String pluginName) {
        return supportedPlugins.contains(pluginName);
    }
}
