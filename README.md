# Soxta-Herobrine 👻

**Client-side scary Herobrine mod for Minecraft 1.21.1 Fabric**

Bu mod faqat sizning kompyuteringizda ishlaydi! Serverga hech qanday ta'sir qilmaydi va boshqalarga koʻrinmaydi.

## O'rnatish

1. **Fabric Loader** o'rnatganingizga ishonch hosil qiling: https://fabricmc.net/
2. Mod folder ochaman: `.minecraft/mods/`
3. Bu moddagi `.jar` faylini `.minecraft/mods/` ga qoʻying
4. Minecraft ishga tushiring!

## Mod nima qiladi?

- ✨ Random vaqtda Herobrine paydo boʻladi
- 👀 U ortingizdan kuzatadi va sizga yaqinlashadi
- 📍 Istalgan paytda teleport qiladi va ortingizga boʻladi
- 👻 Faqat sizga koʻrinadi - boshqa hech kimga emas!
- 🎮 Server multiplayer-da hech kimga ta'sir qilmaydi

## Compile qilish

```bash
./gradlew build
```

Natijasi: `build/libs/soxta-herobrine-1.0.0.jar`

## Texture qoʻshish

`src/main/resources/assets/soxta_herobrine/textures/entity/herobrine.png` ga Steve skin texture qoʻying.
Lekin scary boʻlsin - oq/qora koʻzlar bilan!

## Javob berish

- Q: Boshqalar moddni koʻra oladilarmi?
  - A: YO'Q! Faqat client-side, serverga hech ta'sir qilmaydi

- Q: Teleportni o'chirish mumkinmi?
  - A: HerobrineManager.java da `teleportHerobrine()` methodini tahrirlang

- Q: Herobrine tezligini o'zgartirish mumkinmi?
  - A: HerobrineManager.java da `speed` qiymatini o'zgartiring (0.15)

## Litsenziya

MIT License - foydalanish, o'zgartirish va tarqatish mumkin!

---

**Shunga oydin boʻldi! Herobrine ortingizdan kuzatadi...** 👻
