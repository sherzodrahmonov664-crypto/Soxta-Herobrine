# Soxta-Herobrine Setup Guide 🎮

## Qayta talablar

- **Java 17+** o'rnatilgan bo'lishi kerak
- **Minecraft 1.21.1**
- **Fabric Loader** 

## 1️⃣ Texture Fayl Qo'shish

Texture papkasini yarating:
```
src/main/resources/assets/soxta_herobrine/textures/entity/
```

Bu yerga `herobrine.png` faylini qo'ying (64x64 texture, Steve model uchun).

### Texture qanday bo'lsin?

- Default Steve skin, lekin:
  - **Ko'zlar**: Oq yoki qora (scary bo'lsin)
  - **Terisi**: Qora yoki grimy (dirty)
  - **Mood**: Qorqinchi va unusual

Yoki hozircha default Steve textureni ishlatish mumkin.

## 2️⃣ Moddni Compile Qilish

### Linux/Mac:
```bash
./gradlew build
```

### Windows:
```bash
gradlew.bat build
```

Kuting... ~ 5-10 daqiqa

## 3️⃣ JAR Faylni Topish

Compilation tugallangach:
```
build/libs/soxta-herobrine-1.0.0.jar
```

## 4️⃣ Minecraft Modsga O'tkazish

Minecraft mods folderiga:
```
Windows:   %APPDATA%\.minecraft\mods\
Mac:       ~/Library/Application Support/minecraft/mods/
Linux:     ~/.minecraft/mods/
```

`soxta-herobrine-1.0.0.jar` faylini shunga qo'ying.

## 5️⃣ Minecraft Ishga Tushirish

- Minecraft launcherni ochang
- Fabric 1.21.1 profili tanlang
- Mod loadedd bo'lganini ko'rishingiz kerak
- Play boshing!

## ⚙️ Moddni Tahrirlash

### Spawn Chastotasini O'zgartirish

`HerobrineManager.java` da:
```java
if (RANDOM.nextInt(400) < 2) {  // <-- Raqamni o'zgartiring
```

- **Kattaroq raqam** = Kamroq tez paydo bo'ladi
- **Kichikroq raqam** = Tez-tez paydo bo'ladi

### Harakat Tezligini O'zgartirish

```java
double speed = 0.15;  // <-- Bu raqamni o'zgartiring
```

- **0.1** = Sekinroq
- **0.3** = Tezroq va qorqinchliroq!

### Har Qancha Vaqt Qoysun?

```java
if (scareMeter > 400) {  // <-- 400 ticks = 20 soniya
```

- **200** = 10 soniya
- **600** = 30 soniya

## 🐛 Muammolar va Yechimlar

| Muammo | Yechim |
|--------|--------|
| Mod yuklanmadi | Fabric Loader o'rnatilganini tekshiring |
| Herobrine koʻrinmaydi | Texture fayli kerakdir. Papkani tekshiring. |
| Crash! | Java 17+ o'rnatilganini tekshiring |
| Qalat Herobrine | `HerobrineEntity.java` dagi `noClip = true;` tekshiring |

## 📚 File Struktura

```
soxta-herobrine/
├── src/main/java/com/soxta/herobrine/
│   ├── SoxtaHerobrineClient.java
│   ├── HerobrineEntity.java
│   ├── HerobrineRenderer.java
│   └── HerobrineManager.java
├── src/main/resources/
│   ├── fabric.mod.json
│   ├── soxta_herobrine.mixins.json
│   └── assets/soxta_herobrine/textures/entity/herobrine.png
├── build.gradle
├── gradle.properties
└── settings.gradle
```

## ✅ Tugallandi!

Endi modingiz tayyor! Herobrine ortingizdan kuzatadi... 👻

Savollar bo'lsa, o'zgartirishlar qiling va qayta compile qiling!

---

**Esda tuting:** Bu faqat CLIENT-SIDE moddir!
Serverga hech qanday ta'sir qilmaydi va boshqalarga koʻrinmaydi.
