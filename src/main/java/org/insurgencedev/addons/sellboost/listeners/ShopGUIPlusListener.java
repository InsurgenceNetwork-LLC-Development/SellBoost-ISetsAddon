package org.insurgencedev.addons.sellboost.listeners;

import net.brcdev.shopgui.event.ShopPreTransactionEvent;
import net.brcdev.shopgui.shop.ShopManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class ShopGUIPlusListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onTransact(ShopPreTransactionEvent event) {
        if (!event.getShopAction().equals(ShopManager.ShopAction.SELL)) {
            return;
        }

        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }
}
