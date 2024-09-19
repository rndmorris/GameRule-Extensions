package dev.rndmorris.advgamerules;

import dev.rndmorris.advgamerules.api.IGameRules;
import dev.rndmorris.advgamerules.interfaces.IMixinGameRules;

public class GameRulesWrapper implements IGameRules {

    private final IMixinGameRules rules;

    public GameRulesWrapper(IMixinGameRules rules) {
        this.rules = rules;
    }

    @Override
    public boolean ruleExists(String ruleName) {
        return rules.hasRule(ruleName);
    }

    public String getStringValue(String ruleName) {
        return rules.advanced_gamerules$getStringValue(ruleName);
    }
}
