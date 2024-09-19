package dev.rndmorris.advgamerules.api.rules;

import java.util.ArrayList;
import java.util.Collection;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.advgamerules.api.IGameRule;
import dev.rndmorris.advgamerules.api.IRuleValue;
import dev.rndmorris.advgamerules.api.values.BooleanValue;

public class BooleanGameRule implements IGameRule {

    private final String name;
    private final boolean defaultValue;

    public BooleanGameRule(String name, boolean defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new BooleanValue(defaultValue);
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

    @Override
    public Collection<String> tabCompletionValues(ICommandSender commandSender) {
        final var result = new ArrayList<String>(2);
        result.set(0, "true");
        result.set(1, "false");
        return result;
    }
}
