/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IBAPMethodASGREQ {
    public void startResultREQ();

    public void startResultREQ(StartResultMethod var1);

    public void startREQ();

    public void startREQ(StartResultMethod var1);

    public void abortREQ();

    public void abortREQ(AbortResultMethod var1);
}

