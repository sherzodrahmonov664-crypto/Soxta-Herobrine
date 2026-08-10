package com.soxta.herobrine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SoxtaHerobrineClient implements ClientModInitializer {

    public static final EntityType<HerobrineEntity> HEROBRINE_TYPE = 
        EntityType.Builder.<HerobrineEntity>create(HerobrineEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.8f)
            .eyeHeight(1.62f)
            .build();

    @Override
    public void onInitializeClient() {
        // Herobrine entity turini registratsiya qilish
        Registry.register(Registries.ENTITY_TYPE, new Identifier("soxta_herobrine", "herobrine"), HEROBRINE_TYPE);

        // Herobrine renderer
        EntityRendererRegistry.register(HEROBRINE_TYPE, HerobrineRenderer::new);

        // Client tick event - har frame Herobrine spawn qilish va harakat qilish
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.world != null && client.player != null) {
                HerobrineManager.tick(client);
            }
        });
    }
}
