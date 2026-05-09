package net.nom.jokmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.nom.jokmod.JokMod;
import net.nom.jokmod.entity.custom.DebugEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DebugModel<T extends DebugEntity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(JokMod.MOD_ID, "debug"), "main");
    private final ModelPart group_humannoid;
    private final ModelPart base;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart arm_right;
    private final ModelPart arm_right2;
    private final ModelPart leg_right;
    private final ModelPart leg_left;

    public DebugModel(ModelPart root) {
        this.group_humannoid = root.getChild("group_humannoid");
        this.base = this.group_humannoid.getChild("base");
        this.head = this.base.getChild("head");
        this.body = this.base.getChild("body");
        this.arm_right = this.body.getChild("arm_right");
        this.arm_right2 = this.body.getChild("arm_right2");
        this.leg_right = this.group_humannoid.getChild("leg_right");
        this.leg_left = this.group_humannoid.getChild("leg_left");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition group_humannoid = partdefinition.addOrReplaceChild("group_humannoid", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

        PartDefinition base = group_humannoid.addOrReplaceChild("base", CubeListBuilder.create(), PartPose.offset(0.0F, -8.5F, 0.75F));

        PartDefinition head = base.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.5F, -0.25F));

        PartDefinition body = base.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -11.0F, -2.0F, 6.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 0.25F));

        PartDefinition arm_right = body.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(18, 24).addBox(-3.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -11.0F, -0.5F, 0.0F, 0.0F, 1.5708F));

        PartDefinition arm_right2 = body.addOrReplaceChild("arm_right2", CubeListBuilder.create().texOffs(0, 26).addBox(0.0F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.0F, -0.5F, 0.0F, 0.0F, -1.5708F));

        PartDefinition leg_right = group_humannoid.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(18, 12).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -9.0F, 0.5F));

        PartDefinition leg_left = group_humannoid.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -9.0F, 0.5F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(DebugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animate(entity.idleAnimationState, DebugAnimations.ANIM_DEBUG_IDLE, ageInTicks, 1f);
        this.animate(entity.walkAnimationState, DebugAnimations.ANIM_DEBUG_WALKING, ageInTicks, 1f); // ✅ เปลี่ยน

        this.applyHeadRotation(netHeadYaw, headPitch);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        group_humannoid.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return this.group_humannoid;
    }
}