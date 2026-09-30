/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class RefreshResolvedEntryCommand
extends NavCommand {
    private OnlinePOIResultList.ResultElement result;

    public RefreshResolvedEntryCommand(OnlinePOIResultList.ResultElement resultElement) {
        this.result = resultElement;
    }

    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        if (Util.isEmpty(navLocation.getStreet())) {
            Util.setGeoPosFlagOnLocation(navLocation, true);
        }
        Util.setOnlinePOINameOnLocation(navLocation, this.result.element.name);
        if (!Util.isEmpty(this.result.element.phone)) {
            Util.setPhoneNumberOnLocation(navLocation, this.result.element.phone);
        }
        if (!Util.isEmpty(this.result.element.url)) {
            Util.setURLOnLocation(navLocation, this.result.element.url);
        }
        this.logger.log(10000000, "RefreshResolvedEntryCommand#execute() - resolvedLocation: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.result.setTransformedLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

