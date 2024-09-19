package dev.rndmorris.advgamerules;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.world.World;

import dev.rndmorris.advgamerules.api.IGameRule;
import dev.rndmorris.advgamerules.api.IGameRules;
import dev.rndmorris.advgamerules.api.rules.BooleanGameRule;
import dev.rndmorris.advgamerules.interfaces.IMixinGameRules;

public class GameRuleManager {

    public final static Map<String, IGameRule> gameRules = new HashMap<>();

    public final static Map<String, IGameRule> vanillaGameRules = new HashMap<>(9);

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

    public static IGameRules getGameRules(World world) {
        return new GameRulesWrapper((IMixinGameRules) world.getGameRules());
    }
}
