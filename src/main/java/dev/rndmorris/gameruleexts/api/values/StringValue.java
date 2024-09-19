package dev.rndmorris.gameruleexts.api.values;

import dev.rndmorris.gameruleexts.api.IRuleValue;

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
