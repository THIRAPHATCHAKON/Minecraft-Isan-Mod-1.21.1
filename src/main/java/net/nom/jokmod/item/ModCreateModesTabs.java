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

    public  static final RegistryObject<CreativeModeTab> MIS_ITEM_TAB = CREATIVE_MODE_TABS.register("mis_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.MISRITE.get()))
                    .title(Component.translatable("cretivetab.jokmod.misrite_items"))
                    .displayItems((itemDisplayParameter, output) -> {
                        output.accept(ModItem.MISRITE.get());
                        output.accept(ModBlocks.MIS_BLOCK.get());
                        output.accept(ModItem.DEBUGITEM.get());
                        output.accept(ModItem.TOUNGYOD.get());
                        output.accept(ModItem.RICEWHISKY.get());
                    }).build());

    public static  void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
