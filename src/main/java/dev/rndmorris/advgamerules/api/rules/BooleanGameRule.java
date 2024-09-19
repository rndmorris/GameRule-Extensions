package dev.rndmorris.advgamerules.api.rules;

import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.advgamerules.api.values.BooleanValue;
import dev.rndmorris.advgamerules.api.values.IRuleValue;

public class BooleanGameRule implements IGameRule {

    private final String name;
    private final boolean value;

    public BooleanGameRule(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new BooleanValue(value);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        return new BooleanValue(tag.getBoolean(name));
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value instanceof BooleanValue boolValue) {
            tag.setBoolean(name, boolValue.getValue());
        }
    }
}
