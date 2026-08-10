# Soxta-Herobrine Oʻzgartirishlar Qoʻllanmasi 🎨

Bu fayl moddni o'zingiz istagan tarzda oʻzgartirishni koʻrsatadi.

## 1. Herobrine Rangini Oʻzgartirish

### Oq ko'zlarni qo'shish

`HerobrineRenderer.java` da `renderGlowingEyes()` methodini to'ldiring:

```java
private void renderGlowingEyes(HerobrineEntity entity, MatrixStack matrices,
                                net.minecraft.client.render.VertexConsumerProvider vertexConsumers, int light) {
    // Oq ko'zlar chizish
    // Bu yerga render code qo'shish mumkin
}
```

## 2. Qorqinch Suratni Oʻzgartirish

`HerobrineRenderer.java` da light ni oʻzgartiring:

```java
// Hozirda: super.render(entity, entityYaw, partialTicks, matrices, vertexConsumers, 15728880);
// 15728880 = maksimal light (white)
// Kichikroq raqam = koʻroq qorong'i bo'ladi

super.render(entity, entityYaw, partialTicks, matrices, vertexConsumers, 5000000); // Qorong'i
```

## 3. Teleportation Chastotasini Oʻzgartirish

`HerobrineManager.java` da:

```java
// Hozirda:
if (RANDOM.nextInt(200) == 0) {
    teleportHerobrine(player);
}

// Koʻproq teleport:
if (RANDOM.nextInt(100) == 0) {  // Ikki baravar tez

// Kamroq teleport:
if (RANDOM.nextInt(400) == 0) {  // Ikki baravar sekin
```

## 4. Harakat Tezligini Oʻzgartirish

```java
// HerobrineManager.java da updateHerobrinePosition() methodida:

double speed = 0.15;  // Hozirda

// Sekinroq:
double speed = 0.05;

// Tezroq (qorqinchliroq):
double speed = 0.3;

// Juda tez:
double speed = 0.5;
```

## 5. Spawn Chastotasini Oʻzgartirish

```java
// Har 300-400 tick da spawn qiladi (15-20 soniya)
if (RANDOM.nextInt(400) < 2) {  // <-- Bu qismni oʻzgartiring
    spawnHerobrine(client, player);
    spawnCooldown = 300;
}

// Tez-tez (har 150-200 tickda):
if (RANDOM.nextInt(200) < 2) {

// Kamroq (har 600-800 tickda):
if (RANDOM.nextInt(800) < 2) {
```

## 6. Shuʻnliligi Moddini O'ngartirish (Lifetime)

```java
// HerobrineManager.java da:
if (scareMeter > 400) {  // Hozirda 20 soniya
    herobrine.discard();
}

// 10 soniya:
if (scareMeter > 200) {

// 30 soniya:
if (scareMeter > 600) {

// 1 daqiqa:
if (scareMeter > 1200) {
```

## 7. Spawn Locationni Oʻzgartirish

```java
// HerobrineManager.java da spawnHerobrine() methodida:

// Hozirda: 15-35 blocks malumot
float distance = 15 + RANDOM.nextFloat() * 20;

// Tomoq yangliq:
float distance = 5 + RANDOM.nextFloat() * 10;  // 5-15 blocks

// Oqlroq:
float distance = 30 + RANDOM.nextFloat() * 40; // 30-70 blocks
```

## 8. Spawn Height (Balandlik) Oʻzgartirish

```java
// Hozirda: 5-10 blocks yuqorida
double spawnY = player.getY() + 5 + RANDOM.nextFloat() * 5;

// Oʻyinchi bilan bir balandlikda:
double spawnY = player.getY();

// Oʻyinchiʻdan 20 block yuqorida:
double spawnY = player.getY() + 20;
```

## 9. Chase Tezligini Oʻzgartirish

```java
// updateHerobrinePosition() methodida:

// Hozirda:
double speed = 0.15;

// Kombinatsiya:
double speed = 0.25;  // Va spawn chastotasini ham oʻzgartiring
```

## 🎯 Eng Qorqinch Sozlamalar

Maximun scare mode:

```java
// HerobrineManager.java

// 1. Spawn chastotasi:
if (RANDOM.nextInt(150) < 3) {  // Tez-tez

// 2. Harakat tezligi:
double speed = 0.4;  // Tez-tez chase qiladi

// 3. Teleport chastotasi:
if (RANDOM.nextInt(80) == 0) {  // Koʻp teleport

// 4. Lifetime:
if (scareMeter > 600) {  // Oʻta uzun turadi
```

## 🎮 Test Qilish

Har qanday o'zgartirishdan keyin:

1. Compile qiling:
   ```bash
   ./gradlew build
   ```

2. JAR faylni mods folderiga qo'ying

3. Minecraft ishga tushiring

4. Oʻzgartirishlarni tekshiring

## ⚠️ Muntazam Xatolar

| Xato | Yechim |
|------|--------|
| `ClassNotFoundException` | Java import qismi qo'shilmadi |
| `ClassCastException` | Entity turini xato cast qildingiz |
| `IndexOutOfBoundsException` | Array out of bounds - raqamlarni tekshiring |

## 💡 Pro Tips

1. **Small changes qiling** - bitta narsani o'zgartirib test qiling
2. **Comments qo'ying** - nima oʻzgartirgani yozib qoying
3. **Backup saqlang** - oʻzgartirishdan avval copy qiling
4. **Git ishlatsa**, commit qiling: `git commit -m "Herobrine tezligini oʻzgartirdim"`

---

Shunga oydin boʻldi! Modingizni moslashtirishni boshlang! 🚀
