/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.vps;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.parking.vps.AbstractParkingSystemVPSComponent;
import de.audi.app.earlyfunc.core.parking.vps.AbstractParkingSystemVPSComponent$1;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;

class AbstractParkingSystemVPSComponent$DisplayManagerServiceTrackerListener
implements CarServiceTrackerListener {
    private final /* synthetic */ AbstractParkingSystemVPSComponent this$0;

    private AbstractParkingSystemVPSComponent$DisplayManagerServiceTrackerListener(AbstractParkingSystemVPSComponent abstractParkingSystemVPSComponent) {
        this.this$0 = abstractParkingSystemVPSComponent;
    }

    @Override
    public void serviceAvailable(Object object) {
        AbstractParkingSystemVPSComponent.access$002(this.this$0, (IDisplayManagerService)object);
    }

    @Override
    public void serviceRemoved() {
        AbstractParkingSystemVPSComponent.access$002(this.this$0, null);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractParkingSystemVPSComponent.class$de$audi$atip$interapp$displaymanager$IDisplayManagerService == null ? (AbstractParkingSystemVPSComponent.class$de$audi$atip$interapp$displaymanager$IDisplayManagerService = AbstractParkingSystemVPSComponent.class$("de.audi.atip.interapp.displaymanager.IDisplayManagerService")) : AbstractParkingSystemVPSComponent.class$de$audi$atip$interapp$displaymanager$IDisplayManagerService).getName()};
    }

    /* synthetic */ AbstractParkingSystemVPSComponent$DisplayManagerServiceTrackerListener(AbstractParkingSystemVPSComponent abstractParkingSystemVPSComponent, AbstractParkingSystemVPSComponent$1 abstractParkingSystemVPSComponent$1) {
        this(abstractParkingSystemVPSComponent);
    }
}

