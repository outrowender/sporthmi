/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractParkingSystemControllerComponent$VPSShowButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$VPSShowButtonListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.parkingSoftkeyPressed();
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$VPSShowButtonListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

