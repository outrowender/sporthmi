/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2SwdlDiagServiceC {
    public void responseErrorSwdl(sClientResponseError var1) throws MethodException;

    public void responseModuleVersionNumbers(sModuleVersionNumbers var1) throws MethodException;
}

