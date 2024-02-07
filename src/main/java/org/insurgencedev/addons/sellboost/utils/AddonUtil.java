package org.insurgencedev.addons.sellboost.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.insurgencedev.addons.sellboost.SellBoostAddon;
import org.insurgencedev.insurgencesets.api.ISetsAPI;
import org.insurgencedev.insurgencesets.api.contracts.IArmorSet;
import org.insurgencedev.insurgencesets.api.contracts.IPlayer;
import org.insurgencedev.insurgencesets.data.ArmorSetData;
import org.insurgencedev.insurgencesets.libs.fo.remain.nbt.NBTItem;
import org.insurgencedev.insurgencesets.models.upgrade.Boost;
import org.insurgencedev.insurgencesets.models.upgrade.Upgrade;

import java.util.function.BiConsumer;

@UtilityClass
public class AddonUtil {

    public void getMulti(Player player, BiConsumer<Boolean, Double> ifFound) {
        IPlayer cache = ISetsAPI.getCache(player);
        double totalAmount = 0;

        for (ItemStack item : player.getInventory().getArmorContents()) {
            if (item == null || item.getType().isAir()) {
                continue;
            }

            NBTItem nbtItem = new NBTItem(item);
            if (!nbtItem.hasTag("armorSet")) {
                continue;
            }

            String armorSetName = nbtItem.getString("armorSet");
            if (!ISetsAPI.getArmorSetManager().isArmorSetValid(armorSetName)) {
                continue;
            }

            String itemType = item.getType().name().split("_")[1];
            ArmorSetData data = cache.getArmorSetDataManager().getArmorSetData(armorSetName);
            if (data == null) {
                continue;
            }

            IArmorSet armorSet = ISetsAPI.getArmorSetManager().getArmorSet(armorSetName);
            Upgrade upgrade = armorSet != null ? armorSet.getArmorPieceManager().findPieceLevels(itemType, getLevel(itemType, data)) : null;
            if (upgrade == null) {
                continue;
            }

            for (Boost boost : upgrade.getBoosts()) {
                if (boost.getNamespace().equals(SellBoostAddon.NAMESPACE) && boost.getType().equals(SellBoostAddon.TYPE)) {
                    double boostAmount = boost.getBOOST_SETTINGS().getDouble("Boost_Amount");
                    totalAmount += boost.isPercent() ? boostAmount / 100 : boostAmount;
                }
            }

        }

        ifFound.accept(totalAmount > 0, totalAmount);
    }

    public double calculateAmount(double amountFromEvent, double boostAmount) {
        return amountFromEvent * (boostAmount < 1 ? 1 + boostAmount : boostAmount);
    }

    private int getLevel(String type, ArmorSetData armorSetData) {
        return switch (type) {
            case "HEAD", "HELMET" -> armorSetData.getHelmetLevels();
            case "CHESTPLATE" -> armorSetData.getChestplateLevels();
            case "LEGGINGS" -> armorSetData.getLeggingsLevels();
            case "BOOTS" -> armorSetData.getBootsLevels();
            default -> 0;
        };
    }
}
