package com.soxta.herobrine.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.MinecraftClient;

@Mixin(MinecraftClient.class)
public class ClientTickMixin {
    // Bu yerda qo'shimcha client-side mixins qo'shishingiz mumkin
    // Hozircha bu o'rinda kerak emas, lekin future-proofing uchun qoldirdik
}
