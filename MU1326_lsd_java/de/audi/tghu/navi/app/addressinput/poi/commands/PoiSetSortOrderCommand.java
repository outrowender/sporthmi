/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;

public class PoiSetSortOrderCommand
extends NavCommand {
    private final int sortOrder;

    public PoiSetSortOrderCommand(int n) {
        this.sortOrder = n;
    }

    public void execute() {
        this.logger.log(1000000, "POISetSortOrderCommand#execute() - calling poiSetSortOrder( %1 ) ", (long)this.sortOrder);
        this.getDSINavigation().poiSetSortOrder2(this.sortOrder);
        this.getCommandList().commandFinished();
    }
}

