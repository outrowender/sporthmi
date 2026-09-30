/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusListener;

public interface IPLAInterappService {
    public void registerStatusListener(IPLAStatusListener var1);

    public void unregisterStatusListener(IPLAStatusListener var1);

    public IPLAStatus getDefaultPLAStatus();
}

