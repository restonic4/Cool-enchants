package me.restonic4.cool_enchants.events;

import me.restonic4.cool_enchants.effects.EffectsManager;
import me.restonic4.cool_enchants.registries.EnchantmentsManager;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.phys.EntityHitResult;

public class EntityEvents {
    public static void register() {
        AttackEntityCallback.EVENT.register((Player player, Level level, InteractionHand interactionHand, Entity entity, EntityHitResult hitResult) -> {
            if (entity instanceof Player) {
                Player targetPlayer = (Player) entity;

                MobEffectInstance effectInstance = new MobEffectInstance(EffectsManager.COMBAT_MODE, 60 * 20, 0);

                player.addEffect(effectInstance);
                targetPlayer.addEffect(effectInstance);
            }

            return InteractionResult.PASS;
        });
    }
}
