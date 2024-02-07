package org.insurgencedev.addons.sellboost.listeners;

import dev.norska.dsw.api.DeluxeSellwandSellEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class DeluxeSellWandsListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(DeluxeSellwandSellEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
