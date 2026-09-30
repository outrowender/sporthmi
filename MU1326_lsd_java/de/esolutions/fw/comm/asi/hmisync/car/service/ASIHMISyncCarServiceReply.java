/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.service.AdBlueInfo;
import de.esolutions.fw.comm.asi.hmisync.car.service.OilLevelData;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAOilInspection;
import de.esolutions.fw.comm.asi.hmisync.car.service.SIAServiceData;
import de.esolutions.fw.comm.asi.hmisync.car.service.TireDisplayData;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarServiceReply {
    public static final String IPL_COMM_UUID = "7a1486d5-f261-4cc0-a776-d22b0205f993";
    public static final String IPL_COMM_INTERFACE_KEY = "7a22b628-8259-5dd8-ab90-23654e8883e0";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateOilLevelData(OilLevelData var1, boolean var2) throws MethodException;

    public void updateOilLevelDataVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateAdBlueInfo(AdBlueInfo var1, boolean var2) throws MethodException;

    public void updateAdBlueInfoVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateSIAOilInspection(SIAOilInspection var1, boolean var2) throws MethodException;

    public void updateSIAOilInspectionVisibilityState(int[] var1, boolean var2) throws MethodException;

    public void updateSIAServiceData(SIAServiceData var1, boolean var2) throws MethodException;

    public void updateSIAServiceDataVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateVinData(String var1, boolean var2) throws MethodException;

    public void updateVinDataVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateKeyData(int[] var1, boolean var2) throws MethodException;

    public void updateKeyDataVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateTireDisplayData(TireDisplayData var1, boolean var2) throws MethodException;

    public void updateTireDisplayDataVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateTireSystem(int var1, boolean var2) throws MethodException;

    public void updateVehicleSpeedVisibility(int var1, boolean var2) throws MethodException;

    public void updateVehicleSpeed(FloatBaseType var1, boolean var2) throws MethodException;
}

