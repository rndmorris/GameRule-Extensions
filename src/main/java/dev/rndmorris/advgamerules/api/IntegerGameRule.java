package dev.rndmorris.advgamerules.api;

import java.util.List;

public class IntegerGameRule implements IGameRule {

    private final String name;
    private final int value;

    public IntegerGameRule(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public List<String> tabCompletionOptions() {
        return null;
    }

    public int getValue() {
        return this.value;
    }
}
