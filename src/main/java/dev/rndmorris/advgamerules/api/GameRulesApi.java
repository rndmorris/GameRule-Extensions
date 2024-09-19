package dev.rndmorris.advgamerules.api;

import net.minecraft.world.World;

import dev.rndmorris.advgamerules.GameRuleManager;
import dev.rndmorris.advgamerules.api.rules.IGameRule;

public class GameRulesApi {

    /**
     * Register a new game rule.
     * 
     * @param newGameRule The game rule to add.
     * @return True if the game rule was added, false if a game rule of the same name already exists.
     */
    public static boolean registerGameRule(IGameRule newGameRule) {
        return GameRuleManager.registerGameRule(newGameRule);
    }

    /**
     * Get a game rule by its name.
     * 
     * @param name The name of the rule to get.
     * @return The rule if it exists, otherwise null.
     */
    public static IGameRule getGameRule(World world, String name) {
        return null;
    }

    /**
     * Get a rule of a specific type by its name.
     * 
     * @param name  The name of the rule to get.
     * @param clazz The class of the game rule to get.
     * @return The game rule if it both exists and is of the specified type, otherwise null.
     * @param <T> The type of the game rule to get.
     */
    public static <T extends IGameRule> T getGameRule(World world, String name, Class<T> clazz) {
        return null;
    }
}
