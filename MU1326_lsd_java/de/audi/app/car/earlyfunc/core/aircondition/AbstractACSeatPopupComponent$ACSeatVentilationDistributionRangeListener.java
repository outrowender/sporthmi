/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent$AbstractACSeatSettingRangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;

class AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener
extends AbstractACSeatPopupComponent$AbstractACSeatSettingRangeListener {
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    public AbstractACSeatPopupComponent$ACSeatVentilationDistributionRangeListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent, RangeModelApp rangeModelApp, int n) {
        this.this$0 = abstractACSeatPopupComponent;
        super(abstractACSeatPopupComponent, rangeModelApp, n);
    }

    @Override
    protected void sendACSeatSettingToDSI(int n) {
        this.this$0.getDSI().setAirconSeatVentilationDistribution(this.getDSIZone(), n);
    }
}

