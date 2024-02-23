package org.insurgencedev.addons.sellboost.listeners;

import me.gypopo.economyshopgui.api.events.PreTransactionEvent;
import me.gypopo.economyshopgui.util.Transaction;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class EconomyShopGUIListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    private void onSell(PreTransactionEvent event) {
        Transaction.Type type = event.getTransactionType();
        if (!type.getMode().equalsIgnoreCase("sold")) {
            return;
        }

        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                if (type.equals(Transaction.Type.SELL_GUI_SCREEN) || type.equals(Transaction.Type.SELL_ALL_SCREEN) ||
                        type.equals(Transaction.Type.SELL_ALL_COMMAND)) {

                    event.getPrices().replaceAll((k, v) -> AddonUtil.calculateAmount(v, multi));
                    return;
                }

                event.setPrice(AddonUtil.calculateAmount(event.getPrice(), multi));
            }
        });
    }
}
