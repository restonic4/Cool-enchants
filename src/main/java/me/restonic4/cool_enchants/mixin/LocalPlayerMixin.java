package me.restonic4.cool_enchants.mixin;

import me.restonic4.cool_enchants.effects.EffectsManager;
import me.restonic4.cool_enchants.events.KeyMappings;
import me.restonic4.cool_enchants.networking.PacketsManager;
import me.restonic4.cool_enchants.registries.EnchantmentsManager;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Unique
    private int jumpCount = 0;
    @Unique
    private boolean jumpedLastTick = false;

    @Unique
    private boolean dashing = false;
    @Unique
    private long lastDashTime = 0;

    @Inject(method = "tick", at = @At("HEAD"))
    private void tick(CallbackInfo info) {
        LocalPlayer player = (LocalPlayer) (Object) this;

        // Double jump
        if (player.onGround() || player.onClimbable()) {
            jumpCount = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsManager.DOUBLE_JUMP_ENCHANTMENT, player.getItemBySlot(EquipmentSlot.FEET));
            dashing = false;
        } else if (!jumpedLastTick && jumpCount > 0 && player.getDeltaMovement().y < 0) {
            if (player.input.jumping && canJump(player)) {
                jumpCount--;
                player.jumpFromGround();

                FriendlyByteBuf buf = PacketByteBufs.create();
                ClientPlayNetworking.send(PacketsManager.DOUBLE_JUMP_EFFECTS, buf);
            }
        }

        // Dash
        if (KeyMappings.dashKey.isDown() && !dashing && canDash(player)) {
            long currentTime = System.currentTimeMillis();
            int delayTime = 500;

            if (currentTime - lastDashTime >= delayTime) {
                performDash(player);
                dashing = true;
                lastDashTime = currentTime;

                FriendlyByteBuf buf = PacketByteBufs.create();
                ClientPlayNetworking.send(PacketsManager.DASH_EFFECTS, buf);
            }
        }

        jumpedLastTick = player.input.jumping;
    }

    @Unique
    private void performDash(LocalPlayer player) {
        double yaw = Math.toRadians(player.getYRot());
        double dashSpeed = 1.5;

        if (player.hasEffect(EffectsManager.COMBAT_MODE)) {
            dashSpeed = 0.8;
        }

        double x = -Math.sin(yaw) * dashSpeed;
        double z = Math.cos(yaw) * dashSpeed;

        player.setDeltaMovement(x, player.getDeltaMovement().y, z);
    }

    @Unique
    private boolean canJump(LocalPlayer player) {
        ItemStack chestItemStack = player.getItemBySlot(EquipmentSlot.CHEST);
        boolean wearingElytra = chestItemStack.getItem() == Items.ELYTRA && ElytraItem.isFlyEnabled(chestItemStack);

        return !player.onGround()
                && !player.isFallFlying()
                && !player.getAbilities().flying
                && !player.isPassenger()
                && !player.isSwimming()
                && !player.hasEffect(MobEffects.LEVITATION)
                && !player.getAbilities().instabuild//creative mode
                && !wearingElytra;
    }

    @Unique
    private boolean canDash(LocalPlayer player) {
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        return EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsManager.DASH_ENCHANTMENT, leggings) > 0
                && !player.onGround()
                && !player.isFallFlying()
                && !player.getAbilities().flying
                && !player.isPassenger()
                && !player.isSwimming()
                && !player.hasEffect(MobEffects.LEVITATION)
                && !player.getAbilities().instabuild; // creative mode
    }
}
