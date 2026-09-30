/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class LISPAddCharacterCommand
extends NavCommand {
    private final String inputChar;
    private boolean liValueListResponded;
    private boolean lispUpdateSpellerResultResponded;

    public LISPAddCharacterCommand(String string) {
        this.inputChar = string;
    }

    public void execute() {
        this.logger.log(10000000, "LISPAddCharacterCommand#execute inputChar = %1", (Object)this.inputChar);
        this.getDSINavigation().lispAddCharacter(this.inputChar);
    }

    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(10000000, "LISPAddCharacterCommand#liValueList(%1, %2)", (Object)lIValueList, l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        if (this.liValueListResponded && this.lispUpdateSpellerResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(10000000, "LISPAddCharacterCommand#lispUpdateSpellerResult with lispCurrentInput = %1, lispCurrentSelectionCriterion = %2, lispValidCharacters = %3", (Object)string, (Object)Integer.toString(n), (Object)string2);
        this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
        if (l == 0L) {
            this.lispUpdateSpellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

