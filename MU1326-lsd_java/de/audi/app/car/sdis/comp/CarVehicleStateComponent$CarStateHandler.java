/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.comp.CarVehicleStateComponent;
import de.audi.atip.log.LogChannel;

public class CarVehicleStateComponent$CarStateHandler
extends AbstractCarStateHandler {
    private volatile int vinVisibility;
    private volatile int keyVisibility;
    private volatile int oilVisibility;
    private volatile int adblueVisibility;
    private final /* synthetic */ CarVehicleStateComponent this$0;

    public CarVehicleStateComponent$CarStateHandler(CarVehicleStateComponent carVehicleStateComponent, LogChannel logChannel) {
        this.this$0 = carVehicleStateComponent;
        super(logChannel, CarVehicleStateComponent.access$500(carVehicleStateComponent));
        this.vinVisibility = 0;
        this.keyVisibility = 0;
        this.oilVisibility = 0;
        this.adblueVisibility = 0;
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5 = this.isClamp15On;
        super.updateClampState(bl, bl2, bl3, bl4);
        this.logger.log(1078071040, "[updateClampState] clamp15=%1", bl2);
        this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
        this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
        this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
        this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
        if (!bl5 && bl2) {
            this.resendOilValue();
            this.resendScrValue();
        }
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        super.exceedsUpperThreshold(n);
        this.logger.log(1078071040, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
        this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
        this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
        this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
        this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
    }

    @Override
    public void belowLowerThreshold(int n) {
        super.belowLowerThreshold(n);
        this.logger.log(1078071040, "[belowLowerThreshold] =%1", this.isUnderVThr);
        this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
        this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
        this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
        this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
    }

    @Override
    public void updateStandStill(boolean bl) {
        super.updateStandStill(bl);
        this.logger.log(1078071040, "[updateStandStill] =%1", bl);
        this.updateVisibilityAfterCarStateChange((short)19, this.vinVisibility);
        this.updateVisibilityAfterCarStateChange((short)32, this.keyVisibility);
        this.updateVisibilityAfterCarStateChange((short)18, this.oilVisibility);
        this.updateVisibilityAfterCarStateChange((short)53, this.adblueVisibility);
    }

    private boolean isClamp15Off() {
        return !this.isClamp15On;
    }

    private void updateVisibilityAfterCarStateChange(short s, int n) {
        int n2 = this.updateMenuEntryVisibility(s, n);
        switch (s) {
            case 19: {
                CarVehicleStateComponent.access$600(this.this$0, n2);
                break;
            }
            case 32: {
                CarVehicleStateComponent.access$700(this.this$0, n2);
                break;
            }
            case 18: {
                CarVehicleStateComponent.access$800(this.this$0, n2);
                break;
            }
            case 53: {
                CarVehicleStateComponent.access$900(this.this$0, n2);
                break;
            }
            default: {
                this.logger.log(-1601830656, "Coding %1 not supported", (long)s);
            }
        }
    }

    private void resendOilValue() {
        if (CarVehicleStateComponent.access$1000(this.this$0) != null && this.isClamp15Sensitive((short)18)) {
            this.this$0.updateOilLevelData(CarVehicleStateComponent.access$1000(this.this$0), 1);
            CarVehicleStateComponent.access$1002(this.this$0, null);
        }
    }

    private void resendScrValue() {
        if (CarVehicleStateComponent.access$1100(this.this$0) != null && this.isClamp15Sensitive((short)53)) {
            this.this$0.updateDynamicVehicleInfoSCR(CarVehicleStateComponent.access$1100(this.this$0), 1);
            CarVehicleStateComponent.access$1102(this.this$0, null);
        }
    }

    static /* synthetic */ int access$002(CarVehicleStateComponent$CarStateHandler carVehicleStateComponent$CarStateHandler, int n) {
        carVehicleStateComponent$CarStateHandler.oilVisibility = n;
        return carVehicleStateComponent$CarStateHandler.oilVisibility;
    }

    static /* synthetic */ boolean access$100(CarVehicleStateComponent$CarStateHandler carVehicleStateComponent$CarStateHandler) {
        return carVehicleStateComponent$CarStateHandler.isClamp15Off();
    }

    static /* synthetic */ int access$202(CarVehicleStateComponent$CarStateHandler carVehicleStateComponent$CarStateHandler, int n) {
        carVehicleStateComponent$CarStateHandler.vinVisibility = n;
        return carVehicleStateComponent$CarStateHandler.vinVisibility;
    }

    static /* synthetic */ int access$302(CarVehicleStateComponent$CarStateHandler carVehicleStateComponent$CarStateHandler, int n) {
        carVehicleStateComponent$CarStateHandler.keyVisibility = n;
        return carVehicleStateComponent$CarStateHandler.keyVisibility;
    }

    static /* synthetic */ int access$402(CarVehicleStateComponent$CarStateHandler carVehicleStateComponent$CarStateHandler, int n) {
        carVehicleStateComponent$CarStateHandler.adblueVisibility = n;
        return carVehicleStateComponent$CarStateHandler.adblueVisibility;
    }
}

