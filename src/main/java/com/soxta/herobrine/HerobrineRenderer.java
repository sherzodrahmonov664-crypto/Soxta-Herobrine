package com.soxta.herobrine;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.render.RenderLayer;

public class HerobrineRenderer extends LivingEntityRenderer<HerobrineEntity, PlayerEntityModel<HerobrineEntity>> {

    private static final Identifier HEROBRINE_TEXTURE = new Identifier("soxta_herobrine", "textures/entity/herobrine.png");

    public HerobrineRenderer(EntityRendererFactory.Context context) {
        super(context, new PlayerEntityModel<>(context.getPart("player"), false), 0.5f);
    }

    @Override
    public Identifier getTexture(HerobrineEntity entity) {
        return HEROBRINE_TEXTURE;
    }

    @Override
    public void render(HerobrineEntity entity, float entityYaw, float partialTicks, MatrixStack matrices, 
                       net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        
        // Qorqinchi rangli light - ko'proq qorqinchi bo'lsin
        super.render(entity, entityYaw, partialTicks, matrices, vertexConsumers, 15728880);
        
        // White glow effect - ko'zlar oq bo'lib parlay
        matrices.push();
        matrices.translate(0, entity.getHeight() / 2, 0);
        this.renderGlowingEyes(entity, matrices, vertexConsumers, light);
        matrices.pop();
    }

    private void renderGlowingEyes(HerobrineEntity entity, MatrixStack matrices,
                                    net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
        // Oq ko'zlar renderingini bu yerda qilishni shunga qo'shishingiz mumkin
        // Hozircha, texture o'zi scary bo'ladi
    }
}
