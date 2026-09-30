/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class PoiSelectSelectionCriteriaCommand
extends NavCommand {
    private final int selectionCriteriaIndex;
    private boolean liValueListResponded;
    private boolean lispUpdateSpellerResponded;
    private boolean liResultResponded = false;

    public PoiSelectSelectionCriteriaCommand(int n) {
        this.selectionCriteriaIndex = n;
    }

    public void execute() {
        this.logger.log(1000000, "PoiSelectSelectionCriteria#execute() - selectionCriteriaIndex: %1", (long)this.selectionCriteriaIndex);
        this.getDSINavigation().poiSelectSelectionCriteria(this.selectionCriteriaIndex);
    }

    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(1000000, "PoiSelectSelectionCriteria#liValueList - lispValueListCount: %1 ", l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }

    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(1000000, "PoiSelectSelectionCriteria#lispUpdateSpellerResult");
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.lispUpdateSpellerResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    private void checkFinished() {
        if (this.liValueListResponded && this.lispUpdateSpellerResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    public void liResult(long l) {
        if (l == 0L) {
            this.liResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

