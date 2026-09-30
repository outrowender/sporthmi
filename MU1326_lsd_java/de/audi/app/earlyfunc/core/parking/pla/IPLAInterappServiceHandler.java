/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking.pla;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAStatus;

public interface IPLAInterappServiceHandler {
    public void init();

    public void deinit();

    public void updatePLAStatusIdleMode();

    public void updatePLAStatusStandbyMode(IPLAStatus var1);

    public void updatePLAStatusSearchMode(IPLAStatus var1);

    public void updatePLAStatusInSelectionMode(IPLAStatus var1);

    public void updatePLAStatusOutSelectionMode(IPLAStatus var1);

    public void updatePLAStatusParkInActive(IPLAStatus var1);

    public void updatePLAStatusParkOutActive(IPLAStatus var1);
}

