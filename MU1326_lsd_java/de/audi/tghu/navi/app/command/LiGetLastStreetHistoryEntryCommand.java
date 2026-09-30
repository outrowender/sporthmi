/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.LIStreetHistoryEntry;

public class LiGetLastStreetHistoryEntryCommand
extends NavCommand {
    public static final String LOCATION = "STREET_HISTORY_ENTRY_LOCATION";
    private LIStreetHistoryEntry lastStreet;

    public LiGetLastStreetHistoryEntryCommand(LIStreetHistoryEntry lIStreetHistoryEntry) {
        this.lastStreet = lIStreetHistoryEntry;
    }

    public void execute() {
        this.logger.log(10000000, "LiGetLastStreetHistoryEntryCommand#execute() - calling liGetLastStreetHistoryEntry(%1) ", (Object)this.lastStreet);
        this.getDSINavigation().liGetLastStreetHistoryEntry(this.lastStreet.getId());
    }

    public void liGetLastStreetHistoryEntryResult(NavLocation navLocation, boolean bl) {
        this.logger.log(10000000, "LiGetLastStreetHistoryEntryCommand#liGetLastStreetHistoryEntryResult() - location: %1 ", (Object)navLocation);
        this.getCommandList().put(LOCATION, navLocation);
        this.getCommandList().commandFinished();
    }
}

