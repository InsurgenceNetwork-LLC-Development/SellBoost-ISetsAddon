package org.insurgencedev.addons.sellboost.listeners;

import me.rivaldev.harvesterhoes.api.events.HoeMoneyReceiveEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class RivalHoeEventListener implements Listener {

    @EventHandler
    private void onReceive(HoeMoneyReceiveEnchant event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
