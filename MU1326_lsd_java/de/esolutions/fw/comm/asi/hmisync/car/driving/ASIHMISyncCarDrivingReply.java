/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

import de.esolutions.fw.comm.asi.hmisync.car.driving.TADConfiguration;
import de.esolutions.fw.comm.asi.hmisync.car.driving.TADVehicleInfo;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ASIHMISyncCarDrivingReply {
    public static final String IPL_COMM_UUID = "cf0d1065-933d-46b1-baf6-eb334745e56f";
    public static final String IPL_COMM_INTERFACE_KEY = "379cb220-0a06-531f-b0fc-2506d73807a9";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.00";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.00";

    public void updateASIVersion(String var1, boolean var2) throws MethodException;

    public void updateRequestIDs(short[] var1, boolean var2) throws MethodException;

    public void updateReplyIDs(short[] var1, boolean var2) throws MethodException;

    public void updateTADVehicleInfo(TADVehicleInfo var1, boolean var2) throws MethodException;

    public void updateTADConfiguration(TADConfiguration var1, boolean var2) throws MethodException;

    public void updateTADCurrentRollAngle(float var1, boolean var2) throws MethodException;

    public void updateTADPosMaxRollAngle(float var1, boolean var2) throws MethodException;

    public void updateTADNegMaxRollAngle(float var1, boolean var2) throws MethodException;

    public void updateTADCurrentPitchAngle(float var1, boolean var2) throws MethodException;

    public void updateTADPosMaxPitch(float var1, boolean var2) throws MethodException;

    public void updateTADNegMaxPitch(float var1, boolean var2) throws MethodException;

    public void updateTADVisibilityState(int var1, boolean var2) throws MethodException;

    public void updateSuspensionControlCurrentLevel(int var1, boolean var2) throws MethodException;

    public void updateSuspensionControlTargetLevel(int var1, boolean var2) throws MethodException;

    public void updateSuspensionVisibilityState(int[] var1, boolean var2) throws MethodException;

    public void updateDriveSelectActiveProfile(int var1, boolean var2) throws MethodException;

    public void updateDriveSelectActiveProfileVisibilityState(int var1, boolean var2) throws MethodException;
}

