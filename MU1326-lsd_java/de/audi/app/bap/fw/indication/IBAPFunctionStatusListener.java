/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.indication;

import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPFunctionStatusListener {
    default public void notifyStatusIndicationReceived(int n, StatusProperty statusProperty) {
    }
}

