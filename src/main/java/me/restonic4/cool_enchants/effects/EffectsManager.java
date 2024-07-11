package me.restonic4.cool_enchants.effects;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import static me.restonic4.cool_enchants.CoolEnchants.MOD_ID;

public class EffectsManager {
    public static final MobEffect COMBAT_MODE = Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(MOD_ID, "combat_mode"), new CombatMode());

    public static void register() {
        System.out.println("MobEffects registered");
    }
}
