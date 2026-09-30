/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.addressinput.poi.commands.IPoiScreenUpdateSpeller;
import de.audi.tghu.navi.app.command.NavCommand;

public class NewModelUpdateSpellerCommand
extends NavCommand {
    private final IPoiScreenUpdateSpeller modelAccess;

    public NewModelUpdateSpellerCommand(IPoiScreenUpdateSpeller iPoiScreenUpdateSpeller) {
        this.modelAccess = iPoiScreenUpdateSpeller;
    }

    public void execute() {
        String string = this.dsiResponseContainer.getLispValidCharacters();
        String string2 = this.dsiResponseContainer.getLispCurrentInput();
        boolean bl = this.dsiResponseContainer.isLispIsFullMatch();
        boolean bl2 = this.dsiResponseContainer.isLispIsUndoAvailable();
        this.modelAccess.onUpdateSpeller(string, string2, bl, bl2);
        this.getCommandList().commandFinished();
    }
}

