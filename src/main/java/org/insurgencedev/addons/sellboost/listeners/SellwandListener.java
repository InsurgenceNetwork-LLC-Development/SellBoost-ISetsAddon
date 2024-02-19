package org.insurgencedev.addons.sellboost.listeners;

import me.zachary.sellwand.api.events.SellwandSellEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class SellwandListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(SellwandSellEvent event) {
        Player player = event.getPlayer();

        AddonUtil.getMulti(player, (found, multi) -> {
            if (found) {
                event.setSellPrice(AddonUtil.calculateAmount(event.getSellPrice(), multi));
            }
        });
    }
}
