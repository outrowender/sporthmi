/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.commands;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class PoiSetContextCommand
extends NavCommand {
    protected final NavLocation location;

    public PoiSetContextCommand(NavLocation navLocation) {
        this.location = navLocation;
    }

    public void execute() {
        this.logger.log(10000000, "PoiSetContextCommand#execute() - poiSetContext( %1 ) ", (Object)LocationFormatter.formatLocationShort(this.location));
        if (this.location == null) {
            this.logger.log(10000, "PoiSetContextCommand#execute() - location is null ");
            this.getCommandList().commandAborted("Location is null.");
        } else {
            this.getDSINavigation().poiSetContext(this.location);
            this.getCommandList().commandFinished();
        }
    }
}

