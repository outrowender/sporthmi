/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.networking;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;

public interface DSIDataConfigurationListener
extends DSIListener {
    public void updateAvailableProfiles(CDataProfile[] var1, int var2);

    public void updateActiveProfile(int var1, int var2);

    public void updateRoamingState(int var1, int var2);

    public void updateConnectionMode(int var1, int var2);

    public void updateDataRequest(int var1, int var2);

    public void updateRequestSetting(int var1, int var2, int var3);

    public void setDataProfileResponse(CDataProfile var1, int var2);

    public void automaticProfileResponse(int var1, CDataProfile var2, int var3);

    public void setRoamingStateResponse(int var1);

    public void setConnectionModeResponse(int var1);

    public void setRequestSettingResponse(int var1);

    public void acceptDataRequestResponse(int var1);

    public void resetPacketCounterResponse(int var1);

    public void restoreFactorySettingsResponse(int var1);

    public void updatePacketCounter(CPacketCounter var1, int var2);
}

