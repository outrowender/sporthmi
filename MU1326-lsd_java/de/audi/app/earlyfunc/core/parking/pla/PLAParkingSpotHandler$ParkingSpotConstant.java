/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAParkingSpotHandler;

class PLAParkingSpotHandler$ParkingSpotConstant {
    private final int hmiSelectionValue;
    private final int preSelectionDSIValue;
    private final int parkInDSIValue;
    private final int parkOutDSIValue;
    private final /* synthetic */ PLAParkingSpotHandler this$0;

    PLAParkingSpotHandler$ParkingSpotConstant(PLAParkingSpotHandler pLAParkingSpotHandler, int n, int n2, int n3, int n4) {
        this.this$0 = pLAParkingSpotHandler;
        this.hmiSelectionValue = n;
        this.preSelectionDSIValue = n2;
        this.parkInDSIValue = n3;
        this.parkOutDSIValue = n4;
    }

    int getHmiSelectionValue() {
        return this.hmiSelectionValue;
    }

    int getPreSelectionDSIValue() {
        return this.preSelectionDSIValue;
    }

    int getParkInDSIValue() {
        return this.parkInDSIValue;
    }

    int getParkOutDSIValue() {
        return this.parkOutDSIValue;
    }
}

