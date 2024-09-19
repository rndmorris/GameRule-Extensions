package dev.rndmorris.advgamerules.api;

import java.util.Arrays;
import java.util.List;

public class BooleanGameRule implements IGameRule {

    private final String name;
    private final boolean value;

    public BooleanGameRule(String name, boolean value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValueString() {
        return String.valueOf(this.value);
    }

    @Override
    public List<String> tabCompletionOptions() {
        return Arrays.asList("false", "true");
    }

    public boolean getValue() {
        return this.value;
    }
}
