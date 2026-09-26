/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IBAPIndicationHandlerMethodFSG {
    default public void processIndicationAbort(BAPFunctionMethodFSG bAPFunctionMethodFSG) {
    }

    default public void processIndicationStartResult(BAPFunctionMethodFSG bAPFunctionMethodFSG, StartResultMethod startResultMethod) {
    }
}

