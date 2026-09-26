/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.StringDisplayability;
import de.audi.tuner.app.StringDisplayability$Result;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.HdStationInfoExt;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.StationNameHistory;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$DsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$FmCoverArtHandler;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$JpStationNames;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$MemoryListener;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$RsdbResultListener;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager$TimerListener;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.AbstractStationConsistencyCheck;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.dsi.StationConsistencyCheck;
import de.audi.tuner.app.amfm.dsi.StationConsistencyCheckJp;
import de.audi.tuner.app.fonts.FontSelection;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.NullLogoDatabase;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.TagInformation;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public class AMFMDSIUpManager
implements AMFMTunerListener {
    private static final long UPDATE_DELAY_TIME;
    private final Logger logger;
    private final TunerStatus status;
    private final StationNameHistory stationNameHistory;
    private final ChoiceModelApp isRdsOrSignalOk;
    private boolean tuneRunning = false;
    private boolean waitForTuneRunning = false;
    private boolean seekRunning = false;
    private boolean rtReceivedWhileTune;
    private AMFMStation lastStationUpdate = new AMFMStation();
    private AMFMStation lastDowncall = new AMFMStation();
    private HdStationInfoExt hdStInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
    private int lastAudioStatus = 1;
    protected final TunerAudioMgmt audio;
    private final TunerModels models;
    private final RadioTextPlusStorage rtPlusStorage;
    private TunerObjectContainer[] presets = new TunerObjectContainer[0];
    public final AMFMDsiDownInfo dsiDownListener = new AMFMDSIUpManager$DsiDownInfo(this, null);
    public final AMFMDSIUpManager$JpStationNames jpNameListener = new AMFMDSIUpManager$JpStationNames(this);
    private final StringDisplayability stringChecker;
    private final AbstractStationConsistencyCheck consistencyChecker;
    private final IAmFmDsiDownManager dsiDownManager;
    private final ITaggingManager taggingMngr;
    private boolean updateWaiting;
    AMFMDSIUpManager$TimerListener tL = new AMFMDSIUpManager$TimerListener(this, null);
    private final Timer updateDelayTimer = new Timer("updateDelayTimer", 0, true, this.tL);
    private final Timer listRequestTimer = new Timer("listRequestTimer", 0, true, this.tL);
    private AMFMDsiUpInfo[] listeners = new AMFMDsiUpInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final CoverArtHandler coverArt;
    private final Object globalAmFmLock;
    private ILogoDatabase logoDatabase;

    public AMFMDSIUpManager(TunerBasics tunerBasics, IPSFreezeDB iPSFreezeDB, IAmFmDsiDownManager iAmFmDsiDownManager, Object object, ITaggingManager iTaggingManager, TunerAudioMgmt tunerAudioMgmt) {
        this.logger = tunerBasics.getLogger();
        this.status = tunerBasics.getStatus();
        this.dsiDownManager = iAmFmDsiDownManager;
        this.globalAmFmLock = object;
        this.taggingMngr = iTaggingManager;
        this.logoDatabase = new NullLogoDatabase();
        this.stationNameHistory = new StationNameHistory();
        this.coverArt = new AMFMDSIUpManager$FmCoverArtHandler(this, tunerBasics);
        this.isRdsOrSignalOk = tunerBasics.getModels().getChoiceModel(-511115008);
        this.isRdsOrSignalOk.setValue(1);
        this.audio = tunerAudioMgmt;
        this.models = tunerBasics.getModels();
        this.consistencyChecker = Utilities.isJapan() ? new StationConsistencyCheckJp(tunerBasics) : new StationConsistencyCheck(tunerBasics, iPSFreezeDB);
        this.rtPlusStorage = new RadioTextPlusStorage(this.logger.amfmDSI, "FM");
        this.stringChecker = new StringDisplayability();
        this.stringChecker.addLookupTable(FontSelection.getFont());
    }

    public void register(RadioInfo radioInfo) {
        if (radioInfo instanceof AMFMDsiUpInfo) {
            AMFMDsiUpInfo[] aMFMDsiUpInfoArray = new AMFMDsiUpInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)aMFMDsiUpInfoArray, 0, this.listeners.length);
            aMFMDsiUpInfoArray[this.listeners.length] = (AMFMDsiUpInfo)radioInfo;
            this.listeners = aMFMDsiUpInfoArray;
        } else {
            RadioInfo[] radioInfoArray = new RadioInfo[this.basicListeners.length + 1];
            System.arraycopy((Object)this.basicListeners, 0, (Object)radioInfoArray, 0, this.basicListeners.length);
            radioInfoArray[this.basicListeners.length] = radioInfo;
            this.basicListeners = radioInfoArray;
        }
    }

    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return new AMFMDSIUpManager$MemoryListener(this, iMemoryList);
    }

    public void register(IGracenoteRequest iGracenoteRequest) {
        this.coverArt.register(iGracenoteRequest);
    }

    public void setDatabase(ILogoDatabase iLogoDatabase) {
        this.logoDatabase = iLogoDatabase;
    }

    private void requestCoverArt() {
        if (this.lastStationUpdate.isHd()) {
            if (this.hdStInfo.pi == this.lastStationUpdate.pi) {
                this.coverArt.requestCoverArt(this.hdStInfo.artistName, this.hdStInfo.albumTitle, this.hdStInfo.songTitle);
            }
        } else {
            String string = this.rtPlusStorage.getTag(4);
            String string2 = this.rtPlusStorage.getTag(1);
            String string3 = this.rtPlusStorage.getTag(2);
            this.coverArt.requestCoverArt(string, string3, string2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean updateAllowed() {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            return !this.waitForTuneRunning && !this.tuneRunning && !this.seekRunning && this.lastStationUpdate.waveband != 0;
        }
    }

    @Override
    public void updateStationList(Station[] stationArray) {
        this.logList("FM StationList", stationArray);
        this.listRequestTimer.cancel();
        AMFMStation[] aMFMStationArray = this.convertFmStationList(stationArray);
        aMFMStationArray = this.consistencyChecker.checkList(aMFMStationArray);
        aMFMStationArray = this.stationNameHistory.updateStationList(aMFMStationArray);
        this.logoDatabase.requestAmFmData(aMFMStationArray, new AMFMDSIUpManager$RsdbResultListener(this, 2));
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateStationListFM(aMFMStationArray);
        }
    }

    @Override
    public void updateStationListMW(Station[] stationArray) {
        this.logList("AM StationList", stationArray);
        AMFMStation[] aMFMStationArray = this.convertAmStationList(stationArray);
        aMFMStationArray = this.consistencyChecker.checkList(aMFMStationArray);
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateStationListAM(aMFMStationArray);
        }
    }

    @Override
    public void updateStationListLW(Station[] stationArray) {
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateWavebandInfoList(wavebandInfoArray);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            if (this.tuneRunning) {
                this.rtReceivedWhileTune = true;
                return;
            }
            if (this.lastStationUpdate.pi == aMFMRadioText.pi) {
                String string = aMFMRadioText.text.trim();
                aMFMRadioText.text = Utilities.radioTextReplace(string).trim();
                if (aMFMRadioText.text.length() == 0) {
                    this.logger.amfmDSI.log(-1601830656, "[AMFMDSIUM.updateRadioText] received empty text -> ignore");
                    return;
                }
                if (this.isERT(aMFMRadioText.text)) {
                    StringDisplayability$Result stringDisplayability$Result = this.stringChecker.check(aMFMRadioText.text);
                    this.logger.amfmDSI.log(1078071040, "[AMFMDSIUM.updateRadiotext] received eRT: length: %1, #not displayable %2 !", (long)stringDisplayability$Result.length, (long)stringDisplayability$Result.numNotDisplayable);
                    if (stringDisplayability$Result.numNotDisplayable * 100 / stringDisplayability$Result.length >= 10) {
                        this.logger.amfmDSI.log(1078071040, "[AMFMDSIUM.updateRadiotext] eRT not dilplayable");
                        this.dsiDownManager.setERTDisplayable(false);
                        return;
                    }
                }
                if (this.lastStationUpdate.isRds() && !this.lastStationUpdate.isHd()) {
                    this.distributeRadioText(aMFMRadioText);
                    this.distributeRadioTextPlus(new int[]{64}, new String[]{string});
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void distributeRadioText(AMFMRadioText aMFMRadioText) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            for (int i2 = 0; i2 < this.listeners.length; ++i2) {
                this.listeners[i2].updateRadioText(aMFMRadioText);
            }
        }
    }

    private boolean isERT(String string) {
        char c2;
        return string != null && string.length() > 0 && ((c2 = string.charAt(0)) == '\u200e' || c2 == '\u200f');
    }

    @Override
    public void updateAFSwitchStatus(boolean bl) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateAFSwitchStatus(bl);
        }
    }

    @Override
    public void updateREGSwitchStatus(int n) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateREGSwitchStatus(n);
        }
    }

    @Override
    public void updateLinkingUsageStatus(int n) {
    }

    @Override
    public void updateDetectedDevice(int n) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateDetectedDevice(n);
        }
    }

    @Override
    public void tuneFrequencyStepsStatus(int n) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void selectStationStatus(int n) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            int n2;
            if (this.waitForTuneRunning && n != 1) {
                this.logger.amfmDSI.log(-2137614336, "[AMFMDSIUM.selectStationStatus] ignore status because waiting for status RUNNING");
            } else {
                this.waitForTuneRunning = false;
            }
            boolean bl = this.tuneRunning = this.waitForTuneRunning || n == 1;
            if (this.tuneRunning && this.seekRunning) {
                this.seekRunning = false;
                this.logger.amfmDSI.log(10000, "[AMFMDSIUM.selectStationStatus] RUNNING received while seek running");
            }
            AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
            for (n2 = 0; n2 < aMFMDsiUpInfoArray.length; ++n2) {
                aMFMDsiUpInfoArray[n2].selectStationStatus(n);
            }
            if (!this.waitForTuneRunning) {
                this.doUpdateSelectedStation();
                if (!this.tuneRunning && !this.seekRunning && this.rtReceivedWhileTune) {
                    this.rtReceivedWhileTune = false;
                    this.dsiDownManager.reNotification(6);
                }
                if (n == 2) {
                    boolean bl2;
                    n2 = this.models.getActiveTuner();
                    boolean bl3 = bl2 = n2 == 4 || n2 == 1 || n2 == 10;
                    if (bl2) {
                        this.audio.demute();
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void selectFrequencyStatus(int n) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            if (this.waitForTuneRunning && n != 1) {
                this.logger.amfmDSI.log(-2137614336, "[AMFMDSIUM.selectStationStatus] ignore status because waiting for status RUNNING");
            } else {
                this.waitForTuneRunning = false;
            }
            boolean bl = this.tuneRunning = this.waitForTuneRunning || n == 1;
            if (this.tuneRunning && this.seekRunning) {
                this.seekRunning = false;
                this.logger.amfmDSI.log(10000, "[AMFMDSIUM.selectFrequencyStatus] RUNNING received while seek running");
            }
            AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
            for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
                aMFMDsiUpInfoArray[i2].selectFrequencyStatus(n);
            }
            if (!this.waitForTuneRunning) {
                this.doUpdateSelectedStation();
                if (!this.tuneRunning && !this.seekRunning && this.rtReceivedWhileTune) {
                    this.rtReceivedWhileTune = false;
                    this.dsiDownManager.reNotification(6);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void seekStationStatus(int n) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            boolean bl = this.seekRunning = n == 1;
            if (this.seekRunning && this.tuneRunning) {
                this.tuneRunning = false;
                this.logger.amfmDSI.log(10000, "[AMFMDSIUM.seekStationStatus] RUNNING received while tune running");
            }
            AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
            for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
                aMFMDsiUpInfoArray[i2].seekStationStatus(n == 1);
            }
            this.doUpdateSelectedStation();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateRadioTextPlus(int[] nArray, String[] stringArray) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            if (this.lastStationUpdate.isRds() && !this.lastStationUpdate.isHd()) {
                this.distributeRadioTextPlus(nArray, stringArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void distributeRadioTextPlus(int[] nArray, String[] stringArray) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            if (this.updateAllowed()) {
                this.rtPlusStorage.setRadiotextPlus(nArray, stringArray);
                this.updateWaiting = true;
                this.requestCoverArt();
                this.doUpdateSelectedStation();
                AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
                for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
                    aMFMDsiUpInfoArray[i2].updateRadioTextPlus(this.rtPlusStorage);
                }
            }
        }
    }

    @Override
    public void updateSelectedStation(Station station) {
        this.updateSelectedStationHD(station, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedStationHD(Station station, int n) {
        boolean bl = station.rds || station.receptionQuality > 10;
        this.isRdsOrSignalOk.setValue(bl ? 1 : 0);
        Object object = this.globalAmFmLock;
        synchronized (object) {
            boolean bl2;
            if (station.frequency == 0L) {
                this.logger.amfmDSI.log(10000, "[AMFMDSIUM.updateSelectedStation] Station with frequency 0 received");
                return;
            }
            AMFMStation aMFMStation = new AMFMStation(station, n);
            aMFMStation = this.consistencyChecker.checkStation(aMFMStation);
            aMFMStation = this.stationNameHistory.updateActiveStation(aMFMStation);
            this.logger.dd.log(1078071040, "[AMFMDSIUM.updateSelectedStation] (adjusted) %1", (Object)aMFMStation);
            boolean bl3 = bl2 = this.lastStationUpdate.pi != aMFMStation.pi;
            if (bl2 || this.lastStationUpdate.rds && !aMFMStation.rds) {
                this.rtPlusStorage.reset();
            }
            if (bl2 || this.lastStationUpdate.hd && !aMFMStation.hd) {
                this.coverArt.clear();
                this.hdStInfo = ISimpleTuner.EMPTY_HDSTATIONINFO;
                this.dsiDownManager.reNotification(17);
            }
            this.lastStationUpdate = aMFMStation;
            this.updateWaiting = true;
            this.doUpdateSelectedStation();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateHdStatus(int n) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            this.lastAudioStatus = n;
            this.updateWaiting = true;
            this.doUpdateSelectedStation();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doUpdateSelectedStation() {
        AMFMStation aMFMStation = null;
        Object object = null;
        AMFMStation aMFMStation2 = null;
        Object object2 = this.globalAmFmLock;
        synchronized (object2) {
            int n;
            Object object3;
            if (this.updateWaiting && this.updateAllowed()) {
                object3 = new AMFMStation(this.lastStationUpdate);
                ((AMFMStation)object3).setRadioTextPlus(this.rtPlusStorage.getRadioTextPlus());
                ((AMFMStation)object3).setPresetPos(this.getPresetPos(this.lastStationUpdate));
                ((AMFMStation)object3).setCoverArt(this.coverArt.getCoverArt());
                ((AMFMStation)object3).setHdInfo(this.hdStInfo);
                this.logoDatabase.requestAmFmData(new AMFMStation[]{object3}, new AMFMDSIUpManager$RsdbResultListener(this, 1));
                n = ((AMFMStation)object3).hd ? this.lastAudioStatus : 1;
                ((AMFMStation)object3).setAudioStatus(n);
                object = this.lastStationUpdate = object3;
                if (!this.updateDelayTimer.isRunning()) {
                    aMFMStation = this.lastStationUpdate;
                    this.updateWaiting = false;
                }
            } else if (this.updateWaiting && this.seekRunning) {
                aMFMStation2 = this.lastStationUpdate;
            }
            object3 = this.listeners;
            if (object != null) {
                for (n = 0; n < ((AMFMDsiUpInfo[])object3).length; ++n) {
                    ((AMFMDsiUpInfo)object3[n]).updateSelectedStationFast(this.lastStationUpdate);
                }
            }
            if (aMFMStation != null) {
                for (n = 0; n < ((Object)object3).length; ++n) {
                    ((AMFMDsiUpInfo)object3[n]).updateSelectedStation(aMFMStation);
                }
                RadioInfo[] radioInfoArray = this.basicListeners;
                TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(aMFMStation);
                for (int i2 = 0; i2 < radioInfoArray.length; ++i2) {
                    radioInfoArray[i2].updateStation(tunerObjectContainer, 0);
                }
            }
            if (aMFMStation2 != null) {
                for (int i3 = 0; i3 < ((Object)object3).length; ++i3) {
                    ((AMFMDsiUpInfo)object3[i3]).updateSeekStation(aMFMStation2);
                }
            }
        }
    }

    @Override
    public void prepareTuningStatus(int n) {
    }

    @Override
    public void setAMBandRangeStatus(int n) {
    }

    @Override
    public void forceFMUpdateStatus(int n) {
    }

    @Override
    public void updatePiIgnoreSwitchStatus(boolean bl) {
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].forceAMUpdateStatus(n);
        }
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl) {
    }

    @Override
    public void updateMESwitchStatus(boolean bl) {
    }

    @Override
    public void updateHdMode(int n) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateHdMode(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo) {
        int n;
        Object object;
        Object object2;
        HdStationInfoExt hdStationInfoExt = new HdStationInfoExt(this.checkHdInfo(hdStationInfo));
        if (this.taggingMngr.isTaggingSpaceFree()) {
            if (hdStationInfoExt.artistName.length() != 0 && hdStationInfoExt.songTitle.length() != 0) {
                object2 = this.globalAmFmLock;
                synchronized (object2) {
                    object = new AMFMStation(this.lastStationUpdate);
                }
                n = this.taggingMngr.isAlreadyStored(new TagInformation(false, true, hdStationInfoExt.songTitle, hdStationInfoExt.artistName, hdStationInfoExt.iTunesID, Utilities.kHzToMHz(hdStationInfoExt.frequency), ((AMFMStation)object).shortNameHD, hdStationInfoExt.contactURL, new DateTime(0L), hdStationInfoExt.affiliateID, hdStationInfoExt.albumTitle, hdStationInfoExt.iTunesFrontID, hdStationInfoExt.podcastFeedURL, hdStationInfoExt.genre, hdStationInfoExt.unknownData, ((AMFMStation)object).getProgramNr())) ? 3 : 2;
            } else {
                n = 1;
            }
        } else {
            n = 4;
        }
        hdStationInfoExt.setTaggingStatus(n);
        object = this.globalAmFmLock;
        synchronized (object) {
            this.hdStInfo = hdStationInfoExt;
            this.updateWaiting = true;
            this.requestCoverArt();
            this.doUpdateSelectedStation();
            if (hdStationInfoExt.hasSufficientDataForSimulatedRadioText() && !Utilities.isPGen1OrBentley() && (long)hdStationInfoExt.frequency == this.lastStationUpdate.frequency && hdStationInfoExt.serviceId == this.lastStationUpdate.serviceId) {
                object2 = hdStationInfoExt.constructSimulatedRadioText();
                this.distributeRadioText(new AMFMRadioText(this.lastStationUpdate.pi, (String)object2));
                this.distributeRadioTextPlus(new int[]{64}, new String[]{object2});
            }
        }
    }

    private HdStationInfo checkHdInfo(HdStationInfo hdStationInfo) {
        hdStationInfo.artistName = hdStationInfo.artistName == null ? "" : hdStationInfo.artistName.trim();
        hdStationInfo.albumTitle = hdStationInfo.albumTitle == null ? "" : hdStationInfo.albumTitle.trim();
        hdStationInfo.songTitle = hdStationInfo.songTitle == null ? "" : hdStationInfo.songTitle.trim();
        hdStationInfo.shortDescription = hdStationInfo.shortDescription == null ? "" : hdStationInfo.shortDescription.trim();
        hdStationInfo.affiliateID = hdStationInfo.affiliateID == null ? "" : hdStationInfo.affiliateID.trim();
        hdStationInfo.iTunesID = hdStationInfo.iTunesID == null ? "" : hdStationInfo.iTunesID.trim();
        hdStationInfo.coverArt = hdStationInfo.coverArt == null ? new ResourceLocator("") : hdStationInfo.coverArt;
        return hdStationInfo;
    }

    @Override
    public void updateAvailability(int n) {
        AMFMDsiUpInfo[] aMFMDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < aMFMDsiUpInfoArray.length; ++i2) {
            aMFMDsiUpInfoArray[i2].updateAvailability(n);
        }
    }

    @Override
    public void updateElectronicSerialCode(String string) {
    }

    private AMFMStation[] convertFmStationList(Station[] stationArray) {
        ArrayList arrayList = new ArrayList(stationArray.length);
        if (this.status.isFmHdModeOn()) {
            AMFMStation aMFMStation;
            SimpleIntIntMap simpleIntIntMap = new SimpleIntIntMap(stationArray.length);
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                if (stationArray[i2] == null) continue;
                if (stationArray[i2].frequency == 0L || stationArray[i2].waveband != 1) {
                    this.logger.amfmDSI.log(10000, "Wrong station in list: %1", (Object)stationArray[i2]);
                    continue;
                }
                aMFMStation = new AMFMStation(stationArray[i2]);
                aMFMStation.setPresetPos(this.getPresetPos(aMFMStation));
                arrayList.add(aMFMStation);
                int n = simpleIntIntMap.get((int)aMFMStation.frequency);
                if (n == -1) {
                    simpleIntIntMap.add((int)aMFMStation.frequency, aMFMStation.serviceId);
                    continue;
                }
                simpleIntIntMap.add((int)aMFMStation.frequency, n | aMFMStation.serviceId);
            }
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                aMFMStation = (AMFMStation)iterator.next();
                aMFMStation.setHdStructure(simpleIntIntMap.get((int)aMFMStation.frequency));
            }
        } else {
            for (int i3 = 0; i3 < stationArray.length; ++i3) {
                if (stationArray[i3] == null || stationArray[i3].getServiceId() > 1) continue;
                if (stationArray[i3].frequency == 0L || stationArray[i3].waveband != 1) {
                    this.logger.amfmDSI.log(10000, "Wrong station in list: %1", (Object)stationArray[i3]);
                    continue;
                }
                AMFMStation aMFMStation = new AMFMStation(stationArray[i3]);
                aMFMStation.setPresetPos(this.getPresetPos(aMFMStation));
                arrayList.add(aMFMStation);
            }
        }
        return (AMFMStation[])arrayList.toArray(new AMFMStation[arrayList.size()]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getPresetPos(AMFMStation aMFMStation) {
        Object object = this.globalAmFmLock;
        synchronized (object) {
            if (this.lastDowncall.getPresetPos() != 0 && RadioComparators.equals(aMFMStation, this.lastDowncall)) {
                return this.lastDowncall.getPresetPos();
            }
            for (int i2 = 0; i2 < this.presets.length; ++i2) {
                if (!RadioComparators.equals(aMFMStation, this.presets[i2].getAMFMService())) continue;
                return this.presets[i2].getPresetPos();
            }
        }
        return 0;
    }

    private AMFMStation[] convertAmStationList(Station[] stationArray) {
        ArrayList arrayList = new ArrayList(stationArray.length);
        for (int i2 = 0; i2 < stationArray.length; ++i2) {
            if (stationArray[i2] == null) continue;
            if (stationArray[i2].frequency == 0L || stationArray[i2].waveband != 3) {
                this.logger.amfmDSI.log(10000, "Wrong station in list: %1", (Object)stationArray[i2]);
                continue;
            }
            AMFMStation aMFMStation = new AMFMStation(stationArray[i2]);
            aMFMStation.setPresetPos(this.getPresetPos(aMFMStation));
            arrayList.add(aMFMStation);
        }
        return (AMFMStation[])arrayList.toArray(new AMFMStation[arrayList.size()]);
    }

    private void logList(String string, Station[] stationArray) {
        if (this.logger.amfmList.isDebug2()) {
            for (int i2 = 0; i2 < stationArray.length; ++i2) {
                this.logger.amfmList.log(14808325, "%2: %1", (Object)stationArray[i2], (long)i2);
            }
        } else if (this.logger.amfmDSI.isDebug()) {
            Buffer buffer = new Buffer(5000);
            for (int i3 = 0; i3 < stationArray.length; ++i3) {
                buffer.append(stationArray[i3].name).append(';');
                buffer.append(stationArray[i3].frequency).append(';');
                buffer.append("0x").append(Integer.toHexString(stationArray[i3].pi)).append(';');
                buffer.append("rds=").append(stationArray[i3].rds).append(';');
                buffer.append("scroll=").append(stationArray[i3].scrollingPS).append(';');
                buffer.append("hd=").append(stationArray[i3].hd).append(';');
                if (stationArray[i3].hd) {
                    buffer.append("sid=").append(stationArray[i3].serviceId).append(';');
                    buffer.append("short=").append(stationArray[i3].shortNameHD).append(';');
                    buffer.append("long=").append(stationArray[i3].longNameHD).append(';');
                }
                buffer.append("stLogo=").append(stationArray[i3].stationArt != null && stationArray[i3].stationArt.url != null && stationArray[i3].stationArt.url.trim().length() > 0).append(';');
                buffer.append('\n');
            }
            this.logger.amfmDSI.log(-2137614336, "%2:\n%1", (Object)buffer, (Object)string);
        }
    }

    public StationNameHistory getStationNameHistory() {
        return this.stationNameHistory;
    }

    static /* synthetic */ Object access$200(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.globalAmFmLock;
    }

    static /* synthetic */ boolean access$302(AMFMDSIUpManager aMFMDSIUpManager, boolean bl) {
        aMFMDSIUpManager.waitForTuneRunning = bl;
        return aMFMDSIUpManager.waitForTuneRunning;
    }

    static /* synthetic */ AMFMStation access$402(AMFMDSIUpManager aMFMDSIUpManager, AMFMStation aMFMStation) {
        aMFMDSIUpManager.lastDowncall = aMFMStation;
        return aMFMDSIUpManager.lastDowncall;
    }

    static /* synthetic */ RadioTextPlusStorage access$500(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.rtPlusStorage;
    }

    static /* synthetic */ CoverArtHandler access$600(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.coverArt;
    }

    static /* synthetic */ HdStationInfoExt access$702(AMFMDSIUpManager aMFMDSIUpManager, HdStationInfoExt hdStationInfoExt) {
        aMFMDSIUpManager.hdStInfo = hdStationInfoExt;
        return aMFMDSIUpManager.hdStInfo;
    }

    static /* synthetic */ TunerStatus access$800(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.status;
    }

    static /* synthetic */ int access$902(AMFMDSIUpManager aMFMDSIUpManager, int n) {
        aMFMDSIUpManager.lastAudioStatus = n;
        return aMFMDSIUpManager.lastAudioStatus;
    }

    static /* synthetic */ Timer access$1000(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.updateDelayTimer;
    }

    static /* synthetic */ ChoiceModelApp access$1100(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.isRdsOrSignalOk;
    }

    static /* synthetic */ void access$1200(AMFMDSIUpManager aMFMDSIUpManager) {
        aMFMDSIUpManager.doUpdateSelectedStation();
    }

    static /* synthetic */ IAmFmDsiDownManager access$1300(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.dsiDownManager;
    }

    static /* synthetic */ AbstractStationConsistencyCheck access$1400(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.consistencyChecker;
    }

    static /* synthetic */ TunerObjectContainer[] access$1502(AMFMDSIUpManager aMFMDSIUpManager, TunerObjectContainer[] tunerObjectContainerArray) {
        aMFMDSIUpManager.presets = tunerObjectContainerArray;
        return tunerObjectContainerArray;
    }

    static /* synthetic */ TunerObjectContainer[] access$1500(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.presets;
    }

    static /* synthetic */ AMFMStation access$400(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.lastDowncall;
    }

    static /* synthetic */ boolean access$1602(AMFMDSIUpManager aMFMDSIUpManager, boolean bl) {
        aMFMDSIUpManager.updateWaiting = bl;
        return aMFMDSIUpManager.updateWaiting;
    }

    static /* synthetic */ Timer access$1700(AMFMDSIUpManager aMFMDSIUpManager) {
        return aMFMDSIUpManager.listRequestTimer;
    }
}

