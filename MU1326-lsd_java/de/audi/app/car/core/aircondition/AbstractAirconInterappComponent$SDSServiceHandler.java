/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.core.aircondition.AbstractAirconInterappComponent;
import de.audi.app.car.core.aircondition.AbstractAirconInterappComponent$1;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;

class AbstractAirconInterappComponent$SDSServiceHandler
implements CarServiceTrackerListener,
ISDSServiceStatusListener {
    private final /* synthetic */ AbstractAirconInterappComponent this$0;

    private AbstractAirconInterappComponent$SDSServiceHandler(AbstractAirconInterappComponent abstractAirconInterappComponent) {
        this.this$0 = abstractAirconInterappComponent;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent.SDSServiceHandler#serviceAvailable] service received");
        try {
            ((SDSService)object).registerStatusListener(this);
        }
        catch (ClassCastException classCastException) {
            this.this$0.getLogChannel().log(1000, "[AbstractAirconInterappComponent.SDSServiceHandler#serviceAvailable] sdsServiceTracker: cannot cast service");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void serviceRemoved() {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent.SDSServiceHandler#serviceRemoved] SDS Service has been removed");
        Object object = AbstractAirconInterappComponent.access$000(this.this$0);
        synchronized (object) {
            if (this.this$0.sdsActive) {
                this.notifySDSDialogEnded();
            }
        }
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractAirconInterappComponent.class$de$audi$atip$interapp$SDSService == null ? (AbstractAirconInterappComponent.class$de$audi$atip$interapp$SDSService = AbstractAirconInterappComponent.class$("de.audi.atip.interapp.SDSService")) : AbstractAirconInterappComponent.class$de$audi$atip$interapp$SDSService).getName()};
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifySDSDialogStarted() {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent.SDSServiceHandler#notifySDSDialogStarted] called");
        Object object = AbstractAirconInterappComponent.access$000(this.this$0);
        synchronized (object) {
            this.this$0.sdsActive = true;
            if (this.this$0.getDSI() == null) {
                return;
            }
            AbstractAirconInterappComponent.access$100(this.this$0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void notifySDSDialogEnded() {
        this.this$0.getLogChannel().log(1078071040, "[AbstractAirconInterappComponent.SDSServiceHandler#notifiySDSDialogEnded] called");
        Object object = AbstractAirconInterappComponent.access$000(this.this$0);
        synchronized (object) {
            this.this$0.sdsActive = false;
            if (this.this$0.getDSI() == null) {
                return;
            }
            AbstractAirconInterappComponent.access$100(this.this$0);
        }
    }

    @Override
    public void notifySDSDialogAborting() {
    }

    /* synthetic */ AbstractAirconInterappComponent$SDSServiceHandler(AbstractAirconInterappComponent abstractAirconInterappComponent, AbstractAirconInterappComponent$1 abstractAirconInterappComponent$1) {
        this(abstractAirconInterappComponent);
    }
}

