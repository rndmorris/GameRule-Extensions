package dev.rndmorris.advgamerules.mixins;

import java.util.TreeMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.GameRules;

import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Interface;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.rndmorris.advgamerules.GameRuleManager;
import dev.rndmorris.advgamerules.api.values.BooleanValue;
import dev.rndmorris.advgamerules.api.values.IRuleValue;
import dev.rndmorris.advgamerules.interfaces.IGameRules;

@Mixin(GameRules.class)
@Implements(value = @Interface(iface = IGameRules.class, prefix = "advgamerules$"))
public abstract class MixinGameRules {

    @Shadow
    private TreeMap<String, IRuleValue> theGameRules;

    @Inject(method = "<init>*", at = @At(value = "RETURN"), remap = false)
    public void onInit(CallbackInfo ci) {
        final var newRules = GameRuleManager.ruleDefinitions();
        for (var rule : newRules.values()) {
            final var name = rule.getName();
            theGameRules.put(name, rule.getDefaultValue());
        }
    }

    /**
     * @author rndmorris
     * @reason Dramatic internal changes
     */
    @Overwrite
    public void addGameRule(String name, String value) {
        theGameRules.put(name, new BooleanValue(value));
    }

    /**
     * @author rndmorris
     * @reason Dramatic internal changes
     */
    @Overwrite
    public void setOrCreateGameRule(String name, String value) {
        final var oldValue = theGameRules.get(name);
        if (oldValue == null) {
            addGameRule(name, value);
            return;
        }
        oldValue.setFromValueString(value);
    }

    /**
     * @author rndmorris
     * @reason Dramatic internal changes
     */
    @Overwrite
    public String getGameRuleStringValue(String name) {
        final var value = this.theGameRules.get(name);
        return value != null ? value.getValueString() : "";
    }

    /**
     * @author rndmorris
     * @reason Dramatic internal changes
     */
    @Overwrite
    public boolean getGameRuleBooleanValue(String name) {
        final var value = this.theGameRules.get(name);
        return value instanceof BooleanValue bool && bool.getValue();
    }

    /**
     * @author rndmorris
     * @reason Dramatic internal changes
     */
    @Overwrite
    public void readGameRulesFromNBT(NBTTagCompound tag) {
        var set = tag.func_150296_c();

        for (var name : set) {
            final var definition = GameRuleManager.getRuleDefinition(name);
            if (definition == null) {
                continue;
            }
            final var value = definition.readValueFromNBT(tag);
            theGameRules.put(name, value);
        }
    }

    /**
     * @author rndmorris
     * @reason Dramatic internal changes
     */
    @Overwrite
    public NBTTagCompound writeGameRulesToNBT() {
        final var tag = new NBTTagCompound();

        for (var entry : theGameRules.entrySet()) {
            final var definition = GameRuleManager.getRuleDefinition(entry.getKey());
            if (definition == null) {
                continue;
            }
            definition.writeValueToNBT(tag, entry.getValue());
        }

        return tag;
    }
}
