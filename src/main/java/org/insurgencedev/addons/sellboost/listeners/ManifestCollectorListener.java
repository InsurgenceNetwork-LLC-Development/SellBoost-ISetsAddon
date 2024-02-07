package org.insurgencedev.addons.sellboost.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.hassan.plugin.collector.event.CollectorSellEvent;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class ManifestCollectorListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(CollectorSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice((float) AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }
}
