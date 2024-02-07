package org.insurgencedev.addons.sellboost.listeners;

import me.gypopo.economyshopgui.api.events.PreTransactionEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class EconomyShopGUIListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(PreTransactionEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }
}
