/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2AppDtcTestServiceC {
    public void registerForDiagnosis(int var1, long[] var2) throws MethodException;

    public void deregisterForDiagnosis() throws MethodException;

    public void testStatus(sTestStatus var1) throws MethodException;
}

