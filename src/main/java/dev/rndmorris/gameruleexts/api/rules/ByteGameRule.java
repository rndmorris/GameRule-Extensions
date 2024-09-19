package dev.rndmorris.gameruleexts.api.rules;

import java.util.Collection;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.gameruleexts.api.IGameRule;
import dev.rndmorris.gameruleexts.api.IRuleValue;
import dev.rndmorris.gameruleexts.api.values.ByteValue;

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

    @Override
    public Collection<String> tabCompletionValues(ICommandSender commandSender) {
        return null;
    }
}
