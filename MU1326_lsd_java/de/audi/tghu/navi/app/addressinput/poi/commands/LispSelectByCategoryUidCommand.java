/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.navigation.LIValueList;

public class LispSelectByCategoryUidCommand
extends NavCommand {
    private final int categoryUid;
    private boolean poiValueListResponded;
    private boolean liResultResponded;

    public LispSelectByCategoryUidCommand(int n) {
        this.categoryUid = n;
    }

    public void execute() {
        this.logger.log(1000000, "LispSelectByCategoryUidCommand#liResult() - categoryUidcategoryUid: %1", (long)this.categoryUid);
        this.getDSINavigation().lispSelectByCategoryUid(this.categoryUid);
    }

    public void poiValueList(LIValueList lIValueList, long l) {
        this.logger.log(1000000, "LispSelectByCategoryUidCommand#poiValueList() - lispValueListCount: %1", l);
        this.dsiResponseContainer.setPOIValueList(lIValueList);
        this.dsiResponseContainer.setPOIValueListCount(l);
        this.poiValueListResponded = true;
        this.checkFinished();
    }

    public void liResult(long l) {
        this.logger.log(1000000, "LispSelectByCategoryUidCommand#liResult() - returnCode: %1", l);
        if (l == 0L) {
            this.liResultResponded = true;
            this.checkFinished();
        } else {
            this.getCommandList().commandAborted(l);
        }
    }

    private void checkFinished() {
        if (this.poiValueListResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }
}

