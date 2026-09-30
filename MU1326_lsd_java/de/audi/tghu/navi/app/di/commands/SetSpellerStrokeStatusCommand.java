/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.commands;

import de.audi.tghu.navi.app.addressinput.IMatchspellerModelAccess;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiResultScreenWithMatchSpellerModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;

public class SetSpellerStrokeStatusCommand
extends NavCommand {
    private final IMatchspellerModelAccess modelAccess1;
    private final IPoiResultScreenWithMatchSpellerModelAccess modelAccess2;

    public SetSpellerStrokeStatusCommand(IMatchspellerModelAccess iMatchspellerModelAccess) {
        this.modelAccess1 = iMatchspellerModelAccess;
        this.modelAccess2 = null;
    }

    public SetSpellerStrokeStatusCommand(IPoiResultScreenWithMatchSpellerModelAccess iPoiResultScreenWithMatchSpellerModelAccess) {
        this.modelAccess1 = null;
        this.modelAccess2 = iPoiResultScreenWithMatchSpellerModelAccess;
    }

    public void execute() {
        String string = this.dsiResponseContainer.getLispValidCharacters();
        String string2 = this.dsiResponseContainer.getLispCurrentInput();
        boolean bl = this.dsiResponseContainer.isLispIsFullMatch();
        boolean bl2 = this.dsiResponseContainer.isLispIsUndoAvailable();
        this.logger.log(10000000, "SetSpellerStrokeStatusCommand#onUpdateSpeller with validCharacters = %1, currentInput = %2, isFullMatch = %3, isDeleteAvailable = %4", (Object)string, (Object)string2, (Object)bl, (Object)bl2);
        if (this.modelAccess1 != null) {
            this.modelAccess1.onUpdateSpeller(string, string2, bl, bl2);
        } else if (this.modelAccess2 != null) {
            this.modelAccess2.onUpdateSpeller(string, string2, bl, bl2);
        } else {
            this.getCommandList().commandAborted("Model Access is null!");
        }
        this.getCommandList().commandFinished();
    }
}

