package org.insurgencedev.addons.sellboost.listeners;

import me.rivaldev.mobsword.rivalmobswords.api.SwordMoneyReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class RivalSwordEventListener implements Listener {

    @EventHandler
    private void onReceive(SwordMoneyReceiveEvent event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
