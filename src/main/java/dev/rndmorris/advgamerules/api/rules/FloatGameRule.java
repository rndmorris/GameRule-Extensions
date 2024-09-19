package dev.rndmorris.advgamerules.api.rules;

import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.advgamerules.api.IGameRule;
import dev.rndmorris.advgamerules.api.IRuleValue;
import dev.rndmorris.advgamerules.api.values.FloatValue;

public class FloatGameRule implements IGameRule {

    private final String name;
    private final float defaultValue;

    public FloatGameRule(String name, float defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new FloatValue(defaultValue);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        return new FloatValue(tag.getFloat(name));
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value instanceof FloatValue floatValue) {
            tag.setFloat(name, floatValue.getValue());
        }
    }
}
