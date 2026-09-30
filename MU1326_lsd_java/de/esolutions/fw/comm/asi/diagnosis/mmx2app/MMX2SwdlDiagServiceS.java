/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.swdl.sModuleVersionNumbers;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2SwdlDiagServiceS {
    public void responseErrorSwdl(sClientResponseError var1, MMX2SwdlDiagServiceReply var2) throws MethodException;

    public void responseModuleVersionNumbers(sModuleVersionNumbers var1, MMX2SwdlDiagServiceReply var2) throws MethodException;
}

