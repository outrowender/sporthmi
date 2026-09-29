/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusCallbackListener;

public interface IPLAStatusListener {
    default public void updatePLAStatusIdleMode() {
    }

    default public void updatePLAStatusStandbyMode(IPLAStatus iPLAStatus) {
    }

    default public void updatePLAStatusSearchMode(IPLAStatus iPLAStatus) {
    }

    default public void updatePLAStatusInSelectionMode(IPLAStatus iPLAStatus) {
    }

    default public void updatePLAStatusOutSelectionMode(IPLAStatus iPLAStatus) {
    }

    default public void updatePLAStatusParkInActive(IPLAStatus iPLAStatus) {
    }

    default public void updatePLAStatusParkOutActive(IPLAStatus iPLAStatus) {
    }

    default public void registerCallbackListener(IPLAStatusCallbackListener iPLAStatusCallbackListener) {
    }

    default public void unregisterCallbackListener(IPLAStatusCallbackListener iPLAStatusCallbackListener) {
    }
}

