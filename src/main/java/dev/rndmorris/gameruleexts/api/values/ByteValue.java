package dev.rndmorris.gameruleexts.api.values;

import dev.rndmorris.gameruleexts.api.IRuleValue;

public class ByteValue implements IRuleValue {

    private byte value;

    public ByteValue(byte value) {
        this.value = value;
    }

    public ByteValue(String value) {
        this(Byte.parseByte(value));
    }

    @Override
    public String getValueString() {
        return String.valueOf(value);
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Byte.parseByte(value);
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
