/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.navigation.LIValueList;

public class LISPAddStrokeCommand
extends NavCommand {
    private final String lastStroke;
    private boolean lispUpdateSpellerResultResponded;
    private boolean liValueListResponded;
    private boolean liResultResponded;

    public LISPAddStrokeCommand(String string) {
        this.lastStroke = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LISPAddStrokeCommand#execute() with lastStroke=%1", (Object)this.lastStroke);
        this.getDSINavigation().lispAddStroke(this.lastStroke);
    }

    private void checkFinished() {
        if (this.lispUpdateSpellerResultResponded && this.liValueListResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(-2137614336, "LISPAddStrokeCommand#lispUpdateSpellerResult with lispCurrentInput = %1, lispCurrentSelectionCriterion = %2, lispValidCharacters = %3", (Object)string, (Object)Integer.toString(n), (Object)string2);
        this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
        if (l == 0L) {
            this.lispUpdateSpellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(new StringBuffer().append("LISPAddStrokeCommand#lispUpdateSpellerResult - resultCode=").append(l).toString());
        }
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(-2137614336, "LISPAddStrokeCommand#liValueList - lispValueList=%1", (Object)lIValueList);
        if (Util.isListValid(lIValueList)) {
            this.liValueListResponded = true;
            this.dsiResponseContainer.setLiValueList(lIValueList, l);
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted("LISPAddStrokeCommand#liValueList - liValueList is not valid.");
        }
    }

    @Override
    public void liResult(long l) {
        this.logger.log(-2137614336, "LISPAddStrokeCommand#liResult - returnCode=%1", l);
        if (l == 0L) {
            this.liResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(new StringBuffer().append("LISPAddStrokeCommand#liResult - returnCode=").append(l).toString());
        }
    }
}

