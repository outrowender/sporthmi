/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.comp;

import de.audi.app.car.sdis.base.AbstractCarStateHandler;
import de.audi.app.car.sdis.base.IVisibility;
import de.audi.app.car.sdis.base.VisibilityEntry;
import de.audi.app.car.sdis.comp.CarKombiComponent;
import de.audi.atip.log.LogChannel;

public class CarKombiComponent$CarStateHandler
extends AbstractCarStateHandler {
    private VisibilityEntry[] visibilityEntryStructure;
    private final /* synthetic */ CarKombiComponent this$0;

    public CarKombiComponent$CarStateHandler(CarKombiComponent carKombiComponent, LogChannel logChannel) {
        this.this$0 = carKombiComponent;
        super(logChannel, CarKombiComponent.access$200(carKombiComponent));
        this.init();
    }

    private void init() {
        int n = 0;
        this.visibilityEntryStructure = new VisibilityEntry[10];
        this.visibilityEntryStructure[0] = new VisibilityEntry(n, 13);
        this.visibilityEntryStructure[1] = new VisibilityEntry(n, 13);
        this.visibilityEntryStructure[2] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[3] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[4] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[5] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[6] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[7] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[8] = new VisibilityEntry(n, 10);
        this.visibilityEntryStructure[9] = new VisibilityEntry(n, 10);
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        super.updateClampState(bl, bl2, bl3, bl4);
        this.logger.log(1078071040, "[updateClampState] clamp15=%1", bl2);
        for (int i2 = 0; i2 < this.visibilityEntryStructure.length; ++i2) {
            this.logger.log(1078071040, "[updateClampState: call updateVisibilityAfterCarStateChange] =%1", (Object)CarKombiComponent.access$300()[i2]);
            this.updateVisibilityAfterCarStateChange(i2, this.visibilityEntryStructure[i2].getCoding(), this.visibilityEntryStructure[i2].getVisibility());
        }
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        super.exceedsUpperThreshold(n);
        this.logger.log(1078071040, "[exceedsUpperThreshold] =%1", this.isUnderVThr);
        for (int i2 = 0; i2 < this.visibilityEntryStructure.length; ++i2) {
            this.updateVisibilityAfterCarStateChange(i2, this.visibilityEntryStructure[i2].getCoding(), this.visibilityEntryStructure[i2].getVisibility());
        }
    }

    @Override
    public void belowLowerThreshold(int n) {
        super.belowLowerThreshold(n);
        this.logger.log(1078071040, "[belowLowerThreshold] =%1", this.isUnderVThr);
        for (int i2 = 0; i2 < this.visibilityEntryStructure.length; ++i2) {
            this.updateVisibilityAfterCarStateChange(i2, this.visibilityEntryStructure[i2].getCoding(), this.visibilityEntryStructure[i2].getVisibility());
        }
    }

    @Override
    public void updateStandStill(boolean bl) {
        super.updateStandStill(bl);
        this.logger.log(1078071040, "[updateStandStill] =%1", bl);
        for (int i2 = 0; i2 < this.visibilityEntryStructure.length; ++i2) {
            this.updateVisibilityAfterCarStateChange(i2, this.visibilityEntryStructure[i2].getCoding(), this.visibilityEntryStructure[i2].getVisibility());
        }
    }

    private void setVisibilityState(int n, int n2) {
        if (n < this.visibilityEntryStructure.length) {
            this.visibilityEntryStructure[n].setVisibility(n2);
        }
    }

    private void updateVisibilityAfterCarStateChange(int n, short s, int n2) {
        int n3 = this.updateMenuEntryVisibility(s, n2);
        if (s == 13) {
            CarKombiComponent.access$400(this.this$0, n3);
            CarKombiComponent.access$500(this.this$0, n3);
        }
        if ((n3 != CarKombiComponent.access$600(this.this$0)[n] || n3 == 3) && s == 10) {
            this.logger.log(-2137614336, "updateVisibilityAfterCarStateChange BC: trigger update to tablet: visib: %1, new: %2,latest: %3", (Object)IVisibility.TEXT_TO_STATE[n2], (Object)IVisibility.TEXT_TO_STATE[n3], (Object)IVisibility.TEXT_TO_STATE[CarKombiComponent.access$600(this.this$0)[n]]);
            CarKombiComponent.access$700(this.this$0, n3);
        }
    }

    static /* synthetic */ void access$000(CarKombiComponent$CarStateHandler carKombiComponent$CarStateHandler, int n, int n2) {
        carKombiComponent$CarStateHandler.setVisibilityState(n, n2);
    }

    static /* synthetic */ VisibilityEntry[] access$100(CarKombiComponent$CarStateHandler carKombiComponent$CarStateHandler) {
        return carKombiComponent$CarStateHandler.visibilityEntryStructure;
    }
}

