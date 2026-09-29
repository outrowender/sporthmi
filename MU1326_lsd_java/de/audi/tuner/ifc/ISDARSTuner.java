/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.atip.phone.ITelService;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SDARSStatusManager;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.listener.IUpdateListener;
import org.dsi.ifc.sdars.DSISDARSSeekListener;

public interface ISDARSTuner
extends ISimpleTuner {
    default public void selectStation(StationInfoExt stationInfoExt, int n) {
    }

    default public void sdarsSelected(StationInfoExt stationInfoExt, int n) {
    }

    default public SDARSAdvisoryHandler getAdvisoryHandler() {
    }

    default public SDARSStatusManager getStatusManager() {
    }

    default public PdtInfoHandler getPdtHandler() {
    }

    default public DSISDARSSeekListener getSeekListener() {
    }

    default public SDARSEPGHandler getSdarsEpgHandler() {
    }

    default public AlertHandler getAlertHandler() {
    }

    default public StationInfoExt getActiveStation() {
    }

    default public void setPhoneService(ITelService iTelService) {
    }

    default public IPrevNext getPrevNextHandler() {
    }

    default public void setHmiReady() {
    }

    default public TunerActionProxyListener[] getActionProxyListeners() {
    }

    default public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
    }

    default public void initSeek() {
    }

    default public IDoTagging getTagging() {
    }

    default public TunerObjectContainer getNextChannelByGenre(short s) {
    }

    default public SDARSManTune getManualTuneHandler() {
    }

    default public SDARSDSISeekDownManager getDsiSeekDownManager() {
    }

    default public SDARSStationDescriptions getSdarsStationDescriptions() {
    }
}

