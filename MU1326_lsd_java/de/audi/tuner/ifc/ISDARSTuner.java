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
    public void selectStation(StationInfoExt var1, int var2);

    public void sdarsSelected(StationInfoExt var1, int var2);

    public SDARSAdvisoryHandler getAdvisoryHandler();

    public SDARSStatusManager getStatusManager();

    public PdtInfoHandler getPdtHandler();

    public DSISDARSSeekListener getSeekListener();

    public SDARSEPGHandler getSdarsEpgHandler();

    public AlertHandler getAlertHandler();

    public StationInfoExt getActiveStation();

    public void setPhoneService(ITelService var1);

    public IPrevNext getPrevNextHandler();

    public void setHmiReady();

    public TunerActionProxyListener[] getActionProxyListeners();

    public IUpdateListener getUpdateListener(IMemoryList var1);

    public void initSeek();

    public IDoTagging getTagging();

    public TunerObjectContainer getNextChannelByGenre(short var1);

    public SDARSManTune getManualTuneHandler();

    public SDARSDSISeekDownManager getDsiSeekDownManager();

    public SDARSStationDescriptions getSdarsStationDescriptions();
}

