/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2WlanDiagServiceS {
    public void responseErrorWlan(sClientResponseError var1, MMX2WlanDiagServiceReply var2) throws MethodException;

    public void responseWlanProperties(sWlanProperties var1, MMX2WlanDiagServiceReply var2) throws MethodException;

    public void responseSetWlanHotSpotActive(long var1, MMX2WlanDiagServiceReply var3) throws MethodException;

    public void responseWlanHotSpotActive(long var1, boolean var3, MMX2WlanDiagServiceReply var4) throws MethodException;

    public void responseWlanConnectToAP(long var1, MMX2WlanDiagServiceReply var3) throws MethodException;
}

