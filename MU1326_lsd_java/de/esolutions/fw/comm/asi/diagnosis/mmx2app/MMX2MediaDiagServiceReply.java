/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2MediaDiagServiceReply {
    public static final String IPL_COMM_UUID = "4c311096-2484-4cc9-acaf-f8abcdb758e6";
    public static final String IPL_COMM_INTERFACE_KEY = "dccdf0f3-38de-548c-a50c-274e448a5cd3";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.6.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestSubsystemState(long var1) throws MethodException;

    public void requestMediaDBVersion(long var1) throws MethodException;

    public void requestActiveMediaSourceState(long var1, int var3) throws MethodException;

    public void requestMediaRegionCodes(long var1) throws MethodException;

    public void requestMediaTypeOpticalDrive(long var1) throws MethodException;

    public void requestUsbOvercurrent(long var1) throws MethodException;

    public void requestPmlState(long var1) throws MethodException;

    public void requestSparePartNumberMediaDB(long var1) throws MethodException;

    public void requestApplicationSoftwareVersionNumberMediaDB(long var1) throws MethodException;

    public void requestSerialNumberMediaDB(long var1) throws MethodException;

    public void requestSystemNameMediaDB(long var1) throws MethodException;

    public void requestStatusUSBCommunication(long var1) throws MethodException;

    public void requestUSBHubIdentification(long var1) throws MethodException;

    public void requestDTCPEncryptionState(long var1) throws MethodException;

    public void requestDTCPKeytypeMMX(long var1) throws MethodException;

    public void requestDTCPSRMInfo(long var1) throws MethodException;
}

