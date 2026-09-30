/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2OlsDiagServiceS {
    public void responseErrorOls(sClientResponseError var1, MMX2OlsDiagServiceReply var2) throws MethodException;

    public void responseConnectionState(sConnectionState var1, MMX2OlsDiagServiceReply var2) throws MethodException;

    public void responseActivationState(sActivationState var1, MMX2OlsDiagServiceReply var2) throws MethodException;
}

