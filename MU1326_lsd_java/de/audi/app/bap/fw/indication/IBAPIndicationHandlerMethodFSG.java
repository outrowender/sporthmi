/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IBAPIndicationHandlerMethodFSG {
    public void processIndicationAbort(BAPFunctionMethodFSG var1);

    public void processIndicationStartResult(BAPFunctionMethodFSG var1, StartResultMethod var2);
}

