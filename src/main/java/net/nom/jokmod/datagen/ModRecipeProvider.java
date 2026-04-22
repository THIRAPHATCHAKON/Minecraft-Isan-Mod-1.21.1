package net.nom.jokmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.block.ModBlocks;
import net.nom.jokmod.item.ModItem;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        List<ItemLike> METAL_CHARM_INGOT_SMELTABLES = List.of(ModItem.RAW_METAL_CHARM.get(),
                ModBlocks.METAL_CHARM_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.METAL_CHARM_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("B")
                .define('A', ModItem.METAL_CHARM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItem.METAL_CHARM_SWORD.get()), has(ModItem.METAL_CHARM_INGOT.get()))
                .unlockedBy(getHasName(ModItem.METAL_CHARM_SWORD.get()), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.METAL_CHARM_AXE.get())
                .pattern("AA")
                .pattern("AB")
                .pattern(" B")
                .define('A', ModItem.METAL_CHARM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItem.METAL_CHARM_AXE.get()), has(ModItem.METAL_CHARM_INGOT.get()))
                .unlockedBy(getHasName(ModItem.METAL_CHARM_AXE.get()), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.METAL_CHARM_PICKAXE.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" B ")
                .define('A', ModItem.METAL_CHARM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItem.METAL_CHARM_PICKAXE.get()), has(ModItem.METAL_CHARM_INGOT.get()))
                .unlockedBy(getHasName(ModItem.METAL_CHARM_PICKAXE.get()), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.METAL_CHARM_SHOVEL.get())
                .pattern("A")
                .pattern("B")
                .pattern("B")
                .define('A', ModItem.METAL_CHARM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItem.METAL_CHARM_SHOVEL.get()), has(ModItem.METAL_CHARM_INGOT.get()))
                .unlockedBy(getHasName(ModItem.METAL_CHARM_SHOVEL.get()), has(Items.STICK)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.METAL_CHARM_HOE.get())
                .pattern("AA")
                .pattern("B ")
                .pattern("B ")
                .define('A', ModItem.METAL_CHARM_INGOT.get())
                .define('B', Items.STICK)
                .unlockedBy(getHasName(ModItem.METAL_CHARM_HOE.get()), has(ModItem.METAL_CHARM_INGOT.get()))
                .unlockedBy(getHasName(ModItem.METAL_CHARM_HOE.get()), has(Items.STICK)).save(pRecipeOutput);

//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.TOUNGYOD.get())
//                .pattern("AB")
//                .pattern("C ")
//                .pattern("  ")
//                .define('A', Items.WHEAT)
//                .define('B', Items.SUGAR)
//                .define('C', Items.EGG)
//                .unlockedBy(getHasName(ModItem.TOUNGYOD.get()), has(Items.WHEAT))
//                .unlockedBy(getHasName(ModItem.TOUNGYOD.get()), has(Items.SUGAR))
//                .unlockedBy(getHasName(ModItem.TOUNGYOD.get()), has(Items.EGG)).save(pRecipeOutput);
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.TOUNGYOD.get())
//                .pattern("AB")
//                .pattern("C ")
//                .pattern("  ")
//                .define('A', Items.WHEAT)
//                .define('B', Items.SUGAR)
//                .define('C', Items.EGG)
//                .unlockedBy(getHasName(ModItem.TOUNGYOD.get()), has(Items.WHEAT))
//                .unlockedBy(getHasName(ModItem.TOUNGYOD.get()), has(Items.SUGAR))
//                .unlockedBy(getHasName(ModItem.TOUNGYOD.get()), has(Items.EGG)).save(pRecipeOutput);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
//                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(pRecipeOutput);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 32)
//                .requires(ModBlocks.MAGIC_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
//                .save(pRecipeOutput, TutorialMod.MOD_ID + ":alexandrite_from_magic_block");

        oreSmelting(pRecipeOutput, METAL_CHARM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItem.METAL_CHARM_INGOT.get(), 0.25f, 200, "metalcharmingot");
        oreBlasting(pRecipeOutput, METAL_CHARM_INGOT_SMELTABLES, RecipeCategory.MISC, ModItem.METAL_CHARM_INGOT.get(), 0.25f, 100, "metalcharmingot");

    }

//    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
//                                      float pExperience, int pCookingTIme, String pGroup) {
//        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
//                pExperience, pCookingTIme, pGroup, "_from_smelting");
//    }
//
//    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
//                                      float pExperience, int pCookingTime, String pGroup) {
//        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
//                pExperience, pCookingTime, pGroup, "_from_blasting");
//    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, JokMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
