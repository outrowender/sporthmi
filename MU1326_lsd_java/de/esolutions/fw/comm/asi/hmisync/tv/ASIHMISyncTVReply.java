/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncTVReply {
    public static final String IPL_COMM_UUID = "f3fc2e4b-d25f-4479-9da4-6be3da7c1a1e";
    public static final String IPL_COMM_INTERFACE_KEY = "7b078b73-244f-5129-b88a-1c945501d223";
    public static final String IPL_COMM_INTERFACE_VERSION = "3.4.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateStationInfo(StationInfo[] var1, boolean var2) throws MethodException;

    public void updateActiveStationInfo(ActiveStationInfo var1, boolean var2) throws MethodException;

    public void updateActiveTVStationState(long var1, boolean var3) throws MethodException;

    public void updateTunerConfig(long var1, boolean var3) throws MethodException;

    public void updatePanelKeySet(KeySet[] var1, boolean var2) throws MethodException;

    public void updateSeekStatus(byte var1, boolean var2) throws MethodException;

    public void updateTerminalMode(byte var1, boolean var2) throws MethodException;

    public void updateParentalSettings(ParentalSettings var1, boolean var2) throws MethodException;
}

