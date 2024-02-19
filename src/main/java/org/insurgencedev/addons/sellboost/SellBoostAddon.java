package org.insurgencedev.addons.sellboost;

import org.insurgencedev.addons.sellboost.listeners.*;
import org.insurgencedev.addons.sellboost.settings.MyConfig;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;
import org.insurgencedev.insurgencesets.libs.fo.Common;

@ISetsAddon(name = "SellBoostAddon", version = "2.0.0", author = "InsurgenceDev", description = "All-in-one sell boost")
public class SellBoostAddon extends InsurgenceSetsAddon {

    public static final String TYPE = "Sell Boost";
    public static final String NAMESPACE = "GENERAL_SELL";

    @Override
    public void onAddonReloadablesStart() {
        MyConfig.instance.reload();

        if (isSupported("DeluxeSellwands")) {
            registerEvent(new DeluxeSellWandsListener());
        }

        if (isSupported("EconomyShopGUI") || isSupported("EconomyShopGUI-Premium")) {
            registerEvent(new EconomyShopGUIListener());
        }

        if (isSupported("ShopGUIPlus")) {
            registerEvent(new ShopGUIPlusListener());
        }

        if (isSupported("ManifestCollector")) {
            registerEvent(new ManifestCollectorListener());
        }

        if (isSupported("WildTools")) {
            registerEvent(new WildToolsListener());
        }

        if (isSupported("RivalPickaxes")) {
            registerEvent(new RivalPickaxeEventListener());
        }

        if (isSupported("RivalHarvesterHoes")) {
            registerEvent(new RivalHoeEventListener());
        }

        if (isSupported("RivalFishingRods")) {
            registerEvent(new RivalRodEventListener());
        }

        if (isSupported("RivalMobSwords")) {
            registerEvent(new RivalSwordEventListener());
        }

//        if (isSupported("VoidChest")) {
//            registerEvent(new VoidChestListener());
//        }

        if (isSupported("ZithiumCollectors")) {
            registerEvent(new ZithiumCollectorListener());
        }

        if (isSupported("Sellwand")) {
            registerEvent(new SellwandListener());
        }
    }

    private boolean isSupported(String pluginName) {
        return Common.doesPluginExist(pluginName) && MyConfig.shouldBoost(pluginName);
    }
}