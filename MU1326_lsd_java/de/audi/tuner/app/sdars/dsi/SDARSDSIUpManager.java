/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.epg.sdars.EPGShortInfoExt;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.ISdarsDsiDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.ISeekListener;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.SDARSTunerListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
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
    public final SDARSDsiDownInfo dsiDownListener = new DsiDownInfo();
    private StationInfoExt lastDowncall = new StationInfoExt();
    private int selectStatus = 0;
    private boolean waitForTuneRunning = false;
    private SDARSDsiUpInfo[] listeners = new SDARSDsiUpInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final Logger logger;
    private final ISdarsDsiDownManager dsiDownManager;
    private final StationsDatabase stationsDatabase;
    private Object mutex;
    private TunerObjectContainer[] presets = new TunerObjectContainer[0];
    private boolean noSignal;
    private boolean noAudio;
    private SDARSDSISeekDownManager dsiSeekDownManager;

    public SDARSDSIUpManager(TunerBasics tunerBasics, ISdarsDsiDownManager iSdarsDsiDownManager, Object object) {
        this.logger = tunerBasics.getLogger();
        this.dsiDownManager = iSdarsDsiDownManager;
        this.stationsDatabase = new StationsDatabase(tunerBasics);
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
        return new MemoryListener(iMemoryList);
    }

    public void updateElectronicSerialCode(String string) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateElectronicSerialCode(string);
        }
    }

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

    public void updateSelectedStation(StationInfo stationInfo) {
        if (stationInfo.stationNumber == 0) {
            this.logger.sdarsDSI.log(100000, "[SDARSDSIUM.updateSelectedStation] received channel 000");
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
                this.logger.sdarsDSI.log(100000, "[SDARSDSIUM.doUpdateStationlist] ignore empty StationList -> no update");
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

    public void informationRadioText(RadioText radioText) {
        this.logger.sdarsRadioText.log(100000000, "[SDARSDSIUpManager.informationRadioText] %1", (Object)radioText);
        RadioText[] radioTextArray = new RadioText[]{radioText};
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].informationRadioText2(radioTextArray);
        }
    }

    public void informationRadioText2(RadioText[] radioTextArray) {
        if (this.logger.sdarsRadioText.isDebug2()) {
            for (int i2 = 0; i2 < radioTextArray.length; ++i2) {
                this.logger.sdarsRadioText.log(100000000, "[SDARSDSIUpManager.informationRadioText2] %1", (Object)radioTextArray[i2]);
            }
        }
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i3 = 0; i3 < sDARSDsiUpInfoArray.length; ++i3) {
            sDARSDsiUpInfoArray[i3].informationRadioText2(radioTextArray);
        }
    }

    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.stationsDatabase.informationStationArt(imageInformationArray);
        this.doUpdateStationlist();
        this.doUpdateSelectedStation();
    }

    public void updateStaticTaggingInfo(String string, String string2) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateStaticTaggingInfo(string, string2);
        }
    }

    public void updateDetectedDevice(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateDetectedDevice(n);
        }
    }

    public void selectStationStatus(int n) {
        if (this.waitForTuneRunning && n != 1) {
            this.logger.amfmDSI.log(10000000, "[SDARSDSIUM.selectStationStatus] ignore status because waiting for status RUNNING");
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

    public void updateAvailability(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateAvailability(n);
        }
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateStationDescription(stationDescriptionArray);
        }
    }

    public void responseTime(DateTime dateTime) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].responseTime(dateTime);
        }
    }

    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSubscriptionStatus(subscriptionStatus);
        }
    }

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

    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        EPGShortInfoExt ePGShortInfoExt = this.toExt(ePGShortInfo);
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].responseEPG24Hour(ePGShortInfoExt);
        }
    }

    public void responseEPGDescription(EPGDescription ePGDescription) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].responseEPGDescription(ePGDescription);
        }
    }

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

    public void updateSeekList(SeekEntry[] seekEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSeekList(seekEntryArray);
        }
    }

    public void updateLeagueList(LeagueEntry[] leagueEntryArray) {
    }

    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateTrafficWeatherList(trafficWxEntryArray);
        }
    }

    public void updateSeekAlert(SeekAlert seekAlert) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].updateSeekAlert(seekAlert);
        }
    }

    public void setSeekCommandResult(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].setSeekCommandResult(n);
        }
    }

    public void manageSeekResult(int n) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].manageSeekResult(n);
        }
    }

    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].teamsOfLeague(teamEntryArray);
        }
    }

    public void leagues(LeagueEntry[] leagueEntryArray) {
        SDARSDsiUpInfo[] sDARSDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < sDARSDsiUpInfoArray.length; ++i2) {
            sDARSDsiUpInfoArray[i2].leagues(leagueEntryArray);
        }
    }

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

    static /* synthetic */ TunerObjectContainer[] access$402(SDARSDSIUpManager sDARSDSIUpManager, TunerObjectContainer[] tunerObjectContainerArray) {
        sDARSDSIUpManager.presets = tunerObjectContainerArray;
        return tunerObjectContainerArray;
    }

    private class DsiDownInfo
    extends SDARSDsiDownInfo {
        private DsiDownInfo() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void blockUpdatesForNextTune() {
            Object object = SDARSDSIUpManager.this.mutex;
            synchronized (object) {
                SDARSDSIUpManager.this.waitForTuneRunning = true;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void preTuneAction(StationInfoExt stationInfoExt) {
            Object object = SDARSDSIUpManager.this.mutex;
            synchronized (object) {
                SDARSDSIUpManager.this.waitForTuneRunning = true;
                SDARSDSIUpManager.this.lastDowncall = stationInfoExt;
            }
        }
    }

    private class MemoryListener
    extends DefaultUpdateListener
    implements IUpdateListener {
        private final IMemoryList memory;

        public MemoryListener(IMemoryList iMemoryList) {
            this.memory = iMemoryList;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updatedMemoryList() {
            Object object = SDARSDSIUpManager.this.mutex;
            synchronized (object) {
                SDARSDSIUpManager.access$402(SDARSDSIUpManager.this, this.memory.getList(new int[]{7}));
                boolean bl = false;
                for (int i2 = 0; i2 < SDARSDSIUpManager.this.presets.length; ++i2) {
                    StationInfoExt stationInfoExt = SDARSDSIUpManager.this.presets[i2].getSDARSService();
                    if (!RadioComparators.equals(SDARSDSIUpManager.this.lastDowncall, stationInfoExt) || SDARSDSIUpManager.this.lastDowncall.getPresetPos() != stationInfoExt.getPresetPos()) continue;
                    bl = true;
                    break;
                }
                if (!bl) {
                    SDARSDSIUpManager.this.lastDowncall.setPresetPos(0);
                }
                SDARSDSIUpManager.this.dsiDownManager.reNotification(8);
                SDARSDSIUpManager.this.dsiDownManager.reNotification(9);
            }
        }
    }

    private static class StationsDatabase {
        private final LogChannel lc;
        private StationInfoExt[] stationInfo = new StationInfoExt[0];
        private StationInfoExt[] sIDToStationInfo = new StationInfoExt[384];
        private HMIResourceLocator[] sIDToStationArt = new HMIResourceLocator[384];
        private final Map catNumberToCategory = new HashMap();
        private StationInfoExt selectedStation;

        public StationsDatabase(TunerBasics tunerBasics) {
            this.lc = tunerBasics.getLogger().sdarsDSI;
            Arrays.fill(this.sIDToStationArt, ISimpleTuner.EMPTY_RL);
        }

        public void updateStationInfo(StationInfo[] stationInfoArray) {
            this.stationInfo = new StationInfoExt[stationInfoArray.length];
            this.sIDToStationInfo = new StationInfoExt[384];
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                int n = stationInfoArray[i2].sID;
                StationInfoExt stationInfoExt = new StationInfoExt(stationInfoArray[i2]);
                this.fillInCategoryInfos(stationInfoExt);
                if (stationInfoExt.fullLabel == null || stationInfoExt.shortLabel == null) {
                    String string;
                    this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateStationInfo] name=null for %1", (Object)stationInfoExt);
                    stationInfoExt.fullLabel = string = "Station" + stationInfoExt.stationNumber;
                    stationInfoExt.shortLabel = string;
                }
                this.stationInfo[i2] = stationInfoExt;
                if (StationsDatabase.isSIDValid(n)) {
                    this.sIDToStationInfo[n] = stationInfoExt;
                    this.sIDToStationInfo[n].setStationArt(this.sIDToStationArt[n]);
                    continue;
                }
                this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateStationInfo] invalid sID %1", (long)n);
            }
        }

        public void updateSelectedStation(StationInfo stationInfo) {
            this.selectedStation = new StationInfoExt(stationInfo);
            if (StationsDatabase.isSIDValid(this.selectedStation.sID)) {
                this.selectedStation.setStationArt(this.sIDToStationArt[this.selectedStation.sID]);
            } else {
                this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateSelectedStation] invalid sID %1", (long)this.selectedStation.sID);
            }
            this.fillInCategoryInfos(this.selectedStation);
        }

        public void informationStationArt(ImageInformation[] imageInformationArray) {
            for (int i2 = 0; i2 < imageInformationArray.length; ++i2) {
                int n = imageInformationArray[i2].sID;
                if (StationsDatabase.isSIDValid(n)) {
                    HMIResourceLocator hMIResourceLocator;
                    ResourceLocator resourceLocator = imageInformationArray[i2].getImage();
                    boolean bl = resourceLocator != null && !Utilities.isEmpty(resourceLocator.url);
                    this.sIDToStationArt[n] = hMIResourceLocator = bl ? new HMIResourceLocator(resourceLocator.url) : ISimpleTuner.EMPTY_RL;
                    if (this.sIDToStationInfo[n] == null) continue;
                    this.sIDToStationInfo[n].setStationArt(hMIResourceLocator);
                    continue;
                }
                this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.updateStationArt] invalid sID %1", (long)n);
            }
            if (this.isSelectedStationPresent()) {
                this.selectedStation.setStationArt(this.sIDToStationArt[this.selectedStation.sID]);
            }
        }

        public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
            int n;
            this.catNumberToCategory.clear();
            for (n = 0; n < categoryInfoExtArray.length; ++n) {
                this.catNumberToCategory.put(Util.createInteger(categoryInfoExtArray[n].categoryNumber), categoryInfoExtArray[n]);
            }
            for (n = 0; n < this.stationInfo.length; ++n) {
                this.fillInCategoryInfos(this.stationInfo[n]);
            }
            if (this.isSelectedStationPresent()) {
                this.fillInCategoryInfos(this.selectedStation);
            }
        }

        public StationInfoExt getSelectedStation() {
            return this.selectedStation;
        }

        public boolean isSelectedStationPresent() {
            return this.selectedStation != null;
        }

        public StationInfoExt[] getGaplessStationList() {
            return this.stationInfo;
        }

        public StationInfoExt getStationInfoExtForSID(int n) {
            if (StationsDatabase.isSIDValid(n)) {
                return this.sIDToStationInfo[n];
            }
            this.lc.log(10000, "[SDARSDSIUM.StationsDatabase.getStationInfoExtForSID] invalid sID %1", (long)n);
            return null;
        }

        private void fillInCategoryInfos(StationInfoExt stationInfoExt) {
            CategoryInfoExt categoryInfoExt = (CategoryInfoExt)this.catNumberToCategory.get(Util.createInteger(stationInfoExt.categoryNumber));
            if (categoryInfoExt == null) {
                categoryInfoExt = CategoryInfoExt.EMPTY_CATEGORY;
            }
            stationInfoExt.setCategory(categoryInfoExt);
        }

        private static boolean isSIDValid(int n) {
            return n >= 0 && n < 384;
        }
    }
}

