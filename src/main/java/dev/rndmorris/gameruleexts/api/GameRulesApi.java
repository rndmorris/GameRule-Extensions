package dev.rndmorris.gameruleexts.api;

import net.minecraft.world.World;

import dev.rndmorris.gameruleexts.GameRulesManager;

public class GameRulesApi {

    /**
     * Register a new game rule.
     * 
     * @param newGameRule The game rule to add.
     * @return True if the game rule was added, false if a game rule of the same name already exists.
     */
    public static boolean registerGameRule(IGameRule newGameRule) {
        return GameRulesManager.registerGameRule(newGameRule);
    }

    public static IGameRules getGameRules(World world) {
        return GameRulesManager.getGameRules(world);
    }
}
