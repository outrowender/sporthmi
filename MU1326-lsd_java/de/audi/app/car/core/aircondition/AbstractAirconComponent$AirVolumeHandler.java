/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.app.car.core.app.RangeModelSynchronizer;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import org.dsi.ifc.caraircondition.AirconAirVolume;

public class AbstractAirconComponent$AirVolumeHandler {
    private final String name;
    private final int hmiZone;
    private final int airVolumeAttributeID;
    private final RangeModelApp airVolumeModelValue;
    private final ChoiceModelApp airVolumeModelAuto;
    private boolean sendDefault = false;
    private AirconAirVolume currentAirVolume;
    private final RangeModelSynchronizer airVolumeRangeModelSync;
    private final /* synthetic */ AbstractAirconComponent this$0;

    public AbstractAirconComponent$AirVolumeHandler(AbstractAirconComponent abstractAirconComponent, String string, int n, int n2, int n3, int n4) {
        this.this$0 = abstractAirconComponent;
        this.name = string;
        this.hmiZone = n;
        this.airVolumeAttributeID = n2;
        this.airVolumeModelValue = AbstractAirconComponent.access$800(abstractAirconComponent, n3);
        this.airVolumeModelAuto = AbstractAirconComponent.access$900(abstractAirconComponent, n4);
        this.airVolumeRangeModelSync = new RangeModelSynchronizer(string, AbstractAirconComponent.access$1000(abstractAirconComponent), 0, abstractAirconComponent.getLogChannel());
        this.airVolumeRangeModelSync.addWatchedAttribute(n2, true, this.airVolumeModelValue);
    }

    private void callDSISetAirconAirVolume(AirconAirVolume airconAirVolume) {
        int n = this.this$0.convertZoneHMI2DSI(this.hmiZone);
        if (-1 != n) {
            this.this$0.getLogChannel(1).log(1078071040, "---> DSI.callDSISetAirconAirVolume(%1, %2)", (Object)Integer.toString(n), (Object)airconAirVolume.toString());
            this.this$0.getDSI().setAirconAirVolume(n, airconAirVolume);
        }
    }

    private AirconAirVolume copy(AirconAirVolume airconAirVolume) {
        return null == airconAirVolume ? new AirconAirVolume() : new AirconAirVolume(airconAirVolume.airVolume, airconAirVolume.airVolumeRegulated, airconAirVolume.airVolumeAuto);
    }

    public void incrementVolume(int n) {
        this.airVolumeRangeModelSync.notifyIncrement(this.airVolumeAttributeID, n);
    }

    public void decrementVolume(int n) {
        this.airVolumeRangeModelSync.notifyDecrement(this.airVolumeAttributeID, n);
    }

    public void dsiSetVolume(int n) {
        if (null == this.currentAirVolume) {
            this.this$0.getLogChannel().log(-1601830656, "[AirVolumeHandler(%1)#dsiSetVolume] No AirVolume-Information received yet.", (Object)this.name);
            if (!this.sendDefault) {
                return;
            }
        }
        AirconAirVolume airconAirVolume = this.copy(this.currentAirVolume);
        airconAirVolume.airVolume = n;
        this.callDSISetAirconAirVolume(airconAirVolume);
    }

    public void dsiSetVolumeAuto(int n) {
        if (null == this.currentAirVolume) {
            this.this$0.getLogChannel().log(-1601830656, "[AirVolumeHandler(%1)#dsiSetVolumeAuto] No AirVolume-Information received yet.", (Object)this.name);
            if (!this.sendDefault) {
                return;
            }
        }
        AirconAirVolume airconAirVolume = this.copy(this.currentAirVolume);
        airconAirVolume.airVolumeAuto = n;
        this.callDSISetAirconAirVolume(airconAirVolume);
    }

    public void updateAirVolume(AirconAirVolume airconAirVolume) {
        if (null != airconAirVolume) {
            this.currentAirVolume = airconAirVolume;
            int n = airconAirVolume.getAirVolume();
            int n2 = airconAirVolume.getAirVolumeAuto();
            if (null != this.airVolumeRangeModelSync) {
                this.airVolumeRangeModelSync.notifyUpdateReceived(this.airVolumeAttributeID, n);
            }
            if (null != this.airVolumeModelAuto) {
                this.airVolumeModelAuto.setValue(n2);
            }
            this.this$0.notifyAutoModeStateChanged(this.hmiZone, 1);
        }
    }

    static /* synthetic */ AirconAirVolume access$4100(AbstractAirconComponent$AirVolumeHandler abstractAirconComponent$AirVolumeHandler) {
        return abstractAirconComponent$AirVolumeHandler.currentAirVolume;
    }
}

