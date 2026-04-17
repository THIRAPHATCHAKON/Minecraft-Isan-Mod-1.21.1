package net.nom.jokmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ToungYod = new FoodProperties.Builder()
            .nutrition(2)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400), 1)
            .saturationModifier(0.20f)
            .build();

    public static final FoodProperties RiceWhisky = new FoodProperties.Builder()
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 1200), 1)
            .effect(new MobEffectInstance(MobEffects.BLINDNESS, 60), 1)
            .effect(new MobEffectInstance(MobEffects.WEAKNESS, 600), 1)
            .build();

}

