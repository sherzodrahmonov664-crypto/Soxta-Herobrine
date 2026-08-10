package com.soxta.herobrine;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class HerobrineEntity extends LivingEntity {

    private float headYaw = 0;
    private float prevHeadYaw = 0;
    private float bodyYaw = 0;
    private float prevBodyYaw = 0;

    public HerobrineEntity(EntityType<?> type, World world) {
        super((EntityType<? extends LivingEntity>) type, world);
        this.noClip = true; // Duvarga tiqilmasin, faqat render qilinsin
    }

    public static DefaultAttributeContainer.Builder createHerobrineAttributes() {
        return LivingEntity.createLivingAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    public void tick() {
        super.tick();
        this.prevHeadYaw = this.headYaw;
        this.prevBodyYaw = this.bodyYaw;
        
        // Herobrine o'zini teleport qilsa va tashvishga olib kelsa
        if (this.getWorld().isClient && this.random.nextInt(200) == 0) {
            this.yaw += (this.random.nextFloat() - 0.5f) * 30f;
            this.headYaw = this.yaw;
        }
    }

    @Override
    public void updatePosition() {
        super.updatePosition();
    }

    @Override
    public boolean canSpawn() {
        return true;
    }

    @Override
    public void remove(RemovalReason reason) {
        // Client-side entity, remove qilinishi kerak
        super.remove(reason);
    }
}
