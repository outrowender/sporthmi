/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.mmicombi.exchange.MMICombiPopupRequest;
import de.audi.atip.mmicombi.exchange.MMICombiRequest;
import de.audi.atip.mmicombi.exchange.MMICombiResponse;

public interface IMMICombi {
    public void processMMIRequest(MMICombiRequest var1);

    public void processMMIResponse(MMICombiResponse var1);

    public void processMMIUpdate(MMICombiResponse var1);

    public void processMMIPopupRequest(MMICombiPopupRequest var1);

    public int generateSessionID();

    public void cancelMMIDisplayRequestWatchDog();
}

