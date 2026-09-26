/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$AbstractACSeatSettingRangeListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

abstract class AbstractACSeatPopupComponent$AbstractDefaultACSeatRangeListener
extends AbstractACSeatPopupComponent$AbstractACSeatSettingRangeListener
implements ChoiceListener {
    private static final int DSI_MIN;
    private static final int DSI_MAX;
    private static final int HMI_MIN;
    private static final int HMI_MAX;
    private static final int HMI_AUTO_LEVEL_OFF;
    private static final int HMI_AUTO_LEVEL_ON;
    private int currentVentilationLevelDSI;
    private ChoiceModelApp autoChoiceModel;
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    public AbstractACSeatPopupComponent$AbstractDefaultACSeatRangeListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent, RangeModelApp rangeModelApp, ChoiceModelApp choiceModelApp, int n) {
        this.this$0 = abstractACSeatPopupComponent;
        super(abstractACSeatPopupComponent, rangeModelApp, n);
        this.currentVentilationLevelDSI = 0;
        this.autoChoiceModel = choiceModelApp;
    }

    @Override
    public void init(int n, int n2, int n3) {
        super.init(n, n2, n3);
        this.autoChoiceModel.setChoiceListener(this);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        int n5;
        this.this$0.getLogChannel().log(1078071040, "[AbstractDefaultACSeatRangeListener#itemSelected] modelID=%1 itemID=%2", (long)n, (long)n2);
        int n6 = n5 = n2 == 1 ? 255 : this.currentVentilationLevelDSI;
        int n7 = n2 == 1 ? 2 : (n5 == 0 ? 0 : 1);
        this.sendACSeatSettingToDSI(n7, n5);
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    protected void sendACSeatSettingToDSI(int n) {
        int n2 = AbstractCarComponent.clip(n * 2, 0, 6);
        int n3 = n2 == 0 ? 0 : 1;
        this.sendACSeatSettingToDSI(n3, n2);
    }

    protected abstract void sendACSeatSettingToDSI(int n, int n2) {
    }

    @Override
    public void updateACSeatSetting(int n, int n2) {
        if (n == 2 || n2 == 255) {
            this.autoChoiceModel.setValue(1);
            this.this$0.getLogChannel().log(1078071040, "[AbstractDefaultACSeatRangeListener#updateACSeatSetting] update ac setting model : updatedACSeatSetting='%1' , modelID='%2'", (long)n, (long)this.getAcSeatSettingRangeModel().getID());
            this.getAcSeatSettingRangeModel().setValue(0);
        } else {
            this.autoChoiceModel.setValue(0);
            this.currentVentilationLevelDSI = n2;
            super.updateACSeatSetting(AbstractCarComponent.clip(n2 / 2, 0, 3));
        }
    }
}

