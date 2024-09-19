package dev.rndmorris.advgamerules;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import dev.rndmorris.advgamerules.api.GameRulesApi;

public class CommandAdvGameRules extends CommandBase {

    @Override
    public String getCommandName() {
        return "advGameRules";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length < 1) {
            return;
        }
        final var world = sender.getEntityWorld();
        final var rules = GameRulesApi.getGameRules(world);
        final var hasRule = rules.ruleExists(args[0]);
        final var stringValue = rules.getStringValue(args[0]);
        sender.addChatMessage(
            new ChatComponentText("'" + args[0] + "' exists: " + hasRule + ". Value: '" + stringValue + "'."));
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args) {
        if (args.length == 1) {
            final var results = new ArrayList<String>(9);
            results.addAll(GameRulesManager.vanillaGameRules.keySet());
            results.addAll(GameRulesManager.gameRules.keySet());
            return CommandBase.getListOfStringsFromIterableMatchingLastWord(args, results);
        }
        return null;
    }
}
