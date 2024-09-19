package dev.rndmorris.advgamerules.api.values;

import dev.rndmorris.advgamerules.api.IRuleValue;

public class EnumValue<E extends Enum<E>> implements IRuleValue {

    private E value;
    private final Class<E> enumClass;

    public EnumValue(E value, Class<E> enumClass) {
        this.value = value;
        this.enumClass = enumClass;
    }

    @Override
    public String getValueString() {
        return value.toString();
    }

    @Override
    public void setFromValueString(String value) {
        this.value = Enum.valueOf(enumClass, value);
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
