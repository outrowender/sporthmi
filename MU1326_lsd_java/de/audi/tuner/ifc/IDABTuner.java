/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.listener.IUpdateListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public interface IDABTuner
extends ISimpleTuner {
    public void dabSelected(DabStation var1, int var2);

    public void selectStation(DabStation var1, int var2, int var3);

    public void switchLinking(int var1);

    public void switchFrequencyTable(int var1);

    public int getCurSyncState();

    public int getCurLinkState();

    public ServiceInfo getActiveService();

    public ComponentInfo getActiveComponent();

    public EnsembleInfo getActiveEnsemble();

    public void switchDebugInfos(boolean var1);

    public void abortSeek();

    public DabReceptionStatus prepareReceptionStatus(DabStation var1);

    public DabStation getActiveStation();

    public IPrevNext getPrevNextHandler();

    public void addUpdateListener(IUpdateListener var1);

    public void getEPGDetailData(DabStation var1);

    public TunerActionProxyListener getActionProxyListener();

    public IUpdateListener getUpdateListener(IMemoryList var1);

    public void setSoftlinking(int var1);

    public void reNotification(int var1);
}

