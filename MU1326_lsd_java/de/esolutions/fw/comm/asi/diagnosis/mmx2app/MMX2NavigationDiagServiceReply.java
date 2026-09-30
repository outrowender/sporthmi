/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2NavigationDiagServiceReply {
    public static final String IPL_COMM_UUID = "128c33a5-671a-49e8-911b-ee23a09bcd10";
    public static final String IPL_COMM_INTERFACE_KEY = "8040a0cc-a4ea-5c17-8a45-3b275afe913b";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestSubsystemState(long var1) throws MethodException;

    public void requestVersionsNavDB(long var1) throws MethodException;

    public void requestActiveNavDB(long var1) throws MethodException;

    public void requestGPSNoSatellite(long var1) throws MethodException;

    public void requestGPSOffroad(long var1) throws MethodException;

    public void requestNavCalibrationState(long var1) throws MethodException;

    public void requestNavCorrectedPosition(long var1) throws MethodException;

    public void requestNavCorrectedDirection(long var1) throws MethodException;

    public void requestResetCalibration(long var1, int var3) throws MethodException;

    public void requestSparePartNumberNavDB(long var1) throws MethodException;

    public void requestApplicationSoftwareVersionNumberNavDB(long var1) throws MethodException;

    public void requestHardwareNumberNavDB(long var1) throws MethodException;

    public void requestHardwareVersionNumberNavDB(long var1) throws MethodException;

    public void requestSerialNumberNavDB(long var1) throws MethodException;

    public void requestSystemNameNavDB(long var1) throws MethodException;

    public void requestCountryRegionVersion(long var1) throws MethodException;
}

