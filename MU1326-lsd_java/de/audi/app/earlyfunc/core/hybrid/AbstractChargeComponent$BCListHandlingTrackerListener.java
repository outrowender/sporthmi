/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractChargeComponent;
import de.audi.atip.interapp.IBatteryControlListHandlingService;

class AbstractChargeComponent$BCListHandlingTrackerListener
implements CarServiceTrackerListener {
    private AbstractChargeComponent component;
    private final /* synthetic */ AbstractChargeComponent this$0;

    public AbstractChargeComponent$BCListHandlingTrackerListener(AbstractChargeComponent abstractChargeComponent, AbstractChargeComponent abstractChargeComponent2) {
        this.this$0 = abstractChargeComponent;
        this.component = abstractChargeComponent2;
    }

    @Override
    public void serviceAvailable(Object object) {
        AbstractChargeComponent.access$102(this.this$0, (IBatteryControlListHandlingService)object);
        AbstractChargeComponent.access$100(this.this$0).registerCalledBackComponent(this.component);
    }

    @Override
    public void serviceRemoved() {
        AbstractChargeComponent.access$102(this.this$0, null);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractChargeComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (AbstractChargeComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractChargeComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : AbstractChargeComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
    }

    public IBatteryControlListHandlingService getGoodbyeService() {
        return AbstractChargeComponent.access$100(this.this$0);
    }
}

