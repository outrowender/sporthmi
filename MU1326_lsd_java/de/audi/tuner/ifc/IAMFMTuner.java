/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.listener.IUpdateListener;

public interface IAMFMTuner
extends ISimpleTuner {
    public void changeWaveband(int var1, TunerObjectContainer var2, int var3);

    public void tuneStation(AMFMStation var1, boolean var2, boolean var3, int var4);

    public AMFMStation getActiveStation();

    public AMFMStation getStationWanted();

    public AMFMStation getActiveStation(int var1);

    public void switchAF(boolean var1);

    public void switchReg(boolean var1);

    public void abortSeek();

    public boolean isSeekActive();

    public IUpdateListener[] getUpdateListeners(IMemoryList var1);

    public void reNotification(int var1);

    public TunerActionProxyListener[] getActionProxyListeners();

    public IDoTagging getTagging();

    public IAmFmDsiDownManager getDsiDownManager();

    public void switchHD(boolean var1, boolean var2);
}

