package me.restonic4.cool_enchants.effects;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CombatMode extends MobEffect {
    protected CombatMode() {
        super(MobEffectCategory.HARMFUL, 0x7f2fe0);
    }

    @Override
    public void applyEffectTick(LivingEntity livingEntity, int i) {
        super.applyEffectTick(livingEntity, i);
    }
}
