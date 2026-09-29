/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;

public class LIGetLocationDescriptionTransformCommand
extends NavCommand {
    private NavLocation location2Transform;

    public LIGetLocationDescriptionTransformCommand(PosPosition posPosition) {
        this.location2Transform = Util.getLocationFromGeoPos(posPosition.getLongitude(), posPosition.getLatitude());
    }

    public LIGetLocationDescriptionTransformCommand(NavLocation navLocation) {
        this.location2Transform = navLocation;
    }

    public LIGetLocationDescriptionTransformCommand(NavLocationWgs84 navLocationWgs84) {
        this.location2Transform = Util.wgs84ToNavLocation(navLocationWgs84);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "LIGetLocationDescriptionTransformCommand#execute() - calling liGetLocationDescriptionTransform( %1 ) ", (Object)LocationFormatter.formatLocationShort(this.location2Transform));
        this.getDSINavigation().liGetLocationDescriptionTransform(this.location2Transform);
    }

    @Override
    public void liGetLocationDescriptionTransformResult(NavLocation navLocation) {
        this.logger.log(-2137614336, "LIGetLocationDescriptionTransformCommand#liGetLocationDescriptionTransformResult() - new location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.dsiResponseContainer.setTransformedLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

