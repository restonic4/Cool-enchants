package me.restonic4.cool_enchants.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntry;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetNbtFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static me.restonic4.cool_enchants.CoolEnchants.MOD_ID;

public class VanillaLootTableModifier {
    public static final ResourceLocation DESERT_WELL = new ResourceLocation("minecraft", "archaeology/desert_well");
    public static final ResourceLocation DESERT_PYRAMID = new ResourceLocation("minecraft", "archaeology/desert_pyramid");
    public static final ResourceLocation OCEAN_RUIN_COLD = new ResourceLocation("minecraft", "archaeology/ocean_ruin_cold");
    public static final ResourceLocation OCEAN_RUIN_WARM = new ResourceLocation("minecraft", "archaeology/ocean_ruin_warm");
    public static final ResourceLocation TRAIL_RUINS_COMMON = new ResourceLocation("minecraft", "archaeology/trail_ruins_common");
    public static final ResourceLocation TRAIL_RUINS_RARE = new ResourceLocation("minecraft", "archaeology/trail_ruins_rare");

    public static void modify() {
        CompoundTag dash = createEnchantedBookCompoundTag(new ResourceLocation(MOD_ID, "dash"), 1);
        CompoundTag doubleJump1 = createEnchantedBookCompoundTag(new ResourceLocation(MOD_ID, "double_jump"), 1);
        CompoundTag nourishment = createEnchantedBookCompoundTag(new ResourceLocation(MOD_ID, "nourishment"), 1);

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(DESERT_WELL.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(dash)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(doubleJump1)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(nourishment)).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }

            if(DESERT_PYRAMID.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(dash)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(doubleJump1)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(nourishment)).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }

            if(OCEAN_RUIN_COLD.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(dash)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(doubleJump1)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(nourishment)).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }

            if(OCEAN_RUIN_WARM.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(dash)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(doubleJump1)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(nourishment)).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }

            if(TRAIL_RUINS_COMMON.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(dash)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(doubleJump1)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(nourishment)).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }

            if(TRAIL_RUINS_RARE.equals(id)) {
                List<LootPoolEntryContainer> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(dash)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(doubleJump1)).build());
                entries.add(LootItem.lootTableItem(Items.ENCHANTED_BOOK).apply(SetNbtFunction.setTag(nourishment)).build());

                LootPool.Builder pool = LootPool.lootPool().with(entries);
                return LootTable.lootTable().withPool(pool).build();
            }

            return null;
        });
    }

    public static CompoundTag createEnchantedBookCompoundTag(ResourceLocation location, int level) {
        ItemStack enchantedBook = new ItemStack(net.minecraft.world.item.Items.ENCHANTED_BOOK);

        CompoundTag enchantmentTag = new CompoundTag();
        enchantmentTag.putString("id", location.toString());
        enchantmentTag.putShort("lvl", (short) level);

        ListTag enchantmentsList = new ListTag();
        enchantmentsList.add(enchantmentTag);

        CompoundTag storedEnchantmentsTag = new CompoundTag();
        storedEnchantmentsTag.put("StoredEnchantments", enchantmentsList);

        enchantedBook.setTag(storedEnchantmentsTag);

        return enchantedBook.getOrCreateTag();
    }
}
