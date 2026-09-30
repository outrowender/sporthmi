/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.ParkingPopupIdentifier;
import org.dsi.ifc.carparkingsystem.DisplayContent;

public interface IParkingSystem {
    public static final int PARKING_SYSTEM_APS = 1;
    public static final int PARKING_SYSTEM_OPS = 2;
    public static final int PARKING_SYSTEM_VPS = 4;
    public static final int PARKING_SYSTEM_ARA = 8;
    public static final int PARKING_SYSTEM_PLA = 16;
    public static final int PARKING_SYSTEM_SETTINGS = 32;

    public void setActive(boolean var1, DisplayContent var2);

    public int[] getSupportedDSIPopupIDs();

    public int getParkingSystemID();

    public ParkingPopupIdentifier getHMIPopupID(int var1);

    public int getHMIPopupPrio(int var1);

    public String getName();

    public IParkingFocusPropertyConfig createFocusPropertyDecorator(IParkingFocusPropertyConfig var1);
}

