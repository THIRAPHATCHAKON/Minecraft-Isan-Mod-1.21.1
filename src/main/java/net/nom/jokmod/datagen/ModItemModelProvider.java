package net.nom.jokmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.item.ModItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JokMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItem.RAW_METAL_CHARM.get());
        basicItem(ModItem.DEBUGITEM.get());
        basicItem(ModItem.RICEWHISKY.get());
        basicItem(ModItem.TOUNGYOD.get());
        basicItem(ModItem.METAL_CHARM_INGOT.get());

        handheldItem(ModItem.METAL_CHARM_SWORD);
        handheldItem(ModItem.METAL_CHARM_PICKAXE);
        handheldItem(ModItem.METAL_CHARM_SHOVEL);
        handheldItem(ModItem.METAL_CHARM_AXE);
    }


    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(JokMod.MOD_ID,"item/" + item.getId().getPath()));
    }

}
