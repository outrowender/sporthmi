/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceReply;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2AppDtcTestServiceS {
    public void registerForDiagnosis(int var1, long[] var2, MMX2AppDtcTestServiceReply var3) throws MethodException;

    public void deregisterForDiagnosis(MMX2AppDtcTestServiceReply var1) throws MethodException;

    public void testStatus(sTestStatus var1, MMX2AppDtcTestServiceReply var2) throws MethodException;
}

