/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio;

import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncRadioReply {
    public static final String IPL_COMM_UUID = "c43514a0-a79e-4e4d-905c-816fe72baa19";
    public static final String IPL_COMM_INTERFACE_KEY = "5825259e-363b-5404-81a4-012a1205c9db";
    public static final String IPL_COMM_INTERFACE_VERSION = "3.3.11";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void stationDetailsUpdated(CurrentStation[] var1) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateBandList(int[] var1, boolean var2) throws MethodException;

    public void updateActiveBand(int var1, boolean var2) throws MethodException;

    public void updateRadioStationList(StationInfo[] var1, boolean var2) throws MethodException;

    public void updateActiveStation(CurrentStation var1, boolean var2) throws MethodException;

    public void updateSeekStatus(int var1, boolean var2) throws MethodException;

    public void updateWavebands(WavebandInfo[] var1, boolean var2) throws MethodException;
}

