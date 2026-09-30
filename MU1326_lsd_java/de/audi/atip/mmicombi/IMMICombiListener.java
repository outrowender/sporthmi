/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.mmicombi.exchange.MMICombiPopupStatus;
import de.audi.atip.mmicombi.exchange.MMICombiRequest;
import de.audi.atip.mmicombi.exchange.MMICombiResponse;
import de.audi.atip.mmicombi.exchange.MMICombiStatusUpdate;

public interface IMMICombiListener {
    public void processCombiRequest(MMICombiRequest var1);

    public void processCombiResponse(MMICombiResponse var1);

    public void processCombiUpdate(MMICombiStatusUpdate var1);

    public void processCombiPopupStatus(MMICombiPopupStatus var1);
}

