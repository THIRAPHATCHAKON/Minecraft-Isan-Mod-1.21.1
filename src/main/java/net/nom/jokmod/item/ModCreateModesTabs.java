package net.nom.jokmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.block.ModBlocks;

public class ModCreateModesTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JokMod.MOD_ID);

    public  static final RegistryObject<CreativeModeTab> ISAN_ITEM_TAB = CREATIVE_MODE_TABS.register("isan_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.METAL_CHARM_INGOT.get()))
                    .title(Component.translatable("cretivetab.jokmod.isan_items"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModItem.METAL_CHARM_INGOT.get());
                        output.accept(ModBlocks.METAL_CHARM_ORE.get());
                        output.accept(ModItem.DEBUGITEM.get());
                        output.accept(ModItem.TOUNGYOD.get());
                        output.accept(ModItem.RICEWHISKY.get());
                        output.accept(ModItem.METAL_CHARM_PICKAXE.get());
                        output.accept(ModItem.METAL_CHARM_AXE.get());
                        output.accept(ModItem.METAL_CHARM_SWORD.get());
                        output.accept(ModItem.METAL_CHARM_SHOVEL.get());
                        output.accept(ModItem.METAL_CHARM_HOE.get());
                        output.accept(ModItem.RAW_METAL_CHARM.get());
                        output.accept(ModItem.METAL_CHARM_HELMET.get());
                        output.accept(ModItem.METAL_CHARM_CHESTPLATE.get());
                        output.accept(ModItem.METAL_CHARM_LEGGINGS.get());
                        output.accept(ModItem.METAL_CHARM_BOOTS.get());
                        output.accept(ModItem.EFFCETITEM.get());
                        output.accept(ModItem.EXORCISTKNIFE.get());
                    }).build());

    public static  void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
