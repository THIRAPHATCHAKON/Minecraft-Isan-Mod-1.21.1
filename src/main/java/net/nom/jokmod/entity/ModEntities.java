package net.nom.jokmod.entity;

import net.nom.jokmod.JokMod;
import net.nom.jokmod.entity.custom.DebugEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, JokMod.MOD_ID);

    public static final RegistryObject<EntityType<DebugEntity>> DEBUG =
            ENTITY_TYPES.register("debug", () -> EntityType.Builder.of(DebugEntity::new, MobCategory.CREATURE)
                    .sized(1.5f, 1.5f).build("debug"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}