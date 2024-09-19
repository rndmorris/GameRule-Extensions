package dev.rndmorris.advgamerules.api;

import java.util.Collection;

public interface IGameRules {

    /**
     * Check if a rule exists
     * 
     * @param ruleName The name of the rule to find.
     * @return True if the rule exists or is registered, false otherwise.
     */
    boolean ruleExists(String ruleName);

    /**
     * Get the names of all game rules set in the world.
     * 
     * @return A Collection of Strings.
     */
    Collection<String> getRuleNames();

    /**
     * Get the definition of the named rule.
     * 
     * @param ruleName The name of the rule to find.
     * @return An IGameRule implementation, or null if the game rule does not exist.
     */
    IGameRule getRuleDefinition(String ruleName);

    /**
     * Get a rule's boolean value, or the rule's default value if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The boolean value.
     */
    boolean getBoolean(String ruleName);

    /**
     * Get a rule's byte value, or the rule's default value if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The byte value.
     */
    byte getByte(String ruleName);

    /**
     * Get a rule's double value, or the rule's default value if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The double value.
     */
    double getDouble(String ruleName);

    /**
     * Get a rule's float value, or the rule's default if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The float value.
     */
    float getFloat(String ruleName);

    /**
     * Get a rule's integer value, or the rule's default if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The integer value.
     */
    int getInteger(String ruleName);

    /**
     * Get a rule's long value, or the rule's default if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The long value.
     */
    long getLong(String ruleName);

    /**
     * Get a rule's short value, or the rule's default if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The short value.
     */
    short getShort(String ruleName);

    /**
     * Get a rule's string value, or the rule's default if not set.
     * 
     * @param ruleName The name of the rule to retrieve.
     * @return The string value.
     */
    String getStringValue(String ruleName);

    /**
     * Set a rule's boolean value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setBoolean(String ruleName, boolean value);

    /**
     * Set a rule's byte value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setByte(String ruleName, byte value);

    /**
     * Set a rule's double value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setDouble(String ruleName, double value);

    /**
     * Set a rule's float value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setFloat(String ruleName, float value);

    /**
     * Set a rule's integer value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setInteger(String ruleName, int value);

    /**
     * Set a rule's long value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setLong(String ruleName, long value);

    /**
     * Set a rule's short value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setShort(String ruleName, short value);

    /**
     * Set a rule's string value.
     * 
     * @param ruleName The name of the rule to update.
     * @param value    The new value.
     */
    void setStringValue(String ruleName, String value);
}
