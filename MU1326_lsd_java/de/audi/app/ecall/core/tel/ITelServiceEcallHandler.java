/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.tel;

import de.audi.atip.interapp.phone.ITelServiceEcallListener;

public interface ITelServiceEcallHandler {
    public void hangupAllCalls(ITelServiceEcallListener var1);

    public void hangupAllCalls();
}

