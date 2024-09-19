package dev.rndmorris.gameruleexts.api.rules;

import java.util.Collection;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.gameruleexts.api.IGameRule;
import dev.rndmorris.gameruleexts.api.IRuleValue;
import dev.rndmorris.gameruleexts.api.values.DoubleValue;

public class DoubleGameRule implements IGameRule {

    private final String name;
    private final double defaultValue;

    public DoubleGameRule(String name, double defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new DoubleValue(defaultValue);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        return new DoubleValue(tag.getDouble(name));
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value instanceof DoubleValue doubleValue) {
            tag.setDouble(name, doubleValue.getValue());
        }
    }

    @Override
    public Collection<String> tabCompletionValues(ICommandSender commandSender) {
        return null;
    }
}
