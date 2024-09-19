package dev.rndmorris.gameruleexts.api.values;

import dev.rndmorris.gameruleexts.api.IRuleValue;

public class FloatValue implements IRuleValue {

    private float value;

    public FloatValue(float value) {
        this.value = value;
    }

    public FloatValue(String value) {
        this(Float.parseFloat(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Float.parseFloat(value);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
