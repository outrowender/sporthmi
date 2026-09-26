/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.app.earlyfunc.core.parking.pla.PLAInterappCallbackHandler;
import de.audi.app.earlyfunc.core.parking.pla.PLAInterappCallbackHandler$1;

class PLAInterappCallbackHandler$ParkingSpotConstant {
    private final int hmiActiveSideValue;
    private final int hmiParkingSpotValue;
    private final int preSelectionDSIValue;
    private final int parkInDSIValue;
    private final int parkOutDSIValue;
    private final /* synthetic */ PLAInterappCallbackHandler this$0;

    private PLAInterappCallbackHandler$ParkingSpotConstant(PLAInterappCallbackHandler pLAInterappCallbackHandler, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = pLAInterappCallbackHandler;
        this.hmiActiveSideValue = n;
        this.hmiParkingSpotValue = n2;
        this.preSelectionDSIValue = n3;
        this.parkInDSIValue = n4;
        this.parkOutDSIValue = n5;
    }

    private int getHmiActiveSideValue() {
        return this.hmiActiveSideValue;
    }

    private int getHmiParkingSpotValue() {
        return this.hmiParkingSpotValue;
    }

    private int getPreSelectionDSIValue() {
        return this.preSelectionDSIValue;
    }

    private int getParkInDSIValue() {
        return this.parkInDSIValue;
    }

    private int getParkOutDSIValue() {
        return this.parkOutDSIValue;
    }

    /* synthetic */ PLAInterappCallbackHandler$ParkingSpotConstant(PLAInterappCallbackHandler pLAInterappCallbackHandler, int n, int n2, int n3, int n4, int n5, PLAInterappCallbackHandler$1 pLAInterappCallbackHandler$1) {
        this(pLAInterappCallbackHandler, n, n2, n3, n4, n5);
    }

    static /* synthetic */ int access$100(PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant) {
        return pLAInterappCallbackHandler$ParkingSpotConstant.getHmiActiveSideValue();
    }

    static /* synthetic */ int access$200(PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant) {
        return pLAInterappCallbackHandler$ParkingSpotConstant.getHmiParkingSpotValue();
    }

    static /* synthetic */ int access$300(PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant) {
        return pLAInterappCallbackHandler$ParkingSpotConstant.getPreSelectionDSIValue();
    }

    static /* synthetic */ int access$400(PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant) {
        return pLAInterappCallbackHandler$ParkingSpotConstant.getParkInDSIValue();
    }

    static /* synthetic */ int access$500(PLAInterappCallbackHandler$ParkingSpotConstant pLAInterappCallbackHandler$ParkingSpotConstant) {
        return pLAInterappCallbackHandler$ParkingSpotConstant.getParkOutDSIValue();
    }
}

