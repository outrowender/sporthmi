/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carvehiclestates.DSICarVehicleStates;

public class NullDSICarVehicleStates
implements DSICarVehicleStates {
    private final LogChannel logChan;

    public NullDSICarVehicleStates(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void setCarMenuState(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }

    public void requestServiceKey(int n) {
        this.logChan.log(1000, "null-call at NullDSICarVehicleStates");
    }
}

