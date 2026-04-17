package net.nom.jokmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.item.ModItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JokMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItem.MISRITE.get());
        basicItem(ModItem.DEBUGITEM.get());
        basicItem(ModItem.RICEWHISKY.get());
        basicItem(ModItem.TOUNGYOD.get());
    }
}
