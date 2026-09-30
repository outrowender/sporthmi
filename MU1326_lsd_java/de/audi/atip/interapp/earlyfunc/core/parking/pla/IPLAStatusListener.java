/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.earlyfunc.core.parking.pla;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;
import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatusCallbackListener;

public interface IPLAStatusListener {
    public void updatePLAStatusIdleMode();

    public void updatePLAStatusStandbyMode(IPLAStatus var1);

    public void updatePLAStatusSearchMode(IPLAStatus var1);

    public void updatePLAStatusInSelectionMode(IPLAStatus var1);

    public void updatePLAStatusOutSelectionMode(IPLAStatus var1);

    public void updatePLAStatusParkInActive(IPLAStatus var1);

    public void updatePLAStatusParkOutActive(IPLAStatus var1);

    public void registerCallbackListener(IPLAStatusCallbackListener var1);

    public void unregisterCallbackListener(IPLAStatusCallbackListener var1);
}

