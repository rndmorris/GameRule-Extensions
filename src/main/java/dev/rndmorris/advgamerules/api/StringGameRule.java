package dev.rndmorris.advgamerules.api;

import java.util.List;

public class StringGameRule implements IGameRule {

    private final String name;
    private final String value;

    public StringGameRule(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValueString() {
        return value;
    }

    @Override
    public List<String> tabCompletionOptions() {
        return null;
    }

    public String getValue() {
        return this.value;
    }
}
