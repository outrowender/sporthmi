/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SSEDiagServiceReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2SSEDiagServiceS {
    public void responseErrorSSE(sClientResponseError var1, MMX2SSEDiagServiceReply var2) throws MethodException;

    public void responseClippingCounterMic1(long var1, long var3, MMX2SSEDiagServiceReply var5) throws MethodException;
}

