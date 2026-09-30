/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;

public interface IAmFmDsiDownManager {
    public void isOnPreset(int var1, int var2, int var3, String var4);

    public void enableRadiotextPlus(int[] var1);

    public AMFMDsiUpInfo getDsiUpListener();

    public void register(RadioInfo var1);

    public void forceAMUpdate(int var1);

    public void switchAF(boolean var1);

    public void switchREG(int var1);

    public void tuneStation(AMFMStation var1, boolean var2, boolean var3, int var4);

    public void clearNotification(int[] var1, DSIListener var2);

    public void setNotification(int[] var1, DSIListener var2);

    public void reNotification(int var1);

    public void switchRDSIgnore(boolean var1);

    public boolean isDsiFound();

    public void reset(int var1);

    public void seekStation(int var1);

    public void switchLinkingDeviceUsage(int var1);

    public void setDeviceService(DSIAMFMTuner var1);

    public void setERTPrefered(boolean var1);

    public void setERTDisplayable(boolean var1);

    public void setModeHD(int var1);
}

