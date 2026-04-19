package net.nom.jokmod.item;

import net.nom.jokmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier METAL_CHARM_INGOT = new ForgeTier(1400, 4, 3f, 20,
            ModTags.Blocks.NEEDS_METAL_CHARM_TOOL, () -> Ingredient.of(ModItem.RAW_METAL_CHARM.get()),
            ModTags.Blocks.INCORRECT_FOR_METAL_CHARM_TOOL);
}