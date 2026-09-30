/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPFunctionStatusListener {
    public void notifyStatusIndicationReceived(int var1, StatusProperty var2);
}

