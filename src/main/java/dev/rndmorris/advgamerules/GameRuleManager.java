package dev.rndmorris.advgamerules;

import java.util.Collection;
import java.util.HashMap;

import dev.rndmorris.advgamerules.api.IGameRule;

public class GameRuleManager
{

    private static HashMap<String, IGameRule> gameRuleDefaults = new HashMap<>();

    public static boolean registerGameRule(IGameRule gameRule) {
        return gameRuleDefaults.putIfAbsent(gameRule.getName(), gameRule) != null;
    }

    public static IGameRule getGameRule(String name) {
        return gameRuleDefaults.getOrDefault(name, null);
    }

    public static <T extends IGameRule> T getGameRule(String name, Class<T> clazz) {
        final var rule = getGameRule(name);
        if (rule != null && clazz.isAssignableFrom(rule.getClass())) {
            //noinspection unchecked
            return (T) rule;
        }
        return null;
    }

    public static Collection<IGameRule> gameRuleDefaults() {
        return gameRuleDefaults.values();
    }
}
