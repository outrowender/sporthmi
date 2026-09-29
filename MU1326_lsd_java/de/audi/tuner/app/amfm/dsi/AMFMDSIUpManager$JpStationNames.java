/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.interapp.AMFMStationInfo;
import de.audi.atip.interapp.AMFMTunerService;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;

public class AMFMDSIUpManager$JpStationNames
implements AMFMTunerService {
    private final /* synthetic */ AMFMDSIUpManager this$0;

    public AMFMDSIUpManager$JpStationNames(AMFMDSIUpManager aMFMDSIUpManager) {
        this.this$0 = aMFMDSIUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateReceivableStations(AMFMStationInfo[] aMFMStationInfoArray) {
        Object object = AMFMDSIUpManager.access$200(this.this$0);
        synchronized (object) {
            AMFMDSIUpManager.access$1400(this.this$0).setJpAMFMStationInfo(aMFMStationInfoArray);
        }
        AMFMDSIUpManager.access$1300(this.this$0).reNotification(1);
        AMFMDSIUpManager.access$1300(this.this$0).reNotification(2);
        AMFMDSIUpManager.access$1300(this.this$0).reNotification(3);
    }
}

