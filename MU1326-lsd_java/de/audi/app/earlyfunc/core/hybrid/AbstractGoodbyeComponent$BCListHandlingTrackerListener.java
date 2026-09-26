/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractGoodbyeComponent;
import de.audi.atip.interapp.IBatteryControlListHandlingService;

class AbstractGoodbyeComponent$BCListHandlingTrackerListener
implements CarServiceTrackerListener {
    private AbstractGoodbyeComponent component;
    private final /* synthetic */ AbstractGoodbyeComponent this$0;

    public AbstractGoodbyeComponent$BCListHandlingTrackerListener(AbstractGoodbyeComponent abstractGoodbyeComponent, AbstractGoodbyeComponent abstractGoodbyeComponent2) {
        this.this$0 = abstractGoodbyeComponent;
        this.component = abstractGoodbyeComponent2;
    }

    @Override
    public void serviceAvailable(Object object) {
        AbstractGoodbyeComponent.access$002(this.this$0, (IBatteryControlListHandlingService)object);
        AbstractGoodbyeComponent.access$000(this.this$0).registerCalledBackComponent(this.component);
    }

    @Override
    public void serviceRemoved() {
        AbstractGoodbyeComponent.access$002(this.this$0, null);
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractGoodbyeComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (AbstractGoodbyeComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractGoodbyeComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : AbstractGoodbyeComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
    }

    public IBatteryControlListHandlingService getGoodbyeService() {
        return AbstractGoodbyeComponent.access$000(this.this$0);
    }
}

