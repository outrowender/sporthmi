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

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "DataConfigurationDefaultListener#asyncException(): error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void acceptDataRequestResponse(int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#acceptDataRequestResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#automaticProfileResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void resetPacketCounterResponse(int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#resetPacketCounterResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#restoreFactorySettingsResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void setConnectionModeResponse(int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#setConnectionModeResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#setDataProfileResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void setRequestSettingResponse(int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#setRequestSettingResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void setRoamingStateResponse(int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#setRoamingStateResponse(): Expected to be handled by a Command!");
    }

    @Override
    public void updateActiveProfile(int n, int n2) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updateActiveProfile(): unexpected call (no notification)");
    }

    @Override
    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updateAvailableProfiles(): unexpected call (no notification)");
    }

    @Override
    public void updateConnectionMode(int n, int n2) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updateConnectionMode(): unexpected call (no notification)");
    }

    @Override
    public void updateDataRequest(int n, int n2) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updateDataRequest(): unexpected call (no notification)");
    }

    @Override
    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updatePacketCounter(): unexpected call (no notification)");
    }

    @Override
    public void updateRequestSetting(int n, int n2, int n3) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updateRequestSetting(): unexpected call (no notification)");
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        this.log.log(-1601830656, "DataConfigurationDefaultListener#updateRoamingState(): unexpected call (no notification)");
    }
}

