package me.restonic4.cool_enchants.events;

import me.restonic4.cool_enchants.enchantments.SmeltingEdgeEnchantment;
import me.restonic4.cool_enchants.registries.EnchantmentsManager;
import me.restonic4.cool_enchants.util.LevelUtil;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class LevelEvents {
    public static void register() {
        PlayerBlockBreakEvents.BEFORE.register((level, player, blockPos, blockState, blockEntity) -> {
            if (SmeltingEdgeEnchantment.isAffected(blockState)) {
                ItemLike itemLike = SmeltingEdgeEnchantment.getSmeltedItem(blockState);

                int enchantmentLevel = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsManager.SMELTING_EDGE_ENCHANTMENT, player.getItemBySlot(EquipmentSlot.MAINHAND));;
                int fortuneLevel = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.BLOCK_FORTUNE, player.getItemBySlot(EquipmentSlot.MAINHAND));

                Random random = new Random();

                double probability = calculateProbability(enchantmentLevel);

                if (itemLike != null && random.nextDouble() <= probability) {
                    level.setBlockAndUpdate(blockPos, Blocks.AIR.defaultBlockState());

                    int quantity = calculateQuantity(fortuneLevel, random, blockState);
                    LevelUtil.dropItemStack(level, blockPos, itemLike, quantity);

                    return false;
                }

                return true;
            }

            return true;
        });
    }

    private static double calculateProbability(int enchantmentLevel) {
        if (enchantmentLevel >= 4) {
            return 1.0;
        }

        return 0.25 * enchantmentLevel;
    }

    private static int calculateQuantity(int fortuneLevel, Random random, BlockState blockState) {
        if (!(blockState.getBlock() instanceof DropExperienceBlock)) {
            return 1;
        }

        if (fortuneLevel > 0) {
            int bonusRolls = random.nextInt(fortuneLevel + 2) - 1;
            if (bonusRolls < 0) {
                bonusRolls = 0;
            }
            return 1 + bonusRolls;
        } else {
            return 1;
        }
    }
}
