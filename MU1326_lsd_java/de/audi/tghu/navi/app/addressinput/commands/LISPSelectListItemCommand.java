/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIValueList;

public class LISPSelectListItemCommand
extends NavCommand {
    private final int itemIndex;
    private boolean liCurrentStateResponded;
    private boolean liResultResponded;

    public LISPSelectListItemCommand(int n) {
        this.itemIndex = n;
    }

    public void execute() {
        this.logger.log(10000000, "LISPSelectListItemCommand#execute() - itemIndex = %1", (long)this.itemIndex);
        this.getDSINavigation().lispSelectListItem(this.itemIndex);
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(10000000, "LISPSelectListItemCommand#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2; usefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
        this.liCurrentStateResponded = true;
        this.checkFinished();
    }

    private void checkFinished() {
        if (this.liCurrentStateResponded && this.liResultResponded) {
            this.getCommandList().commandFinished();
        }
    }

    public void poiValueList(LIValueList lIValueList, long l) {
        this.logger.log(10000, "%1#poiValueList was called but was not expected for DSI-call lispSelectListItem! Either you are using the wrong command or the southside is sending the wrong answer!", (Object)this.CLASS_NAME);
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

