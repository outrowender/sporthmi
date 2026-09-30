/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2DisplayManagerDiagServiceC {
    public void responseErrorDisplayManager(sClientResponseError var1) throws MethodException;

    public void responseVideoInputState(sVideoInputState var1) throws MethodException;

    public void responseTrunkOfferFBAS(sTrunkOfferFBAS var1) throws MethodException;
}

