/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class LISPDeleteAllCharactersCommand
extends NavCommand {
    private boolean liValueListResponded;
    private boolean lispUpdateSpellerResultResponded;
    private final boolean touchPadInputModeChanged;

    public LISPDeleteAllCharactersCommand() {
        this(false);
    }

    public LISPDeleteAllCharactersCommand(boolean bl) {
        this.touchPadInputModeChanged = bl;
    }

    public void execute() {
        if (this.dsiResponseContainer.isLispIsUndoAvailable() || this.touchPadInputModeChanged) {
            this.getDSINavigation().lispDeleteAllCharacters();
        } else {
            this.getCommandList().commandFinished();
        }
    }

    private void checkFinished() {
        if (this.liValueListResponded && this.lispUpdateSpellerResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
        if (l == 0L) {
            this.lispUpdateSpellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    public void liValueList(LIValueList lIValueList, long l) {
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }
}

