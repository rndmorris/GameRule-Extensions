package dev.rndmorris.gameruleexts.interfaces;

import java.util.TreeMap;

import dev.rndmorris.gameruleexts.api.IRuleValue;

public interface IMixinGameRules {

    TreeMap<String, IRuleValue> getTheGameRules();
}
