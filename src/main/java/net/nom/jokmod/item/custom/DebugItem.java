package net.nom.jokmod.item.custom;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;


import java.util.List;


public class DebugItem extends Item {

    public DebugItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();

        if(!level.isClientSide()) {
            List<Block> allBlocks = BuiltInRegistries.BLOCK.stream().toList();
            RandomSource random = level.getRandom();
            Block randomBlock = allBlocks.get(random.nextInt(allBlocks.size()));
            level.setBlockAndUpdate(pContext.getClickedPos(), randomBlock.defaultBlockState());

            pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                    item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
        }

        return InteractionResult.SUCCESS;
    }
}
