package net.nom.jokmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.item.custom.DebugItem;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JokMod.MOD_ID);

    public static final RegistryObject<Item> MISRITE = ITEMS.register("misrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEBUGITEM = ITEMS.register("debugitem",
            () -> new DebugItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
