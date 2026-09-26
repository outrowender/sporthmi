/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$1;
import de.audi.atip.interapp.IBatteryControlListHandlingService;

class AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener
implements CarServiceTrackerListener {
    private IBatteryControlListHandlingService bcListHandlingService = null;
    private final /* synthetic */ AbstractHybridTimerControlComponent this$0;

    private AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent) {
        this.this$0 = abstractHybridTimerControlComponent;
    }

    public IBatteryControlListHandlingService getService() {
        return this.bcListHandlingService;
    }

    public boolean isServiceAvailable() {
        return null != this.bcListHandlingService;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.bcListHandlingService = (IBatteryControlListHandlingService)object;
        this.bcListHandlingService.registerCalledBackComponent(this.this$0);
    }

    @Override
    public void serviceRemoved() {
        this.bcListHandlingService = null;
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractHybridTimerControlComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (AbstractHybridTimerControlComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractHybridTimerControlComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : AbstractHybridTimerControlComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
    }

    /* synthetic */ AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, AbstractHybridTimerControlComponent$1 abstractHybridTimerControlComponent$1) {
        this(abstractHybridTimerControlComponent);
    }
}

