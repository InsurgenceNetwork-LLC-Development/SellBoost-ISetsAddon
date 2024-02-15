package org.insurgencedev.addons.sellboost;

import org.insurgencedev.addons.sellboost.listeners.*;
import org.insurgencedev.insurgencesets.api.addon.ISetsAddon;
import org.insurgencedev.insurgencesets.api.addon.InsurgenceSetsAddon;
import org.insurgencedev.insurgencesets.libs.fo.Common;

@ISetsAddon(name = "SellBoostAddon", version = "1.0.1", author = "InsurgenceDev", description = "All-in-one sell boost")
public class SellBoostAddon extends InsurgenceSetsAddon {

    public static final String TYPE = "Sell Boost";
    public static final String NAMESPACE = "GENERAL_SELL";

    @Override
    public void onAddonReloadablesStart() {
        if (Common.doesPluginExist("DeluxeSellwands")) {
            registerEvent(new DeluxeSellWandsListener());
        }

        if (Common.doesPluginExist("EconomyShopGUI") || Common.doesPluginExist("EconomyShopGUI-Premium")) {
            registerEvent(new EconomyShopGUIListener());
        }

        if (Common.doesPluginExist("ShopGUIPlus")) {
            registerEvent(new ShopGUIPlusListener());
        }

        if (Common.doesPluginExist("ManifestCollector")) {
            registerEvent(new ManifestCollectorListener());
        }

        if (Common.doesPluginExist("WildTools")) {
            registerEvent(new WildToolsListener());
        }

        if (Common.doesPluginExist("RivalPickaxes")) {
            registerEvent(new RivalPickaxeEventListener());
        }

        if (Common.doesPluginExist("RivalHarvesterHoes")) {
            registerEvent(new RivalHoeEventListener());
        }

        if (Common.doesPluginExist("RivalFishingRods")) {
            registerEvent(new RivalRodEventListener());
        }

        if (Common.doesPluginExist("RivalMobSwords")) {
            registerEvent(new RivalSwordEventListener());
        }

//        if (Common.doesPluginExist("VoidChest")) {
//            registerEvent(new VoidChestListener());
//        }
    }
}