/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.commands;

import de.audi.atip.hmi.modelaccess.MatchspellerModelApp;
import de.audi.tghu.navi.app.command.NavCommand;

public class SetSpellerValidHanziCharsCommand
extends NavCommand {
    private final MatchspellerModelApp matchspellerModelApp;

    public SetSpellerValidHanziCharsCommand(MatchspellerModelApp matchspellerModelApp) {
        this.matchspellerModelApp = matchspellerModelApp;
    }

    public void execute() {
        String string = this.dsiResponseContainer.getLispNextValidCharacters();
        int n = this.dsiResponseContainer.getLispNextValidCharactersCount();
        this.logger.log(10000000, "SetSpellerValidHanziCharsCommand#execute() setValidHanziChars() with hanzichars = %1, amount = %2", (Object)string, (long)n);
        this.matchspellerModelApp.setValidHanziChars(string, n);
        this.getCommandList().commandFinished();
    }
}

