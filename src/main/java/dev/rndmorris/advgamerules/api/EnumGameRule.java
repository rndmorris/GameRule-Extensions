package dev.rndmorris.advgamerules.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnumGameRule<E extends Enum<E>> implements IGameRule {

    private final String name;
    private final Class<E> enumClass;
    private final E value;

    public EnumGameRule(String name, Class<E> enumClass, E value) {
        this.name = name;
        this.enumClass = enumClass;
        this.value = value;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getValueString() {
        return value.toString();
    }

    @Override
    public List<String> tabCompletionOptions() {
        return Arrays.stream(enumClass.getEnumConstants())
            .map(Enum::toString)
            .collect(Collectors.toList());
    }

    public E getValue() {
        return this.value;
    }
}
