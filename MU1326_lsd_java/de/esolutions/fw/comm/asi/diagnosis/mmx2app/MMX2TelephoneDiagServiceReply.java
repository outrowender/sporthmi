/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2TelephoneDiagServiceReply {
    public static final String IPL_COMM_UUID = "434ab88c-5027-40eb-92ee-df5658912e1a";
    public static final String IPL_COMM_INTERFACE_KEY = "dd966f77-1703-5382-80a9-c2b428743ae7";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.4.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestSimState(long var1) throws MethodException;

    public void requestNadIMEI(long var1) throws MethodException;

    public void requestTelephoneAntennaState(long var1, int var3) throws MethodException;

    public void requestConnectedBtHandset(long var1, int var3) throws MethodException;

    public void requestNumberHandsetsHUCs(long var1) throws MethodException;

    public void requestTelephoneNetworkState(long var1) throws MethodException;

    public void requestTelephoneTemperature(long var1) throws MethodException;

    public void requestDeleteMemory(long var1, int var3) throws MethodException;

    public void requestNetworkName(long var1) throws MethodException;

    public void requestNetworkType(long var1) throws MethodException;

    public void requestDialNumber(long var1, String var3) throws MethodException;

    public void requestCallStatus(long var1) throws MethodException;

    public void requestInternalSimIdentification(long var1) throws MethodException;
}

