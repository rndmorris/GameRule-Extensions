package dev.rndmorris.advgamerules.interfaces;

import java.util.TreeMap;

import dev.rndmorris.advgamerules.api.IRuleValue;

public interface IMixinGameRules {

    TreeMap<String, IRuleValue> getTheGameRules();
}
