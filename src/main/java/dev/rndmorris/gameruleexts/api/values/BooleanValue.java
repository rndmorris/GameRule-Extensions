package dev.rndmorris.gameruleexts.api.values;

import dev.rndmorris.gameruleexts.api.IRuleValue;

public class BooleanValue implements IRuleValue {

    private boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    public BooleanValue(String value) {
        this(Boolean.parseBoolean(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Boolean.parseBoolean(value);
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
