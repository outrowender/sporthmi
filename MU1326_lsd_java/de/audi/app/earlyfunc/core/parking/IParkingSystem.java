/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public interface IParkingSystem {
    public static final int PARKING_SYSTEM_APS;
    public static final int PARKING_SYSTEM_OPS;
    public static final int PARKING_SYSTEM_VPS;
    public static final int PARKING_SYSTEM_ARA;
    public static final int PARKING_SYSTEM_PLA;
    public static final int PARKING_SYSTEM_SETTINGS;

    default public void setActive(boolean bl, DisplayContent displayContent) {
    }

    default public int[] getSupportedDSIPopupIDs() {
    }

    default public int getParkingSystemID() {
    }

    default public ParkingPopupIdentifier getHMIPopupID(int n) {
    }

    default public int getHMIPopupPrio(int n) {
    }

    default public String getName() {
    }

    default public IParkingFocusPropertyConfig createFocusPropertyDecorator(IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
    }
}

