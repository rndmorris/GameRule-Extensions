package dev.rndmorris.advgamerules.api.rules;

import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.advgamerules.api.IGameRule;
import dev.rndmorris.advgamerules.api.IRuleValue;
import dev.rndmorris.advgamerules.api.values.ByteValue;

public class ByteGameRule implements IGameRule {

    private final String name;
    private final byte defaultValue;

    public ByteGameRule(String name, byte defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new ByteValue(defaultValue);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        return new ByteValue(tag.getByte(name));
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value instanceof ByteValue byteValue) {
            tag.setByte(name, byteValue.getValue());
        }
    }
}
