package me.restonic4.cool_enchants.client;

import me.restonic4.cool_enchants.events.KeyMappings;
import net.fabricmc.api.ClientModInitializer;

public class CoolEnchantsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyMappings.register();
    }
}
