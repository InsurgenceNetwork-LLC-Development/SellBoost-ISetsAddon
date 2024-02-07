package org.insurgencedev.addons.sellboost.listeners;

import me.rivaldev.fishingrod.rivalfishingrods.api.RodMoneyReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class RivalRodEventListener implements Listener {

    @EventHandler
    private void onReceive(RodMoneyReceiveEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
