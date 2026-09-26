/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusListener;

public interface IPLAInterappService {
    default public void registerStatusListener(IPLAStatusListener iPLAStatusListener) {
    }

    default public void unregisterStatusListener(IPLAStatusListener iPLAStatusListener) {
    }

    default public IPLAStatus getDefaultPLAStatus() {
    }
}

