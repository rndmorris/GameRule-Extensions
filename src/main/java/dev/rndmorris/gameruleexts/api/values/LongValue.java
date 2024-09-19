package dev.rndmorris.gameruleexts.api.values;

import dev.rndmorris.gameruleexts.api.IRuleValue;

public class LongValue implements IRuleValue {

    private long value;

    public LongValue(long value) {
        this.value = value;
    }

    public LongValue(String value) {
        this(Long.parseLong(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Long.parseLong(value);
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
