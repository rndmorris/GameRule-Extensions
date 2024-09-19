# GameRule-Extensions
An extension library to allow mod developers to more easily add custom gamerules, with additional datatype support.

# Usage (Mod Developers Only)

## Adding a new game rule

1. Add the API jar as a dependency to your project.
2. Call `dev.rndmorris.gameruleexts.api.GameRulesApi.registerGameRule(...)` to add a new gamerule for your mod. The `api.rules` package contains basic implementations for declaring boolean, numerical, and string gamerules.
3. If necessary, write your own `IGameRule` implementation.

## Reading a game rule
1. Call `dev.rndmorris.gameruleexts.api.GameRulesApi.getGameRules(...)`.
2. The returned `IGameRules` object can be used to retrieve and update gamerules by their name.

# Examples
```java

public class CommonProxy {
  // ...
  public void postInit(FMLPostInitializationEvent event) {
    GameRulesApi.registerGameRule(new FloatGameRule("grassCuttingSwordDamage", 90F));
  }
  // ...
}

public class SwordGrassCutting extends ItemSword {
  // ...
  public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase player) {
    final var gameRules = GameRulesApi.getGameRules(player.worldObj);
    target.attackEntityFrom(DamageSource.causePlayerDamage(player).setMagicDamage(), gameRules.getFloat("grassCuttingSwordDamage"));
    return super.hitEntity(stack, target, player);
  }
  // ...
}

```

# Credits
* rndmorris (primary author)
* The GTNH team, for the project template
