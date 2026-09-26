/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.atip.interapp.SDSService;

class AbstractParkingSystemControllerComponent$SDSServiceTrackerListener
implements CarServiceTrackerListener {
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$SDSServiceTrackerListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void serviceAvailable(Object object) {
        boolean bl;
        AbstractParkingSystemControllerComponent.access$002(this.this$0, (SDSService)object);
        Object object2 = AbstractParkingSystemControllerComponent.mutex;
        synchronized (object2) {
            bl = AbstractParkingSystemControllerComponent.access$100(this.this$0, this.this$0.currentDisplayContent);
        }
        if (bl) {
            AbstractParkingSystemControllerComponent.access$200(this.this$0, true);
        }
    }

    @Override
    public void serviceRemoved() {
        AbstractParkingSystemControllerComponent.access$002(this.this$0, null);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractParkingSystemControllerComponent.class$de$audi$atip$interapp$SDSService == null ? (AbstractParkingSystemControllerComponent.class$de$audi$atip$interapp$SDSService = AbstractParkingSystemControllerComponent.class$("de.audi.atip.interapp.SDSService")) : AbstractParkingSystemControllerComponent.class$de$audi$atip$interapp$SDSService).getName()};
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$SDSServiceTrackerListener(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

