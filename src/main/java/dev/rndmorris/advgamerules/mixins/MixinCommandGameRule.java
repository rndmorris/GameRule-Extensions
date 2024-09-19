package dev.rndmorris.advgamerules.mixins;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandGameRule;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;

import dev.rndmorris.advgamerules.api.GameRulesApi;
import dev.rndmorris.advgamerules.api.IGameRules;

@Mixin(value = CommandGameRule.class, remap = false)
public abstract class MixinCommandGameRule extends CommandBase {

    /**
     * @author rndmorris
     * @reason No clean way to update tab completion for 2 arguments
     */
    @Overwrite
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        final var gameRules = advanced_gamerules$getGameRules();
        if (args.length == 1) {
            return getListOfStringsFromIterableMatchingLastWord(args, gameRules.getRuleNames());
        }
        if (args.length == 2) {
            final var gameruleName = args[0];
            final var gameRule = gameRules.getRuleDefinition(gameruleName);
            if (gameRule == null) {
                return null;
            }
            return getListOfStringsFromIterableMatchingLastWord(args, gameRule.tabCompletionValues(sender));
        }
        return null;
    }

    @Unique
    private IGameRules advanced_gamerules$getGameRules() {
        return GameRulesApi.getGameRules(
            MinecraftServer.getServer()
                .worldServerForDimension(0));
    }
}
