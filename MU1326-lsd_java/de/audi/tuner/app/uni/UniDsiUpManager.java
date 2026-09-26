/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.dab.stationlist.DabDummyNames;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniDsiUpManager$DsiDownInfo;
import de.audi.tuner.app.uni.UniDsiUpManager$RsdbResultListener;
import de.audi.tuner.app.uni.UniDsiUpManager$SlsSpeedManager;
import de.audi.tuner.app.uni.UniDsiUpManager$TimerListener;
import de.audi.tuner.app.uni.UniDsiUpManager$UniCoverArtHandler;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.NullLogoDatabase;
import de.audi.tuner.ifc.UnifiedTunerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

class UniDsiUpManager
implements UnifiedTunerListener {
    private static final long UPDATE_DELAY_TIME;
    private static final long LIST_UPDATE_WAIT_TIME;
    final UniDsiDownInfo dsiDownListener = new UniDsiUpManager$DsiDownInfo(this, null);
    private final UniDsiUpManager$SlsSpeedManager slsManager;
    private static final ResourceLocator EMPTY_RESOURCE_LOCATOR;
    private final Logger logger;
    private UniDsiUpInfo[] listeners = new UniDsiUpInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private boolean selectRunning = false;
    private boolean waitForSelectRunning = false;
    private boolean rtReceivedWhileTune;
    private boolean rtEnhReceivedWhileTune;
    private boolean rtPlusReceivedWhileTune;
    private int audioStatus = 1;
    private UnifiedStationExt preSelectedStation = null;
    private UnifiedStationExt lastSelectedStation = null;
    private final Object globalUniLock;
    private final IPSFreezeDB psFreeze;
    private final RadioTextPlusStorage rtPlusStorage;
    UniDsiUpManager$TimerListener tL = new UniDsiUpManager$TimerListener(this, null);
    private final Timer updateDelayTimer = new Timer("updateDelayTimer", 0, true, this.tL);
    private final Timer waitingListTimer = new Timer("waitingListTimer", 0, true, this.tL);
    private final Timer listRequestTimer = new Timer("listRequestTimer", 0, true, this.tL);
    private final CoverArtHandler coverArt;
    private final UnifiedTuner uniTuner;
    private final DabDummyNames dummyNames;
    private UnifiedStationExt[] currentStationList = null;
    private UnifiedStationExt[] waitingStationList = null;
    private ILogoDatabase logoDatabase;
    private boolean noStationListReceived = true;

    UniDsiUpManager(TunerBasics tunerBasics, IPSFreezeDB iPSFreezeDB, UnifiedTuner unifiedTuner, DabDummyNames dabDummyNames, Object object) {
        this.globalUniLock = object;
        this.logger = tunerBasics.getLogger();
        this.psFreeze = iPSFreezeDB;
        this.uniTuner = unifiedTuner;
        this.dummyNames = dabDummyNames;
        this.coverArt = new UniDsiUpManager$UniCoverArtHandler(this, tunerBasics);
        this.slsManager = new UniDsiUpManager$SlsSpeedManager(this, this.logger.uniDSI);
        this.rtPlusStorage = new RadioTextPlusStorage(this.logger.radioText, "Uni");
        this.logoDatabase = new NullLogoDatabase();
    }

    void init() {
        Utilities.getFramework().getSysApp().registerSpeedThresholdListener(this.slsManager, 4);
    }

    void register(RadioInfo radioInfo) {
        if (radioInfo instanceof UniDsiUpInfo) {
            UniDsiUpInfo[] uniDsiUpInfoArray = new UniDsiUpInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)uniDsiUpInfoArray, 0, this.listeners.length);
            uniDsiUpInfoArray[this.listeners.length] = (UniDsiUpInfo)radioInfo;
            this.listeners = uniDsiUpInfoArray;
        } else {
            RadioInfo[] radioInfoArray = new RadioInfo[this.basicListeners.length + 1];
            System.arraycopy((Object)this.basicListeners, 0, (Object)radioInfoArray, 0, this.basicListeners.length);
            radioInfoArray[this.basicListeners.length] = radioInfo;
            this.basicListeners = radioInfoArray;
        }
    }

    void register(IGracenoteRequest iGracenoteRequest) {
        this.coverArt.register(iGracenoteRequest);
    }

    public void setDatabase(ILogoDatabase iLogoDatabase) {
        this.logoDatabase = iLogoDatabase;
    }

    private void requestCoverArt() {
        String string = this.rtPlusStorage.getTag(4);
        String string2 = this.rtPlusStorage.getTag(1);
        String string3 = this.rtPlusStorage.getTag(2);
        this.coverArt.requestCoverArt(string, string3, string2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doUpdateSelectedStation() {
        Object object = this.globalUniLock;
        synchronized (object) {
            if (!this.waitForSelectRunning && !this.selectRunning && this.lastSelectedStation != null) {
                UnifiedStationExt unifiedStationExt = this.checkStation(this.lastSelectedStation);
                unifiedStationExt = this.findAndAddPrimaryService(this.waitingStationList, unifiedStationExt);
                if (unifiedStationExt.ensId == 0 && !unifiedStationExt.rds) {
                    this.rtPlusStorage.reset();
                    this.slsManager.clear();
                    this.coverArt.clear();
                }
                unifiedStationExt.setAudioStatus(this.audioStatus);
                unifiedStationExt.setRadioTextPlus(this.rtPlusStorage.getRadioTextPlus());
                unifiedStationExt.setSlsImage(this.slsManager.getSlsImage());
                unifiedStationExt.setCoverArt(this.coverArt.getCoverArt());
                this.logoDatabase.requestUniData(new UnifiedStationExt[]{unifiedStationExt}, new UniDsiUpManager$RsdbResultListener(this, 1));
                UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
                this.doUpdateStationList(unifiedStationExt);
                if (!this.updateDelayTimer.isRunning()) {
                    for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
                        uniDsiUpInfoArray[i2].updateSelectedStation(unifiedStationExt);
                    }
                    TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(unifiedStationExt);
                    RadioInfo[] radioInfoArray = this.basicListeners;
                    for (int i3 = 0; i3 < radioInfoArray.length; ++i3) {
                        radioInfoArray[i3].updateStation(tunerObjectContainer, 0);
                    }
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doUpdateStationList(UnifiedStationExt unifiedStationExt) {
        this.waitingListTimer.cancel();
        Object object = this.globalUniLock;
        synchronized (object) {
            this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.doUpdateStationList] %1", (Object)unifiedStationExt);
            UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
            if (this.waitingStationList != null) {
                this.currentStationList = this.waitingStationList;
            } else if (this.currentStationList == null) {
                return;
            }
            for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
                uniDsiUpInfoArray[i2].updateStationList(this.currentStationList, unifiedStationExt);
            }
            this.waitingStationList = null;
        }
    }

    private boolean containsListActiveService(UnifiedStationExt[] unifiedStationExtArray, UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt != null) {
            for (int i2 = 0; i2 < unifiedStationExtArray.length; ++i2) {
                if (unifiedStationExtArray[i2].piSId != unifiedStationExt.piSId || unifiedStationExtArray[i2].ensId != unifiedStationExt.ensId || unifiedStationExtArray[i2].ecc != unifiedStationExt.ecc) continue;
                return true;
            }
        }
        return false;
    }

    private boolean containsListActiveComponent(UnifiedStationExt[] unifiedStationExtArray, UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt != null) {
            for (int i2 = 0; i2 < unifiedStationExtArray.length; ++i2) {
                if (!UnifiedStationExt.equals(unifiedStationExt, unifiedStationExtArray[i2])) continue;
                return true;
            }
        }
        return false;
    }

    private UnifiedStationExt[] addItemToList(UnifiedStationExt unifiedStationExt, UnifiedStationExt[] unifiedStationExtArray) {
        if (unifiedStationExt == null) {
            return unifiedStationExtArray;
        }
        this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.addItemToList] added station to uni station list: %1", (Object)unifiedStationExt);
        UnifiedStationExt[] unifiedStationExtArray2 = new UnifiedStationExt[unifiedStationExtArray.length + 1];
        System.arraycopy((Object)unifiedStationExtArray, 0, (Object)unifiedStationExtArray2, 0, unifiedStationExtArray.length);
        unifiedStationExtArray2[unifiedStationExtArray.length] = unifiedStationExt;
        return unifiedStationExtArray2;
    }

    private UnifiedStationExt[] addActiveStationToList(UnifiedStationExt[] unifiedStationExtArray) {
        if (this.preSelectedStation != null) {
            UnifiedStationExt unifiedStationExt;
            if (unifiedStationExtArray == null) {
                unifiedStationExtArray = new UnifiedStationExt[]{};
            }
            if ((unifiedStationExt = this.preSelectedStation).hasPrimaryService()) {
                UnifiedStationExt unifiedStationExt2 = unifiedStationExt.getPrimaryService();
                unifiedStationExt2.setAudioStatus(unifiedStationExt.getAudioStatus());
                if (!this.containsListActiveService(unifiedStationExtArray, unifiedStationExt2)) {
                    unifiedStationExtArray = this.addItemToList(unifiedStationExt2, unifiedStationExtArray);
                }
            }
            if (!this.containsListActiveComponent(unifiedStationExtArray, unifiedStationExt)) {
                unifiedStationExtArray = this.addItemToList(unifiedStationExt, unifiedStationExtArray);
            }
        }
        return unifiedStationExtArray;
    }

    private UnifiedStationExt findAndAddPrimaryService(UnifiedStation[] unifiedStationArray, UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt == null || unifiedStationExt.hasPrimaryService()) {
            return unifiedStationExt;
        }
        if (this.preSelectedStation != null && this.preSelectedStation.hasPrimaryService()) {
            UnifiedStationExt unifiedStationExt2 = this.preSelectedStation.getPrimaryService();
            if (unifiedStationExt2.piSId == unifiedStationExt.piSId) {
                unifiedStationExt.setPrimaryService(unifiedStationExt2);
                return unifiedStationExt;
            }
        }
        if (unifiedStationArray != null && unifiedStationExt != null && unifiedStationExt.sCIDI > 0) {
            for (int i2 = 0; i2 < unifiedStationArray.length; ++i2) {
                if (unifiedStationArray[i2] == null || unifiedStationArray[i2].piSId != unifiedStationExt.piSId || unifiedStationArray[i2].sCIDI != 0) continue;
                unifiedStationExt.setPrimaryService(unifiedStationArray[i2]);
                this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.findAndAddPrimaryService] primary service found and added station component: %1", (Object)unifiedStationExt);
                return unifiedStationExt;
            }
        }
        return unifiedStationExt;
    }

    private UnifiedStationExt[] convertList(UnifiedStation[] unifiedStationArray) {
        ArrayList arrayList = new ArrayList(unifiedStationArray.length);
        for (int i2 = 0; i2 < unifiedStationArray.length; ++i2) {
            if (unifiedStationArray[i2] == null) continue;
            UnifiedStationExt unifiedStationExt = new UnifiedStationExt(unifiedStationArray[i2]);
            unifiedStationExt = this.checkNames(unifiedStationExt);
            unifiedStationExt = this.findAndAddPrimaryService(unifiedStationArray, unifiedStationExt);
            unifiedStationExt = this.checkStation(unifiedStationExt);
            arrayList.add(unifiedStationExt);
        }
        return (UnifiedStationExt[])arrayList.toArray(new UnifiedStationExt[arrayList.size()]);
    }

    private UnifiedStationExt checkStation(UnifiedStationExt unifiedStationExt) {
        String string;
        UnifiedStationExt unifiedStationExt2 = unifiedStationExt;
        String string2 = (unifiedStationExt2.stationLogo = unifiedStationExt2.stationLogo == null ? UniDsiUpManager.EMPTY_RESOURCE_LOCATOR : unifiedStationExt2.stationLogo).url = unifiedStationExt2.stationLogo.url == null ? "" : unifiedStationExt2.stationLogo.url;
        if (unifiedStationExt2.isAnalog() && unifiedStationExt2.longName.length() == 0 && (string = this.psFreeze.getFreezedName(unifiedStationExt2)) != null) {
            unifiedStationExt2.freezePs(string);
        }
        return unifiedStationExt2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void selectStationStatus(int n) {
        UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
            uniDsiUpInfoArray[i2].selectionIsRunning(n == 1);
        }
        Object object = this.globalUniLock;
        synchronized (object) {
            if (this.waitForSelectRunning && n != 1) {
                this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.selectStationStatus] ignore status because waiting for status RUNNING");
                return;
            }
            this.waitForSelectRunning = false;
            this.selectRunning = n == 1;
        }
        this.doUpdateSelectedStation();
        if (this.rtReceivedWhileTune) {
            this.rtReceivedWhileTune = false;
            this.uniTuner.reNotification(5);
        }
        if (this.rtEnhReceivedWhileTune) {
            this.rtEnhReceivedWhileTune = false;
            this.uniTuner.reNotification(6);
        }
        if (this.rtPlusReceivedWhileTune) {
            this.rtPlusReceivedWhileTune = false;
            this.uniTuner.reNotification(7);
        }
    }

    @Override
    public void updateAudioStatus(int n) {
        this.audioStatus = n;
        UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
            uniDsiUpInfoArray[i2].updateAudioStatus(n);
        }
        if (n == 3 || n == 2) {
            this.updateDelayTimer.cancel();
        }
        this.doUpdateSelectedStation();
    }

    @Override
    public void updateDetectedDevice(int n) {
        UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
            uniDsiUpInfoArray[i2].updateDetectedDevice(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSelectedStation(UnifiedStation unifiedStation) {
        UnifiedStationExt unifiedStationExt = new UnifiedStationExt(unifiedStation);
        Object object = this.globalUniLock;
        synchronized (object) {
            unifiedStationExt = this.checkNames(unifiedStationExt);
            unifiedStationExt = this.findAndAddPrimaryService(this.waitingStationList, unifiedStationExt);
            if (unifiedStationExt.hasPrimaryService() && unifiedStationExt.getPrimaryService() != null) {
                unifiedStationExt.setPrimaryService(this.checkNames(unifiedStationExt.getPrimaryService()));
            }
            this.preSelectedStation = unifiedStationExt;
            if (this.isFig06Linking(unifiedStationExt)) {
                this.slsManager.clear();
                this.rtPlusStorage.reset();
                this.coverArt.clear();
            }
            this.lastSelectedStation = unifiedStationExt;
        }
        this.doUpdateSelectedStation();
    }

    private boolean isFig06Linking(UnifiedStation unifiedStation) {
        return this.lastSelectedStation != null && !this.selectRunning && unifiedStation.piSId != this.lastSelectedStation.piSId;
    }

    private UnifiedStationExt checkNames(UnifiedStationExt unifiedStationExt) {
        UnifiedStationExt unifiedStationExt2 = unifiedStationExt;
        unifiedStationExt2.shortName = unifiedStationExt2.shortName == null ? "" : unifiedStationExt2.shortName.trim();
        String string = unifiedStationExt2.longName = unifiedStationExt2.longName == null ? "" : unifiedStationExt2.longName.trim();
        if (unifiedStationExt2.ensId != 0) {
            if (Utilities.isEmpty(unifiedStationExt2.longName) && !Utilities.isEmpty(unifiedStationExt2.shortName)) {
                unifiedStationExt2.longName = Utilities.getShortName(unifiedStationExt2.shortName);
            } else if (Utilities.isEmpty(unifiedStationExt2.shortName) && !Utilities.isEmpty(unifiedStationExt2.longName)) {
                unifiedStationExt2.shortName = Utilities.getShortName(unifiedStationExt2.longName);
            }
            if (unifiedStationExt2.shortName.length() == 0 || unifiedStationExt2.longName.length() == 0) {
                this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.checkNames] empty names received %1", (Object)unifiedStationExt2);
                UnifiedStationExt unifiedStationExt3 = this.uniTuner.getActiveStation();
                if (RadioComparators.equals(unifiedStationExt3, unifiedStationExt2)) {
                    unifiedStationExt2.shortName = unifiedStationExt3.shortName;
                    unifiedStationExt2.longName = unifiedStationExt3.longName;
                    unifiedStationExt2.ptyCodes = unifiedStationExt3.ptyCodes;
                } else {
                    this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.checkNames] station %1 not found \nActive is %2", (Object)unifiedStationExt2, (Object)unifiedStationExt3);
                    if (unifiedStationExt2.sCIDI == 0) {
                        ServiceInfo serviceInfo = this.dummyNames.getDummyServiceName(unifiedStationExt2.piSId);
                        unifiedStationExt2.shortName = serviceInfo.shortName;
                        unifiedStationExt2.longName = serviceInfo.fullName;
                        this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.checkNames] new Name %1 ", (Object)unifiedStationExt2);
                    } else {
                        ComponentInfo componentInfo = this.dummyNames.getDummyComponentName(unifiedStationExt2.piSId, unifiedStationExt2.sCIDI);
                        unifiedStationExt2.shortName = componentInfo.shortName;
                        unifiedStationExt2.longName = componentInfo.fullName;
                    }
                    this.logger.uniDSI.log(-2137614336, "[UniDsiUpManager.checkNames] reproduced station %1 ", (Object)unifiedStationExt2);
                }
            }
        }
        if (this.logger.uniList.isDebug2()) {
            this.logger.uniDSI.log(14808325, "[UniDsiUpManager.checkNames] adjusted station %1", (Object)unifiedStationExt2);
        }
        return unifiedStationExt2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStationList(UnifiedStation[] unifiedStationArray) {
        this.listRequestTimer.cancel();
        if (this.logger.uniList.isDebug2()) {
            for (int i2 = 0; i2 < unifiedStationArray.length; ++i2) {
                this.logger.uniList.log(14808325, "%2: %1", (Object)unifiedStationArray[i2], (long)i2);
            }
        } else if (this.logger.uniDSI.isDebug()) {
            Buffer buffer = new Buffer(5000);
            buffer.append('\n');
            for (int i3 = 0; i3 < unifiedStationArray.length; ++i3) {
                UnifiedStation unifiedStation = unifiedStationArray[i3];
                if (unifiedStation != null) {
                    buffer.append(i3).append(": \"");
                    buffer.append(unifiedStation.shortName).append("\",\"").append(unifiedStation.longName).append("\"");
                    buffer.append(",f=").append(unifiedStation.frequency);
                    buffer.append(",ens=").append(unifiedStation.ensId);
                    buffer.append(",ecc=").append(unifiedStation.ecc);
                    buffer.append(",pi/sdi=").append(unifiedStation.piSId);
                    buffer.append(",scidi=").append(unifiedStation.sCIDI);
                    buffer.append('\n');
                    continue;
                }
                buffer.append(i3).append(": NULL\n");
            }
            this.logger.uniDSI.log(-2137614336, "%1", (Object)buffer);
        }
        UnifiedStationExt[] unifiedStationExtArray = this.convertList(unifiedStationArray);
        unifiedStationExtArray = this.addActiveStationToList(unifiedStationExtArray);
        this.logoDatabase.requestUniData(unifiedStationExtArray, new UniDsiUpManager$RsdbResultListener(this, 2));
        Object object = this.globalUniLock;
        synchronized (object) {
            this.waitingStationList = unifiedStationExtArray;
            if (this.noStationListReceived) {
                this.doUpdateStationList(null);
                this.noStationListReceived = false;
            } else if (!this.waitingListTimer.isRunning()) {
                this.waitingListTimer.start();
            }
        }
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText) {
        if (!this.selectRunning) {
            this.doUpdateRadioText(unifiedRadioText);
        } else {
            this.rtReceivedWhileTune = true;
        }
    }

    @Override
    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText) {
        if (!this.selectRunning) {
            this.doUpdateRadioText(unifiedRadioText);
        } else {
            this.rtEnhReceivedWhileTune = true;
        }
    }

    private void doUpdateRadioText(UnifiedRadioText unifiedRadioText) {
        if (this.lastSelectedStation != null && unifiedRadioText.ensId == this.lastSelectedStation.ensId && unifiedRadioText.ecc == this.lastSelectedStation.ecc && unifiedRadioText.piSId == this.lastSelectedStation.piSId && unifiedRadioText.sCIDI == this.lastSelectedStation.sCIDI) {
            String string = unifiedRadioText.radioText.trim();
            unifiedRadioText.radioText = Utilities.radioTextReplace(string).trim();
            if (unifiedRadioText.radioText.length() == 0) {
                this.logger.uniDSI.log(-1601830656, "[UniDsiUpManager.updateRadioText] received empty text -> ignore");
                return;
            }
            UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
            for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
                uniDsiUpInfoArray[i2].updateRadioText(unifiedRadioText);
            }
            this.updateRadioTextPlus(new UnifiedRadioTextPlus(unifiedRadioText.piSId, unifiedRadioText.ensId, unifiedRadioText.ecc, unifiedRadioText.sCIDI, new int[]{64}, new String[]{string}, 0));
        }
    }

    @Override
    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        if (!this.selectRunning) {
            if (this.lastSelectedStation != null && this.lastSelectedStation.piSId == unifiedRadioTextPlus.piSId && this.lastSelectedStation.ensId == unifiedRadioTextPlus.ensId && this.lastSelectedStation.ecc == unifiedRadioTextPlus.ecc && this.lastSelectedStation.sCIDI == unifiedRadioTextPlus.sCIDI) {
                this.rtPlusStorage.setRadiotextPlus(unifiedRadioTextPlus.tags, unifiedRadioTextPlus.content);
                this.requestCoverArt();
                this.doUpdateSelectedStation();
                UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
                for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
                    uniDsiUpInfoArray[i2].updateRadioTextPlus(this.rtPlusStorage);
                }
            } else {
                this.logger.uniDSI.log(-1601830656, "[UniDsiUpManager.updateRadioTextPlusInfo] activeStation and RT+ differ X1 - %2", (Object)this.lastSelectedStation, (Object)unifiedRadioTextPlus);
            }
        } else {
            this.rtPlusReceivedWhileTune = true;
        }
    }

    @Override
    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        if (!this.selectRunning && this.lastSelectedStation != null && (this.lastSelectedStation.ensId == 0 && this.lastSelectedStation.piSId == dABSlideShowInfo.sID || this.lastSelectedStation.piSId == dABSlideShowInfo.sID && this.lastSelectedStation.ensId == dABSlideShowInfo.ensID && this.lastSelectedStation.ecc == dABSlideShowInfo.ensECC && this.lastSelectedStation.sCIDI == dABSlideShowInfo.sCIDI)) {
            this.slsManager.setImage(dABSlideShowInfo.slideshowImage);
            this.doUpdateSelectedStation();
        } else {
            this.logger.uniDSI.log(-1601830656, "[UniDsiUpManager.updateSlideShowInfo] activeStation and Slide differ %1 - %2", (Object)this.lastSelectedStation, (Object)dABSlideShowInfo);
        }
    }

    @Override
    public void listMode(int n) {
    }

    @Override
    public void stationFollowingMode(int n) {
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n) {
        UniDsiUpInfo[] uniDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < uniDsiUpInfoArray.length; ++i2) {
            uniDsiUpInfoArray[i2].updateSoftLinkSwitchStatus(n);
        }
    }

    @Override
    public void updateDeviceUsageStatus(int n) {
    }

    @Override
    public void updateRegModeStatus(int n) {
    }

    static /* synthetic */ Timer access$200(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.updateDelayTimer;
    }

    static /* synthetic */ Object access$300(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.globalUniLock;
    }

    static /* synthetic */ void access$400(UniDsiUpManager uniDsiUpManager) {
        uniDsiUpManager.doUpdateSelectedStation();
    }

    static /* synthetic */ Timer access$500(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.waitingListTimer;
    }

    static /* synthetic */ boolean access$600(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.selectRunning;
    }

    static /* synthetic */ void access$700(UniDsiUpManager uniDsiUpManager, UnifiedStationExt unifiedStationExt) {
        uniDsiUpManager.doUpdateStationList(unifiedStationExt);
    }

    static /* synthetic */ UnifiedStationExt[] access$800(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.waitingStationList;
    }

    static /* synthetic */ Timer access$900(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.listRequestTimer;
    }

    static /* synthetic */ UnifiedTuner access$1000(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.uniTuner;
    }

    static /* synthetic */ boolean access$1102(UniDsiUpManager uniDsiUpManager, boolean bl) {
        uniDsiUpManager.waitForSelectRunning = bl;
        return uniDsiUpManager.waitForSelectRunning;
    }

    static /* synthetic */ boolean access$602(UniDsiUpManager uniDsiUpManager, boolean bl) {
        uniDsiUpManager.selectRunning = bl;
        return uniDsiUpManager.selectRunning;
    }

    static /* synthetic */ UniDsiUpManager$SlsSpeedManager access$1200(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.slsManager;
    }

    static /* synthetic */ RadioTextPlusStorage access$1300(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.rtPlusStorage;
    }

    static /* synthetic */ CoverArtHandler access$1400(UniDsiUpManager uniDsiUpManager) {
        return uniDsiUpManager.coverArt;
    }

    static /* synthetic */ UnifiedStationExt access$1502(UniDsiUpManager uniDsiUpManager, UnifiedStationExt unifiedStationExt) {
        uniDsiUpManager.preSelectedStation = unifiedStationExt;
        return uniDsiUpManager.preSelectedStation;
    }

    static {
        EMPTY_RESOURCE_LOCATOR = new ResourceLocator(-1, "");
    }
}

