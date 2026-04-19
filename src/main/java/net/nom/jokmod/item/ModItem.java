package net.nom.jokmod.item;

import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.item.custom.DebugItem;
import net.nom.jokmod.item.custom.RiceWhisky;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JokMod.MOD_ID);

    public static final RegistryObject<Item> METAL_CHARM_INGOT = ITEMS.register("metalcharmingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_METAL_CHARM = ITEMS.register("rawmetalcharm",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> DEBUGITEM = ITEMS.register("debugitem",
            () -> new DebugItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> TOUNGYOD = ITEMS.register("toungyod",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ToungYod)));

    public static final RegistryObject<Item> RICEWHISKY = ITEMS.register("ricewhisky",
            () -> new RiceWhisky(new Item.Properties().food(ModFoodProperties.RiceWhisky)));

    public static final RegistryObject<Item> YEAST = ITEMS.register("yeast",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_CHARM_SWORD = ITEMS.register("metal_charm_sword",
            () -> new SwordItem(ModToolTiers.METAL_CHARM_INGOT, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.METAL_CHARM_INGOT, 6, -2.4f))));
    public static final RegistryObject<Item> METAL_CHARM_PICKAXE = ITEMS.register("metal_charm_pickaxe",
            () -> new PickaxeItem(ModToolTiers.METAL_CHARM_INGOT, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.METAL_CHARM_INGOT, 3, -2.8f))));
    public static final RegistryObject<Item> METAL_CHARM_SHOVEL = ITEMS.register("metal_charm_shovel",
            () -> new ShovelItem(ModToolTiers.METAL_CHARM_INGOT, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.METAL_CHARM_INGOT, 1.5f, -3.0f))));
    public static final RegistryObject<Item> METAL_CHARM_AXE = ITEMS.register("metal_charm_axe",
            () -> new AxeItem(ModToolTiers.METAL_CHARM_INGOT, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.METAL_CHARM_INGOT, 8, -3.2f))));
//    public static final RegistryObject<Item> METAL_CHARM_HOE = ITEMS.register("metal_charm_hoe",
//            () -> new HoeItem(ModToolTiers.METAL_CHARM_INGOT, new Item.Properties()
//                    .attributes(HoeItem.createAttributes(ModToolTiers.METAL_CHARM_INGOT, 0, -3.0f))));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
