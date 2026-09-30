/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.sds;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import org.dsi.ifc.global.NavLocation;

public class LIStripLocationCommand
extends NavCommand {
    public static final String STRIPPED_LOCATION = "STRIPPED_LOCATION";
    private NavLocation location;
    private int type;

    public LIStripLocationCommand(NavLocation navLocation, int n) {
        this.location = navLocation;
        this.type = n;
    }

    public void execute() {
        this.logger.log(10000000, "LIStripLocationCommand#execute() - calling liStripLocation( %1, %2 )", (Object)LocationFormatter.formatLocationShort(this.location), (long)this.type);
        this.getDSINavigation().liStripLocation(this.location, this.type);
    }

    public void liStripLocationResult(NavLocation navLocation) {
        this.logger.log(10000000, "LIStripLocationCommand#liStripLocationResult( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.getCommandList().put(STRIPPED_LOCATION, navLocation);
        this.getCommandList().commandFinished();
    }
}

