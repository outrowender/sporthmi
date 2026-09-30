/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes.protocol;

import de.vw.mib.bap.requests.StatusAckProperty;
import de.vw.mib.bap.requests.StatusProperty;

public interface IBAPPropertyASGIND {
    public void statusIND(StatusProperty var1);

    public void statusAckIND(StatusAckProperty var1);
}

