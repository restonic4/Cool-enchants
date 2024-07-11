package me.restonic4.cool_enchants.events;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

@Environment(EnvType.CLIENT)
public class KeyMappings {
    public static final String KEY_CATEGORY = "key.category.cool_enchantments.tab";
    public static final String KEY_DASH = "key.cool_enchantments.dash";

    public static KeyMapping dashKey;

    public static void register() {
        dashKey = KeyBindingHelper.registerKeyBinding(new KeyMapping(
                KEY_DASH,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATEGORY
        ));

    }
}
