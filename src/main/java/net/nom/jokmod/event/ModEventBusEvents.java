package net.nom.jokmod.event;

import net.nom.jokmod.JokMod;
import net.nom.jokmod.entity.ModEntities;
import net.nom.jokmod.entity.client.DebugModel;
import net.nom.jokmod.entity.custom.DebugEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = JokMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(DebugModel.LAYER_LOCATION, DebugModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DEBUG.get(), DebugEntity.createAttributes().build());
    }
}