/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class GetLastStreetHistoryEntryCommand
extends NavCommand {
    private LIStreetHistoryEntry lastStreet;

    public GetLastStreetHistoryEntryCommand(LIStreetHistoryEntry lIStreetHistoryEntry) {
        this.lastStreet = lIStreetHistoryEntry;
    }

    @Override
    public void execute() {
        this.getDSINavigation().liGetLastStreetHistoryEntry(this.lastStreet.getId());
    }

    @Override
    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logger.log(-2137614336, "%1#liGetLastStreetHistoryEntryResult(%2, %3)", (Object)this.CLASS_NAME, (Object)navLocation, (Object)Boolean.toString(bl));
        if (navLocation != null) {
            this.getCommandList().put("NavLocation from History", navLocation);
        }
        this.getCommandList().commandFinished();
    }
}

