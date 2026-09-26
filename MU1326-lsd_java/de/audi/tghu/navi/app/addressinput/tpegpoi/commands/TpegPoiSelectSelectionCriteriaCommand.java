/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.tpegpoi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class TpegPoiSelectSelectionCriteriaCommand
extends NavCommand {
    private final int index;
    protected boolean liValueListResponded;
    protected boolean lispUpdateSpellerResponded;
    protected boolean liResultResponded;

    public TpegPoiSelectSelectionCriteriaCommand(int n) {
        this.index = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "%1#execute() - selectionCriteriaIndex: %2", (Object)this.CLASS_NAME, (long)this.index);
        this.getDSINavigation().poiSelectSelectionCriteria(this.index);
    }

    @Override
    public void liValueList(LIValueList lIValueList, long l) {
        this.logger.log(1078071040, "%1#liValueList - lispValueListCount: %2", (Object)this.CLASS_NAME, l);
        this.dsiResponseContainer.setLiValueList(lIValueList, l);
        this.liValueListResponded = true;
        this.checkFinished();
    }

    @Override
    public void lispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4, long l) {
        this.logger.log(1078071040, "%1#lispUpdateSpellerResult - resultCode: %2", (Object)this.CLASS_NAME, l);
        if (l == 0L) {
            this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
            this.lispUpdateSpellerResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    @Override
    public void liResult(long l) {
        this.logger.log(-2137614336, "%1#liResult( %2 )", (Object)this.CLASS_NAME, l);
        if (l == 0L) {
            this.liResultResponded = true;
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
}

