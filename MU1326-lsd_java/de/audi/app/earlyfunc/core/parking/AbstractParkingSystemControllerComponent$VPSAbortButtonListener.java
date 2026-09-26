/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.app.earlyfunc.core.parking.IParkingSystem;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import de.audi.atip.hmi.model.DefaultButtonListener;
import org.dsi.ifc.carparkingsystem.PDCPLASystemState;

class AbstractParkingSystemControllerComponent$VPSAbortButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$VPSAbortButtonListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.this$0.getLogChannel().log(-2137614336, "keyPressed for modelID=%1", (long)n);
        if (n == 1611407360) {
            this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent.VPSAbortButtonListener#keyPressed] cancel popup, call DSI.setPDCPLASystemState");
            if (AbstractParkingSystemControllerComponent.access$800(this.this$0)) {
                IParkingSystem iParkingSystem = (IParkingSystem)this.this$0.getAvailableParkingSystems().get(16);
                if (iParkingSystem instanceof AbstractParkingSystemPLAComponent) {
                    ((AbstractParkingSystemPLAComponent)iParkingSystem).canceledByHMI();
                }
            } else {
                this.this$0.getDSI().setPDCPLASystemState(new PDCPLASystemState(false, false));
            }
        }
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$VPSAbortButtonListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

