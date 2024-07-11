package me.restonic4.cool_enchants.registries;

import me.restonic4.cool_enchants.enchantments.DashEnchantment;
import me.restonic4.cool_enchants.enchantments.DoubleJumpEnchantment;
import me.restonic4.cool_enchants.enchantments.NourishmentEnchantment;
import me.restonic4.cool_enchants.enchantments.SmeltingEdgeEnchantment;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import static me.restonic4.cool_enchants.CoolEnchants.MOD_ID;

public class EnchantmentsManager {
    public static final DoubleJumpEnchantment DOUBLE_JUMP_ENCHANTMENT = new DoubleJumpEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentCategory.ARMOR_FEET,
            new EquipmentSlot[] {}
    );

    public static final DashEnchantment DASH_ENCHANTMENT = new DashEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentCategory.ARMOR_LEGS,
            new EquipmentSlot[] {}
    );

    public static final NourishmentEnchantment NOURISHMENT_ENCHANTMENT = new NourishmentEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentCategory.ARMOR_CHEST,
            new EquipmentSlot[] {}
    );

    public static final SmeltingEdgeEnchantment SMELTING_EDGE_ENCHANTMENT = new SmeltingEdgeEnchantment(
            Enchantment.Rarity.UNCOMMON,
            EnchantmentCategory.DIGGER,
            new EquipmentSlot[] {}
    );

    public static void register() {
        Registry.register(
                BuiltInRegistries.ENCHANTMENT,
                new ResourceLocation(MOD_ID, "double_jump"),
                DOUBLE_JUMP_ENCHANTMENT
        );

        Registry.register(
                BuiltInRegistries.ENCHANTMENT,
                new ResourceLocation(MOD_ID, "dash"),
                DASH_ENCHANTMENT
        );

        Registry.register(
                BuiltInRegistries.ENCHANTMENT,
                new ResourceLocation(MOD_ID, "nourishment"),
                NOURISHMENT_ENCHANTMENT
        );

        Registry.register(
                BuiltInRegistries.ENCHANTMENT,
                new ResourceLocation(MOD_ID, "smelting_edge"),
                SMELTING_EDGE_ENCHANTMENT
        );
    }
}
