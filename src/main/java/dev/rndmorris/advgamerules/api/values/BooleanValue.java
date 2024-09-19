package dev.rndmorris.advgamerules.api.values;

public class BooleanValue implements IRuleValue {

    private boolean value;

    public BooleanValue(boolean value) {
        this.value = value;
    }

    public BooleanValue(String value) {
        this.value = Boolean.parseBoolean(value);
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
