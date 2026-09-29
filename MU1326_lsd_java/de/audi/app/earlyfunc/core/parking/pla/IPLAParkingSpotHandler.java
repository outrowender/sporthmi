/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import org.dsi.ifc.carparkingsystem.PDCPLAStatus;

public interface IPLAParkingSpotHandler {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void updateParkingSpots(PDCPLAStatus pDCPLAStatus) {
    }

    default public void updateSelectedParkingSpot(int n) {
    }

    default public boolean isActiveParkInSpotLeft() {
    }
}

