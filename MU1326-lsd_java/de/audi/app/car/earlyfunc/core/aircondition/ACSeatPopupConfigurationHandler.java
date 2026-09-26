/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.caraircondition.AirconMasterConfiguration;
import org.dsi.ifc.caraircondition.AirconMasterViewOptions;

public class ACSeatPopupConfigurationHandler {
    private final LogChannel logChannel;
    private volatile AirconMasterViewOptions viewOptions;
    private boolean driversideLeft = true;
    public static final int ZONE_FRONT_LEFT;
    public static final int ZONE_FRONT_RIGHT;

    public ACSeatPopupConfigurationHandler(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    public void updateConfiguration(AirconMasterViewOptions airconMasterViewOptions) {
        this.viewOptions = airconMasterViewOptions;
        if (airconMasterViewOptions != null) {
            this.applyAirconConfig(airconMasterViewOptions.getConfiguration());
        }
    }

    public boolean isDriverSideLeft() {
        return this.driversideLeft;
    }

    public int getResponsibleDSIZoneID(int n) {
        if (this.isDriverSideLeft()) {
            return n;
        }
        return n == 1 ? 2 : 1;
    }

    private void applyAirconConfig(AirconMasterConfiguration airconMasterConfiguration) {
        if (airconMasterConfiguration != null) {
            this.setDriversideLeft(!airconMasterConfiguration.isCarDriverSide());
        }
    }

    private void setDriversideLeft(boolean bl) {
        this.driversideLeft = bl;
    }
}

