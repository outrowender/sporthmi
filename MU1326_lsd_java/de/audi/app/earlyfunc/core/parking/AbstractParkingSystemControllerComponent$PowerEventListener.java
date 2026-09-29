/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.power.IPowerEventListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.app.earlyfunc.core.parking.IParkingSystem;
import de.audi.app.earlyfunc.core.parking.pla.AbstractParkingSystemPLAComponent;
import org.dsi.ifc.carparkingsystem.DisplayContent;

class AbstractParkingSystemControllerComponent$PowerEventListener
implements IPowerEventListener {
    private DisplayContent displayContentForMMIOn;
    private boolean isInStandby;
    private boolean isQueuedUp = false;
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$PowerEventListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    private void handleDisplayState(boolean bl) {
        this.this$0.getLogChannel().log(-2137614336, "[AbstractParkingSystemControllerComponent.PowerEventListener#handleDisplayState] displayOn=%1", bl);
        if (!bl && AbstractParkingSystemControllerComponent.access$700(this.this$0)) {
            if (AbstractParkingSystemControllerComponent.access$800(this.this$0)) {
                IParkingSystem iParkingSystem = (IParkingSystem)this.this$0.getAvailableParkingSystems().get(16);
                if (iParkingSystem instanceof AbstractParkingSystemPLAComponent) {
                    ((AbstractParkingSystemPLAComponent)iParkingSystem).canceledByHMI();
                }
            } else {
                AbstractParkingSystemControllerComponent.access$900(this.this$0, 1);
            }
        }
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n) {
        switch (n) {
            case 2: 
            case 3: {
                this.isInStandby = true;
                break;
            }
            case 1: {
                this.handleDisplayState(false);
            }
            default: {
                this.isInStandby = false;
            }
        }
        if (!this.isInStandby && this.displayContentForMMIOn != null) {
            AbstractParkingSystemControllerComponent.access$1000(this.this$0, this.displayContentForMMIOn);
            this.displayContentForMMIOn = null;
        }
    }

    @Override
    public void notifyPowerListenerOnExitState(int n) {
        switch (n) {
            case 1: {
                this.handleDisplayState(true);
                break;
            }
        }
    }

    @Override
    public void notifyPowerTriggerAction(int n) {
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public boolean isInStandby() {
        return this.isInStandby;
    }

    public boolean isQueuedUp() {
        return this.isQueuedUp;
    }

    public void setDisplayContentForMMIOn(DisplayContent displayContent) {
        this.displayContentForMMIOn = displayContent;
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$PowerEventListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

