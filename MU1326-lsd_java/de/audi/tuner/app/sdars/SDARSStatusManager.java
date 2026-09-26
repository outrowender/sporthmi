/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.sdars.GUIHandlerSDARS;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import org.dsi.ifc.sdars.ServiceStatus3;

public class SDARSStatusManager {
    private ServiceStatus3 currentStatus;
    private final SDARSAdvisoryHandler advisoryHandler;

    SDARSStatusManager(TunerBasics tunerBasics, SDARSAdvisoryHandler sDARSAdvisoryHandler, GUIHandlerSDARS gUIHandlerSDARS) {
        this.advisoryHandler = sDARSAdvisoryHandler;
        this.currentStatus = new ServiceStatus3();
        this.currentStatus.listUpdateStatus = 2;
        this.currentStatus.antennaStatus = 2;
        this.currentStatus.audioStatus = 2;
        this.currentStatus.dataSubscription = 2;
        this.currentStatus.dataUpdateStatus = 2;
    }

    void updateServiceStatus(ServiceStatus3 serviceStatus3) {
        boolean bl = this.isSubscriptionUpdate(serviceStatus3);
        boolean bl2 = this.isAntennaError(serviceStatus3);
        int n = 10;
        if (bl) {
            n = 4;
        } else if (this.isSubscriptionUpdate(this.currentStatus) && !bl) {
            n = 7;
        }
        if (bl2) {
            n = 6;
        }
        this.advisoryHandler.requestAdvisory(n);
        this.currentStatus = serviceStatus3;
    }

    private boolean isAudioMuted(ServiceStatus3 serviceStatus3) {
        return serviceStatus3.audioStatus == 1;
    }

    private boolean isAntennaError(ServiceStatus3 serviceStatus3) {
        return serviceStatus3.antennaStatus == 1;
    }

    private boolean isSubscriptionUpdate(ServiceStatus3 serviceStatus3) {
        return serviceStatus3.subscriptionUpdateStatus == 1;
    }

    void sdarsSelected() {
    }

    public boolean isMute() {
        return this.isAudioMuted(this.currentStatus);
    }
}

