/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.base.ICoding;
import de.audi.app.car.sdis.comp.CarComfortComponent;
import de.audi.atip.log.LogChannel;

public class CarComfortComponent$CarStateHandler
extends AbstractCarStateHandler {
    private volatile int rdkVisibility;
    private final /* synthetic */ CarComfortComponent this$0;

    public CarComfortComponent$CarStateHandler(CarComfortComponent carComfortComponent, LogChannel logChannel) {
        this.this$0 = carComfortComponent;
        super(logChannel, CarComfortComponent.access$100(carComfortComponent));
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super.updateClampState(bl, bl2, bl3, bl4);
        this.logger.log(1078071040, "[updateClampState] clamp15=%1", bl2);
        this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        super.exceedsUpperThreshold(n);
        this.logger.log(1078071040, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
        this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
    }

    @Override
    public void belowLowerThreshold(int n) {
        super.belowLowerThreshold(n);
        this.logger.log(1078071040, "[belowLowerThreshold] =%1", this.isUnderVThr);
        this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
    }

    @Override
    public void updateStandStill(boolean bl) {
        super.updateStandStill(bl);
        this.logger.log(1078071040, "[updateStandStill] =%1", bl);
        this.updateVisibilityAfterCarStateChange((short)11, this.rdkVisibility);
    }

    private void updateVisibilityAfterCarStateChange(short s, int n) {
        int n2 = this.updateMenuEntryVisibility(s, n);
        this.logger.log(-2137614336, "updateVisibilityAfterCarStateChange: %1 %2 rdkVisiblity:%3", (Object)ICoding.CODING_INDEX_TEXT[s], (long)n2, (long)this.rdkVisibility);
        switch (s) {
            case 11: {
                CarComfortComponent.access$200(this.this$0, n2);
                break;
            }
            default: {
                this.logger.log(-1601830656, "Coding %1 not supported", (long)s);
            }
        }
    }

    static /* synthetic */ int access$002(CarComfortComponent$CarStateHandler carComfortComponent$CarStateHandler, int n) {
        carComfortComponent$CarStateHandler.rdkVisibility = n;
        return carComfortComponent$CarStateHandler.rdkVisibility;
    }
}

