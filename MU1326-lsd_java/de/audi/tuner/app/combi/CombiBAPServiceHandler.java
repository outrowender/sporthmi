/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTuner;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPAudioSource;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPCurrentStationInfo;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPPresetListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPReceptionListEntry;
import de.audi.atip.interapp.combi.bap.audio.data.MuteState;
import de.audi.atip.interapp.combi.bap.audio.data.MuteState$Builder;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.ArtistAndTitlePair;
import de.audi.tuner.app.PresetIds;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerConfiguration;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.combi.CombiBAPIdMapper;
import de.audi.tuner.app.combi.CombiBAPServiceHandler$1;
import de.audi.tuner.app.combi.CombiBAPServiceHandler$DsiUpListener;
import de.audi.tuner.app.combi.CombiBAPServiceHandler$TunerActionProxyListenerExt;
import de.audi.tuner.app.combi.CombiBAPUtilities;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ICombiBAPServiceElementBuilderAMFM;
import de.audi.tuner.ifc.ICombiBAPServiceElementFactory;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.DefaultUpdateListener;
import de.audi.tuner.util.NullCombiBAPServiceTuner;
import de.esolutions.fw.util.commons.Buffer;
import java.util.ArrayList;
import org.dsi.ifc.radio.EnsembleInfo;

