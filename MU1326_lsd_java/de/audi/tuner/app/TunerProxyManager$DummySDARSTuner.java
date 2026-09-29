/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.phone.ITelService;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager$1;
import de.audi.tuner.app.TunerProxyManager$DummySDARSTuner$1;
import de.audi.tuner.app.TunerProxyManager$DummySDARSTuner$2;
import de.audi.tuner.app.TunerProxyManager$DummySDARSTuner$3;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SDARSStatusManager;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSSeekListener;

class TunerProxyManager$DummySDARSTuner
extends DefaultChoiceListener
implements ISDARSTuner,
ITunerGUIHandler,
IStationListHandler {
    private TunerProxyManager$DummySDARSTuner() {
    }

    @Override
    public void register(ISearchBreak iSearchBreak, int n) {
    }

    @Override
    public void register(IDrawerFocusManager iDrawerFocusManager) {
    }

    @Override
    public void clearNotification(int[] nArray) {
    }

    @Override
    public void deinit() {
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
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
    }

    @Override
    public int init() {
        return 0;
    }

    @Override
    public void initSeek() {
    }

    @Override
    public void resetToDefaultSettings() {
    }

    @Override
    public void sdarsSelected(StationInfoExt stationInfoExt, int n) {
    }

    @Override
    public void seekStation(int n, int n2) {
    }

    @Override
    public void selectStation(StationInfoExt stationInfoExt, int n) {
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
    public void audioManagementJustBecameAvailable() {
    }

    @Override
    public SDARSAdvisoryHandler getAdvisoryHandler() {
        return null;
    }

    @Override
    public SDARSStatusManager getStatusManager() {
        return null;
    }

    @Override
    public AlertHandler getAlertHandler() {
        return null;
    }

    @Override
    public boolean tuneById(long l, int n) {
        return false;
    }

    @Override
    public TunerObjectContainer[] getStationList() {
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
    public PdtInfoHandler getPdtHandler() {
        return null;
    }

    @Override
    public boolean isDeviceInUse() {
        return false;
    }

    @Override
    public void register(DSIListener dSIListener) {
    }

    @Override
    public void register(ITaggingManager iTaggingManager) {
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
    public void initSetup() {
    }

    @Override
    public DSISDARSSeekListener getSeekListener() {
        return null;
    }

    @Override
    public StationInfoExt getActiveStation() {
        return new StationInfoExt();
    }

    @Override
    public void setPhoneService(ITelService iTelService) {
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        return null;
    }

    @Override
    public IPrevNext getPrevNextHandler() {
        return null;
    }

    @Override
    public SDARSDSISeekDownManager getDsiSeekDownManager() {
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
    public void setPrefImgType(int n) {
    }

    @Override
    public void setHmiReady() {
    }

    @Override
    public boolean isEnsemble(int n) {
        return false;
    }

    @Override
    public SDARSEPGHandler getSdarsEpgHandler() {
        return null;
    }

    @Override
    public void performLanguageChange() {
    }

    @Override
    public IPowerEvent getPoPowerStateListener() {
        return new TunerProxyManager$DummySDARSTuner$1(this);
    }

    @Override
    public TunerActionProxyListener[] getActionProxyListeners() {
        return new TunerActionProxyListener[0];
    }

    @Override
    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return null;
    }

    @Override
    public IDoTagging getTagging() {
        return new TunerProxyManager$DummySDARSTuner$2(this);
    }

    @Override
    public TunerObjectContainer getNextChannelByGenre(short s) {
        return null;
    }

    @Override
    public void reRequestCoverArt() {
    }

    @Override
    public SDARSManTune getManualTuneHandler() {
        return null;
    }

    @Override
    public SDARSStationDescriptions getSdarsStationDescriptions() {
        return null;
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new TunerProxyManager$DummySDARSTuner$3(this);
    }

    /* synthetic */ TunerProxyManager$DummySDARSTuner(TunerProxyManager$1 tunerProxyManager$1) {
        this();
    }
}

