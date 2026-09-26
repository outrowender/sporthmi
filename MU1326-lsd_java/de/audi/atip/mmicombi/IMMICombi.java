/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.mmicombi.exchange.MMICombiPopupRequest;
import de.audi.atip.mmicombi.exchange.MMICombiRequest;
import de.audi.atip.mmicombi.exchange.MMICombiResponse;

public interface IMMICombi {
    default public void processMMIRequest(MMICombiRequest mMICombiRequest) {
    }

    default public void processMMIResponse(MMICombiResponse mMICombiResponse) {
    }

    default public void processMMIUpdate(MMICombiResponse mMICombiResponse) {
    }

    default public void processMMIPopupRequest(MMICombiPopupRequest mMICombiPopupRequest) {
    }

    default public int generateSessionID() {
    }

    default public void cancelMMIDisplayRequestWatchDog() {
    }
}

