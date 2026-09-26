/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

abstract class AbstractACSeatPopupComponent$AbstractACSeatSettingRangeListener
extends DefaultRangeListener {
    private final RangeModelApp acSeatSettingRangeModel;
    private final int zone;
    private int min;
    private int max;
    private int stepWidth;
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    public AbstractACSeatPopupComponent$AbstractACSeatSettingRangeListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent, RangeModelApp rangeModelApp, int n) {
        this.this$0 = abstractACSeatPopupComponent;
        this.acSeatSettingRangeModel = rangeModelApp;
        this.zone = n;
    }

    public void init(int n, int n2, int n3) {
        this.initRange(n, n2, n3);
        this.getAcSeatSettingRangeModel().setLimits(n, n2, n3);
        this.getAcSeatSettingRangeModel().setRangeListener(this);
    }

    private void initRange(int n, int n2, int n3) {
        this.min = n;
        this.max = n2;
        this.stepWidth = n3;
    }

    public void deinit() {
        this.getAcSeatSettingRangeModel().resetListener();
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        AbstractACSeatPopupComponent.access$000(this.this$0, "[AbstractACSeatSettingRangeListener#decrement]", n, n2, true);
        this.modifyACSeatSetting(-n2);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        AbstractACSeatPopupComponent.access$100(this.this$0, "[AbstractACSeatSettingRangeListener#increment]", n, n2, true);
        this.modifyACSeatSetting(n2);
    }

    private void modifyACSeatSetting(int n) {
        int n2 = this.getAcSeatSettingRangeModel().getValue() + n;
        n2 = AbstractCarComponent.clip(n2, this.min, this.max);
        this.sendACSeatSettingToDSI(n2);
    }

    protected abstract void sendACSeatSettingToDSI(int n) {
    }

    public void updateACSeatSetting(int n, int n2) {
        int n3 = AbstractCarComponent.clip(n2, this.min, this.max);
        this.this$0.getLogChannel().log(1078071040, "[AbstractACSeatSettingRangeListener#updateACSeatSetting] update ac setting model : updatedACSeatSetting='%1' , modelID='%2'", (long)n2, (long)this.getAcSeatSettingRangeModel().getID());
        this.getAcSeatSettingRangeModel().setValue(n3);
    }

    public void updateACSeatSetting(int n) {
        int n2 = AbstractCarComponent.clip(n, this.min, this.max);
        this.this$0.getLogChannel().log(1078071040, "[AbstractACSeatSettingRangeListener#updateACSeatSetting] update ac setting model : updatedACSeatSetting='%1' , modelID='%2'", (long)n, (long)this.getAcSeatSettingRangeModel().getID());
        this.getAcSeatSettingRangeModel().setValue(n2);
    }

    protected RangeModelApp getAcSeatSettingRangeModel() {
        return this.acSeatSettingRangeModel;
    }

    public int getDSIZone() {
        return this.zone;
    }
}

