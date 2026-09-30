/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class LISPSelectListItemCommand
extends NavCommand {
    private final int itemIndex;
    private boolean poiValueListResponded;
    private boolean liResultResponded;

    public LISPSelectListItemCommand(int n) {
        this.itemIndex = n;
    }

    public void execute() {
        this.logger.log(1000000, "de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand#execute() - itemIndex: %1", (long)this.itemIndex);
        this.getDSINavigation().lispSelectListItem(this.itemIndex);
    }

    public void poiValueList(LIValueList lIValueList, long l) {
        this.logger.log(1000000, "de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand#poiValueList() - lispValueListCount: %1", l);
        this.dsiResponseContainer.setPOIValueList(lIValueList);
        this.dsiResponseContainer.setPOIValueListCount(l);
        this.poiValueListResponded = true;
        this.checkFinished();
    }

    public void liResult(long l) {
        this.logger.log(1000000, "de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand#liResult() - returnCode: %1", l);
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

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(10000, "de.audi.tghu.navi.app.addressinput.poi.commands.LISPSelectListItemCommand#liCurrentState() - liCurrentState was called but was not expected for DSI-call lispSelectListItem! Either you are using the wrong command or the southside is sending the wrong answer!");
    }
}

