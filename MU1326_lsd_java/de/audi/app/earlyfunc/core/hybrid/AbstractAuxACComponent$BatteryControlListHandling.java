/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingService;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

class AbstractAuxACComponent$BatteryControlListHandling
implements IBatteryControlListHandlingCallback,
CarServiceTrackerListener {
    private CarServiceTracker bcListHandlingTracker;
    private IBatteryControlListHandlingService bcListHandlingService = null;
    private final /* synthetic */ AbstractAuxACComponent this$0;

    public AbstractAuxACComponent$BatteryControlListHandling(AbstractAuxACComponent abstractAuxACComponent) {
        this.this$0 = abstractAuxACComponent;
    }

    public void init() {
        this.bcListHandlingTracker = new CarServiceTracker(this, AbstractAuxACComponent.access$000(this.this$0).getBundleContext(), this.this$0.getLogChannel());
        this.bcListHandlingTracker.startTracking();
    }

    public void deinit() {
        this.bcListHandlingTracker.stopTracking();
    }

    public IBatteryControlListHandlingService getService() {
        return this.bcListHandlingService;
    }

    @Override
    public void serviceAvailable(Object object) {
        this.bcListHandlingService = (IBatteryControlListHandlingService)object;
        this.bcListHandlingService.registerCalledBackComponent(this);
    }

    @Override
    public void serviceRemoved() {
        this.bcListHandlingService = null;
    }

    @Override
    public String[] getTrackedServiceClazzName() {
        return new String[]{(AbstractAuxACComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (AbstractAuxACComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractAuxACComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : AbstractAuxACComponent.class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
    }

    @Override
    public void updateClimateSystemType(int n, int n2) {
        switch (n) {
            case 6: {
                AbstractAuxACComponent.access$100(this.this$0, -1291051008).setValue(n2);
                break;
            }
            case 3: {
                AbstractAuxACComponent.access$200(this.this$0, -1811144704).setValue(n2);
                this.this$0.updateThermometerIconVisibility(1, n2);
                break;
            }
            case 4: {
                AbstractAuxACComponent.access$300(this.this$0, -1307828224).setValue(n2);
                this.this$0.updateThermometerIconVisibility(2, n2);
            }
            default: {
                this.this$0.getLogChannel().log(-2137614336, "[AbstractAuxCoolerComponent.BatteryControlListHandling#setClimateSystemType] profileId=%1 not handled", (long)n);
            }
        }
    }

    @Override
    public void updateChargeTimerClimateChoice(int n, int n2) {
    }

    @Override
    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
    }
}

