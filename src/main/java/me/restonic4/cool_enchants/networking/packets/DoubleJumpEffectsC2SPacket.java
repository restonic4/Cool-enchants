package me.restonic4.cool_enchants.networking.packets;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.sounds.SoundEvents;

public class DoubleJumpEffectsC2SPacket {
    public static void receive(MinecraftServer minecraftServer, ServerPlayer serverPlayer, ServerGamePacketListenerImpl serverGamePacketListener, FriendlyByteBuf friendlyByteBuf, PacketSender packetSender) {
        ServerLevel serverLevel = serverPlayer.serverLevel();

        serverLevel.sendParticles(ParticleTypes.CLOUD, serverPlayer.getX(), serverPlayer.getY(), serverPlayer.getZ(), 10, 0.1, 0.1, 0.1, 0.01);
        serverLevel.playSound(null, serverPlayer.blockPosition(), SoundEvents.PHANTOM_FLAP, serverPlayer.getSoundSource(), 1.0F, 2.0F);
        serverLevel.playSound(null, serverPlayer.blockPosition(), SoundEvents.CHERRY_LEAVES_FALL, serverPlayer.getSoundSource(), 0.25F, 1.0F);
    }
}
