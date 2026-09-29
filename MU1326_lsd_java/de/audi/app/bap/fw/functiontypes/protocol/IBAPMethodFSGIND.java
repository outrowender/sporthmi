/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IBAPMethodFSGIND {
    default public void startResultIND(StartResultMethod startResultMethod) {
    }

    default public void startIND(StartResultMethod startResultMethod) {
    }

    default public void abortIND() {
    }

    default public void abortIND(AbortResultMethod abortResultMethod) {
    }

    default public void processingCNF() {
    }
}

