package dev.rndmorris.advgamerules.api.values;

import dev.rndmorris.advgamerules.api.IRuleValue;

public class DoubleValue implements IRuleValue {

    private double value;

    public DoubleValue(double value) {
        this.value = value;
    }

    public DoubleValue(String value) {
        this(Double.parseDouble(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
