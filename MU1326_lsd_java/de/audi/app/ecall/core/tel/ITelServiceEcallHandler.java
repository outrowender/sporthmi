/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.tel;

import de.audi.atip.interapp.phone.ITelServiceEcallListener;

public interface ITelServiceEcallHandler {
    default public void hangupAllCalls(ITelServiceEcallListener iTelServiceEcallListener) {
    }

    default public void hangupAllCalls() {
    }
}

