/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import org.dsi.ifc.caraircondition.AirconAirDistribution;

public class AbstractAirconComponent$AirDistributionHandler {
    private static final int DSI_DISTRIBUTION_ON;
    private static final int DSI_DISTRIBUTION_OFF;
    private final String name;
    private final int hmiZone;
    private final ChoiceModelApp airDistributionModelUp;
    private final ChoiceModelApp airDistributionModelIDMiddle;
    private final ChoiceModelApp airDistributionModelIDDown;
    private final ChoiceModelApp airDistributionModelIDAuto;
    private boolean sendDefault = false;
    private AirconAirDistribution currentAirDistribution;
    private final /* synthetic */ AbstractAirconComponent this$0;

    public AbstractAirconComponent$AirDistributionHandler(AbstractAirconComponent abstractAirconComponent, String string, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = abstractAirconComponent;
        this.name = string;
        this.hmiZone = n;
        this.airDistributionModelUp = AbstractAirconComponent.access$400(abstractAirconComponent, n2);
        this.airDistributionModelIDMiddle = AbstractAirconComponent.access$500(abstractAirconComponent, n3);
        this.airDistributionModelIDDown = AbstractAirconComponent.access$600(abstractAirconComponent, n4);
        this.airDistributionModelIDAuto = AbstractAirconComponent.access$700(abstractAirconComponent, n5);
    }

    private void callDSISetAirconAirDistribution(AirconAirDistribution airconAirDistribution) {
        int n = this.this$0.convertZoneHMI2DSI(this.hmiZone);
        if (-1 != n) {
            this.this$0.getLogChannel(1).log(1078071040, "---> DSI.setAirconAirDistribution(%1, %2)", (Object)Integer.toString(n), (Object)airconAirDistribution.toString());
            this.this$0.getDSI().setAirconAirDistribution(n, airconAirDistribution);
        }
    }

    private AirconAirDistribution copy(AirconAirDistribution airconAirDistribution) {
        return null == airconAirDistribution ? new AirconAirDistribution() : new AirconAirDistribution(airconAirDistribution.up, airconAirDistribution.body, airconAirDistribution.footwell, airconAirDistribution.indirect, airconAirDistribution.automode, airconAirDistribution.autoDemandOriented, airconAirDistribution.side);
    }

    public void dsiSetUp(int n) {
        if (null == this.currentAirDistribution) {
            this.this$0.getLogChannel().log(-1601830656, "[AirDistributionHandler(%1)#setUp] No AirDistribution-Information received yet.", (Object)this.name);
            if (!this.sendDefault) {
                return;
            }
        }
        AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
        airconAirDistribution.up = n;
        this.callDSISetAirconAirDistribution(airconAirDistribution);
    }

    public void dsiSetBody(int n) {
        if (null == this.currentAirDistribution) {
            this.this$0.getLogChannel().log(-1601830656, "[AirDistributionHandler(%1)#setBody] No AirDistribution-Information received yet.", (Object)this.name);
            if (!this.sendDefault) {
                return;
            }
        }
        AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
        airconAirDistribution.body = n;
        this.callDSISetAirconAirDistribution(airconAirDistribution);
    }

    public void dsiSetFootwell(int n) {
        if (null == this.currentAirDistribution) {
            this.this$0.getLogChannel().log(-1601830656, "[AirDistributionHandler(%1)#setFootwell] No AirDistribution-Information received yet.", (Object)this.name);
            if (!this.sendDefault) {
                return;
            }
        }
        AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
        airconAirDistribution.footwell = n;
        this.callDSISetAirconAirDistribution(airconAirDistribution);
    }

    public void dsiSetAutomode(boolean bl) {
        if (null == this.currentAirDistribution) {
            this.this$0.getLogChannel().log(-1601830656, "[AirDistributionHandler(%1)#setAutomode] No AirDistribution-Information received yet.", (Object)this.name);
            if (!this.sendDefault) {
                return;
            }
        }
        AirconAirDistribution airconAirDistribution = this.copy(this.currentAirDistribution);
        airconAirDistribution.automode = bl;
        this.callDSISetAirconAirDistribution(airconAirDistribution);
    }

    public void updateAirDistribution(AirconAirDistribution airconAirDistribution) {
        if (null != airconAirDistribution) {
            int n;
            this.currentAirDistribution = airconAirDistribution;
            int n2 = 12 == airconAirDistribution.getUp() ? 1 : 0;
            int n3 = 12 == airconAirDistribution.getBody() ? 1 : 0;
            int n4 = 12 == airconAirDistribution.getFootwell() ? 1 : 0;
            int n5 = n = airconAirDistribution.isAutomode() ? 1 : 0;
            if (null != this.airDistributionModelUp) {
                this.airDistributionModelUp.setValue(n2);
            }
            if (null != this.airDistributionModelIDMiddle) {
                this.airDistributionModelIDMiddle.setValue(n3);
            }
            if (null != this.airDistributionModelIDDown) {
                this.airDistributionModelIDDown.setValue(n4);
            }
            if (null != this.airDistributionModelIDAuto) {
                this.airDistributionModelIDAuto.setValue(n);
            }
            this.this$0.notifyAutoModeStateChanged(this.hmiZone, 0);
        }
    }

    static /* synthetic */ AirconAirDistribution access$4200(AbstractAirconComponent$AirDistributionHandler abstractAirconComponent$AirDistributionHandler) {
        return abstractAirconComponent$AirDistributionHandler.currentAirDistribution;
    }
}

