/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$AbstractDefaultACSeatRangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

class AbstractACSeatPopupComponent$ACSeatHeaterRangeListener
extends AbstractACSeatPopupComponent$AbstractDefaultACSeatRangeListener {
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    public AbstractACSeatPopupComponent$ACSeatHeaterRangeListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent, RangeModelApp rangeModelApp, ChoiceModelApp choiceModelApp, int n) {
        this.this$0 = abstractACSeatPopupComponent;
        super(abstractACSeatPopupComponent, rangeModelApp, choiceModelApp, n);
    }

    @Override
    protected void sendACSeatSettingToDSI(int n, int n2) {
        this.this$0.getLogChannel().log(1078071040, "[ACSeatHeaterRangeListener#sendACSeatSettingToDSI] dsi.setAirconSeatHeater zone=%1 ventilationState=%2 ventilationLevel=%3", (long)this.getDSIZone(), (long)n, (long)n2);
        this.this$0.getDSI().setAirconSeatHeater(this.getDSIZone(), n, n2);
    }
}

