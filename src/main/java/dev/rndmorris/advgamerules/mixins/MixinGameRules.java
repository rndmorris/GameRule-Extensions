package dev.rndmorris.advgamerules.mixins;

import dev.rndmorris.advgamerules.GameRuleManager;
import net.minecraft.world.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Desc;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.annotation.Target;
import java.util.TreeMap;

@Mixin(GameRules.class)
public abstract class MixinGameRules
{
    @SuppressWarnings("rawtypes")
    @Shadow
    private TreeMap theGameRules;

    @Inject(target = @Desc(owner = GameRules.class, value = "<init>", ret = GameRules.class), at = @At(value = "TAIL"), remap = false)
    public void onInit(CallbackInfo ci) {
        for (var rule : GameRuleManager.gameRuleDefaults()) {
            addGameRule(rule.getName(), rule.getValueString());
        }
    }

    @Shadow
    public abstract void addGameRule(String name, String value);
}
