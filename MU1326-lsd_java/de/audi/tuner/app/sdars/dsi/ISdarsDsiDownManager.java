/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSTuner;

public interface ISdarsDsiDownManager {
    default public void reNotification(int n) {
    }

    default public void register(RadioInfo radioInfo) {
    }

    default public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    default public void setHmiReady() {
    }

    default public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    default public boolean isDsiFound() {
    }

    default public void setDeviceService(DSISDARSTuner dSISDARSTuner) {
    }

    default public void reset(int n) {
    }

    default public void selectStation(StationInfoExt stationInfoExt, int n) {
    }

    default public void getTime() {
    }

    default public void getEPG24Hour(int n) {
    }

    default public void getEPGDescription(int n, int n2) {
    }

    default public SDARSDsiUpInfo getDsiUpListener() {
    }
}

