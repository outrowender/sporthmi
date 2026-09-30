/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.networking;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;

public interface DSIDataConfigurationReply {
    public static final String IPL_COMM_UUID = "f9fb7e79-4d84-5a34-a680-170dceb55106";
    public static final String IPL_COMM_INTERFACE_KEY = "c8650c36-f6c5-5d60-9989-d1f0620ec7e8";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.14";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.14";

    public void updateAvailableProfiles(CDataProfile[] var1, int var2) throws MethodException;

    public void updateActiveProfile(int var1, int var2) throws MethodException;

    public void updateRoamingState(int var1, int var2) throws MethodException;

    public void updateConnectionMode(int var1, int var2) throws MethodException;

    public void updateDataRequest(int var1, int var2) throws MethodException;

    public void updateRequestSetting(int var1, int var2, int var3) throws MethodException;

    public void setDataProfileResponse(CDataProfile var1, int var2) throws MethodException;

    public void automaticProfileResponse(int var1, CDataProfile var2, int var3) throws MethodException;

    public void setRoamingStateResponse(int var1) throws MethodException;

    public void setConnectionModeResponse(int var1) throws MethodException;

    public void setRequestSettingResponse(int var1) throws MethodException;

    public void acceptDataRequestResponse(int var1) throws MethodException;

    public void resetPacketCounterResponse(int var1) throws MethodException;

    public void restoreFactorySettingsResponse(int var1) throws MethodException;

    public void updatePacketCounter(CPacketCounter var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

