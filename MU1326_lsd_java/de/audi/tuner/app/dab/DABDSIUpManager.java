/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.AbstractSlsSpeedManagerBase;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.ComparatorComponent;
import de.audi.tuner.app.dab.stationlist.ComparatorDataService;
import de.audi.tuner.app.dab.stationlist.ComparatorEnsemble;
import de.audi.tuner.app.dab.stationlist.ComparatorService;
import de.audi.tuner.app.dab.stationlist.DabDummyNames;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRSDBResult;
import de.audi.tuner.ifc.DABTunerListener;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.NullLogoDatabase;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.DABRadioTextPlusInfo;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.DataServiceInfo;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.EPGLogo;
import org.dsi.ifc.radio.EPGShortInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.FrequencyInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DABDSIUpManager
implements DABTunerListener {
    final DABDsiDownInfo dsiDownListener = new DsiDownInfo();
    private final SlsSpeedManager slsManager;
    private static final char LINE_BREAK_DELIMITER = '\n';
    private static final char HEADER_DELIMITER = '\u000b';
    private static final char SEPARATOR_DELIMITER = '\u001f';
    private static final String REPLACE_LINE_BREAK = "\n";
    private static final String REPLACE_HEADER = "\n";
    private static final String REPLACE_WORD_SEPARATOR = "-";
    private EnsembleInfo[] ensList;
    private ServiceInfo[] serList;
    private ComponentInfo[] comList;
    private DabStation[] ensDabSList = new DabStation[0];
    private DabStation[] serDabSList = new DabStation[0];
    private DabStation[] comDabSList = new DabStation[0];
    private FrequencyInfo selectedFrequency = new FrequencyInfo();
    private EnsembleInfo bufferedEnsemble = null;
    private ServiceInfo bufferedService = null;
    private ComponentInfo bufferedComponent = null;
    private boolean serviceChangedAtTune = false;
    private DabStation selectedStation = new DabStation();
    private final RadioTextPlusStorage rtPlusStorage;
    private TunerObjectContainer[] presets = new TunerObjectContainer[0];
    private final Timer listRequestTimer = new Timer("listRequestTimer", 500L, true, new TimerListener());
    private int selectServiceStatus = 0;
    private boolean waitForSelectRunning;
    private int seekServiceStatus = 0;
    private final Logger logger;
    private final LanguageManager langMngr;
    private boolean listContentChanged = true;
    private boolean listUpdateRunning;
    private boolean rtReceivedWhileTune;
    private boolean rtPlusReceivedWhileTune;
    private int numEns;
    private int numSer;
    private int numCom;
    private int numData;
    private int usefull;
    private boolean logStartup = true;
    private DataServiceInfo[] dataList = new DataServiceInfo[0];
    private EPGShortInfo[] epgListData = new EPGShortInfo[0];
    private EPGLogo[] epgLogoList = new EPGLogo[0];
    private DABDsiUpInfo[] listeners = new DABDsiUpInfo[0];
    private RadioInfo[] basicListeners = new RadioInfo[0];
    private final DabDummyNames dummyNames;
    private final Object mutex = new Object();
    private int syncStatus;
    private int linkinStatus;
    private final CoverArtHandler coverArt;
    private final DABTuner dabTuner;
    private ILogoDatabase logoDatabase;
    private boolean slsRentotification = false;

    DABDSIUpManager(TunerBasics tunerBasics, LanguageManager languageManager, DABTuner dABTuner, DabDummyNames dabDummyNames) {
        this.logger = tunerBasics.getLogger();
        this.langMngr = languageManager;
        this.dabTuner = dABTuner;
        this.logoDatabase = new NullLogoDatabase();
        this.coverArt = new DabCoverArtHandler(tunerBasics);
        this.slsManager = new SlsSpeedManager(this.logger.dabDSI);
        this.ensList = new EnsembleInfo[0];
        this.serList = new ServiceInfo[0];
        this.comList = new ComponentInfo[0];
        this.dummyNames = dabDummyNames;
        this.rtPlusStorage = new RadioTextPlusStorage(this.logger.dabDSI, "DAB");
    }

    void init() {
        Utilities.getFramework().getSysApp().registerSpeedThresholdListener(this.slsManager, 4);
    }

    void register(RadioInfo radioInfo) {
        if (radioInfo instanceof DABDsiUpInfo) {
            DABDsiUpInfo[] dABDsiUpInfoArray = new DABDsiUpInfo[this.listeners.length + 1];
            System.arraycopy((Object)this.listeners, 0, (Object)dABDsiUpInfoArray, 0, this.listeners.length);
            dABDsiUpInfoArray[this.listeners.length] = (DABDsiUpInfo)radioInfo;
            this.listeners = dABDsiUpInfoArray;
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

    public void updateSelectedEnsemble(EnsembleInfo ensembleInfo) {
        this.adjustEnsembleNames(ensembleInfo, true);
        this.bufferedEnsemble = ensembleInfo;
    }

    public void updateSelectedService(ServiceInfo serviceInfo) {
        this.adjustServiceNames(serviceInfo, true);
        this.bufferedService = serviceInfo;
    }

    public void updateSelectedComponent(ComponentInfo componentInfo) {
        this.adjustComponentNames(componentInfo, true);
        this.bufferedComponent = componentInfo;
        this.doUpdateSelectedService();
    }

    public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        int n;
        DABDsiUpInfo[] dABDsiUpInfoArray;
        if (this.selectedFrequency.frequency != frequencyInfo.frequency) {
            this.selectedFrequency = frequencyInfo;
            if (frequencyInfo.frequency != (long)this.selectedStation.ensemble.frequencyValue && this.seekServiceStatus == 1) {
                dABDsiUpInfoArray = this.listeners;
                for (n = 0; n < dABDsiUpInfoArray.length; ++n) {
                    dABDsiUpInfoArray[n].ensembleSeekIsRunning(frequencyInfo.label);
                }
            }
        }
        dABDsiUpInfoArray = this.listeners;
        for (n = 0; n < dABDsiUpInfoArray.length; ++n) {
            dABDsiUpInfoArray[n].updateSelectedFrequency(frequencyInfo);
        }
    }

    public void updateEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        if (this.logger.dabList.isDebug2()) {
            for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
                this.logger.dabList.log(10000000, "updateEnsembleList: %2: %1 ", (Object)ensembleInfoArray[i2], (long)i2);
            }
        } else if (this.logger.dabDSI.isDebug()) {
            Buffer buffer = new Buffer(5000);
            buffer.append('\n');
            for (int i3 = 0; i3 < ensembleInfoArray.length; ++i3) {
                EnsembleInfo ensembleInfo = ensembleInfoArray[i3];
                if (ensembleInfo != null) {
                    buffer.append(i3).append(": \"");
                    buffer.append(ensembleInfo.shortName).append("\",\"").append(ensembleInfo.fullName).append("\"");
                    buffer.append(",ens=").append(ensembleInfo.ensID);
                    buffer.append(",ecc=").append(ensembleInfo.ensECC);
                    buffer.append('\n');
                    continue;
                }
                buffer.append(i3).append(": NULL\n");
            }
            this.logger.dabDSI.log(10000000, "%1", (Object)buffer);
        }
        this.adjustEnsembleNames(ensembleInfoArray);
        this.setEnsembleList(ensembleInfoArray);
    }

    public void updateServiceList(ServiceInfo[] serviceInfoArray) {
        if (this.logger.dabList.isDebug2()) {
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                this.logger.dabList.log(10000000, "updateServiceList: %2: %1 ", (Object)serviceInfoArray[i2], (long)i2);
            }
        } else if (this.logger.dabDSI.isDebug()) {
            Buffer buffer = new Buffer(5000);
            buffer.append('\n');
            for (int i3 = 0; i3 < serviceInfoArray.length; ++i3) {
                ServiceInfo serviceInfo = serviceInfoArray[i3];
                if (serviceInfo != null) {
                    buffer.append(i3).append(": \"");
                    buffer.append(serviceInfo.shortName).append("\",\"").append(serviceInfo.fullName).append("\"");
                    buffer.append(",ens=").append(serviceInfo.ensID);
                    buffer.append(",ecc=").append(serviceInfo.ensECC);
                    buffer.append(",sid=").append(serviceInfo.sID);
                    buffer.append('\n');
                    continue;
                }
                buffer.append(i3).append(": NULL\n");
            }
            this.logger.dabDSI.log(10000000, "%1", (Object)buffer);
        }
        this.adjustServiceNames(serviceInfoArray);
        this.setServiceList(serviceInfoArray);
    }

    public void updateComponentList(ComponentInfo[] componentInfoArray) {
        if (this.logger.dabList.isDebug2()) {
            for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
                this.logger.dabList.log(10000000, "updateComponentList: %2: %1 ", (Object)componentInfoArray[i2], (long)i2);
            }
        } else if (this.logger.dabDSI.isDebug()) {
            Buffer buffer = new Buffer(5000);
            buffer.append('\n');
            for (int i3 = 0; i3 < componentInfoArray.length; ++i3) {
                ComponentInfo componentInfo = componentInfoArray[i3];
                if (componentInfo != null) {
                    buffer.append(i3).append(": \"");
                    buffer.append(componentInfo.shortName).append("\",\"").append(componentInfo.fullName).append("\"");
                    buffer.append(",ens=").append(componentInfo.ensID);
                    buffer.append(",ecc=").append(componentInfo.ensECC);
                    buffer.append(",sid=").append(componentInfo.sID);
                    buffer.append(",scidi=").append(componentInfo.sCIDI);
                    buffer.append('\n');
                    continue;
                }
                buffer.append(i3).append(": NULL\n");
            }
            this.logger.dabDSI.log(10000000, "%1", (Object)buffer);
        }
        this.adjustComponentNames(componentInfoArray);
        this.setComponentList(componentInfoArray);
    }

    public void updateDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        if (this.logger.dabList.isDebug2()) {
            for (int i2 = 0; i2 < dataServiceInfoArray.length; ++i2) {
                this.logger.dabList.log(100000000, "[DABT.updateDataServiceList] [%2] %1", (Object)dataServiceInfoArray[i2], (long)i2);
            }
        }
        this.setDataServiceList(dataServiceInfoArray);
    }

    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].updateFrequencyList(frequencyInfoArray);
        }
    }

    public void updateRadioText(DABRadioText dABRadioText) {
        if (this.updateAllowed()) {
            this.doUpdateRadioText(dABRadioText);
        } else {
            this.rtReceivedWhileTune = true;
        }
    }

    private void doUpdateRadioText(DABRadioText dABRadioText) {
        if ((long)dABRadioText.sID == this.selectedStation.service.sID) {
            String string = dABRadioText.text.trim();
            dABRadioText.text = Utilities.radioTextReplace(string).trim();
            if (dABRadioText.text.length() == 0) {
                this.logger.dabDSI.log(100000, "[DABDSIUpManager.doUpdateRadioText] received empty text -> ignore");
                return;
            }
            DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
            for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
                dABDsiUpInfoArray[i2].updateRadioText(dABRadioText);
            }
            this.updateRadioTextPlusInfo(new DABRadioTextPlusInfo(dABRadioText.ensID, dABRadioText.ensECC, dABRadioText.sID, dABRadioText.sCIDI, new int[]{64}, new String[]{string}));
        } else {
            this.logger.dabDSI.log(100000, "[DABDSIUpManager.doUpdateRadioText] updateRadioText for other station: %1 ", (Object)dABRadioText);
        }
    }

    public void updateSyncStatus(int n) {
        this.syncStatus = n;
        if (n == 4 && this.selectServiceStatus != 1) {
            this.selectServiceStatus = 3;
        }
        this.doUpdateSelectedService();
    }

    public void updateQuality(short s) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].updateQuality(s);
        }
    }

    public void updateLinkingSwitchStatus(int n) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].updateLinkingSwitchStatus(n);
        }
    }

    public void updateFrequencyTableSwitchStatus(int n) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].updateFrequencyTableSwitchStatus(n);
        }
    }

    public void updateLinkingStatus(int n) {
        this.linkinStatus = n;
        if (n == 2 && this.selectServiceStatus != 1) {
            this.selectServiceStatus = 3;
        }
        this.doUpdateSelectedService();
    }

    public void updateLinkingUsageStatus(int n) {
    }

    public void updateDetectedDevice(int n) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].updateDetectedDevice(n);
        }
    }

    public void updateQualityInfo(String string) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void selectServiceStatus(int n) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.mutex;
        synchronized (this.mutex) {
            int n2;
            if (this.waitForSelectRunning && n != 1) {
                this.logger.dabDSI.log(10000000, "[DABDSIUpManager.selectServiceStatus] ignore status because waiting for status RUNNING");
                // ** MonitorExit[var2_2] (shouldn't be in output)
                return;
            }
            int n3 = n2 = n == 1 ? 1 : 0;
            if (n2 != 0) {
                boolean bl;
                if (this.isServiceChangedAtTune()) {
                    this.logger.dabDSI.log(10000000, "[DABDSIUpManager.selectServiceStatus] Serviced Changed => Clean Buffer");
                    this.bufferedEnsemble = null;
                    this.bufferedService = null;
                    this.bufferedComponent = null;
                } else {
                    this.logger.dabDSI.log(10000000, "[DABDSIUpManager.selectServiceStatus] Serviced not Changed => keep Buffer");
                    this.setServiceChangedAtTune(true);
                    this.rtReceivedWhileTune = true;
                    this.slsRentotification = true;
                }
                boolean bl2 = bl = this.seekServiceStatus == 1;
                if (bl) {
                    this.seekServiceStatus = 3;
                    this.logger.dabDSI.log(10000, "[DABDSIUpManager.selectServiceStatus] RUNNING received while seek running");
                }
            }
            if (n == 3) {
                this.dabTuner.getAudioManager().demute();
            }
            this.waitForSelectRunning = false;
            this.selectServiceStatus = n;
            // ** MonitorExit[var2_2] (shouldn't be in output)
            dABDsiUpInfoArray = this.listeners;
            for (n2 = 0; n2 < dABDsiUpInfoArray.length; ++n2) {
                dABDsiUpInfoArray[n2].selectServiceStatus(n);
            }
            this.doUpdateSelectedService();
            if (this.rtReceivedWhileTune) {
                this.rtReceivedWhileTune = false;
                this.dabTuner.reNotification(10);
            }
            if (this.slsRentotification) {
                this.slsRentotification = false;
                this.dabTuner.reNotification(32);
            }
            if (this.rtPlusReceivedWhileTune) {
                this.rtPlusReceivedWhileTune = false;
                this.dabTuner.reNotification(33);
            }
            return;
        }
    }

    private synchronized void doUpdateSelectedService() {
        if (this.updateAllowed()) {
            int n;
            if (this.bufferedComponent.ensID == 0) {
                this.bufferedComponent = new ComponentInfo(this.bufferedService.ensID, this.bufferedService.ensECC, this.bufferedService.sID, 0, "", "", true, false);
            }
            this.selectedStation = new DabStation(this.bufferedEnsemble, this.bufferedService, this.bufferedComponent);
            this.selectedStation.setSlideshowSupported(this.getSLS(this.selectedStation));
            this.selectedStation.setSlsImage(this.slsManager.getSlsImage());
            this.selectedStation.setStationLogo(this.getEpgLogo(this.selectedStation));
            this.logoDatabase.requestDabData(new DabStation[]{this.selectedStation}, new RsdbResultListener(1));
            this.selectedStation.setCoverArt(this.coverArt.getCoverArt());
            this.selectedStation.setRadioTextPlus(this.rtPlusStorage.getRadioTextPlus());
            this.selectedStation.setPresetPos(this.getPresetPos(this.selectedStation));
            DabReceptionStatus dabReceptionStatus = new DabReceptionStatus(this.syncStatus, this.linkinStatus);
            DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
            for (n = 0; n < dABDsiUpInfoArray.length; ++n) {
                dABDsiUpInfoArray[n].updateReceptionStatus(dabReceptionStatus);
            }
            for (n = 0; n < dABDsiUpInfoArray.length; ++n) {
                dABDsiUpInfoArray[n].updateCurrentStation(this.selectedStation, dabReceptionStatus);
            }
            TunerObjectContainer tunerObjectContainer = new TunerObjectContainer(this.selectedStation);
            tunerObjectContainer.setReceptionStatus(dabReceptionStatus.getReception());
            RadioInfo[] radioInfoArray = this.basicListeners;
            for (int i2 = 0; i2 < radioInfoArray.length; ++i2) {
                radioInfoArray[i2].updateStation(tunerObjectContainer, 0);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getPresetPos(DabStation dabStation) {
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.presets.length; ++i2) {
                if (!RadioComparators.equals(dabStation, this.presets[i2].getDABStation())) continue;
                return this.presets[i2].getPresetPos();
            }
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean updateAllowed() {
        boolean bl;
        boolean bl2 = this.seekServiceStatus == 1;
        Object object = this.mutex;
        synchronized (object) {
            bl = this.selectServiceStatus == 1;
        }
        boolean bl3 = !bl && !bl2 && this.bufferedEnsemble != null && this.bufferedService != null && this.bufferedComponent != null;
        this.logger.dabDSI.log(10000, "[DABDSIUpManager.updateAllowed] updateAllowed = %1", bl3);
        return bl3;
    }

    public void seekServiceStatus(int n) {
        boolean bl;
        this.seekServiceStatus = n;
        boolean bl2 = bl = n == 1;
        if (bl) {
            boolean bl3;
            boolean bl4 = bl3 = this.selectServiceStatus == 1;
            if (bl3) {
                this.selectServiceStatus = 3;
                this.logger.dabDSI.log(10000, "[DABDSIUpManager.seekServiceStatus] RUNNING received while tune running");
            }
        }
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].seekServiceStatus(n == 1);
        }
        this.doUpdateSelectedService();
    }

    public void tuneEnsembleStatus(int n) {
    }

    public void selectDataServiceStatus(int n) {
    }

    public void forceLMUpdateStatus(int n) {
        this.logger.dabDSI.log(1000000, "[DABDSIUpManager.forceLMUpdateStatus] status: %1", (long)n);
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].forceLMUpdateStatus(n);
        }
    }

    public void updateEpgLogoList(EPGLogo[] ePGLogoArray) {
        this.epgLogoList = ePGLogoArray;
        this.updateEPGLogosInLists();
        this.doUpdateSelectedService();
        this.sendLists();
    }

    private HMIResourceLocator getEpgLogo(DabStation dabStation) {
        for (int i2 = 0; i2 < this.epgLogoList.length; ++i2) {
            EPGLogo ePGLogo = this.epgLogoList[i2];
            if (dabStation.service.sID != (long)ePGLogo.sID || dabStation.ensemble.ensID != ePGLogo.ensID || dabStation.ensemble.ensECC != ePGLogo.ensECC || dabStation.component.sCIDI != ePGLogo.sCIDI || ePGLogo.epgDescriptorList[0] == null) continue;
            return new HMIResourceLocator(new HMIResourceLocator(ePGLogo.epgDescriptorList[0].picture.url));
        }
        return ISimpleTuner.EMPTY_RL;
    }

    private void updateEPGLogosInLists() {
        int n;
        int n2;
        block0: for (n2 = 0; n2 < this.serDabSList.length; ++n2) {
            for (n = 0; n < this.epgLogoList.length; ++n) {
                if (this.epgLogoList[n].sCIDI == 0 && this.serDabSList[n2].service.ensECC == this.epgLogoList[n].ensECC && this.serDabSList[n2].service.ensID == this.epgLogoList[n].ensID && this.serDabSList[n2].service.sID == (long)this.epgLogoList[n].sID) {
                    this.serDabSList[n2].setStationLogo(new HMIResourceLocator(this.epgLogoList[n].epgDescriptorList[0].picture.url));
                    continue block0;
                }
                if (!this.serDabSList[n2].getStationLogo().equals(ISimpleTuner.EMPTY_RL)) continue;
                this.serDabSList[n2].setStationLogo(ISimpleTuner.EMPTY_RL);
            }
        }
        block2: for (n2 = 0; n2 < this.comDabSList.length; ++n2) {
            for (n = 0; n < this.epgLogoList.length; ++n) {
                if (this.comDabSList[n2].component.ensECC == this.epgLogoList[n].ensECC && this.comDabSList[n2].component.ensID == this.epgLogoList[n].ensID && this.comDabSList[n2].component.sID == (long)this.epgLogoList[n].sID && this.comDabSList[n2].component.sCIDI == this.epgLogoList[n].sCIDI) {
                    this.comDabSList[n2].setStationLogo(new HMIResourceLocator(this.epgLogoList[n].epgDescriptorList[0].picture.url));
                    continue block2;
                }
                if (!this.comDabSList[n2].getStationLogo().equals(ISimpleTuner.EMPTY_RL)) continue;
                this.comDabSList[n2].setStationLogo(ISimpleTuner.EMPTY_RL);
            }
        }
    }

    public void updateAvailability(int n) {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].updateAvailability(n);
        }
    }

    public void updateEPGMode(int n) {
    }

    public void updateEPGListData(EPGShortInfo[] ePGShortInfoArray) {
        this.epgListData = ePGShortInfoArray;
        this.updateEPGList();
    }

    public void updateEPGDetailData(EPGFullInfo ePGFullInfo) {
        ePGFullInfo.nowProgramInfo.detailProgramInfo = this.replaceTextEPG(ePGFullInfo.nowProgramInfo.detailProgramInfo);
        ePGFullInfo.nextProgramInfo.detailProgramInfo = this.replaceTextEPG(ePGFullInfo.nextProgramInfo.detailProgramInfo);
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].setEPGDetailData(ePGFullInfo);
        }
    }

    public void updateRadioTextPlusInfo(DABRadioTextPlusInfo dABRadioTextPlusInfo) {
        if (this.updateAllowed()) {
            ServiceInfo serviceInfo = this.selectedStation.service;
            if (!(serviceInfo.sID != (long)dABRadioTextPlusInfo.sID || serviceInfo.ensID != dABRadioTextPlusInfo.ensID || serviceInfo.ensECC != dABRadioTextPlusInfo.ensECC || this.selectedStation.isComponent() && this.selectedStation.component.sCIDI != dABRadioTextPlusInfo.sCIDI)) {
                this.rtPlusStorage.setRadiotextPlus(dABRadioTextPlusInfo.tags, dABRadioTextPlusInfo.content);
                this.requestCoverArt();
                this.doUpdateSelectedService();
                DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
                for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
                    dABDsiUpInfoArray[i2].updateRadioTextPlusInfo(this.rtPlusStorage);
                }
            } else {
                this.logger.dabDSI.log(100000, "[DABDSIUpManager.updateRadioTextPlusInfo] activeStation and RT+ differ X1 - %2", (Object)this.selectedStation, (Object)dABRadioTextPlusInfo);
            }
        } else {
            this.rtPlusReceivedWhileTune = true;
        }
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        ServiceInfo serviceInfo = this.selectedStation.service;
        if (this.updateAllowed() && serviceInfo.sID == (long)dABSlideShowInfo.sID && serviceInfo.ensID == dABSlideShowInfo.ensID && serviceInfo.ensECC == dABSlideShowInfo.ensECC && (!this.selectedStation.isComponent() || this.selectedStation.component.sCIDI == dABSlideShowInfo.sCIDI)) {
            this.slsManager.setImage(dABSlideShowInfo.slideshowImage);
            this.doUpdateSelectedService();
        } else {
            this.logger.dabDSI.log(100000, "[DABDSIUpManager.updateSlideShowInfo] activeStation and RT+ differ X1 - %2", (Object)this.selectedStation, (Object)dABSlideShowInfo);
        }
    }

    private String replaceTextEPG(String string) {
        String string2 = Utilities.replaceDelimiter(string, '\t', " ");
        string2 = Utilities.replaceDelimiter(string2, '\u000b', "\n");
        string2 = Utilities.replaceDelimiter(string2, '\n', "\n");
        string2 = Utilities.replaceDelimiter(string2, '\u001f', REPLACE_WORD_SEPARATOR);
        return string2;
    }

    private void updateEPGList() {
        ArrayList arrayList = new ArrayList(this.epgListData.length);
        for (int i2 = 0; i2 < this.epgListData.length; ++i2) {
            EPGShortInfo ePGShortInfo = this.epgListData[i2];
            DabStation dabStation = this.getStation(ePGShortInfo.getEnsID(), ePGShortInfo.getEnsECC(), ePGShortInfo.getSID(), ePGShortInfo.getSCIDI());
            if (dabStation == null) continue;
            arrayList.add(new EPGShortInfoExt(ePGShortInfo, dabStation));
        }
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i3 = 0; i3 < dABDsiUpInfoArray.length; ++i3) {
            dABDsiUpInfoArray[i3].setEPGList((EPGShortInfoExt[])arrayList.toArray(new EPGShortInfoExt[arrayList.size()]));
        }
    }

    private DabStation getStation(int n, int n2, long l, int n3) {
        if (n3 == 0) {
            for (int i2 = 0; i2 < this.serDabSList.length; ++i2) {
                if (this.serDabSList[i2].service.getSID() != l || this.serDabSList[i2].service.getEnsID() != n || this.serDabSList[i2].service.getEnsECC() != n2) continue;
                return this.serDabSList[i2];
            }
        } else {
            for (int i3 = 0; i3 < this.comDabSList.length; ++i3) {
                if (this.comDabSList[i3].component.getSID() != l || this.comDabSList[i3].component.getSCIDI() != n3 || this.comDabSList[i3].component.getEnsID() != n || this.comDabSList[i3].component.getEnsECC() != n2) continue;
                return this.comDabSList[i3];
            }
        }
        return null;
    }

    private void setEnsembleList(EnsembleInfo[] ensembleInfoArray) {
        boolean bl;
        this.listContentChanged = true;
        ++this.numEns;
        this.listUpdateRunning = true;
        Arrays.sort(ensembleInfoArray, new ComparatorEnsemble(this.langMngr));
        if (this.listContentChanged) {
            this.ensList = ensembleInfoArray;
            return;
        }
        boolean bl2 = bl = ensembleInfoArray.length != this.ensList.length;
        if (!bl) {
            for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
                if (this.compareEnsemble(ensembleInfoArray[i2], this.ensList[i2])) continue;
                bl = true;
                break;
            }
        }
        if (bl) {
            this.ensList = ensembleInfoArray;
            this.listContentChanged = true;
        }
    }

    private boolean compareEnsemble(EnsembleInfo ensembleInfo, EnsembleInfo ensembleInfo2) {
        return ensembleInfo.getEnsID() == ensembleInfo2.getEnsID() && ensembleInfo.getEnsECC() == ensembleInfo2.getEnsECC() && ensembleInfo.getFullName().equals(ensembleInfo2.getFullName()) && ensembleInfo.getShortName().equals(ensembleInfo2.getShortName()) && ensembleInfo.frequencyValue == ensembleInfo2.frequencyValue;
    }

    private void setServiceList(ServiceInfo[] serviceInfoArray) {
        boolean bl;
        ++this.numSer;
        this.listUpdateRunning = true;
        Arrays.sort(serviceInfoArray, new ComparatorService(this.langMngr));
        if (this.listContentChanged) {
            this.serList = serviceInfoArray;
            return;
        }
        boolean bl2 = bl = serviceInfoArray.length != this.serList.length;
        if (!bl) {
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                if (this.compareService(serviceInfoArray[i2], this.serList[i2])) continue;
                bl = true;
                break;
            }
        }
        if (bl) {
            this.serList = serviceInfoArray;
            this.listContentChanged = true;
        }
    }

    private boolean compareService(ServiceInfo serviceInfo, ServiceInfo serviceInfo2) {
        if (serviceInfo == null && serviceInfo2 == null) {
            return true;
        }
        if (serviceInfo == null || serviceInfo2 == null) {
            return false;
        }
        return serviceInfo.getSID() == serviceInfo2.getSID() && serviceInfo.getEnsID() == serviceInfo2.getEnsID() && serviceInfo.getEnsECC() == serviceInfo2.getEnsECC() && serviceInfo.getFullName().equals(serviceInfo2.getFullName()) && serviceInfo.getShortName().equals(serviceInfo2.getShortName()) && this.equalsPty(serviceInfo.ptyCodes, serviceInfo2.ptyCodes) && serviceInfo.radiotext == serviceInfo2.radiotext;
    }

    private boolean equalsPty(byte[] byArray, byte[] byArray2) {
        if (byArray == null || byArray2 == null || byArray.length != byArray2.length) {
            return false;
        }
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if (byArray[i2] == byArray2[i2]) continue;
            return false;
        }
        return true;
    }

    private void setComponentList(ComponentInfo[] componentInfoArray) {
        ++this.numCom;
        Arrays.sort(componentInfoArray, new ComparatorComponent(this.langMngr));
        if (this.listContentChanged) {
            this.comList = componentInfoArray;
        } else {
            boolean bl;
            boolean bl2 = bl = componentInfoArray.length != this.comList.length;
            if (!bl) {
                for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
                    if (this.compareComponent(componentInfoArray[i2], this.comList[i2])) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) {
                this.comList = componentInfoArray;
                this.listContentChanged = true;
            }
        }
        if (this.listContentChanged) {
            this.updateAll();
        } else {
            Buffer buffer = new Buffer(50);
            buffer.append("DABListManager: no new content: #e: ");
            buffer.append(this.numEns);
            buffer.append(" #s: ");
            buffer.append(this.numSer);
            buffer.append(" #c: ");
            buffer.append(this.numCom);
            buffer.append(" #data: ");
            buffer.append(this.numData);
            buffer.append(" #usefull: ");
            buffer.append(this.usefull);
            this.logger.dabDSI.log(10000000, "%1", (Object)buffer);
        }
        this.listUpdateRunning = false;
    }

    private void updateAll() {
        this.listRequestTimer.cancel();
        ArrayList arrayList = new ArrayList(this.ensList.length);
        ArrayList arrayList2 = new ArrayList(this.serList.length);
        ArrayList arrayList3 = new ArrayList(this.comList.length);
        for (int i2 = 0; i2 < this.ensList.length; ++i2) {
            List list = this.getServ(this.ensList[i2].ensID, this.ensList[i2].ensECC);
            if (list.isEmpty()) {
                this.logger.dabDSI.log(100000, "[DABDSIUpManager.updateAll] no service found for ensemble %1", (Object)this.ensList[i2]);
                continue;
            }
            arrayList.add(new DabStation(this.ensList[i2]));
            for (int i3 = 0; i3 < list.size(); ++i3) {
                ServiceInfo serviceInfo = (ServiceInfo)list.get(i3);
                DabStation dabStation = new DabStation(this.ensList[i2], serviceInfo);
                boolean bl = this.getSLS(dabStation);
                dabStation.setSlideshowSupported(bl);
                dabStation.setPresetPos(this.getPresetPos(dabStation));
                arrayList2.add(dabStation);
                List list2 = this.getComp(serviceInfo);
                for (int i4 = 0; i4 < list2.size(); ++i4) {
                    dabStation = new DabStation(this.ensList[i2], serviceInfo, (ComponentInfo)list2.get(i4));
                    dabStation.setSlideshowSupported(bl);
                    arrayList3.add(dabStation);
                }
            }
        }
        this.ensDabSList = (DabStation[])arrayList.toArray(new DabStation[arrayList.size()]);
        this.serDabSList = (DabStation[])arrayList2.toArray(new DabStation[arrayList2.size()]);
        this.comDabSList = (DabStation[])arrayList3.toArray(new DabStation[arrayList3.size()]);
        this.updateEPGLogosInLists();
        this.requestLogos();
        if (this.logStartup) {
            Utilities.getFramework().getStartupMgr().logStartupEvent("Sender list: DAB received");
            this.sendLists();
            Utilities.getFramework().getStartupMgr().logStartupEvent("Sender list: DAB ready");
            this.logStartup = false;
        } else {
            this.sendLists();
        }
        this.updateEPGList();
        this.listContentChanged = false;
        ++this.usefull;
    }

    private void requestLogos() {
        this.logoDatabase.requestDabData(this.serDabSList, new RsdbResultListener(1));
        this.logoDatabase.requestDabData(this.comDabSList, new RsdbResultListener(1));
    }

    private List getComp(ServiceInfo serviceInfo) {
        ArrayList arrayList = new ArrayList(5);
        for (int i2 = 0; i2 < this.comList.length; ++i2) {
            if (this.comList[i2].sID != serviceInfo.sID || this.comList[i2].ensID != serviceInfo.ensID || this.comList[i2].ensECC != serviceInfo.ensECC) continue;
            arrayList.add(this.comList[i2]);
        }
        return arrayList;
    }

    private List getServ(int n, int n2) {
        ArrayList arrayList = new ArrayList(25);
        for (int i2 = 0; i2 < this.serList.length; ++i2) {
            if (this.serList[i2].ensID != n || this.serList[i2].ensECC != n2) continue;
            arrayList.add(this.serList[i2]);
        }
        return arrayList;
    }

    private void sendLists() {
        DABDsiUpInfo[] dABDsiUpInfoArray = this.listeners;
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            dABDsiUpInfoArray[i2].listUpdate(this.ensDabSList, this.serDabSList, this.comDabSList);
        }
    }

    private boolean getSLS(DabStation dabStation) {
        for (int i2 = 0; i2 < this.dataList.length; ++i2) {
            if (this.dataList[i2].sID != dabStation.service.sID || this.dataList[i2].ensID != dabStation.service.ensID || this.dataList[i2].ensECC != dabStation.service.ensECC || this.dataList[i2].sCIDI != dabStation.component.sCIDI || this.dataList[i2].type != 2) continue;
            return true;
        }
        return false;
    }

    private boolean compareComponent(ComponentInfo componentInfo, ComponentInfo componentInfo2) {
        return componentInfo.getSID() == componentInfo2.getSID() && componentInfo.getSCIDI() == componentInfo2.getSCIDI() && componentInfo.getEnsID() == componentInfo2.getEnsID() && componentInfo.getEnsECC() == componentInfo2.getEnsECC() && componentInfo.getFullName().equals(componentInfo2.getFullName()) && componentInfo.getShortName().equals(componentInfo2.getShortName()) && componentInfo.radiotext == componentInfo2.radiotext;
    }

    private void setDataServiceList(DataServiceInfo[] dataServiceInfoArray) {
        ++this.numData;
        Arrays.sort(dataServiceInfoArray, new ComparatorDataService());
        if (this.listContentChanged) {
            this.dataList = dataServiceInfoArray;
        } else {
            boolean bl;
            boolean bl2 = bl = dataServiceInfoArray.length != this.comList.length;
            if (!bl) {
                for (int i2 = 0; i2 < dataServiceInfoArray.length; ++i2) {
                    if (this.compareDataService(dataServiceInfoArray[i2], this.comList[i2])) continue;
                    bl = true;
                    break;
                }
            }
            if (bl) {
                this.dataList = dataServiceInfoArray;
                this.listContentChanged = true;
            }
        }
        if (!this.listUpdateRunning && this.listContentChanged) {
            this.updateAll();
        }
    }

    private boolean compareDataService(DataServiceInfo dataServiceInfo, ComponentInfo componentInfo) {
        return dataServiceInfo.getSID() == componentInfo.getSID() && dataServiceInfo.getSCIDI() == componentInfo.getSCIDI() && dataServiceInfo.getEnsID() == componentInfo.getEnsID() && dataServiceInfo.getEnsECC() == componentInfo.getEnsECC();
    }

    private void adjustEnsembleNames(EnsembleInfo[] ensembleInfoArray) {
        for (int i2 = 0; i2 < ensembleInfoArray.length; ++i2) {
            if (ensembleInfoArray[i2] == null) continue;
            this.adjustEnsembleNames(ensembleInfoArray[i2], false);
        }
    }

    private void adjustEnsembleNames(EnsembleInfo ensembleInfo, boolean bl) {
        boolean bl2 = false;
        if (ensembleInfo != null) {
            if (Utilities.isEmpty(ensembleInfo.getFullName())) {
                if (Utilities.isEmpty(ensembleInfo.getShortName())) {
                    EnsembleInfo ensembleInfo2 = null;
                    if (bl) {
                        EnsembleInfo ensembleInfo3 = this.dabTuner.getActiveStation().ensemble;
                        if (RadioComparators.equals(ensembleInfo3, ensembleInfo)) {
                            ensembleInfo2 = ensembleInfo3;
                        }
                        if (ensembleInfo2 == null) {
                            ensembleInfo2 = this.getEnsembleById(ensembleInfo.ensID);
                        }
                    }
                    if (ensembleInfo2 == null) {
                        ensembleInfo2 = this.dummyNames.getDummyEnsembleName(ensembleInfo.getEnsID(), ensembleInfo.getEnsECC());
                    }
                    ensembleInfo.fullName = ensembleInfo2.getFullName();
                    ensembleInfo.shortName = ensembleInfo2.getShortName();
                } else {
                    ensembleInfo.fullName = ensembleInfo.getShortName().trim();
                    ensembleInfo.shortName = ensembleInfo.getShortName().trim();
                }
                bl2 = true;
            } else if (Utilities.isEmpty(ensembleInfo.getShortName())) {
                ensembleInfo.fullName = ensembleInfo.getFullName().trim();
                ensembleInfo.shortName = Utilities.getShortName(ensembleInfo.getFullName());
                bl2 = true;
            } else {
                ensembleInfo.fullName = ensembleInfo.getFullName().trim();
                ensembleInfo.shortName = ensembleInfo.getShortName().trim();
            }
        }
        if (bl2) {
            this.logger.dabDSI.log(10000000, "[DABDSIUpManager.adjustServiceNames] %1", (Object)ensembleInfo);
        }
    }

    private void adjustServiceNames(ServiceInfo[] serviceInfoArray) {
        for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
            if (serviceInfoArray[i2] == null) continue;
            this.adjustServiceNames(serviceInfoArray[i2], false);
        }
    }

    private void adjustServiceNames(ServiceInfo serviceInfo, boolean bl) {
        boolean bl2 = false;
        if (serviceInfo != null) {
            if (Utilities.isEmpty(serviceInfo.getFullName())) {
                if (Utilities.isEmpty(serviceInfo.getShortName())) {
                    ServiceInfo serviceInfo2 = null;
                    if (bl) {
                        ServiceInfo serviceInfo3 = this.dabTuner.getActiveStation().service;
                        if (RadioComparators.equals(serviceInfo3, serviceInfo)) {
                            serviceInfo2 = serviceInfo3;
                        }
                        if (serviceInfo2 == null) {
                            serviceInfo2 = this.getServiceById(serviceInfo.sID, serviceInfo.ensID);
                        }
                    }
                    if (serviceInfo2 == null) {
                        serviceInfo2 = this.dummyNames.getDummyServiceName((int)serviceInfo.sID);
                    }
                    serviceInfo.fullName = serviceInfo2.getFullName();
                    serviceInfo.shortName = serviceInfo2.getShortName();
                } else {
                    serviceInfo.fullName = serviceInfo.getShortName().trim();
                    serviceInfo.shortName = serviceInfo.getShortName().trim();
                }
                bl2 = true;
            } else if (Utilities.isEmpty(serviceInfo.getShortName())) {
                serviceInfo.fullName = serviceInfo.getFullName().trim();
                serviceInfo.shortName = Utilities.getShortName(serviceInfo.getFullName());
                bl2 = true;
            } else {
                serviceInfo.fullName = serviceInfo.getFullName().trim();
                serviceInfo.shortName = serviceInfo.getShortName().trim();
            }
            serviceInfo.radiotext = true;
            if (serviceInfo.ptyCodes == null || serviceInfo.ptyCodes.length == 0) {
                serviceInfo.ptyCodes = new byte[]{0};
            }
        }
        if (bl2) {
            this.logger.dabDSI.log(10000000, "[DABDSIUpManager.adjustServiceNames] %1", (Object)serviceInfo);
        }
    }

    private void adjustComponentNames(ComponentInfo[] componentInfoArray) {
        for (int i2 = 0; i2 < componentInfoArray.length; ++i2) {
            if (componentInfoArray[i2] == null) continue;
            this.adjustComponentNames(componentInfoArray[i2], false);
        }
    }

    private void adjustComponentNames(ComponentInfo componentInfo, boolean bl) {
        boolean bl2 = false;
        if (componentInfo != null) {
            if (Utilities.isEmpty(componentInfo.getFullName())) {
                if (Utilities.isEmpty(componentInfo.getShortName())) {
                    ComponentInfo componentInfo2 = null;
                    if (bl) {
                        ComponentInfo componentInfo3 = this.dabTuner.getActiveStation().component;
                        if (RadioComparators.equals(componentInfo3, componentInfo)) {
                            componentInfo2 = componentInfo3;
                        }
                        if (componentInfo2 == null) {
                            componentInfo2 = this.getComponent(componentInfo.ensID, componentInfo.ensECC, componentInfo.sID, componentInfo.sCIDI);
                        }
                    }
                    if (componentInfo2 == null) {
                        componentInfo2 = this.dummyNames.getDummyComponentName((int)componentInfo.getSID(), componentInfo.getSCIDI());
                    }
                    componentInfo.fullName = componentInfo2.getFullName();
                    componentInfo.shortName = componentInfo2.getShortName();
                } else {
                    componentInfo.fullName = componentInfo.getShortName().trim();
                    componentInfo.shortName = componentInfo.getShortName().trim();
                }
                bl2 = true;
            } else if (Utilities.isEmpty(componentInfo.getShortName())) {
                componentInfo.fullName = componentInfo.getFullName().trim();
                componentInfo.shortName = Utilities.getShortName(componentInfo.getFullName());
                bl2 = true;
            } else {
                componentInfo.fullName = componentInfo.getFullName().trim();
                componentInfo.shortName = componentInfo.getShortName().trim();
            }
        }
        if (bl2) {
            this.logger.dabDSI.log(10000000, "[DABDSIUpManager.adjustComponentName] %1", (Object)componentInfo);
        }
    }

    private EnsembleInfo getEnsembleById(int n) {
        EnsembleInfo ensembleInfo = null;
        if (this.ensList != null) {
            this.logger.dd.log(10000000, "getEnsembleById ensid: %1", (long)n);
            for (int i2 = 0; i2 < this.ensList.length; ++i2) {
                if (this.ensList[i2] == null || n != this.ensList[i2].ensID) continue;
                ensembleInfo = this.ensList[i2];
                break;
            }
        }
        this.logger.dd.log(10000000, "getEnsembleById, found: %1", ensembleInfo);
        return ensembleInfo;
    }

    private ServiceInfo getServiceById(long l, long l2) {
        ServiceInfo serviceInfo = null;
        for (int i2 = 0; i2 < this.serList.length; ++i2) {
            if (this.serList[i2] == null || (long)this.serList[i2].ensID != l2 || this.serList[i2].sID != l) continue;
            serviceInfo = this.serList[i2];
            break;
        }
        return serviceInfo;
    }

    private ComponentInfo getComponent(long l, int n, long l2, int n2) {
        ComponentInfo componentInfo = null;
        for (int i2 = 0; i2 < this.comList.length; ++i2) {
            if (this.comList[i2] == null || (long)this.comList[i2].ensID != l || this.comList[i2].sID != l2 || this.comList[i2].sCIDI != n2) continue;
            componentInfo = this.comList[i2];
            break;
        }
        return componentInfo;
    }

    public boolean isServiceChangedAtTune() {
        return this.serviceChangedAtTune;
    }

    public void setServiceChangedAtTune(boolean bl) {
        this.serviceChangedAtTune = bl;
    }

    public void forceNextListUpdate() {
        this.listContentChanged = true;
    }

    static /* synthetic */ TunerObjectContainer[] access$1002(DABDSIUpManager dABDSIUpManager, TunerObjectContainer[] tunerObjectContainerArray) {
        dABDSIUpManager.presets = tunerObjectContainerArray;
        return tunerObjectContainerArray;
    }

    private class DsiDownInfo
    extends DABDsiDownInfo {
        private DsiDownInfo() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
            Object object = DABDSIUpManager.this.mutex;
            synchronized (object) {
                DABDSIUpManager.this.selectServiceStatus = 1;
                DABDSIUpManager.this.slsManager.clear();
                DABDSIUpManager.this.coverArt.clear();
                DABDSIUpManager.this.rtPlusStorage.reset();
                DABDSIUpManager.this.waitForSelectRunning = true;
            }
        }

        public void seekStarted() {
            DABDSIUpManager.this.seekServiceStatus = 1;
            DABDSIUpManager.this.slsManager.clear();
            DABDSIUpManager.this.coverArt.clear();
            DABDSIUpManager.this.rtPlusStorage.reset();
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Object object = DABDSIUpManager.this.mutex;
            synchronized (object) {
                DABDSIUpManager.this.listContentChanged = true;
                DABDSIUpManager.this.dabTuner.reNotification(7);
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
            Object object = DABDSIUpManager.this.mutex;
            synchronized (object) {
                DABDSIUpManager.access$1002(DABDSIUpManager.this, this.memory.getList(new int[]{5}));
                DABDSIUpManager.this.listContentChanged = true;
                DABDSIUpManager.this.dabTuner.reNotification(1);
                DABDSIUpManager.this.dabTuner.reNotification(2);
                DABDSIUpManager.this.dabTuner.reNotification(3);
                DABDSIUpManager.this.dabTuner.reNotification(5);
                DABDSIUpManager.this.dabTuner.reNotification(6);
                DABDSIUpManager.this.dabTuner.reNotification(7);
            }
        }
    }

    private class SlsSpeedManager
    extends AbstractSlsSpeedManagerBase {
        public SlsSpeedManager(LogChannel logChannel) {
            super(logChannel);
        }

        protected void update() {
            DABDSIUpManager.this.doUpdateSelectedService();
        }
    }

    private class DabCoverArtHandler
    extends CoverArtHandler {
        public DabCoverArtHandler(TunerBasics tunerBasics) {
            super(tunerBasics);
        }

        public boolean setCoverArt(int n, ResourceLocator resourceLocator) {
            if (super.setCoverArt(n, resourceLocator)) {
                DABDSIUpManager.this.doUpdateSelectedService();
            }
            return false;
        }
    }

    private class RsdbResultListener
    implements IRSDBResult {
        private final int type;

        public RsdbResultListener(int n) {
            this.type = n;
        }

        public void resultAvailable() {
            DABDSIUpManager.this.doUpdateSelectedService();
            if (this.type == 2) {
                DABDSIUpManager.this.listRequestTimer.start();
            }
        }
    }
}

