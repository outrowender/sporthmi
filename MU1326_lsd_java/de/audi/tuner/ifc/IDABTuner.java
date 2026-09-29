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
    default public void dabSelected(DabStation dabStation, int n) {
    }

    default public void selectStation(DabStation dabStation, int n, int n2) {
    }

    default public void switchLinking(int n) {
    }

    default public void switchFrequencyTable(int n) {
    }

    default public int getCurSyncState() {
    }

    default public int getCurLinkState() {
    }

    default public ServiceInfo getActiveService() {
    }

    default public ComponentInfo getActiveComponent() {
    }

    default public EnsembleInfo getActiveEnsemble() {
    }

    default public void switchDebugInfos(boolean bl) {
    }

    default public void abortSeek() {
    }

    default public DabReceptionStatus prepareReceptionStatus(DabStation dabStation) {
    }

    default public DabStation getActiveStation() {
    }

    default public IPrevNext getPrevNextHandler() {
    }

    default public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    default public void getEPGDetailData(DabStation dabStation) {
    }

    default public TunerActionProxyListener getActionProxyListener() {
    }

    default public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
    }

    default public void setSoftlinking(int n) {
    }

    default public void reNotification(int n) {
    }
}

