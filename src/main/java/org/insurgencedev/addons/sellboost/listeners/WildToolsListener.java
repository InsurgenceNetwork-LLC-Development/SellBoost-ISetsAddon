package org.insurgencedev.addons.sellboost.listeners;

import com.bgsoftware.wildtools.api.events.HarvesterHoeSellEvent;
import com.bgsoftware.wildtools.api.events.SellWandUseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class WildToolsListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(SellWandUseEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }

    @EventHandler(ignoreCancelled = true)
    private void onSell(HarvesterHoeSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }
}
