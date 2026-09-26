/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager$1;
import de.audi.tuner.app.TunerProxyManager$DummyUnifiedTuner$1;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

class TunerProxyManager$DummyUnifiedTuner
implements IUnifiedTuner,
IStationListHandler,
ITunerGUIHandler {
    private TunerProxyManager$DummyUnifiedTuner() {
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
    public void setNotification(int[] nArray) {
    }

    @Override
    public void clearNotification(int[] nArray) {
    }

    @Override
    public int init() {
        return 0;
    }

    @Override
    public void initSetup() {
    }

    @Override
    public void setInitDone() {
    }

    @Override
    public void deinit() {
    }

    @Override
    public void executeInitialCommands() {
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
    public void setDeviceService(DSIBase dSIBase) {
    }

    @Override
    public void seekStation(int n, int n2) {
    }

    @Override
    public void resetToDefaultSettings() {
    }

    @Override
    public boolean isDeviceInUse() {
        return false;
    }

    @Override
    public void setComponentUsage(boolean bl) {
    }

    @Override
    public void setComponentUnused() {
    }

    @Override
    public boolean forceStationListUpdate(boolean bl) {
        return false;
    }

    @Override
    public void audioManagementJustBecameAvailable() {
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
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        return null;
    }

    @Override
    public void selectStation(UnifiedStationExt unifiedStationExt, int n) {
    }

    @Override
    public UnifiedStationExt getActiveStation() {
        return null;
    }

    @Override
    public void uniSelected(UnifiedStationExt unifiedStationExt, int n) {
    }

    @Override
    public IStationListHandler getStationListHandler() {
        return this;
    }

    @Override
    public IPrevNext getPrevNextHandler() {
        return null;
    }

    @Override
    public boolean tuneById(long l, int n) {
        return false;
    }

    @Override
    public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    @Override
    public TunerObjectContainer[] startScan() {
        return new TunerObjectContainer[0];
    }

    @Override
    public void stopScan() {
    }

    @Override
    public void register(IGracenoteRequest iGracenoteRequest) {
    }

    @Override
    public void setPrefImgType(int n) {
    }

    @Override
    public void reNotification(int n) {
    }

    @Override
    public boolean isEnsemble(int n) {
        return false;
    }

    @Override
    public void performLanguageChange() {
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return null;
    }

    @Override
    public TunerObjectContainer[] getStationList() {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer[] getStationList(int n) {
        return new TunerObjectContainer[0];
    }

    @Override
    public TunerObjectContainer getCurrentStation() {
        return TunerObjectContainer.EMPTY_CONTAINER;
    }

    @Override
    public void register(IStoreStationHandler iStoreStationHandler) {
    }

    @Override
    public void setSoftlinking(int n) {
    }

    @Override
    public void reRequestCoverArt() {
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new TunerProxyManager$DummyUnifiedTuner$1(this);
    }

    /* synthetic */ TunerProxyManager$DummyUnifiedTuner(TunerProxyManager$1 tunerProxyManager$1) {
        this();
    }
}

