package net.nom.jokmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class RiceWhisky extends Item {
    public RiceWhisky(Properties properties){
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity) {
        MobEffectInstance currentEffect = pLivingEntity.getEffect(MobEffects.CONFUSION);
        if(currentEffect != null){
            int duration = 1200;
            int amplifier = currentEffect.getAmplifier();
            amplifier += 1;
            duration *= amplifier;

            if(amplifier > 4){
                amplifier = 4;
            }
            pLivingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, duration, amplifier ));
        }
        return super.finishUsingItem(pStack, pLevel, pLivingEntity);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }
}
