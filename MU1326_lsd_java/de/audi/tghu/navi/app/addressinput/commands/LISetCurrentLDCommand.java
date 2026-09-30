/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;

public class LISetCurrentLDCommand
extends NavCommand {
    private final NavLocation location;

    public LISetCurrentLDCommand(NavLocation navLocation) {
        this.location = navLocation;
    }

    public void execute() {
        this.logger.log(10000000, "LISetCurrentLDCommand#execute() - calling liSetCurrentLD( %1 ) ", (Object)LocationFormatter.formatLocationShort(this.location));
        this.getDSINavigation().liSetCurrentLD(this.location);
    }

    public void liCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2, long l) {
        this.logger.log(10000000, "LISetCurrentLDCommand#liCurrentState - liCurrentLD=%1; availableSelectionCriteria=%2, usefulRefinementCriteria=%3)", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        if (l != 0L) {
            this.getCommandList().commandAborted(l);
            return;
        }
        this.dsiResponseContainer.setLiCurrentState(navLocation, nArray, nArray2);
        this.getCommandList().commandFinished();
    }
}

