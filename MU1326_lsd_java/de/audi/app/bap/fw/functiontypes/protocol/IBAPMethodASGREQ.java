/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.AbortResultMethod;
import de.vw.mib.bap.requests.StartResultMethod;

public interface IBAPMethodASGREQ {
    default public void startResultREQ() {
    }

    default public void startResultREQ(StartResultMethod startResultMethod) {
    }

    default public void startREQ() {
    }

    default public void startREQ(StartResultMethod startResultMethod) {
    }

    default public void abortREQ() {
    }

    default public void abortREQ(AbortResultMethod abortResultMethod) {
    }
}

