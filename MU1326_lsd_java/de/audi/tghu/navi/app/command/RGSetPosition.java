/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class RGSetPosition
extends NavCommand {
    private NavLocation location = null;

    public RGSetPosition(NavLocation navLocation) {
        this.location = navLocation;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "RGSetPosition#execute() - calling rgSetPosition( %1 ) ", (Object)LocationFormatter.formatLocationShort(this.location));
        this.getDSINavigation().rgSetPosition(this.location);
        this.getCommandList().commandFinished();
    }
}

