package dev.rndmorris.advgamerules;

import java.util.Collection;

import dev.rndmorris.advgamerules.api.IGameRules;
import dev.rndmorris.advgamerules.api.IRuleValue;
import dev.rndmorris.advgamerules.api.values.BooleanValue;
import dev.rndmorris.advgamerules.api.values.ByteValue;
import dev.rndmorris.advgamerules.api.values.DoubleValue;
import dev.rndmorris.advgamerules.api.values.FloatValue;
import dev.rndmorris.advgamerules.api.values.IntegerValue;
import dev.rndmorris.advgamerules.api.values.LongValue;
import dev.rndmorris.advgamerules.api.values.ShortValue;
import dev.rndmorris.advgamerules.interfaces.IMixinGameRules;

public class GameRulesWrapper implements IGameRules {

    private final IMixinGameRules rules;

    public GameRulesWrapper(IMixinGameRules rules) {
        this.rules = rules;
    }

    private void setRule(String ruleName, IRuleValue value) {
        rules.getTheGameRules()
            .put(ruleName, value);
    }

    private IRuleValue getRule(String ruleName) {
        return rules.getTheGameRules()
            .get(ruleName);
    }

    private <I extends IRuleValue> I getRuleValueOrDefault(String ruleName, Class<I> valueClass) {
        final var ruleValue = getRule(ruleName);
        if (ruleValue != null && valueClass.isAssignableFrom(ruleValue.getClass())) {
            // noinspection unchecked
            return (I) ruleValue;
        }
        final var definition = GameRulesManager.gameRules.get(ruleName);
        if (definition == null) {
            throw new IllegalArgumentException(
                String.format("Game rule %s does not exist and was not registered.", ruleName));
        }
        final var defaultValue = definition.getDefaultValue();
        if (defaultValue != null && valueClass.isAssignableFrom(defaultValue.getClass())) {
            // noinspection unchecked
            return (I) ruleValue;
        }
        final var found = defaultValue != null ? defaultValue.getClass()
            .getSimpleName() : "null";
        throw new IllegalArgumentException(
            String.format(
                "Expected %s for Game Rule '%s', found %s instead.",
                valueClass.getSimpleName(),
                ruleName,
                found));
    }

    @Override
    public boolean ruleExists(String ruleName) {
        return rules.getTheGameRules()
            .containsKey(ruleName);
    }

    @Override
    public Collection<String> getRuleNames() {
        return rules.getTheGameRules()
            .keySet();
    }

    @Override
    public boolean getBoolean(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, BooleanValue.class);
        return value != null && value.getValue();
    }

    @Override
    public byte getByte(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, ByteValue.class);
        return value != null ? value.getValue() : 0;
    }

    @Override
    public double getDouble(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, DoubleValue.class);
        return value != null ? value.getValue() : 0;
    }

    @Override
    public float getFloat(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, FloatValue.class);
        return value != null ? value.getValue() : 0;
    }

    @Override
    public int getInteger(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, IntegerValue.class);
        return value != null ? value.getValue() : 0;
    }

    @Override
    public long getLong(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, LongValue.class);
        return value != null ? value.getValue() : 0;
    }

    @Override
    public short getShort(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, ShortValue.class);
        return value != null ? value.getValue() : 0;
    }

    @Override
    public String getStringValue(String ruleName) {
        final var value = getRuleValueOrDefault(ruleName, IRuleValue.class);
        return value != null ? value.getValueString() : "";
    }

    @Override
    public void setBoolean(String ruleName, boolean value) {
        final var val = getRuleValueOrDefault(ruleName, BooleanValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setByte(String ruleName, byte value) {
        final var val = getRuleValueOrDefault(ruleName, ByteValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setDouble(String ruleName, double value) {
        final var val = getRuleValueOrDefault(ruleName, DoubleValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setFloat(String ruleName, float value) {
        final var val = getRuleValueOrDefault(ruleName, FloatValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setInteger(String ruleName, int value) {
        final var val = getRuleValueOrDefault(ruleName, IntegerValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setLong(String ruleName, long value) {
        final var val = getRuleValueOrDefault(ruleName, LongValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setShort(String ruleName, short value) {
        final var val = getRuleValueOrDefault(ruleName, ShortValue.class);
        val.setValue(value);
        setRule(ruleName, val);
    }

    @Override
    public void setStringValue(String ruleName, String value) {
        final var val = getRuleValueOrDefault(ruleName, IRuleValue.class);
        val.setFromValueString(value);
        setRule(ruleName, val);
    }
}
