package dev.rndmorris.advgamerules.api.values;

import dev.rndmorris.advgamerules.api.IRuleValue;

public class ShortValue implements IRuleValue {

    private short value;

    public ShortValue(short value) {
        this.value = value;
    }

    public ShortValue(String value) {
        this(Short.parseShort(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Short.parseShort(value);
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }
}