public class CombiBAPServiceHandler
extends DefaultUpdateListener
implements IUpdateListener {
    public final AMFMDsiUpInfo dsiUpListener = new CombiBAPServiceHandler$DsiUpListener(this, null);
    public final TunerActionProxyListener actionProxyListener = new CombiBAPServiceHandler$TunerActionProxyListenerExt(this, null);
    private static final boolean STATION_LIST_AVAILABLE;
    private static final boolean MEMORY_LIST_AVAILABLE;
    private static final boolean AUTO_UPDATE_FM_LIST;
    private final boolean autoUpdateAMList;
    private final boolean autoUpdateDABList;
    private boolean autoUpdateSDARSList = false;
    private final boolean autoUpdateAMLWList;
    private final boolean autoUpdateAMSWList;
    private HMIResourceLocator fmDefault = null;
    private HMIResourceLocator amDefault = null;
    private HMIResourceLocator dabDefault = null;
    private HMIResourceLocator uniDefault = null;
    private HMIResourceLocator sdarsDefault = null;
    protected AMFMStation currentAMFMStation = null;
    private boolean dabLongNames = false;
    private static final boolean sdarsLongNames;
    private final LogChannel logger;
    private final TunerModels models;
    private final TunerStatus status;
    private IMemoryList memory = new CombiBAPServiceHandler$1(this);
    private final CombiBAPIdMapper idMapper;
    private final ITunerVariantExt variantExt;
    private CombiBAPServiceTuner combiService;
    private volatile int sourceState = 0;
    private int combiWaveband = 0;
    private boolean listUpdateRunning;
    private int[] bands = new int[0];
    private boolean dabMute;
    private boolean uniMute;
    private boolean sdarsMute;
    private boolean ibocMute;
    private int imgType;
    protected boolean listUpdateNecessary;
    protected int fmAudioStatus;
    private CombiBAPReceptionListEntry[] lastReceptionList = new CombiBAPReceptionListEntry[0];
    private Object mutex = new Object();

    public CombiBAPServiceHandler(TunerBasics tunerBasics, CombiBAPIdMapper combiBAPIdMapper, TunerStorage tunerStorage, ITunerVariantExt iTunerVariantExt) {
        this(TunerConfiguration.isAMDoubleTuner(), TunerConfiguration.isDABDoubleTuner(), TunerConfiguration.isAMDoubleTuner(), TunerConfiguration.isAMDoubleTuner(), tunerBasics.getLogger().combi, tunerBasics.getModels(), tunerBasics.getStatus(), combiBAPIdMapper, tunerStorage, iTunerVariantExt);
    }

    CombiBAPServiceHandler(boolean bl, boolean bl2, boolean bl3, boolean bl4, LogChannel logChannel, TunerModels tunerModels, TunerStatus tunerStatus, CombiBAPIdMapper combiBAPIdMapper, TunerStorage tunerStorage, ITunerVariantExt iTunerVariantExt) {
        this.autoUpdateAMList = bl;
        this.autoUpdateDABList = bl2;
        this.autoUpdateAMLWList = bl3;
        this.autoUpdateAMSWList = bl4;
        this.logger = logChannel;
        this.models = tunerModels;
        this.status = tunerStatus;
        this.idMapper = combiBAPIdMapper;
        this.variantExt = iTunerVariantExt;
        this.combiService = new NullCombiBAPServiceTuner(logChannel);
        this.imgType = tunerStorage.loadPreferredImageType();
    }

    public synchronized void setFavortieListHandler(IMemoryList iMemoryList) {
        this.memory = iMemoryList;
        if (!(this.combiService instanceof NullCombiBAPServiceTuner)) {
            this.updatedMemoryList();
        }
    }

    public synchronized void setCombiService(CombiBAPServiceTuner combiBAPServiceTuner) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.setCombiService] %1", (Object)combiBAPServiceTuner);
        if (combiBAPServiceTuner == null) {
            this.combiService = new NullCombiBAPServiceTuner(this.logger);
            return;
        }
        this.combiService = combiBAPServiceTuner;
        try {
            this.combiService.updateReceptionListAutoUpdateInformation(true, this.autoUpdateAMList, this.autoUpdateDABList, this.autoUpdateSDARSList, this.autoUpdateAMLWList, this.autoUpdateAMSWList);
            this.combiService.updatePreferredList(this.models.getActiveList() == 12 ? 2 : 1);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
        if (this.status.hasAudioFocus(0)) {
            this.tunerActivated();
        } else {
            this.sendBandList(this.bands);
            this.updatedWaveband(this.models.getActiveTuner());
            this.updatedMemoryList();
        }
    }

    public void setPreferredImgType(int n) {
        this.imgType = n;
        this.updatedActiveStation(this.models.getActiveTuner());
    }

    public void setLongNames(boolean bl, boolean bl2) {
        this.dabLongNames = bl;
        try {
            this.combiService.updateProgramStringLength(this.dabLongNames, false);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
        this.updatedStationList(this.models.getActiveTuner());
    }

    public void tunerActivated() {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.tunerActivated]");
        this.sendBandList(this.bands);
        this.updatedWaveband(this.models.getActiveTuner());
        this.updatedMemoryList();
    }

    @Override
    public void updatedMemoryList() {
        int n;
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedMemoryList]");
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = null;
        int n2 = this.combiWaveband;
        if (n2 > 0) {
            combiBAPCurrentStationInfo = this.getCurrentActiveStation(n2);
        }
        TunerObjectContainer[] tunerObjectContainerArray = this.memory.getList();
        CombiBAPPresetListEntry[] combiBAPPresetListEntryArray = new CombiBAPPresetListEntry[tunerObjectContainerArray.length];
        for (n = 0; n < tunerObjectContainerArray.length; ++n) {
            String string = "";
            int n3 = 0;
            int n4 = 0;
            switch (tunerObjectContainerArray[n].getType()) {
                case 3: {
                    AMFMStation aMFMStation = tunerObjectContainerArray[n].getAMFMService();
                    string = tunerObjectContainerArray[n].getStationName(false);
                    n3 = CombiBAPUtilities.getBAPWaveband(Utilities.getBandIdByWaveband(aMFMStation.getWaveband()));
                    n4 = CombiBAPUtilities.getBAPPrestListAttributes(tunerObjectContainerArray[n]);
                    if (combiBAPCurrentStationInfo == null || combiBAPCurrentStationInfo.getPresetListRef() != tunerObjectContainerArray[n].getPresetPos()) break;
                    string = this.getAMFMName(this.currentAMFMStation);
                    n4 = combiBAPCurrentStationInfo.getAttributes();
                    break;
                }
                case 6: {
                    string = this.getDABName(tunerObjectContainerArray[n].getDABStation());
                    n3 = CombiBAPUtilities.getBAPWaveband(5);
                    n4 = CombiBAPUtilities.getBAPPrestListAttributes(tunerObjectContainerArray[n]);
                    break;
                }
                case 7: {
                    string = this.getUniName(tunerObjectContainerArray[n].getUniStation());
                    n3 = CombiBAPUtilities.getBAPWaveband(tunerObjectContainerArray[n].getUniStation().isAnalog() ? 1 : 5);
                    n4 = CombiBAPUtilities.getBAPPrestListAttributes(tunerObjectContainerArray[n]);
                    break;
                }
                case 5: {
                    string = this.getSDARSName(tunerObjectContainerArray[n].getSDARSService());
                    n3 = CombiBAPUtilities.getBAPWaveband(7);
                    n4 = CombiBAPUtilities.getBAPPrestListAttributes(tunerObjectContainerArray[n]);
                    break;
                }
                case 8: {
                    string = tunerObjectContainerArray[n].getTVStation().getName();
                    n3 = CombiBAPUtilities.getBAPWaveband(15);
                    break;
                }
            }
            combiBAPPresetListEntryArray[n] = new CombiBAPPresetListEntry(tunerObjectContainerArray[n].getPresetPos(), tunerObjectContainerArray[n].getPresetPos(), n3, string, n4);
        }
        for (n = 0; n < combiBAPPresetListEntryArray.length; ++n) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedMemoryList] Entry: %1 ", (Object)combiBAPPresetListEntryArray[n].toString());
        }
        try {
            this.combiService.updatePresetList(combiBAPPresetListEntryArray);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void updatedBandList(int[] nArray) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedBandList]");
        this.bands = nArray;
        this.sendBandList(nArray);
        this.updatedActiveSource(this.combiWaveband);
    }

    private void sendBandList(int[] nArray) {
        ArrayList arrayList = new ArrayList(nArray.length);
        try {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (nArray[i2] == 12 || nArray[i2] == 13) continue;
                arrayList.add(new CombiBAPAudioSource(CombiBAPUtilities.getBAPSourceType(nArray[i2]), 0, 10, ""));
                if (nArray[i2] != 7 || this.autoUpdateSDARSList) continue;
                this.autoUpdateSDARSList = true;
                this.combiService.updateReceptionListAutoUpdateInformation(true, this.autoUpdateAMList, this.autoUpdateDABList, this.autoUpdateSDARSList, this.autoUpdateAMLWList, this.autoUpdateAMSWList);
            }
            this.combiService.updateSourceListTuner((CombiBAPAudioSource[])arrayList.toArray(new CombiBAPAudioSource[arrayList.size()]));
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void updatedStationList(int n) {
        if (this.sendReceptionList(n)) {
            this.updatedActiveStation(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean sendReceptionList(int n) {
        CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray;
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.sendReceptionList] band:%1", (long)n);
        if (n != this.models.getActiveTuner()) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.sendReceptionList] band not active tuner (%1)", (long)this.models.getActiveTuner());
            return false;
        }
        if (n != this.combiWaveband) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.sendReceptionList] ignore band -> send bandchange fisrt");
            return false;
        }
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.sendReceptionList] guiHandler is null!");
            return false;
        }
        TunerObjectContainer[] tunerObjectContainerArray = iTunerGUIHandler.getStationList();
        if (tunerObjectContainerArray == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.sendReceptionList] station list is null!");
            return false;
        }
        switch (n) {
            case 1: 
            case 4: 
            case 10: {
                combiBAPReceptionListEntryArray = this.createAMFMList(tunerObjectContainerArray);
                break;
            }
            case 5: {
                combiBAPReceptionListEntryArray = this.createDABList(tunerObjectContainerArray, TunerProxyManager.getInstance().getDABTuner().getCurSyncState());
                break;
            }
            case 11: {
                combiBAPReceptionListEntryArray = this.createUniList(tunerObjectContainerArray);
                break;
            }
            case 7: {
                combiBAPReceptionListEntryArray = this.createSDARSList(tunerObjectContainerArray);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unexpected band: ").append(n).toString());
            }
        }
        try {
            this.combiService.updateReceptionList(CombiBAPUtilities.getBAPReceptionListType(n), combiBAPReceptionListEntryArray);
            Object object = this.mutex;
            synchronized (object) {
                this.lastReceptionList = combiBAPReceptionListEntryArray;
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
        return true;
    }

    @Override
    public void updatedWaveband(int n) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedWaveband], band: %1", (long)n);
        if (n != 0) {
            if (this.combiWaveband != n) {
                this.idMapper.reset();
                this.listUpdateRunning = false;
            }
            this.combiWaveband = n;
            this.updatedActiveSource(n);
            this.sendReceptionList(n);
            this.updatedActiveStation(n);
            this.updatedActiveInfoState(n);
            this.updatedActiveList(this.models.getActiveList());
            this.updatedMuteStatus(n);
        }
    }

    private void updatedActiveSource(int n) {
        if (n != 0) {
            int n2 = this.listUpdateRunning ? 4 : 3;
            try {
                this.combiService.updateActiveSource(CombiBAPUtilities.getBAPSourceType(n), 0, 0, true, true, n2);
            }
            catch (Exception exception) {
                this.logger.log(10000, "%1", (Throwable)exception);
            }
        }
    }

    @Override
    public void updatedActiveList(int n) {
        this.combiService.updatePreferredList(n == 12 ? 2 : 1);
    }

    @Override
    public void updatedActiveInfoState(int n) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] band: %1", (long)n);
        if (n != this.models.getActiveTuner()) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveInfoState] band not active tuner (%1)", (long)this.models.getActiveTuner());
            return;
        }
        try {
            if (n == 7) {
                boolean bl;
                SDARSAdvisoryHandler sDARSAdvisoryHandler = TunerProxyManager.getInstance().getSDARSTuner().getAdvisoryHandler();
                boolean bl2 = bl = this.models.getChoiceModel(981926144).getValue() == 0;
                if (sDARSAdvisoryHandler != null) {
                    int n2 = sDARSAdvisoryHandler.getActiveAdvisory();
                    int n3 = CombiBAPUtilities.getBAPInfoStateSDARS(n2);
                    if (n3 == 0 && bl) {
                        n3 = 69;
                    }
                    this.combiService.updateActiveInfoState(n3);
                }
            } else {
                this.combiService.updateActiveInfoState(0);
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    private CombiBAPCurrentStationInfo getCurrentActiveStation(int n) {
        if (TunerProxyManager.getInstance() == null) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] TunerProxyManager.getInstance is null.");
            return null;
        }
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler == null) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] ITunerGUIHandler is null.");
            return null;
        }
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = this.getCurrentActiveStation(n, iTunerGUIHandler);
        return combiBAPCurrentStationInfo;
    }

    protected CombiBAPCurrentStationInfo getCurrentActiveStation(int n, ITunerGUIHandler iTunerGUIHandler) {
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = null;
        TunerObjectContainer tunerObjectContainer = iTunerGUIHandler.getCurrentStation();
        boolean bl = false;
        if (tunerObjectContainer == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.getCurrentActiveStation] currentStation == null, band == %1", (long)n);
            bl = true;
        }
        switch (n) {
            case 1: 
            case 4: 
            case 10: {
                if (bl) break;
                AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
                int n2 = aMFMStation.getAudioStatus();
                if (n2 != this.fmAudioStatus && (n2 == 3 || this.fmAudioStatus == 3)) {
                    this.listUpdateNecessary = true;
                }
                this.fmAudioStatus = n2;
                this.currentAMFMStation = aMFMStation;
                int n3 = this.idMapper.getBapId(aMFMStation.getUniqueId());
                PresetIds presetIds = this.memory.getPresetIds(tunerObjectContainer);
                HMIResourceLocator hMIResourceLocator = aMFMStation.getImage(this.imgType);
                hMIResourceLocator = this.checkIfEmpty(hMIResourceLocator, aMFMStation.waveband == 1 ? 1 : 4);
                ICombiBAPServiceElementFactory iCombiBAPServiceElementFactory = this.variantExt.getCombiBAPServiceElementFactory();
                ICombiBAPServiceElementBuilderAMFM iCombiBAPServiceElementBuilderAMFM = iCombiBAPServiceElementFactory.getServiceElementFactoryAMFM();
                combiBAPCurrentStationInfo = iCombiBAPServiceElementBuilderAMFM.getAMFMCurrentStationEntry(tunerObjectContainer, n3, presetIds.posId, presetIds.index, hMIResourceLocator);
                break;
            }
            case 5: {
                combiBAPCurrentStationInfo = this.createDABCurrentStation(iTunerGUIHandler);
                break;
            }
            case 11: {
                combiBAPCurrentStationInfo = this.createUniCurrentStation(iTunerGUIHandler);
                break;
            }
            case 7: {
                combiBAPCurrentStationInfo = this.createSDARSCurrentStation(iTunerGUIHandler);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Unexpected band: ").append(n).toString());
            }
        }
        return combiBAPCurrentStationInfo;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updatedActiveStation(int n) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] band: %1", (long)n);
        if (n != this.models.getActiveTuner()) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] band not active tuner (%1)", (long)this.models.getActiveTuner());
            return;
        }
        if (n != this.combiWaveband) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] ignore activeStation -> send bandchange fisrt");
            return;
        }
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler == null) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveStation] ITunerGUIHandler is null.");
            return;
        }
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = this.getCurrentActiveStation(n, iTunerGUIHandler);
        boolean bl = false;
        Object object = this.mutex;
        synchronized (object) {
            for (int i2 = 0; i2 < this.lastReceptionList.length; ++i2) {
                if (combiBAPCurrentStationInfo.getListRef() != this.lastReceptionList[i2].getPosID()) continue;
                bl = true;
                break;
            }
        }
        if (!bl) {
            this.sendReceptionList(n);
        }
        if (combiBAPCurrentStationInfo != null) {
            this.logger.log(14808325, "[CombiBAPServiceHandler.updatedActiveStation] %1", (Object)combiBAPCurrentStationInfo);
            try {
                this.combiService.updateCurrentStation(combiBAPCurrentStationInfo);
            }
            catch (Exception exception) {
                this.logger.log(10000, "%1", (Throwable)exception);
            }
        }
        if (this.listUpdateNecessary) {
            this.listUpdateNecessary = false;
            this.sendReceptionList(n);
        }
        if (combiBAPCurrentStationInfo.getPresetListAbsolutePosition() > 0) {
            this.updatedMemoryList();
        }
    }

    @Override
    public void updatedAbortAnnoucementStatus(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedAbortAnnoucementStatus] status:%1", bl);
        try {
            this.combiService.cancelAnnouncementResult(CombiBAPUtilities.getBAPAbortAnnouncementStatus(bl));
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void updatedAnnouncementStatus(int n) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedAnnouncementStatus] status:%1", (long)n);
        int n2 = CombiBAPUtilities.getBAPAnnouncementType(n);
        String string = n2 == 0 ? "" : this.models.getLabelModel(397).getText();
        try {
            this.combiService.updateAnnouncementInfo(n2, string);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void updatedForceStationListUpdateStatus(int n, int n2) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedForceStationListUpdateStatus] band:%1 status:%2", (long)n, (long)n2);
        int n3 = this.models.getActiveTuner();
        try {
            if (n3 == n) {
                if (CombiBAPUtilities.isStationListUpdateRunning(n2, n)) {
                    this.combiService.updateActiveSource(CombiBAPUtilities.getBAPSourceType(n), 0, 0, true, true, 4);
                    this.listUpdateRunning = true;
                } else if (CombiBAPUtilities.isStationListUpdateAborted(n2, n)) {
                    this.combiService.updateActiveSource(CombiBAPUtilities.getBAPSourceType(n), 0, 0, true, true, 3);
                    this.listUpdateRunning = false;
                } else if (CombiBAPUtilities.isStationListUpdateDone(n2, n)) {
                    this.combiService.updateActiveSource(CombiBAPUtilities.getBAPSourceType(n), 0, 0, true, true, 3);
                    this.listUpdateRunning = false;
                } else {
                    this.combiService.updateActiveSource(CombiBAPUtilities.getBAPSourceType(n), 0, 0, true, true, 3);
                    this.startStationListUpdateResult(false);
                    this.listUpdateRunning = false;
                }
            } else {
                this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedForceStationListUpdateStatus] no action! active Tuner is %1 ", (long)n3);
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    void startStationListUpdateResult(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.startStationListUpdateResult] success:%1", bl);
        try {
            if (bl) {
                this.combiService.startStationListUpdateResult(0);
            } else {
                this.combiService.startStationListUpdateResult(1);
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    void cancelStationListUpdateResult(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.cancelStationListUpdateResult] success:%1", bl);
        try {
            if (bl) {
                this.combiService.cancelStationListUpdateResult(0);
            } else {
                this.combiService.cancelStationListUpdateResult(1);
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    private void updatedSeekFrequency(AMFMStation aMFMStation) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedSeekFrequency] status:%1", (Object)aMFMStation);
        String string = aMFMStation.getFrequencyString();
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo(string, 68);
        try {
            this.combiService.updateCurrentStation(combiBAPCurrentStationInfo);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    void selectListEntryResult(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.selectListEntryResult] success:%1", bl);
        try {
            if (bl) {
                this.combiService.selectListEntryResult(0);
            } else {
                this.combiService.selectListEntryResult(1);
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void updatedSkipResult(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.skipResult] success:%1", bl);
        try {
            this.combiService.skipResult(bl);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    void updatedSwitchSourceResult(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedSwitchSourceResult] success:%1", bl);
        int n = CombiBAPUtilities.getBAPSwitchSourceResult(bl);
        try {
            this.combiService.switchSourceResult(n);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    private void updatedMuteStatus(int n) {
        switch (n) {
            case 5: {
                this.updatedMuteStatus(n, this.dabMute);
                break;
            }
            case 11: {
                this.updatedMuteStatus(n, this.uniMute);
                break;
            }
            case 7: {
                this.updatedMuteStatus(n, this.sdarsMute);
                break;
            }
            case 1: {
                this.updatedMuteStatus(n, this.ibocMute);
                break;
            }
        }
    }

    @Override
    public void updatedMuteStatus(int n, boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedMuteState] band:%2 mute:%1", bl, (long)n);
        this.dabMute = n == 5 ? bl : this.dabMute;
        this.uniMute = n == 11 ? bl : this.uniMute;
        this.sdarsMute = n == 7 ? bl : this.sdarsMute;
        this.ibocMute = n == 1 ? bl : this.ibocMute;
        boolean bl2 = this.models.getActiveTuner() == 11 ? this.uniMute : this.dabMute;
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedMuteState] dab: %1 sdars %2 Iboc %3", this.dabMute, this.sdarsMute, this.ibocMute);
        try {
            MuteState$Builder muteState$Builder = MuteState.builder();
            muteState$Builder.setDabMutingLowSignal(bl2);
            muteState$Builder.setSdarsMutingLowSignal(this.sdarsMute);
            muteState$Builder.setIbocNotInSync(this.ibocMute);
            muteState$Builder.setIbocMutingLowSignal(this.ibocMute);
            this.combiService.updateMuteState(muteState$Builder.build());
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    @Override
    public void updatedSeekStatus(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedSeekStatus] seekRunning:%1", bl);
        try {
            this.combiService.updateSeekStatus(bl);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
        if (bl || this.sourceState == 6) {
            this.sourceState = bl ? 6 : 0;
            this.updatedActiveSourceState(this.sourceState);
        }
    }

    @Override
    public void updatedScanStatus(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedScanStatus] scanRunning:%1", bl);
        this.sourceState = bl ? 1 : 0;
        this.updatedActiveSourceState(this.sourceState);
    }

    private void updateManualTuneActiveStatus(boolean bl) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updateMnualTuneActiveStatus] manualMode:%1 ", bl);
        if (bl || this.sourceState == 5) {
            this.logger.log(-2137614336, "[CombiBAPServiceHandler.updateMnualTuneActiveStatus] inform combi");
            this.sourceState = bl ? 5 : 0;
            this.updatedActiveSourceState(this.sourceState);
        }
    }

    private void updatedActiveSourceState(int n) {
        this.logger.log(-2137614336, "[CombiBAPServiceHandler.updatedActiveSourceState] state:%1", (long)n);
        try {
            this.combiService.updateActiveSourceState(n, 0);
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1", (Throwable)exception);
        }
    }

    private String getUniName(UnifiedStationExt unifiedStationExt) {
        return unifiedStationExt.getName(this.dabLongNames);
    }

    private String getAMFMName(AMFMStation aMFMStation) {
        AMFMStation aMFMStation2 = null;
        String string = "";
        aMFMStation2 = this.currentAMFMStation != null && RadioComparators.equals(this.currentAMFMStation, aMFMStation) ? this.currentAMFMStation : aMFMStation;
        if (Utilities.isPiIgnore()) {
            Buffer buffer = new Buffer(50);
            buffer.append(aMFMStation2.getFrequencyString());
            if (aMFMStation2.isHd()) {
                buffer.append(' ');
                if (aMFMStation2.serviceId < 2) {
                    buffer.append(this.getIBOCNameWithoutExt(aMFMStation2));
                } else {
                    buffer.append(aMFMStation2.getHdExtension());
                }
            } else if (!Utilities.isEmpty(aMFMStation2.getName())) {
                buffer.append(' ');
                buffer.append(aMFMStation2.getName());
            }
            string = buffer.toString();
        } else {
            string = aMFMStation2.getName();
            if (Utilities.isEmpty(string)) {
                string = aMFMStation2.getFrequencyString();
            }
        }
        return string;
    }

    private String getDABName(DabStation dabStation) {
        return this.dabLongNames ? dabStation.getFullName() : dabStation.getShortName();
    }

    private String getIBOCNameWithoutExt(AMFMStation aMFMStation) {
        return aMFMStation.getShortNameHD();
    }

    private String getSDARSName(StationInfoExt stationInfoExt) {
        return stationInfoExt.getShortLabel();
    }

    private CombiBAPReceptionListEntry[] createAMFMList(TunerObjectContainer[] tunerObjectContainerArray) {
        CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray = new CombiBAPReceptionListEntry[tunerObjectContainerArray.length];
        ICombiBAPServiceElementFactory iCombiBAPServiceElementFactory = this.variantExt.getCombiBAPServiceElementFactory();
        ICombiBAPServiceElementBuilderAMFM iCombiBAPServiceElementBuilderAMFM = iCombiBAPServiceElementFactory.getServiceElementFactoryAMFM();
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            CombiBAPReceptionListEntry combiBAPReceptionListEntry;
            TunerObjectContainer tunerObjectContainer = tunerObjectContainerArray[i2];
            AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
            int n = this.idMapper.getBapId(aMFMStation.getUniqueId());
            combiBAPReceptionListEntryArray[i2] = combiBAPReceptionListEntry = iCombiBAPServiceElementBuilderAMFM.getAMFMListStationEntry(tunerObjectContainer, n);
        }
        return combiBAPReceptionListEntryArray;
    }

    private CombiBAPReceptionListEntry[] createDABList(TunerObjectContainer[] tunerObjectContainerArray, int n) {
        CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray = new CombiBAPReceptionListEntry[tunerObjectContainerArray.length];
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            int n2;
            int n3;
            int n4;
            int n5;
            TunerObjectContainer tunerObjectContainer = tunerObjectContainerArray[i2];
            DabStation dabStation = tunerObjectContainerArray[i2].getDABStation();
            String string = this.getDABName(dabStation);
            String string2 = "";
            switch (dabStation.getType()) {
                case 1: {
                    EnsembleInfo ensembleInfo = dabStation.ensemble;
                    n5 = 2;
                    string2 = ensembleInfo.getFrequencyLabel();
                    n4 = CombiBAPUtilities.getBAPStationAttributes(tunerObjectContainer);
                    n3 = 0;
                    n2 = 0;
                    break;
                }
                case 2: {
                    n5 = 3;
                    n4 = CombiBAPUtilities.getBAPStationAttributes(tunerObjectContainer);
                    if (n == 3 && (n4 & 1) != 1) {
                        n4 |= 1;
                        n4 |= 8;
                    }
                    n2 = tunerObjectContainer.getPresetPos();
                    n3 = dabStation.getPTY();
                    break;
                }
                default: {
                    n5 = 4;
                    n3 = 0;
                    n4 = CombiBAPUtilities.getBAPStationAttributes(tunerObjectContainer);
                    n2 = 0;
                }
            }
            combiBAPReceptionListEntryArray[i2] = new CombiBAPReceptionListEntry(this.idMapper.getBapId(dabStation.getUniqueId()), n5, string, string2);
            combiBAPReceptionListEntryArray[i2].setAttributes(n4);
            combiBAPReceptionListEntryArray[i2].setCategory(n3);
            combiBAPReceptionListEntryArray[i2].setPresetID(n2);
            this.logger.log(14808325, "[CombiBAPServiceHandler.createDABList] %2:,%1", (Object)combiBAPReceptionListEntryArray[i2], (long)i2);
        }
        return combiBAPReceptionListEntryArray;
    }

    private CombiBAPReceptionListEntry[] createUniList(TunerObjectContainer[] tunerObjectContainerArray) {
        CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray = new CombiBAPReceptionListEntry[tunerObjectContainerArray.length];
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            TunerObjectContainer tunerObjectContainer = tunerObjectContainerArray[i2];
            UnifiedStationExt unifiedStationExt = tunerObjectContainerArray[i2].getUniStation();
            int n = tunerObjectContainer.getPresetPos();
            int n2 = unifiedStationExt.ensId == 0 ? 1 : 3;
            int n3 = Utilities.getDABPty(unifiedStationExt.ptyCodes);
            String string = Utilities.isEmpty(unifiedStationExt.longName) ? unifiedStationExt.shortName : unifiedStationExt.longName;
            String string2 = new StringBuffer().append(Utilities.kHzToMHz(unifiedStationExt.frequency)).append(" MHz").toString();
            combiBAPReceptionListEntryArray[i2] = new CombiBAPReceptionListEntry(this.idMapper.getBapId(unifiedStationExt.getUniqueId()), n2, string, string2);
            combiBAPReceptionListEntryArray[i2].setAttributes(CombiBAPUtilities.getBAPStationAttributes(tunerObjectContainer));
            combiBAPReceptionListEntryArray[i2].setCategory(n3);
            combiBAPReceptionListEntryArray[i2].setPresetID(n);
            this.logger.log(14808325, "[CombiBAPServiceHandler.createUniList] %2:,%1", (Object)combiBAPReceptionListEntryArray[i2], (long)i2);
        }
        return combiBAPReceptionListEntryArray;
    }

    private CombiBAPReceptionListEntry[] createSDARSList(TunerObjectContainer[] tunerObjectContainerArray) {
        CombiBAPReceptionListEntry[] combiBAPReceptionListEntryArray = new CombiBAPReceptionListEntry[tunerObjectContainerArray.length];
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            TunerObjectContainer tunerObjectContainer = tunerObjectContainerArray[i2];
            StationInfoExt stationInfoExt = tunerObjectContainer.getSDARSService();
            int n = tunerObjectContainer.getPresetPos();
            int n2 = stationInfoExt.subscription == 2 ? 128 : 0;
            String string = this.getSDARSName(stationInfoExt);
            String string2 = Utilities.getFormatedStationNumber(stationInfoExt.stationNumber);
            combiBAPReceptionListEntryArray[i2] = new CombiBAPReceptionListEntry(this.idMapper.getBapId(RadioObjectIds.getSDARSObjectId(stationInfoExt.getSID())), 8, string, string2);
            combiBAPReceptionListEntryArray[i2].setAttributes(n2);
            combiBAPReceptionListEntryArray[i2].setCategory(0);
            combiBAPReceptionListEntryArray[i2].setPresetID(n);
            this.logger.log(14808325, "[CombiBAPServiceHandler.createSDARSList] %2: %1", (Object)combiBAPReceptionListEntryArray[i2], (long)i2);
        }
        return combiBAPReceptionListEntryArray;
    }

    private CombiBAPCurrentStationInfo createDABCurrentStation(ITunerGUIHandler iTunerGUIHandler) {
        int n;
        String string;
        TunerObjectContainer tunerObjectContainer = iTunerGUIHandler.getCurrentStation();
        if (tunerObjectContainer == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.createDABCurrentStation] currentStation == null");
            return null;
        }
        DabStation dabStation = tunerObjectContainer.getDABStation();
        int n2 = 0;
        if (dabStation == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.createDABCurrentStation] DabStation == null");
            return null;
        }
        switch (dabStation.getType()) {
            case 2: {
                string = this.getDABName(dabStation);
                n = (int)dabStation.service.sID;
                break;
            }
            case 3: {
                string = this.getDABName(dabStation);
                n = (int)dabStation.component.sID;
                break;
            }
            default: {
                this.logger.log(10000, "[CombiBAPServiceHandler.createDABCurrentStation] Unexpected type: %1", (Object)tunerObjectContainer);
                return null;
            }
        }
        int n3 = this.idMapper.getBapId(dabStation.getUniqueId());
        PresetIds presetIds = this.memory.getPresetIds(tunerObjectContainer);
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo(string, 70, n, n3, 0);
        combiBAPCurrentStationInfo.setPresetListRef(presetIds.posId);
        combiBAPCurrentStationInfo.setPresetListAbsolutePosition(presetIds.index);
        if (TunerProxyManager.getInstance().getDABTuner().getCurLinkState() == 2) {
            n2 |= 0x10;
        }
        if (dabStation.service.tp) {
            n2 |= 8;
        }
        combiBAPCurrentStationInfo.addAttribute(n2);
        HMIResourceLocator hMIResourceLocator = dabStation.getImage(this.imgType);
        this.logger.log(1078071040, "[CombiBAPServiceHandler.createDABCurrentStation] ImageType: %1", (long)this.imgType);
        this.logger.log(1078071040, "[CombiBAPServiceHandler.createDABCurrentStation] ResourceLocator: %1", (Object)hMIResourceLocator.toString());
        hMIResourceLocator = this.checkIfEmpty(hMIResourceLocator, 5);
        combiBAPCurrentStationInfo.setPicture(hMIResourceLocator.getResourceID(), hMIResourceLocator.getResourceURI());
        ArtistAndTitlePair artistAndTitlePair = dabStation.getArtistAndTitlePair();
        String string2 = artistAndTitlePair.titleString;
        if (!Utilities.isEmpty(string2)) {
            combiBAPCurrentStationInfo.setTertiaryInformation(string2, 72);
        }
        if (!Utilities.isEmpty(string2 = artistAndTitlePair.artistString)) {
            combiBAPCurrentStationInfo.setQuaternaryInformation(string2, 73);
        }
        return combiBAPCurrentStationInfo;
    }

    private CombiBAPCurrentStationInfo createUniCurrentStation(ITunerGUIHandler iTunerGUIHandler) {
        TunerObjectContainer tunerObjectContainer = iTunerGUIHandler.getCurrentStation();
        if (tunerObjectContainer == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.createUniCurrentStation] currentStation == null");
            return null;
        }
        UnifiedStationExt unifiedStationExt = tunerObjectContainer.getUniStation();
        String string = this.getUniName(unifiedStationExt);
        int n = 0;
        int n2 = unifiedStationExt.ensId != 0 ? 70 : (unifiedStationExt.isRds() ? 68 : 67);
        int n3 = this.idMapper.getBapId(unifiedStationExt.getUniqueId());
        PresetIds presetIds = this.memory.getPresetIds(tunerObjectContainer);
        if (unifiedStationExt.tpAvailability == 2 || unifiedStationExt.tpAvailability == 3) {
            n |= 8;
        }
        if (unifiedStationExt.getAudioStatus() == 1 && !unifiedStationExt.isFM()) {
            n |= 0x10;
        }
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo(string, n2, 0, n3, 0);
        combiBAPCurrentStationInfo.setPresetListRef(presetIds.posId);
        combiBAPCurrentStationInfo.setPresetListAbsolutePosition(presetIds.index);
        combiBAPCurrentStationInfo.addAttribute(n);
        HMIResourceLocator hMIResourceLocator = unifiedStationExt.getImage(this.imgType);
        hMIResourceLocator = this.checkIfEmpty(hMIResourceLocator, 11);
        combiBAPCurrentStationInfo.setPicture(hMIResourceLocator.getResourceID(), hMIResourceLocator.getResourceURI());
        ArtistAndTitlePair artistAndTitlePair = unifiedStationExt.getArtistAndTitlePair();
        String string2 = artistAndTitlePair.titleString;
        if (!Utilities.isEmpty(string2)) {
            combiBAPCurrentStationInfo.setTertiaryInformation(string2, 72);
        }
        if (!Utilities.isEmpty(string2 = artistAndTitlePair.artistString)) {
            combiBAPCurrentStationInfo.setQuaternaryInformation(string2, 73);
        }
        return combiBAPCurrentStationInfo;
    }

    private CombiBAPCurrentStationInfo createSDARSCurrentStation(ITunerGUIHandler iTunerGUIHandler) {
        TunerObjectContainer tunerObjectContainer = iTunerGUIHandler.getCurrentStation();
        if (tunerObjectContainer == null) {
            this.logger.log(10000, "[CombiBAPServiceHandler.createSDARSCurrentStation] currentStation == null");
            return null;
        }
        StationInfoExt stationInfoExt = tunerObjectContainer.getSDARSService();
        String string = this.getSDARSName(stationInfoExt);
        int n = this.idMapper.getBapId(RadioObjectIds.getSDARSObjectId(stationInfoExt.sID));
        PresetIds presetIds = this.memory.getPresetIds(tunerObjectContainer);
        CombiBAPCurrentStationInfo combiBAPCurrentStationInfo = new CombiBAPCurrentStationInfo(string, 69, 0, n, 0);
        combiBAPCurrentStationInfo.setChannelID(stationInfoExt.getStationNumber());
        combiBAPCurrentStationInfo.setPresetListRef(presetIds.posId);
        combiBAPCurrentStationInfo.setPresetListAbsolutePosition(presetIds.index);
        ArtistAndTitlePair artistAndTitlePair = tunerObjectContainer.getArtistAndTitlePair();
        String string2 = artistAndTitlePair.titleString;
        if (!Utilities.isEmpty(string2)) {
            combiBAPCurrentStationInfo.setTertiaryInformation(string2, 72);
        }
        if (!Utilities.isEmpty(string2 = artistAndTitlePair.artistString)) {
            combiBAPCurrentStationInfo.setQuaternaryInformation(string2, 73);
        }
        HMIResourceLocator hMIResourceLocator = tunerObjectContainer.getImage(this.imgType);
        hMIResourceLocator = this.checkIfEmpty(hMIResourceLocator, 7);
        combiBAPCurrentStationInfo.setPicture(hMIResourceLocator.getResourceID(), hMIResourceLocator.getResourceURI());
        return combiBAPCurrentStationInfo;
    }

    void activateSourceResult(int n) {
        this.combiService.activateSourceResult(n);
    }

    private HMIResourceLocator checkIfEmpty(HMIResourceLocator hMIResourceLocator, int n) {
        if (hMIResourceLocator != ISimpleTuner.EMPTY_RL) {
            return hMIResourceLocator;
        }
        switch (n) {
            case 4: {
                if (this.amDefault == null) {
                    this.amDefault = this.variantExt.getDefaultImage(n);
                }
                return this.amDefault;
            }
            case 1: {
                if (this.fmDefault == null) {
                    this.fmDefault = this.variantExt.getDefaultImage(n);
                }
                return this.fmDefault;
            }
            case 5: {
                if (this.dabDefault == null) {
                    this.dabDefault = this.variantExt.getDefaultImage(n);
                }
                return this.dabDefault;
            }
            case 11: {
                if (this.uniDefault == null) {
                    this.uniDefault = this.variantExt.getDefaultImage(n);
                }
                return this.uniDefault;
            }
            case 7: {
                if (this.sdarsDefault == null) {
                    this.sdarsDefault = this.variantExt.getDefaultImage(n);
                }
                return this.sdarsDefault;
            }
        }
        return ISimpleTuner.EMPTY_RL;
    }

    static /* synthetic */ void access$200(CombiBAPServiceHandler combiBAPServiceHandler, AMFMStation aMFMStation) {
        combiBAPServiceHandler.updatedSeekFrequency(aMFMStation);
    }

    static /* synthetic */ void access$300(CombiBAPServiceHandler combiBAPServiceHandler, boolean bl) {
        combiBAPServiceHandler.updateManualTuneActiveStatus(bl);
    }
}

