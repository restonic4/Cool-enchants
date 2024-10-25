package me.restonic4.cool_enchants;

import me.restonic4.cool_enchants.effects.EffectsManager;
import me.restonic4.cool_enchants.events.EntityEvents;
import me.restonic4.cool_enchants.events.KeyMappings;
import me.restonic4.cool_enchants.events.LevelEvents;
import me.restonic4.cool_enchants.networking.PacketsManager;
import me.restonic4.cool_enchants.registries.EnchantmentsManager;
import me.restonic4.cool_enchants.registries.LootTableFunctionsManager;
import me.restonic4.cool_enchants.util.VanillaLootTableModifier;
import net.fabricmc.api.ModInitializer;

public class CoolEnchants implements ModInitializer {
    public static final String MOD_ID = "cool_enchantments";
    @Override
    public void onInitialize() {
        LootTableFunctionsManager.register();
        EnchantmentsManager.register();
        PacketsManager.registerClientToServerPackets();
        EffectsManager.register();
        EntityEvents.register();
        LevelEvents.register();
        VanillaLootTableModifier.modify();
    }
}
