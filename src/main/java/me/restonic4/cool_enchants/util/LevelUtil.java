package me.restonic4.cool_enchants.util;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class LevelUtil {
    public static void dropItemStack(Level level, BlockPos blockPos, ItemLike item, int amount) {
        ItemStack dropItemStack = new ItemStack(item, amount);
        ItemEntity itemEntity = new ItemEntity(level, blockPos.getX() + 0.5, blockPos.getY() + 0.5, blockPos.getZ() + 0.5, dropItemStack);

        itemEntity.setDeltaMovement(level.random.nextDouble() * 0.2 - 0.1,
                level.random.nextDouble() * 0.2 + 0.1,
                level.random.nextDouble() * 0.2 - 0.1);

        level.addFreshEntity(itemEntity);
    }
}
