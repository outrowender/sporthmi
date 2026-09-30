/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.ooc.sTemperatureMMX;
import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2OocDiagServiceS {
    public void responseErrorOoc(sClientResponseError var1, MMX2OocDiagServiceReply var2) throws MethodException;

    public void responseTemperatureMMX(sTemperatureMMX var1, MMX2OocDiagServiceReply var2) throws MethodException;

    public void responseDeleteMemory(sRoutineResponse var1, MMX2OocDiagServiceReply var2) throws MethodException;
}

