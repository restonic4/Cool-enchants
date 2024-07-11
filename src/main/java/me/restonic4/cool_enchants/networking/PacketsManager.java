package me.restonic4.cool_enchants.networking;

import me.restonic4.cool_enchants.networking.packets.DashEffectsC2SPacket;
import me.restonic4.cool_enchants.networking.packets.DoubleJumpEffectsC2SPacket;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.resources.ResourceLocation;

import static me.restonic4.cool_enchants.CoolEnchants.MOD_ID;

public class PacketsManager {
    public static final ResourceLocation DOUBLE_JUMP_EFFECTS = new ResourceLocation(MOD_ID, "double_jump_effects");
    public static final ResourceLocation DASH_EFFECTS = new ResourceLocation(MOD_ID, "dash_effects");

    public static void registerClientToServerPackets() {
        ServerPlayNetworking.registerGlobalReceiver(DOUBLE_JUMP_EFFECTS, DoubleJumpEffectsC2SPacket::receive);
        ServerPlayNetworking.registerGlobalReceiver(DASH_EFFECTS, DashEffectsC2SPacket::receive);
    }
}
