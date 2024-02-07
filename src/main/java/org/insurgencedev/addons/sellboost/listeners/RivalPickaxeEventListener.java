package org.insurgencedev.addons.sellboost.listeners;

import me.rivaldev.pickaxes.api.events.PickaxeMoneyReceiveEnchant;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.addons.sellboost.utils.AddonUtil;

public final class RivalPickaxeEventListener implements Listener {

    @EventHandler
    private void onReceive(PickaxeMoneyReceiveEnchant event) {
        AddonUtil.getMulti(event.getPlayer(), (found, multi) -> {
            if (found) {
                event.setMoney(AddonUtil.calculateAmount(event.getMoney(), multi));
            }
        });
    }
}
