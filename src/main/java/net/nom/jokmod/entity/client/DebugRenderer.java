package net.nom.jokmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.entity.custom.DebugEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DebugRenderer extends MobRenderer<DebugEntity, DebugModel<DebugEntity>> {
    public DebugRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DebugModel<>(pContext.bakeLayer(DebugModel.LAYER_LOCATION)), 0.85f);
    }

    @Override
    public ResourceLocation getTextureLocation(DebugEntity pEntity) {
        return ResourceLocation.fromNamespaceAndPath(JokMod.MOD_ID, "textures/entity/debug/debug_texture.png");
    }

    @Override
    public void render(DebugEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack,
                       MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            pPoseStack.scale(1f, 1f, 1f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}