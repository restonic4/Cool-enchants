package me.restonic4.cool_enchants.enchantments;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class SmeltingEdgeEnchantment extends Enchantment {
    private static final Map<Block, Item> SMELTED_ITEMS = new HashMap<>();

    static {
        SMELTED_ITEMS.put(Blocks.IRON_ORE, Items.IRON_INGOT);
        SMELTED_ITEMS.put(Blocks.DEEPSLATE_IRON_ORE, Items.IRON_INGOT);
        SMELTED_ITEMS.put(Blocks.GOLD_ORE, Items.GOLD_INGOT);
        SMELTED_ITEMS.put(Blocks.DEEPSLATE_GOLD_ORE, Items.GOLD_INGOT);
        SMELTED_ITEMS.put(Blocks.COPPER_ORE, Items.COPPER_INGOT);
        SMELTED_ITEMS.put(Blocks.DEEPSLATE_COPPER_ORE, Items.COPPER_INGOT);
        SMELTED_ITEMS.put(Blocks.ANCIENT_DEBRIS, Items.NETHERITE_SCRAP);
        SMELTED_ITEMS.put(Blocks.SAND, Items.GLASS);
        SMELTED_ITEMS.put(Blocks.RED_SAND, Items.GLASS);
        SMELTED_ITEMS.put(Blocks.WET_SPONGE, Items.SPONGE);
    }

    public SmeltingEdgeEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot[] equipmentSlots) {
        super(rarity, enchantmentCategory, equipmentSlots);
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public boolean canEnchant(ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof DiggerItem)) {
            return false;
        }

        return !hasSilkTouchEnchantment(itemStack);
    }

    private boolean hasSilkTouchEnchantment(ItemStack stack) {
        ListTag enchantments = stack.getEnchantmentTags();
        for (int i = 0; i < enchantments.size(); ++i) {
            CompoundTag enchantmentTag = enchantments.getCompound(i);
            String enchantmentId = enchantmentTag.getString("id");
            if (enchantmentId.equals("minecraft:silk_touch")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAffected(BlockState blockState) {
        Block block = blockState.getBlock();
        return SMELTED_ITEMS.containsKey(block);
    }

    public static ItemLike getSmeltedItem(BlockState blockState) {
        Block block = blockState.getBlock();
        return SMELTED_ITEMS.get(block);
    }
}
