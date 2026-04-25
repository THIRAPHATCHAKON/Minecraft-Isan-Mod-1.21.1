package net.nom.jokmod.item.custom;


import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ExorcistKnife extends Item {
    public ExorcistKnife(Properties properties){
        super(properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pTarget instanceof Monster monster){
            monster.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200 , 1));
            monster.addEffect(new MobEffectInstance(MobEffects.POISON, 1200 , 2));
        }
        pStack.hurtAndBreak(1,pAttacker, LivingEntity.getSlotForHand(InteractionHand.MAIN_HAND));
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
