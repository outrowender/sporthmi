/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.mmicombi;

import de.audi.atip.mmicombi.exchange.MMICombiPopupStatus;
import de.audi.atip.mmicombi.exchange.MMICombiRequest;
import de.audi.atip.mmicombi.exchange.MMICombiResponse;
import de.audi.atip.mmicombi.exchange.MMICombiStatusUpdate;

public interface IMMICombiListener {
    default public void processCombiRequest(MMICombiRequest mMICombiRequest) {
    }

    default public void processCombiResponse(MMICombiResponse mMICombiResponse) {
    }

    default public void processCombiUpdate(MMICombiStatusUpdate mMICombiStatusUpdate) {
    }

    default public void processCombiPopupStatus(MMICombiPopupStatus mMICombiPopupStatus) {
    }
}

