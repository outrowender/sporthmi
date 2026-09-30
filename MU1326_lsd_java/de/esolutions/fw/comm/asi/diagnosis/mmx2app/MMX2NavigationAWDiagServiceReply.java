/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2NavigationAWDiagServiceReply {
    public static final String IPL_COMM_UUID = "55213c43-0995-4f3c-9f56-08df21a1a0f5";
    public static final String IPL_COMM_INTERFACE_KEY = "aceab9d2-746a-59f3-836b-7e4e2d8af5ed";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestSubsystemStates(long var1) throws MethodException;

    public void requestVersionsNavDB(long var1) throws MethodException;

    public void requestActiveNavDB(long var1) throws MethodException;

    public void requestGPSNoSatellite(long var1) throws MethodException;

    public void requestGPSOffroad(long var1) throws MethodException;

    public void requestNavCalibrationState(long var1) throws MethodException;

    public void requestNavCorrectedPosition(long var1) throws MethodException;

    public void requestNavCorrectedDirection(long var1) throws MethodException;

    public void requestUnitStateDSRC(long var1) throws MethodException;

    public void requestAntennaStateDSRC(long var1) throws MethodException;

    public void requestAntennaStateVICS(long var1) throws MethodException;

    public void requestRadioBeaconStateVICS(long var1) throws MethodException;

    public void requestInfraredBeaconStateVICS(long var1) throws MethodException;

    public void requestResetCalibration(long var1, int var3) throws MethodException;

    public void requestSparePartNumber(long var1, int var3) throws MethodException;

    public void requestApplicationSoftwareVersionNumber(long var1, int var3) throws MethodException;

    public void requestHardwareNumber(long var1, int var3) throws MethodException;

    public void requestHardwareVersionNumber(long var1, int var3) throws MethodException;

    public void requestSerialNumber(long var1, int var3) throws MethodException;

    public void requestSystemName(long var1, int var3) throws MethodException;

    public void requestCountryRegionVersion(long var1) throws MethodException;

    public void requestDeleteMemory(long var1, int var3) throws MethodException;
}

