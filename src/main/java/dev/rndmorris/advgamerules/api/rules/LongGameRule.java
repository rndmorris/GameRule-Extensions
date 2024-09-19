package dev.rndmorris.advgamerules.api.rules;

import java.util.Collection;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.advgamerules.api.IGameRule;
import dev.rndmorris.advgamerules.api.IRuleValue;
import dev.rndmorris.advgamerules.api.values.LongValue;

public class LongGameRule implements IGameRule {

    private final String name;
    private final long defaultValue;

    public LongGameRule(String name, long defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new LongValue(defaultValue);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        return new LongValue(tag.getLong(name));
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value instanceof LongValue longValue) {
            tag.setLong(name, longValue.getValue());
        }
    }

    @Override
    public Collection<String> tabCompletionValues(ICommandSender commandSender) {
        return null;
    }
}
