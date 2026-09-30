/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

class DataConfigurationDefaultListener
implements DSIDataConfigurationListener {
    private final LogChannel log;

    DataConfigurationDefaultListener(LogChannel logChannel) {
        this.log = logChannel;
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConfigurationDefaultListener#asyncException(): error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    public void acceptDataRequestResponse(int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#acceptDataRequestResponse(): Expected to be handled by a Command!");
    }

    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        this.log.log(100000, "DataConfigurationDefaultListener#automaticProfileResponse(): Expected to be handled by a Command!");
    }

    public void resetPacketCounterResponse(int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#resetPacketCounterResponse(): Expected to be handled by a Command!");
    }

    public void restoreFactorySettingsResponse(int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#restoreFactorySettingsResponse(): Expected to be handled by a Command!");
    }

    public void setConnectionModeResponse(int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#setConnectionModeResponse(): Expected to be handled by a Command!");
    }

    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#setDataProfileResponse(): Expected to be handled by a Command!");
    }

    public void setRequestSettingResponse(int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#setRequestSettingResponse(): Expected to be handled by a Command!");
    }

    public void setRoamingStateResponse(int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#setRoamingStateResponse(): Expected to be handled by a Command!");
    }

    public void updateActiveProfile(int n, int n2) {
        this.log.log(100000, "DataConfigurationDefaultListener#updateActiveProfile(): unexpected call (no notification)");
    }

    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#updateAvailableProfiles(): unexpected call (no notification)");
    }

    public void updateConnectionMode(int n, int n2) {
        this.log.log(100000, "DataConfigurationDefaultListener#updateConnectionMode(): unexpected call (no notification)");
    }

    public void updateDataRequest(int n, int n2) {
        this.log.log(100000, "DataConfigurationDefaultListener#updateDataRequest(): unexpected call (no notification)");
    }

    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        this.log.log(100000, "DataConfigurationDefaultListener#updatePacketCounter(): unexpected call (no notification)");
    }

    public void updateRequestSetting(int n, int n2, int n3) {
        this.log.log(100000, "DataConfigurationDefaultListener#updateRequestSetting(): unexpected call (no notification)");
    }

    public void updateRoamingState(int n, int n2) {
        this.log.log(100000, "DataConfigurationDefaultListener#updateRoamingState(): unexpected call (no notification)");
    }
}

