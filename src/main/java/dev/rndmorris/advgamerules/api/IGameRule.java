package dev.rndmorris.advgamerules.api;

import java.util.Collection;

import net.minecraft.command.ICommandSender;
import net.minecraft.nbt.NBTTagCompound;

/**
 * A game rule within the GameRule Extensions API. See api.rules for default implementations.
 */
public interface IGameRule {

    /**
     * The name under which a game rule is registered.
     * 
     * @return A String
     */
    String getName();

    /**
     * The default value of the rule
     * 
     * @return An IRuleValue implementation
     */
    IRuleValue getDefaultValue();

    /**
     * Extract a value from NBT
     * 
     * @param tag The tag to read
     * @return The Rule Value for the rule.
     */
    IRuleValue readValueFromNBT(NBTTagCompound tag);

    /**
     * Write the given Rule Value to NBT
     * 
     * @param tag   The tag to write
     * @param value The current value of the rule.
     */
    void writeValueToNBT(NBTTagCompound tag, IRuleValue value);

    /**
     * Get the values available for tab completion in the /gamerule command
     * 
     * @param commandSender The user executing the command
     * @return A collection of valid strings, or null if none are available.
     */
    Collection<String> tabCompletionValues(ICommandSender commandSender);
}
