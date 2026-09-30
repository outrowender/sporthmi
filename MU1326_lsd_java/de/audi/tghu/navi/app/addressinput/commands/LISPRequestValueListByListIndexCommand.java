/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class LISPRequestValueListByListIndexCommand
extends NavCommand {
    private final int anchorIndex;
    private final boolean nextPage;
    private boolean liValueListResponded;
    private boolean lispUpdateSpellerResultResponded;

    public LISPRequestValueListByListIndexCommand(int n, boolean bl) {
        this.anchorIndex = n;
        this.nextPage = bl;
    }

    public void execute() {
        this.logger.log(10000000, "%1#execute() - anchorIndex = %2, nextPage = %3", (Object)this.CLASS_NAME, (Object)String.valueOf(this.anchorIndex), (Object)String.valueOf(this.nextPage));
        this.getDSINavigation().lispRequestValueListByListIndex(this.anchorIndex, this.nextPage);
        if (!this.dsiResponseContainer.isLiIsSpellerActive()) {
            this.logger.log(10000, "%1#execute() - speller is not active", (Object)this.CLASS_NAME);
        }
    }

    public void liValueList(LIValueList lIValueList, long l) {
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
        this.dsiResponseContainer.setLispUpdateSpellerResult(string, n, bl, bl2, string2, n2, n3, bl3, bl4, n4);
        if (l == 0L) {
            this.lispUpdateSpellerResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }
}

