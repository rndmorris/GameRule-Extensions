package dev.rndmorris.gameruleexts.api.rules;

import java.util.Collection;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

import dev.rndmorris.gameruleexts.api.IGameRule;
import dev.rndmorris.gameruleexts.api.IRuleValue;
import dev.rndmorris.gameruleexts.api.values.ShortValue;

public class ShortGameRule implements IGameRule {

    private final String name;
    private final short defaultValue;

    public ShortGameRule(String name, short defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRuleValue getDefaultValue() {
        return new ShortValue(defaultValue);
    }

    @Override
    public IRuleValue readValueFromNBT(NBTTagCompound tag) {
        if (!tag.hasKey(name)) {
            return getDefaultValue();
        }
        return new ShortValue(tag.getShort(name));
    }

    @Override
    public void writeValueToNBT(NBTTagCompound tag, IRuleValue value) {
        if (value instanceof ShortValue shortValue) {
            tag.setShort(name, shortValue.getValue());
        }
    }

    @Override
    public Collection<String> tabCompletionValues(ICommandSender commandSender) {
        return null;
    }
}
