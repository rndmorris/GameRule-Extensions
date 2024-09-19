package dev.rndmorris.advgamerules.api;

import net.minecraft.nbt.NBTTagCompound;

/**
 * A game rule within the AdvancedGameRules API
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
}
