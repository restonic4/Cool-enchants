package me.restonic4.cool_enchants.registries;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import me.restonic4.cool_enchants.CoolEnchants;
import me.restonic4.cool_enchants.enchantments.DashEnchantment;
import me.restonic4.cool_enchants.enchantments.DoubleJumpEnchantment;
import me.restonic4.cool_enchants.enchantments.NourishmentEnchantment;
import me.restonic4.cool_enchants.enchantments.SmeltingEdgeEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctions;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import static me.restonic4.cool_enchants.CoolEnchants.MOD_ID;

public class LootTableFunctionsManager {
    /*public static final LootItemFunctionType CUSTOM_BOOK = Registry.register(
            BuiltInRegistries.LOOT_FUNCTION_TYPE,
            new ResourceLocation(MOD_ID, "custom_book"),
            new LootItemFunctionType(
                    new CustomEnchantedBookFunction.Serializer()
            )
    );*/

    public static void register() {
        System.out.println("Registering loot table functions");
    }
}
