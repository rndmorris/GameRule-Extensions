package dev.rndmorris.advgamerules.api.values;

import dev.rndmorris.advgamerules.api.IRuleValue;

public class StringValue implements IRuleValue {

    private String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public String getValueString() {
        return value;
    }

    @Override
    public void setFromValueString(String value) {
        this.value = value;
    }
}
