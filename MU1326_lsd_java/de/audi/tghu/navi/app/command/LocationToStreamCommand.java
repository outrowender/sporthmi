/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class LocationToStreamCommand
extends NavCommand {
    public static final String LOCATION_STREAM = "LOCATION_STREAM";
    private NavLocation location;

    public LocationToStreamCommand(NavLocation navLocation) {
        this.location = navLocation;
    }

    public void execute() {
        if (this.location != null) {
            this.logger.log(10000000, "LocationToStreamCommand#execute() - calling locationToStream( %1 )", (Object)LocationFormatter.formatLocationShort(this.location));
            this.getDSINavigation().locationToStream(this.location);
        } else {
            this.getCommandList().commandAborted("location is null");
        }
    }

    public void locationToStreamResult(boolean bl, byte[] byArray) {
        this.logger.log(10000000, "LocationToStreamCommand#locationToStreamResult( %1 )", bl);
        if (bl) {
            this.getCommandList().put(LOCATION_STREAM, byArray);
        }
        this.getCommandList().commandFinished();
    }
}

