/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.PoiFuelWarningService;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import org.dsi.ifc.global.NavLocation;

public class PoiFuelWarningLocationHandler
implements ILocationHandler {
    private final int petrolStationCategory;
    private final LogChannel logChannel;

    public PoiFuelWarningLocationHandler(LogChannel logChannel, int n) {
        this.logChannel = logChannel;
        this.petrolStationCategory = n;
    }

    @Override
    public NavLocation handleLocation(NavLocation navLocation) {
        this.logChannel.log(1078071040, "[PoiInput] FuelWarningLocationHandler#handleLocation() - set the flag for the category");
        PoiFuelWarningService.setPetrolStationFlagToLocation(this.logChannel, navLocation, this.petrolStationCategory);
        return navLocation;
    }
}

