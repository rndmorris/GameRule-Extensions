package dev.rndmorris.advgamerules.api;

import java.util.List;

public class DoubleGameRule implements IGameRule {

    private final String name;
    private final double value;

    public DoubleGameRule(String name, double value) {
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

    public double getValue() {
        return this.value;
    }
}
