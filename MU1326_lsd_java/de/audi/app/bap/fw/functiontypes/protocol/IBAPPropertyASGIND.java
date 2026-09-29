/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPPropertyASGIND {
    default public void statusIND(StatusProperty statusProperty) {
    }

    default public void statusAckIND(StatusAckProperty statusAckProperty) {
    }
}

