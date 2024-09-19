package dev.rndmorris.gameruleexts.api.values;

import dev.rndmorris.gameruleexts.api.IRuleValue;

public class IntegerValue implements IRuleValue {

    private int value;

    public IntegerValue(int value) {
        this.value = value;
    }

    public IntegerValue(String value) {
        this(Integer.parseInt(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Integer.parseInt(value);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
