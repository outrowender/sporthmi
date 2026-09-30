/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStateHistoryEntry;

public class GetLastStateHistoryEntryCommand
extends NavCommand {
    private LIStateHistoryEntry lastState;

    public GetLastStateHistoryEntryCommand(LIStateHistoryEntry lIStateHistoryEntry) {
        this.lastState = lIStateHistoryEntry;
    }

    public void execute() {
        this.getDSINavigation().liGetLastStateHistoryEntry(this.lastState.getId());
    }

    public void liGetLastStateHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logger.log(10000000, "GetLastStateHistoryEntryCommand#liGetLastStateHistoryEntryResult(%1, %2)", (Object)navLocation, (Object)Boolean.toString(bl));
        if (navLocation != null) {
            this.getCommandList().put("NavLocation from History", navLocation);
        }
        this.getCommandList().commandFinished();
    }
}

