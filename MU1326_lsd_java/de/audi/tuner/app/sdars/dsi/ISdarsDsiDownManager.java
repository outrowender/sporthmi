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
    public void reNotification(int var1);

    public void register(RadioInfo var1);

    public void setNotification(int[] var1, DSIListener var2);

    public void setHmiReady();

    public void clearNotification(int[] var1, DSIListener var2);

    public boolean isDsiFound();

    public void setDeviceService(DSISDARSTuner var1);

    public void reset(int var1);

    public void selectStation(StationInfoExt var1, int var2);

    public void getTime();

    public void getEPG24Hour(int var1);

    public void getEPGDescription(int var1, int var2);

    public SDARSDsiUpInfo getDsiUpListener();
}

