package dev.rndmorris.advgamerules;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.World;

import dev.rndmorris.advgamerules.api.rules.BooleanGameRule;
import dev.rndmorris.advgamerules.api.rules.IGameRule;
import dev.rndmorris.advgamerules.interfaces.IGameRules;

public class GameRuleManager {

    private final static Map<String, IGameRule> gameRules = new HashMap<>();

    private final static Map<String, IGameRule> vanillaGameRules = new HashMap<>(9);

    static {
        final var vanillaRules = new IGameRule[] { new BooleanGameRule("doFireTick", true),
            new BooleanGameRule("mobGriefing", true), new BooleanGameRule("keepInventory", false),
            new BooleanGameRule("doMobSpawning", true), new BooleanGameRule("doMobLoot", true),
            new BooleanGameRule("doTileDrops", true), new BooleanGameRule("commandBlockOutput", true),
            new BooleanGameRule("naturalRegeneration", true), new BooleanGameRule("doDaylightCycle", true), };
        for (var rule : vanillaRules) {
            vanillaGameRules.put(rule.getName(), rule);
        }
    }

    public static boolean registerGameRule(IGameRule gameRule) {
        if (vanillaGameRules.containsKey(gameRule.getName())) {
            return false;
        }
        return gameRules.putIfAbsent(gameRule.getName(), gameRule) != null;
    }

    public static IGameRule getRuleDefinition(String name) {
        final var vanillaRule = vanillaGameRules.get(name);
        if (vanillaRule != null) {
            return vanillaRule;
        }
        return gameRules.get(name);
    }

    public static Map<String, IGameRule> ruleDefinitions() {
        return gameRules;
    }

    public static IGameRules gameRules(World world) {
        return (IGameRules) world.getGameRules();
    }
}
