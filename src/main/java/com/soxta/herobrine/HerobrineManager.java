package com.soxta.herobrine;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import java.util.Random;

public class HerobrineManager {

    private static HerobrineEntity herobrine = null;
    private static int spawnCooldown = 0;
    private static final Random RANDOM = new Random();
    private static int scareMeter = 0;

    public static void tick(MinecraftClient client) {
        if (client.player == null || client.world == null) return;

        PlayerEntity player = client.player;
        
        // Spawn cooldown kam qil
        if (spawnCooldown > 0) {
            spawnCooldown--;
        }

        // Random spawn - har 300-400 tick da (15-20 soniya)
        if (herobrine == null && spawnCooldown <= 0) {
            if (RANDOM.nextInt(400) < 2) {
                spawnHerobrine(client, player);
                spawnCooldown = 300;
            }
        }

        // Herobrine bilan harakat
        if (herobrine != null && herobrine.isAlive()) {
            updateHerobrinePosition(player);
            
            // Random teleportation - tashvishga olib kelish
            if (RANDOM.nextInt(200) == 0) {
                teleportHerobrine(player);
            }
            
            // Herobrine hayotini ko'rsatish - 10-20 soniya
            scareMeter++;
            if (scareMeter > 400) {
                herobrine.discard();
                herobrine = null;
                scareMeter = 0;
            }
        }
    }

    private static void spawnHerobrine(MinecraftClient client, PlayerEntity player) {
        HerobrineEntity newHerobrine = new HerobrineEntity(SoxtaHerobrineClient.HEROBRINE_TYPE, client.world);
        
        // Random spawn location - orta, endi, belakida
        float angle = RANDOM.nextFloat() * (float) Math.PI * 2;
        float distance = 15 + RANDOM.nextFloat() * 20;
        
        double spawnX = player.getX() + Math.cos(angle) * distance;
        double spawnY = player.getY() + 5 + RANDOM.nextFloat() * 5;
        double spawnZ = player.getZ() + Math.sin(angle) * distance;
        
        newHerobrine.setPosition(spawnX, spawnY, spawnZ);
        newHerobrine.setHealth(20);
        
        // Entity ni world ga qo'shish - FAQAT CLIENT SIDE
        client.world.addEntity(newHerobrine.getId(), newHerobrine);
        
        herobrine = newHerobrine;
        scareMeter = 0;
    }

    private static void updateHerobrinePosition(PlayerEntity player) {
        if (herobrine == null) return;

        Vec3d playerPos = player.getPos();
        Vec3d herobrinePos = herobrine.getPos();
        
        // Herobrine o'yinchi tomoniga yaqinlashsin
        double dx = playerPos.x - herobrinePos.x;
        double dy = playerPos.y - herobrinePos.y;
        double dz = playerPos.z - herobrinePos.z;
        
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        
        if (distance > 0.1) {
            // Harakat tezligi - 0.15 blocks/tick
            double speed = 0.15;
            double nx = dx / distance * speed;
            double ny = dy / distance * speed;
            double nz = dz / distance * speed;
            
            herobrine.setPosition(herobrinePos.x + nx, herobrinePos.y + ny, herobrinePos.z + nz);
            
            // Head yaw - o'yinchi tomoniga qarasyn
            float yaw = (float) Math.atan2(dz, dx) * 180 / (float) Math.PI - 90;
            herobrine.setYaw(yaw);
        }
    }

    private static void teleportHerobrine(PlayerEntity player) {
        if (herobrine == null) return;

        // Teleport - orta, endi, yoki belakida ko'rinsin
        int spawnType = RANDOM.nextInt(3);
        
        Vec3d playerPos = player.getPos();
        Vec3d newPos;
        
        switch(spawnType) {
            case 0: // Behind player
                newPos = playerPos.add(0, 3, -20);
                break;
            case 1: // Above player
                newPos = playerPos.add(0, 15, 0);
                break;
            case 2: // To the side
                double angle = RANDOM.nextFloat() * (float) Math.PI * 2;
                newPos = playerPos.add(
                    Math.cos(angle) * 25,
                    RANDOM.nextFloat() * 10 + 5,
                    Math.sin(angle) * 25
                );
                break;
            default:
                return;
        }
        
        herobrine.setPosition(newPos.x, newPos.y, newPos.z);
    }

    public static HerobrineEntity getHerobrine() {
        return herobrine;
    }
}
