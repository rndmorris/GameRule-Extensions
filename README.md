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

## Creating and reading a gamerule
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

## Creating a custom gamerule implementation
Here's an example custom gamerule that maps enums to bytes.
<details>

```java

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.gameruleexts.api.IGameRule;
import dev.rndmorris.gameruleexts.api.IRuleValue;
import dev.rndmorris.gameruleexts.api.values.EnumValue;

public class ExampleCustomGameRule implements IGameRule {

    public enum ModDifficulty {

        EASY,
        MEDIUM,
        HARD;

        public static ModDifficulty fromByte(int val, ModDifficulty defaultValue) {
            return switch (val) {
                case 0 -> ModDifficulty.EASY;
                case 1 -> ModDifficulty.MEDIUM;
                case 2 -> ModDifficulty.HARD;
                default -> defaultValue;
            };
        }

        public byte toByte() {
            return switch (this) {
                case EASY -> 0;
                case MEDIUM -> 1;
                case HARD -> 2;
            };
        }
    }

    private final String name = "modDifficulty";
    private final ModDifficulty defaultValue;
    private List<String> tabCompletionValues;

    public ExampleCustomGameRule(ModDifficulty defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new EnumValue<>(defaultValue, ModDifficulty.class);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        final var value = ModDifficulty.fromByte(tag.getByte(name), defaultValue);
        return new EnumValue<>(value, ModDifficulty.class);
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        // noinspection rawtypes
        if (value instanceof EnumValue storedVal && storedVal.getValue() instanceof ModDifficulty enumVal) {
            tag.setByte(name, enumVal.toByte());
        }
    }

    @Override
    public Collection<String> tabCompletionValues(ICommandSender commandSender) {
        if (tabCompletionValues == null) {
            tabCompletionValues = Arrays.stream(ModDifficulty.values())
                    .map(ModDifficulty::toString)
                    .collect(Collectors.toList());
        }
        return tabCompletionValues;
    }
}


```

</details>

# Credits
* rndmorris (primary author)
* The GTNH team, for the project template
