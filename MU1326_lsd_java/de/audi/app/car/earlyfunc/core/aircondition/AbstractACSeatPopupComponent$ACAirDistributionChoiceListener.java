/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.earlyfunc.core.aircondition;

import de.audi.app.car.earlyfunc.core.aircondition.AbstractACSeatPopupComponent;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.caraircondition.AirconAirDistribution;

class AbstractACSeatPopupComponent$ACAirDistributionChoiceListener
extends DefaultChoiceListener {
    private static final int HMI_DISTRIBUTION_BITMASK_TOP;
    private static final int HMI_DISTRIBUTION_BITMASK_MIDDLE;
    private static final int HMI_DISTRIBUTION_BITMASK_BOTTOM;
    private static final int DSI_ZONE_INACTIVE;
    private static final int DSI_ZONE_ACTIVE;
    private static final int AUTO_OFF;
    private static final int AUTO_ON;
    private final ChoiceModelApp distributionModel;
    private final ChoiceModelApp distributionAutoModel;
    private final int zone;
    private volatile boolean distributionAuto = false;
    private final /* synthetic */ AbstractACSeatPopupComponent this$0;

    public AbstractACSeatPopupComponent$ACAirDistributionChoiceListener(AbstractACSeatPopupComponent abstractACSeatPopupComponent, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, int n) {
        this.this$0 = abstractACSeatPopupComponent;
        this.distributionModel = choiceModelApp;
        this.distributionAutoModel = choiceModelApp2;
        choiceModelApp2.setValue(0);
        this.zone = n;
    }

    public void init() {
        this.distributionModel.setChoiceListener(this);
    }

    public void deinit() {
        this.distributionModel.resetListener();
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n == this.distributionModel.getID()) {
            AbstractACSeatPopupComponent.access$200(this.this$0, "[ACAirDistributionChoiceListener#itemSelected]", n, n2, true);
            int n5 = this.zone;
            AirconAirDistribution airconAirDistribution = new AirconAirDistribution();
            airconAirDistribution.footwell = this.calculateZoneState(n2, 4);
            airconAirDistribution.body = this.calculateZoneState(n2, 2);
            airconAirDistribution.up = this.calculateZoneState(n2, 1);
            airconAirDistribution.automode = this.distributionAuto;
            this.this$0.getLogChannel().log(1078071040, "[ACAirDistributionChoiceListener#itemSelected] dsi.setAirconAirDistribution() : zone='%1' , airDistribution='%2'", (Object)new Integer(n5), (Object)airconAirDistribution);
            this.this$0.getDSI().setAirconAirDistribution(n5, airconAirDistribution);
        } else {
            AbstractACSeatPopupComponent.access$300(this.this$0, "[ACAirDistributionChoiceListener#itemSelected]", n, n2, false);
        }
    }

    public void updateAirDistribution(AirconAirDistribution airconAirDistribution) {
        int n = 0;
        n = airconAirDistribution.footwell > 0 ? n | 4 : n;
        n = airconAirDistribution.body > 0 ? n | 2 : n;
        n = airconAirDistribution.up > 0 ? n | 1 : n;
        this.this$0.getLogChannel().log(1078071040, "[ACAirDistributionChoiceListener#updateAirDistribution] update air distribution model : hmiDistribution='%1' , modelID='%2'", (long)n, (long)this.distributionModel.getID());
        this.distributionModel.setValue(n);
        this.distributionAutoModel.setValue(airconAirDistribution.isAutomode() ? 1 : 0);
        this.distributionAuto = airconAirDistribution.isAutomode();
    }

    private int calculateZoneState(int n, int n2) {
        return (n & n2) == n2 ? 12 : 0;
    }
}

