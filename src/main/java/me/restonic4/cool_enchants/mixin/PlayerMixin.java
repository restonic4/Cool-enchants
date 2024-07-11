package me.restonic4.cool_enchants.mixin;

import me.restonic4.cool_enchants.registries.EnchantmentsManager;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {
    @Inject(method = "causeFoodExhaustion", at = @At("HEAD"), cancellable = true)
    private void causeFoodExhaustion(float f, CallbackInfo ci) {
        Player player = (Player) (Object) this;
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);

        int level = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsManager.NOURISHMENT_ENCHANTMENT, chestplate);
        if (level > 0) {
            f /= (1 + level);
        }

        if (!player.getAbilities().invulnerable) {
            if (!player.level().isClientSide) {
                FoodData foodData = player.getFoodData();
                foodData.addExhaustion(f);
            }
        }
        ci.cancel();
    }
}
