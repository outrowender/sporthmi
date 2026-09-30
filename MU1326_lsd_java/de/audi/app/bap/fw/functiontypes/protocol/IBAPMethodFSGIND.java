/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IBAPMethodFSGIND {
    public void startResultIND(StartResultMethod var1);

    public void startIND(StartResultMethod var1);

    public void abortIND();

    public void abortIND(AbortResultMethod var1);

    public void processingCNF();
}

