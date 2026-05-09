package net.nom.jokmod.entity.custom;

import net.nom.jokmod.entity.ModEntities;
import net.nom.jokmod.item.ModItem;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class DebugEntity extends Animal {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public DebugEntity(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
//        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, stack -> stack.is(ModItems.KOHLRABI.get()), false));
//        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));

        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    private void setupAnimationStates() {
        if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
            // กำลังเดิน
            this.idleAnimationState.stop();                        // ✅ หยุด idle
            this.walkAnimationState.start(this.tickCount);         // ✅ เริ่ม walk
        } else {
            // หยุดนิ่ง
            this.walkAnimationState.stop();                        // ✅ หยุด walk
            this.idleAnimationState.start(this.tickCount);         // ✅ เริ่ม idle
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6) {
            // กำลังเดิน
            walkAnimationState.start(this.tickCount);
            idleAnimationState.stop();  // ← หยุด idle
        } else {
            // หยุดนิ่ง
            walkAnimationState.stop();  // ← หยุด walk
            idleAnimationState.start(this.tickCount);
        }
    }
}