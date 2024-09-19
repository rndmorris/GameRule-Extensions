package dev.rndmorris.advgamerules.api.rules;

import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.advgamerules.api.IGameRule;
import dev.rndmorris.advgamerules.api.IRuleValue;
import dev.rndmorris.advgamerules.api.values.EnumValue;

public class EnumGameRule<E extends Enum<E>> implements IGameRule {

    private final String name;
    private final E defaultValue;
    private final Class<E> enumClass;

    public EnumGameRule(String name, E defaultValue, Class<E> enumClass) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.enumClass = enumClass;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new EnumValue<>(defaultValue, enumClass);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        final var strValue = tag.getString(name);
        final var value = Enum.valueOf(enumClass, strValue);
        return new EnumValue<>(value, enumClass);
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value != null && enumClass.isAssignableFrom(value.getClass())) {
            tag.setString(name, value.getValueString());
        }
    }
}
