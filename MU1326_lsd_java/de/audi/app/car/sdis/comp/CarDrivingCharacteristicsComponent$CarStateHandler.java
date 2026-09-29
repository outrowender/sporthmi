/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.comp.CarDrivingCharacteristicsComponent;
import de.audi.atip.log.LogChannel;

public class CarDrivingCharacteristicsComponent$CarStateHandler
extends AbstractCarStateHandler {
    private volatile int tadVisibility;
    private volatile int suspVisibility;
    private volatile int charismaVisibility;
    private final /* synthetic */ CarDrivingCharacteristicsComponent this$0;

    public CarDrivingCharacteristicsComponent$CarStateHandler(CarDrivingCharacteristicsComponent carDrivingCharacteristicsComponent, LogChannel logChannel) {
        this.this$0 = carDrivingCharacteristicsComponent;
        super(logChannel, CarDrivingCharacteristicsComponent.access$300(carDrivingCharacteristicsComponent));
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super.updateClampState(bl, bl2, bl3, bl4);
        this.logger.log(1078071040, "[updateClampState] clamp15=%1", bl2);
        this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
        this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
        this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        super.exceedsUpperThreshold(n);
        this.logger.log(1078071040, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
        this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
        this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
        this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
    }

    @Override
    public void belowLowerThreshold(int n) {
        super.belowLowerThreshold(n);
        this.logger.log(1078071040, "[belowLowerThreshold] =%1", this.isUnderVThr);
        this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
        this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
        this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
    }

    @Override
    public void updateStandStill(boolean bl) {
        super.updateStandStill(bl);
        this.logger.log(1078071040, "[updateStandStill] =%1", bl);
        this.updateVisibilityAfterCarStateChange((short)40, this.tadVisibility);
        this.updateVisibilityAfterCarStateChange((short)21, this.suspVisibility);
        this.updateVisibilityAfterCarStateChange((short)17, this.charismaVisibility);
    }

    private void updateVisibilityAfterCarStateChange(short s, int n) {
        int n2 = this.updateMenuEntryVisibility(s, n);
        switch (s) {
            case 40: {
                CarDrivingCharacteristicsComponent.access$400(this.this$0, n2);
                break;
            }
            case 21: {
                CarDrivingCharacteristicsComponent.access$500(this.this$0, new int[]{n2, n2});
                break;
            }
            case 17: {
                CarDrivingCharacteristicsComponent.access$600(this.this$0, n2);
                break;
            }
            default: {
                this.logger.log(-1601830656, "Coding %1 not supported", (long)s);
            }
        }
    }

    static /* synthetic */ int access$002(CarDrivingCharacteristicsComponent$CarStateHandler carDrivingCharacteristicsComponent$CarStateHandler, int n) {
        carDrivingCharacteristicsComponent$CarStateHandler.tadVisibility = n;
        return carDrivingCharacteristicsComponent$CarStateHandler.tadVisibility;
    }

    static /* synthetic */ int access$102(CarDrivingCharacteristicsComponent$CarStateHandler carDrivingCharacteristicsComponent$CarStateHandler, int n) {
        carDrivingCharacteristicsComponent$CarStateHandler.suspVisibility = n;
        return carDrivingCharacteristicsComponent$CarStateHandler.suspVisibility;
    }

    static /* synthetic */ int access$202(CarDrivingCharacteristicsComponent$CarStateHandler carDrivingCharacteristicsComponent$CarStateHandler, int n) {
        carDrivingCharacteristicsComponent$CarStateHandler.charismaVisibility = n;
        return carDrivingCharacteristicsComponent$CarStateHandler.charismaVisibility;
    }
}

