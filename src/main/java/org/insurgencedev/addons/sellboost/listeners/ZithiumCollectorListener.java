package org.insurgencedev.addons.sellboost.listeners;

import net.zithium.collectors.events.CollectorAutoSellEvent;
import net.zithium.collectors.events.CollectorSellAllEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.hassan.plugin.collector.event.CollectorSellEvent;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class ZithiumCollectorListener implements Listener {

    @EventHandler
    private void onSell(CollectorSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice((float) AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }

    @EventHandler
    private void onSell(CollectorSellAllEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setTotalWorth(AddonUtil.calculateAmount(event.getTotalAmount(), multi));
            }
        });
    }

    @EventHandler
    private void onSell(CollectorAutoSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setTotalWorth(AddonUtil.calculateAmount(event.getTotalAmount(), multi));
            }
        });
    }
}
