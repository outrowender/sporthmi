/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.epg.sdars.EPGShortInfoExt;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.ISdarsDsiDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager$DsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager$MemoryListener;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager$StationsDatabase;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.ISeekListener;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.SDARSTunerListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekInformation;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.SeekState;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class SDARSDSIUpManager
implements SDARSTunerListener,
ISeekListener {
    public final SDARSDsiDownInfo dsiDownListener = new SDARSDSIUpManager$DsiDownInfo(this, null);
    private StationInfoExt lastDowncall = new StationInfoExt();
    private int selectStatus = 0;
    private boolean waitForTuneRunning = false;
    private SDARSDsiUpInfo[] listeners = new SDARSDsiUpInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final Logger logger;
    private final ISdarsDsiDownManager dsiDownManager;
    private final SDARSDSIUpManager$StationsDatabase stationsDatabase;
    private Object mutex;
    private TunerObjectContainer[] presets = new TunerObjectContainer[0];
    private boolean noSignal;
    private boolean noAudio;
    private SDARSDSISeekDownManager dsiSeekDownManager;

    public SDARSDSIUpManager(TunerBasics tunerBasics, ISdarsDsiDownManager iSdarsDsiDownManager, Object object) {
        this.logger = tunerBasics.getLogger();
        this.dsiDownManager = iSdarsDsiDownManager;
        this.stationsDatabase = new SDARSDSIUpManager$StationsDatabase(tunerBasics);
        this.mutex = object;
    }

    public void register(RadioInfo radioInfo) {
        if (radioInfo instanceof SDARSDsiUpInfo) {
            SDARSDsiUpInfo[] sDARSDsiUpInfoArray = new SDARSDsiUpInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)sDARSDsiUpInfoArray, 0, this.listeners.length);
            sDARSDsiUpInfoArray[this.listeners.length] = (SDARSDsiUpInfo)radioInfo;
            this.listeners = sDARSDsiUpInfoArray;
        } else {
            RadioInfo[] radioInfoArray = new RadioInfo[this.basicListeners.length + 1];
            System.arraycopy((Object)this.basicListeners, 0, (Object)radioInfoArray, 0, this.basicListeners.length);
            radioInfoArray[this.basicListeners.length] = radioInfo;
            this.basicListeners = radioInfoArray;
        }
    }

    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return new SDARSDSIUpManager$MemoryListener(this, iMemoryList);
    }

    @Override
    public void updateElectronicSerialCode(String string) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateElectronicSerialCode(string);
        }
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        boolean bl;
        boolean bl2 = bl = serviceStatus3.audioStatus == 1;
        if (bl != this.noAudio) {
            this.noAudio = bl;
            if (Utilities.isPGen1OrBentley()) {
                this.informNoSignalPorsche();
            }
        }
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateServiceStatus3(serviceStatus3);
        }
    }

    @Override
    public void updateSignalQuality(SignalQuality signalQuality) {
        boolean bl;
        boolean bl2 = bl = signalQuality.compositeQuality == 1;
        if (this.noSignal != bl) {
            this.noSignal = bl;
            if (Utilities.isPGen1OrBentley()) {
                this.informNoSignalPorsche();
            } else {
                this.informNoSignal(this.noSignal);
            }
            if (this.dsiSeekDownManager != null) {
                this.dsiSeekDownManager.setSeekPossibliltyNotification();
            }
        }
    }

    private void informNoSignalPorsche() {
        this.informNoSignal(this.noAudio && this.noSignal);
    }

    private void informNoSignal(boolean bl) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSignalStatus(bl);
        }
        this.doUpdateSelectedStation();
        this.doUpdateStationlist();
    }

    @Override
    public void updateSelectedStation(StationInfo stationInfo) {
        if (stationInfo.stationNumber == 0) {
            this.logger.sdarsDSI.log(-1601830656, "[SDARSDSIUM.updateSelectedStation] received channel 000");
            return;
        }
        this.stationsDatabase.updateSelectedStation(stationInfo);
        this.doUpdateSelectedStation();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doUpdateSelectedStation() {
        Object object = this.mutex;
        synchronized (object) {
            if (this.updateAllowed()) {
                StationInfoExt stationInfoExt = this.stationsDatabase.getSelectedStation();
                stationInfoExt.setAudioOk(!this.noSignal);
                stationInfoExt.setPresetPos(this.getPresetPos(stationInfoExt));
                SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
                for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
                    sDARSDsiUpInfoArray[i2].updateSelectedStation(stationInfoExt);
                }
                RadioInfo[] radioInfoArray = this.basicListeners;
                TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(stationInfoExt);
                for (int i3 = 0; i3 < radioInfoArray.length; ++i3) {
                    radioInfoArray[i3].updateStation(tunerObjectContainer, 0);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean updateAllowed() {
        Object object = this.mutex;
        synchronized (object) {
            return !this.waitForTuneRunning && this.selectStatus != 1 && this.stationsDatabase.isSelectedStationPresent();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationList(StationInfo[] stationInfoArray) {
        Object object = this.mutex;
        synchronized (object) {
            this.stationsDatabase.updateStationInfo(stationInfoArray);
            this.doUpdateStationlist();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doUpdateStationlist() {
        Object object = this.mutex;
        synchronized (object) {
            StationInfoExt[] stationInfoExtArray = this.stationsDatabase.getGaplessStationList();
            if (stationInfoExtArray.length == 0) {
                this.logger.sdarsDSI.log(-1601830656, "[SDARSDSIUM.doUpdateStationlist] ignore empty StationList -> no update");
                return;
            }
            for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
                stationInfoExtArray[i2].setAudioOk(!this.noSignal);
                stationInfoExtArray[i2].setPresetPos(this.getPresetPos(stationInfoExtArray[i2]));
            }
            SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
            for (int i3 = 0; i3 < sDARSDsiUpInfoArray.length; ++i3) {
                sDARSDsiUpInfoArray[i3].updateStationList(stationInfoExtArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getPresetPos(StationInfo stationInfo) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.lastDowncall.getPresetPos() != 0 && this.lastDowncall.sID == stationInfo.sID) {
                return this.lastDowncall.getPresetPos();
            }
            for (int i2 = 0; i2 < this.presets.length; ++i2) {
                if (stationInfo.sID != this.presets[i2].getSDARSService().sID) continue;
                return this.presets[i2].getPresetPos();
            }
        }
        return 0;
    }

    @Override
    public void updateCategoryList(CategoryInfo[] categoryInfoArray) {
        CategoryInfoExt[] categoryInfoExtArray = this.makeCatInfoExt(categoryInfoArray);
        this.stationsDatabase.updateCategoryList(categoryInfoExtArray);
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateCategoryList(categoryInfoExtArray);
        }
        this.doUpdateStationlist();
        this.doUpdateSelectedStation();
    }

    private CategoryInfoExt[] makeCatInfoExt(CategoryInfo[] categoryInfoArray) {
        CategoryInfoExt[] categoryInfoExtArray = new CategoryInfoExt[categoryInfoArray.length];
        for (int i2 = 0; i2 < categoryInfoExtArray.length; ++i2) {
            categoryInfoExtArray[i2] = new CategoryInfoExt(categoryInfoArray[i2], this.getGraceNoteRequest(categoryInfoArray[i2]));
        }
        return categoryInfoExtArray;
    }

    private boolean getGraceNoteRequest(CategoryInfo categoryInfo) {
        String string = categoryInfo.shortLabel;
        String string2 = categoryInfo.fullLabel;
        return !"Traf/Wth".equalsIgnoreCase(string) && !"Traffic/Weather".equalsIgnoreCase(string2) && !"Sports".equalsIgnoreCase(string) && !"Sports".equalsIgnoreCase(string2) && !"Politics".equalsIgnoreCase(string) && !"Politics/Issues".equalsIgnoreCase(string2) && !"News".equalsIgnoreCase(string) && !"News/PublicRadio".equalsIgnoreCase(string2);
    }

    @Override
    public void informationRadioText(RadioText radioText) {
        this.logger.sdarsRadioText.log(14808325, "[SDARSDSIUpManager.informationRadioText] %1", (Object)radioText);
        RadioText[] radioTextArray = new RadioText[]{radioText};
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].informationRadioText2(radioTextArray);
        }
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        if (this.logger.sdarsRadioText.isDebug2()) {
            for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
                this.logger.sdarsRadioText.log(14808325, "[SDARSDSIUpManager.informationRadioText2] %1", (Object)radioTextArray[i2]);
            }
        }
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i3 = 0; i3 < sDARSDsiUpInfoArray.length; ++i3) {
            sDARSDsiUpInfoArray[i3].informationRadioText2(radioTextArray);
        }
    }

    @Override
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.stationsDatabase.informationStationArt(imageInformationArray);
        this.doUpdateStationlist();
        this.doUpdateSelectedStation();
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateStaticTaggingInfo(string, string2);
        }
    }

    @Override
    public void updateDetectedDevice(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateDetectedDevice(n);
        }
    }

    @Override
    public void selectStationStatus(int n) {
        if (this.waitForTuneRunning && n != 1) {
            this.logger.amfmDSI.log(-2137614336, "[SDARSDSIUM.selectStationStatus] ignore status because waiting for status RUNNING");
        } else {
            this.waitForTuneRunning = false;
        }
        this.selectStatus = n;
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].selectStationStatus(n);
        }
        this.doUpdateSelectedStation();
    }

    @Override
    public void updateAvailability(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateAvailability(n);
        }
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateStationDescription(stationDescriptionArray);
        }
    }

    @Override
    public void responseTime(DateTime dateTime) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].responseTime(dateTime);
        }
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSubscriptionStatus(subscriptionStatus);
        }
    }

    @Override
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        EPGShortInfoExt[] ePGShortInfoExtArray = new EPGShortInfoExt[ePGShortInfoArray.length];
        for (int i2 = 0; i2 < ePGShortInfoArray.length; ++i2) {
            ePGShortInfoExtArray[i2] = this.toExt(ePGShortInfoArray[i2]);
        }
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i3 = 0; i3 < sDARSDsiUpInfoArray.length; ++i3) {
            sDARSDsiUpInfoArray[i3].informationEPGChannelList(ePGShortInfoExtArray);
        }
    }

    @Override
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        EPGShortInfoExt ePGShortInfoExt = this.toExt(ePGShortInfo);
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].responseEPG24Hour(ePGShortInfoExt);
        }
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].responseEPGDescription(ePGDescription);
        }
    }

    @Override
    public void updateSeekPossibility(SeekPossibility seekPossibility) {
        if (this.noSignal) {
            seekPossibility.seekState = new SeekState[0];
            seekPossibility.seekInformation = new SeekInformation[0];
        }
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSeekPossibility(seekPossibility);
        }
    }

    @Override
    public void updateSeekList(SeekEntry[] seekEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSeekList(seekEntryArray);
        }
    }

    @Override
    public void updateLeagueList(LeagueEntry[] leagueEntryArray) {
    }

    @Override
    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateTrafficWeatherList(trafficWxEntryArray);
        }
    }

    @Override
    public void updateSeekAlert(SeekAlert seekAlert) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSeekAlert(seekAlert);
        }
    }

    @Override
    public void setSeekCommandResult(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].setSeekCommandResult(n);
        }
    }

    @Override
    public void manageSeekResult(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].manageSeekResult(n);
        }
    }

    @Override
    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].teamsOfLeague(teamEntryArray);
        }
    }

    @Override
    public void leagues(LeagueEntry[] leagueEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].leagues(leagueEntryArray);
        }
    }

    @Override
    public void updateRegisteredTeams(TeamEntry[] teamEntryArray) {
    }

    private EPGShortInfoExt toExt(EPGShortInfo ePGShortInfo) {
        StationInfoExt stationInfoExt = this.stationsDatabase.getStationInfoExtForSID(ePGShortInfo.sID);
        if (stationInfoExt == null) {
            stationInfoExt = new StationInfoExt();
            stationInfoExt.sID = ePGShortInfo.sID;
        }
        return new EPGShortInfoExt(stationInfoExt, ePGShortInfo);
    }

    public void setSeekDownManager(SDARSDSISeekDownManager sDARSDSISeekDownManager) {
        this.dsiSeekDownManager = sDARSDSISeekDownManager;
    }

    static /* synthetic */ Object access$100(SDARSDSIUpManager sDARSDSIUpManager) {
        return sDARSDSIUpManager.mutex;
    }

    static /* synthetic */ boolean access$202(SDARSDSIUpManager sDARSDSIUpManager, boolean bl) {
        sDARSDSIUpManager.waitForTuneRunning = bl;
        return sDARSDSIUpManager.waitForTuneRunning;
    }

    static /* synthetic */ StationInfoExt access$302(SDARSDSIUpManager sDARSDSIUpManager, StationInfoExt stationInfoExt) {
        sDARSDSIUpManager.lastDowncall = stationInfoExt;
        return sDARSDSIUpManager.lastDowncall;
    }

    static /* synthetic */ TunerObjectContainer[] access$402(SDARSDSIUpManager sDARSDSIUpManager, TunerObjectContainer[] tunerObjectContainerArray) {
        sDARSDSIUpManager.presets = tunerObjectContainerArray;
        return tunerObjectContainerArray;
    }

    static /* synthetic */ TunerObjectContainer[] access$400(SDARSDSIUpManager sDARSDSIUpManager) {
        return sDARSDSIUpManager.presets;
    }

    static /* synthetic */ StationInfoExt access$300(SDARSDSIUpManager sDARSDSIUpManager) {
        return sDARSDSIUpManager.lastDowncall;
    }

    static /* synthetic */ ISdarsDsiDownManager access$500(SDARSDSIUpManager sDARSDSIUpManager) {
        return sDARSDSIUpManager.dsiDownManager;
    }
}

