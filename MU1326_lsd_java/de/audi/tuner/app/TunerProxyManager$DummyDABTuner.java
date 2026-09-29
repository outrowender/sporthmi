/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager$1;
import de.audi.tuner.app.TunerProxyManager$DummyDABTuner$1;
import de.audi.tuner.app.TunerProxyManager$DummyDABTuner$2;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerDABGUIHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;
import de.audi.tuner.itunes.ITaggingManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

class TunerProxyManager$DummyDABTuner
extends DefaultChoiceListener
implements IDABTuner,
ITunerDABGUIHandler,
IStationListHandler {
    private TunerProxyManager$DummyDABTuner() {
    }

    @Override
    public void register(ISearchBreak iSearchBreak, int n) {
    }

    @Override
    public void register(ITaggingManager iTaggingManager) {
    }

    @Override
    public void register(IDrawerFocusManager iDrawerFocusManager) {
    }

    @Override
    public void clearNotification(int[] nArray) {
    }

    @Override
    public void reNotification(int n) {
    }

    @Override
    public void dabSelected(DabStation dabStation, int n) {
    }

    @Override
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
    }

    @Override
    public void deinit() {
    }

    @Override
    public int getCurSyncState() {
        return 4;
    }

    @Override
    public boolean isDsiFound() {
        return false;
    }

    @Override
    public ITunerGUIHandler getGUIHandler() {
        return this;
    }

    @Override
    public IStationListHandler getStationListHandler() {
        return this;
    }

    @Override
    public int init() {
        return 0;
    }

    @Override
    public void resetToDefaultSettings() {
    }

    @Override
    public void seekStation(int n, int n2) {
    }

    @Override
    public void setComponentUsage(boolean bl) {
    }

    @Override
    public void setDeviceService(DSIBase dSIBase) {
    }

    @Override
    public void setNotification(int[] nArray) {
    }

    @Override
    public void switchFrequencyTable(int n) {
    }

    @Override
    public void switchLinking(int n) {
    }

    @Override
    public int getCurLinkState() {
        return 1;
    }

    @Override
    public ServiceInfo getActiveService() {
        return null;
    }

    @Override
    public EnsembleInfo getActiveEnsemble() {
        return new EnsembleInfo();
    }

    @Override
    public boolean tuneById(long l, int n) {
        return false;
    }

    @Override
    public void audioManagementJustBecameAvailable() {
    }

    @Override
    public TunerObjectContainer[] getStationList() {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer[] getStationListHierarchical() {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer getCurrentStation() {
        return TunerObjectContainer.EMPTY_CONTAINER;
    }

    @Override
    public boolean forceStationListUpdate(boolean bl) {
        return false;
    }

    @Override
    public TunerObjectContainer[] getStationList(int n) {
        return new TunerObjectContainer[0];
    }

    @Override
    public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    @Override
    public boolean isDeviceInUse() {
        return false;
    }

    @Override
    public void register(DSIListener dSIListener) {
    }

    @Override
    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
    }

    @Override
    public IRadioCmdManager getCmdManager() {
        return null;
    }

    @Override
    public void setComponentUnused() {
    }

    @Override
    public void setInitDone() {
    }

    @Override
    public void executeInitialCommands() {
    }

    @Override
    public ComponentInfo getActiveComponent() {
        return new ComponentInfo();
    }

    @Override
    public void selectStation(DabStation dabStation, int n, int n2) {
    }

    @Override
    public void switchDebugInfos(boolean bl) {
    }

    @Override
    public void abortSeek() {
    }

    @Override
    public void initSetup() {
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        return null;
    }

    @Override
    public DabReceptionStatus prepareReceptionStatus(DabStation dabStation) {
        return new DabReceptionStatus(0, 0);
    }

    @Override
    public DabStation getActiveStation() {
        return new DabStation();
    }

    @Override
    public IPrevNext getPrevNextHandler() {
        return null;
    }

    @Override
    public TunerObjectContainer[] startScan() {
        return new TunerObjectContainer[0];
    }

    @Override
    public void stopScan() {
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
    }

    @Override
    public void register(IGracenoteRequest iGracenoteRequest) {
    }

    @Override
    public void getEPGDetailData(DabStation dabStation) {
    }

    @Override
    public void setPrefImgType(int n) {
    }

    @Override
    public void setSyncLinkState(DabReceptionStatus dabReceptionStatus) {
    }

    @Override
    public boolean isEnsemble(int n) {
        return false;
    }

    @Override
    public TunerActionProxyListener getActionProxyListener() {
        return new TunerActionProxyListener();
    }

    @Override
    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return null;
    }

    @Override
    public void performLanguageChange() {
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return new TunerProxyManager$DummyDABTuner$1(this);
    }

    @Override
    public MessageListener getMessageListener() {
        return new MessageListener();
    }

    @Override
    public void reRequestCoverArt() {
    }

    @Override
    public void setSoftlinking(int n) {
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new TunerProxyManager$DummyDABTuner$2(this);
    }

    /* synthetic */ TunerProxyManager$DummyDABTuner(TunerProxyManager$1 tunerProxyManager$1) {
        this();
    }
}

