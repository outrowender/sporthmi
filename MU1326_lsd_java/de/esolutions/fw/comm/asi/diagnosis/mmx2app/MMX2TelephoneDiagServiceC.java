/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sConnectedBtHandset;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNadIMEI;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sSimState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneAntennaState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneNetworkState;
import de.esolutions.fw.comm.asi.diagnosis.telephone.sTelephoneTemperature;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2TelephoneDiagServiceC {
    public void responseErrorTelephone(sClientResponseError var1) throws MethodException;

    public void responseSimState(sSimState var1) throws MethodException;

    public void responseNadIMEI(sNadIMEI var1) throws MethodException;

    public void responseTelephoneAntennaState(sTelephoneAntennaState var1) throws MethodException;

    public void responseConnectedBtHandset(sConnectedBtHandset var1) throws MethodException;

    public void responseNumberHandsetsHUCs(sNumberHandsetsHUCs var1) throws MethodException;

    public void responseTelephoneNetworkState(sTelephoneNetworkState var1) throws MethodException;

    public void responseTelephoneTemperature(sTelephoneTemperature var1) throws MethodException;

    public void responseDeleteMemory(sRoutineResponse var1) throws MethodException;

    public void responseNetworkName(long var1, String var3) throws MethodException;

    public void responseNetworkType(long var1, int var3) throws MethodException;

    public void responseDialNumber(long var1) throws MethodException;

    public void responseCallStatus(long var1, boolean var3) throws MethodException;

    public void responseInternalSimIdentification(long var1, String var3, String var4) throws MethodException;
}

