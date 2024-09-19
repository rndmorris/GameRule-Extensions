package dev.rndmorris.advgamerules.api;

import java.util.List;

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
     * The String representation of a game rule's value.
     * 
     * @return A String
     */
    String getValueString();

    /**
     * Specifies values that are acceptable for tab-completion for the /gamerule command.
     * 
     * @return A List of Strings, or null if none are available.
     */
    List<String> tabCompletionOptions();
}
