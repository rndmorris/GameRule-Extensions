package dev.rndmorris.advgamerules.api;

public interface IGameRules {

    boolean ruleExists(String ruleName);

    String getStringValue(String ruleName);
}
