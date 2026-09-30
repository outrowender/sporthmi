/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public interface IPLAParkingSpotHandler {
    public void init();

    public void deinit();

    public void updateParkingSpots(PDCPLAStatus var1);

    public void updateSelectedParkingSpot(int var1);

    public boolean isActiveParkInSpotLeft();
}

