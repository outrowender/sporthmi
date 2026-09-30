/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2DisplayManagerDiagServiceS {
    public void responseErrorDisplayManager(sClientResponseError var1, MMX2DisplayManagerDiagServiceReply var2) throws MethodException;

    public void responseVideoInputState(sVideoInputState var1, MMX2DisplayManagerDiagServiceReply var2) throws MethodException;

    public void responseTrunkOfferFBAS(sTrunkOfferFBAS var1, MMX2DisplayManagerDiagServiceReply var2) throws MethodException;
}

