/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.BCDTime;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.interapp.IInterappConnectionListener;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.ITVInterappService;
import de.audi.tv.app.interapp.InterappUtil;
import de.audi.tv.app.interapp.NullTVInterappListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultTVListsListener;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;
import org.dsi.ifc.tvtuner.Time;

public class TvSdisManager
implements ITVInterappService {
    private StationMapper mapper;
    public final TVListener tvListener = new TVListener();
    public final ITVListsListener listsListener = new ListListener();
    public final ITVEventListener eventListener = new TVEventListener();
    public final DSICallListener callListener = new CallListener();
    private final TVEnv env;
    private final DSIHandler dsi;
    private final KeyPanelHandler keyPanelHandler;
    private final IInterappConnectionListener interappConnectionListener;
    private final ISourceActivator sourceActivator;
    private int currentTerminalMode = -2;
    private int currentSource = 0;
    private ITVInterappListener service = new NullTVInterappListener();
    private boolean serviceUsesTV = false;
    private boolean muHasAudioFocus = false;
    private boolean isTunerInEsm = true;
    private final Object stateUsageMutex = new Object();
    private ProgramInfo currentProgram = new ProgramInfo();
    private short[] keyPanel = new short[0];
    private ITVInterappListener.TvTunerConfig tvConfig = new ITVInterappListener.TvTunerConfig();
    private ITVInterappListener.ServiceInfo[] services = new ITVInterappListener.ServiceInfo[0];
    private int parentalLevel = 0;
    private boolean isParentalManagementRequired = false;
    private boolean isSearchRunning = false;
    public static final SimpleIntIntMap CONTEXT_SYNCHRONIZATION_MAP = new SimpleIntIntMap(4);

    public TvSdisManager(TVEnv tVEnv, DSIHandler dSIHandler, StationMapper stationMapper, KeyPanelHandler keyPanelHandler, IInterappConnectionListener iInterappConnectionListener, ISourceActivator iSourceActivator) {
        this.env = tVEnv;
        this.dsi = dSIHandler;
        this.mapper = stationMapper;
        this.keyPanelHandler = keyPanelHandler;
        this.interappConnectionListener = iInterappConnectionListener;
        this.sourceActivator = iSourceActivator;
        tVEnv.getChoiceModel(2600146).setStatus(0);
        tVEnv.getButtonModel(2600090).setButtonListener(new ParentalEnforcementListener());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerService(ITVInterappListener iTVInterappListener) {
        if (iTVInterappListener != null) {
            this.service = iTVInterappListener;
            if (iTVInterappListener instanceof NullTVInterappListener) {
                Object object = this.stateUsageMutex;
                synchronized (object) {
                    this.serviceUsesTV = false;
                }
            }
            Object object = this.stateUsageMutex;
            synchronized (object) {
                iTVInterappListener.updateTerminalMode(this.getSdisTerminalMode());
            }
            iTVInterappListener.updatePanelKeySet(this.keyPanel);
            iTVInterappListener.updateTvTunerConfig(this.tvConfig);
            iTVInterappListener.updateTVStationList(this.services);
            iTVInterappListener.updateSeekStatus(this.isSearchRunning);
            this.sendSdisActiveStation(this.currentProgram);
        }
    }

    private byte getSdisTerminalMode() {
        int n = 0;
        if (this.muHasAudioFocus || this.serviceUsesTV) {
            if (this.currentSource == 0) {
                n = 1;
            } else if (this.currentSource == 1) {
                n = 2;
            }
        }
        return InterappUtil.getSDISTerminalMode(this.currentTerminalMode, n, this.isTunerInEsm);
    }

    public void setActiveStation(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.env.getBaseListModel(2600000).getRowByUniqueID(l);
        this.env.lcHMI.log(10000000, "[TVInterappManager.setActiveStation] %1", (Object)abstractTVStationRow);
        this.dsi.selectService(abstractTVStationRow.service, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setTerminalMode(byte by) {
        int n = InterappUtil.getMUTerminalMode(by);
        switch (n) {
            case -1: {
                break;
            }
            case -2: {
                this.env.lcHMI.log(10000, "[TVInterappManager.setTerminalMode] tried to set unknown terminal mode: %1. Nothing done.", (long)by);
                break;
            }
            default: {
                this.env.properties.terminalMode.desiredTerminalMode.accept(new Integer(n));
                this.setApplicationContext(n);
                this.env.getChoiceModel(2600146).setStatus(1);
                Object object = this.stateUsageMutex;
                synchronized (object) {
                    if (by == 2 && this.currentSource == 1) {
                        this.sourceActivator.activate(0);
                    }
                    break;
                }
            }
        }
    }

    private void setApplicationContext(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(2600146);
        int n2 = CONTEXT_SYNCHRONIZATION_MAP.get(n);
        if (n2 != -1) {
            choiceModelApp.setValue(n2);
        } else {
            choiceModelApp.setValue(0);
        }
    }

    public void sendPressedPanelKey(short s) {
        this.keyPanelHandler.externalKeyPressed(s);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void logonToTV() {
        this.interappConnectionListener.onGotInterappConnection();
        Object object = this.stateUsageMutex;
        synchronized (object) {
            this.serviceUsesTV = true;
            this.service.updateTerminalMode(this.getSdisTerminalMode());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void logoffFromTV() {
        this.interappConnectionListener.onLostInterappConnection();
        Object object = this.stateUsageMutex;
        synchronized (object) {
            this.serviceUsesTV = false;
            this.service.updateTerminalMode(this.getSdisTerminalMode());
        }
    }

    private void sendSdisActiveStation(ProgramInfo programInfo) {
        long l = this.mapper.getServiceID(programInfo.getServiceInfo());
        if (l != 0L) {
            this.service.updateActiveStation(new ITVInterappListener.ActiveStationInfo(l, programInfo.serviceInfo.name, programInfo.channelName, programInfo.normArea, programInfo.videoFormat, programInfo.selectedAudioChannel, programInfo.caDescriptor, programInfo.casStatus, TVUtil.singleByteBCDToDual(programInfo.parentalRating), InterappUtil.translateTvTunerFlag(programInfo.epgFlag), InterappUtil.translateTvTunerFlag(programInfo.teletextFlag), InterappUtil.translateTvTunerFlag(programInfo.variantDatabroadcastFlag), InterappUtil.translateTvTunerFlag(programInfo.databroadcastFlag1), InterappUtil.translateTvTunerFlag(programInfo.databroadcastFlag2), InterappUtil.translateTvTunerFlag(programInfo.bwsFlag), InterappUtil.translateTvTunerFlag(programInfo.slsFlag), InterappUtil.translateTvTunerFlag(programInfo.txtFlag), InterappUtil.translateTvTunerFlag(programInfo.casFlag), InterappUtil.translateTvTunerFlag(programInfo.visAudioFlag), InterappUtil.translateTvTunerFlag(programInfo.announcement), InterappUtil.translateTvTunerFlag(programInfo.subtitleFlag), TvSdisManager.getSdisProgramInfo(programInfo.nowProgramInfo, programInfo.nowStartTime, programInfo.nowEndTime), TvSdisManager.getSdisProgramInfo(programInfo.nextProgramInfo, programInfo.nextStartTime, programInfo.nextEndTime), TvSdisManager.getSdisAudioChannels(programInfo.availableAudioChannels)));
        }
    }

    private static ITVInterappListener.ProgramInfo getSdisProgramInfo(String string, Time time, Time time2) {
        int n = -1;
        int n2 = -1;
        int n3 = -1;
        int n4 = -1;
        int n5 = -1;
        int n6 = -1;
        if (time != null && BCDTime.isValid(time)) {
            n = TVUtil.singleByteBCDToDual(time.hour);
            n2 = TVUtil.singleByteBCDToDual(time.minute);
            n3 = TVUtil.singleByteBCDToDual(time.second);
        }
        if (time2 != null && BCDTime.isValid(time2)) {
            n4 = TVUtil.singleByteBCDToDual(time2.hour);
            n5 = TVUtil.singleByteBCDToDual(time2.minute);
            n6 = TVUtil.singleByteBCDToDual(time2.second);
        }
        return new ITVInterappListener.ProgramInfo(string, n, n2, n3, n4, n5, n6);
    }

    private static ITVInterappListener.AudioChannel[] getSdisAudioChannels(AudioChannel[] audioChannelArray) {
        ITVInterappListener.AudioChannel[] audioChannelArray2 = new ITVInterappListener.AudioChannel[audioChannelArray == null ? 0 : audioChannelArray.length];
        for (int i2 = 0; i2 < audioChannelArray2.length; ++i2) {
            AudioChannel audioChannel = audioChannelArray[i2];
            audioChannelArray2[i2] = new ITVInterappListener.AudioChannel(audioChannel.channelID, audioChannel.audioLanguage, audioChannel.audioFormat, audioChannel.audioDescription);
        }
        return audioChannelArray2;
    }

    public void updateSdisTerminalMode(byte by) {
        this.service.updateTerminalMode(by);
    }

    static /* synthetic */ short[] access$1502(TvSdisManager tvSdisManager, short[] sArray) {
        tvSdisManager.keyPanel = sArray;
        return sArray;
    }

    static /* synthetic */ ITVInterappListener.ServiceInfo[] access$2102(TvSdisManager tvSdisManager, ITVInterappListener.ServiceInfo[] serviceInfoArray) {
        tvSdisManager.services = serviceInfoArray;
        return serviceInfoArray;
    }

    static {
        CONTEXT_SYNCHRONIZATION_MAP.add(0, 1);
        CONTEXT_SYNCHRONIZATION_MAP.add(13, 3);
        CONTEXT_SYNCHRONIZATION_MAP.add(1, 4);
        CONTEXT_SYNCHRONIZATION_MAP.add(7, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(8, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(6, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(5, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(4, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(2, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(3, 5);
        CONTEXT_SYNCHRONIZATION_MAP.add(14, 6);
    }

    private class TVListener
    extends DefaultTVListener {
        private TVListener() {
        }

        public void updateTuneStatus(boolean bl, boolean bl2, boolean bl3) {
            boolean bl4;
            boolean bl5 = bl4 = bl || bl2;
            if (bl4 != TvSdisManager.this.isSearchRunning) {
                TvSdisManager.this.isSearchRunning = bl4;
                TvSdisManager.this.service.updateSeekStatus(bl4);
            }
        }

        public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
            TvSdisManager.access$1502(TvSdisManager.this, startUpConfig.requiredKeypanelList);
            TvSdisManager.this.isParentalManagementRequired = startUpConfig.parentalControlReq;
            TvSdisManager.this.service.updatePanelKeySet(startUpConfig.requiredKeypanelList);
            TvSdisManager.this.service.updateParentalSettings(startUpConfig.parentalControlReq, TvSdisManager.this.parentalLevel);
            TvSdisManager.this.tvConfig = new ITVInterappListener.TvTunerConfig(startUpConfig.linkingAvail, startUpConfig.avSrcAvail, startUpConfig.tvNormAvail, startUpConfig.audioChannelAvail, startUpConfig.videoFormatAvail, startUpConfig.avNormAvail, startUpConfig.avFormatAvail, startUpConfig.subtitleAvail, startUpConfig.ewsAvail, startUpConfig.logoListAvail, startUpConfig.casAvail, startUpConfig.skipBehaviourAvail, startUpConfig.visualAudioAvail, startUpConfig.browserListSortAvail, startUpConfig.parentalControlReq, startUpConfig.tmTeletextAvail, startUpConfig.tmDatabroadDMBAvail, startUpConfig.tmDatabroadISDBAvail, startUpConfig.tmDatabroadDTMBAvail, startUpConfig.tmDatabroadDMBAvail, startUpConfig.tmDatabroadATSCAvail, startUpConfig.tmDatabroad1Avail, startUpConfig.tmDatabroad2Avail, startUpConfig.tmBWSAvail, startUpConfig.tmSLSDLSAvail, startUpConfig.tmTXTAvail, startUpConfig.tmCASAvail, startUpConfig.tmEPGAvail, startUpConfig.tmVisualAudioAvail);
            TvSdisManager.this.service.updateTvTunerConfig(TvSdisManager.this.tvConfig);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateSelectedSource(int n) {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.currentSource = n;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateTerminalMode(int n, int n2) {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.currentTerminalMode = n;
                TvSdisManager.this.setApplicationContext(n);
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        public void updateMuteState(int n) {
            TvSdisManager.this.service.updateTvState(new ITVInterappListener.TvState(InterappUtil.translateMuteState(n)));
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateMessageService(int n) {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.isTunerInEsm = n == 1;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }
    }

    private class CallListener
    extends DSICallListener {
        private CallListener() {
        }

        public void selectService(ServiceInfo serviceInfo, boolean bl) {
            TvSdisManager.this.currentProgram = new ProgramInfo();
            ((TvSdisManager)TvSdisManager.this).currentProgram.serviceInfo = serviceInfo;
            TvSdisManager.this.sendSdisActiveStation(TvSdisManager.this.currentProgram);
            TvSdisManager.this.service.updateTvState(new ITVInterappListener.TvState(0));
        }
    }

    private class ListListener
    extends DefaultTVListsListener {
        private ListListener() {
        }

        public void updateStationList() {
            BaseListModelApp baseListModelApp = TvSdisManager.this.env.getBaseListModel(2600000).getCopy();
            ITVInterappListener.ServiceInfo[] serviceInfoArray = new ITVInterappListener.ServiceInfo[baseListModelApp.getLength()];
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
                ServiceInfo serviceInfo = abstractTVStationRow.service;
                serviceInfoArray[i2] = new ITVInterappListener.ServiceInfo(abstractTVStationRow.getUniqueID(), serviceInfo.name, serviceInfo.sType, serviceInfo.getContentGroup());
            }
            TvSdisManager.access$2102(TvSdisManager.this, serviceInfoArray);
            TvSdisManager.this.service.updateTVStationList(serviceInfoArray);
        }
    }

    private class TVEventListener
    extends TVEventDefaultListener {
        private TVEventListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onEsmLeft() {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.currentTerminalMode = 0;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerAvailable() {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.currentTerminalMode = 0;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onTunerUnavailable() {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.currentTerminalMode = -2;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onMuGotTvAudioFocus() {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.muHasAudioFocus = true;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void onMuLostTvAudioFocus() {
            Object object = TvSdisManager.this.stateUsageMutex;
            synchronized (object) {
                TvSdisManager.this.muHasAudioFocus = false;
                TvSdisManager.this.service.updateTerminalMode(TvSdisManager.this.getSdisTerminalMode());
            }
        }

        public void parentalLevelSettingChanged(int n) {
            TvSdisManager.this.parentalLevel = n;
            TvSdisManager.this.service.updateParentalSettings(TvSdisManager.this.isParentalManagementRequired, n);
        }

        public void onSelectedServiceDebounced(ProgramInfo programInfo) {
            TvSdisManager.this.currentProgram = programInfo;
            TvSdisManager.this.sendSdisActiveStation(programInfo);
        }
    }

    private class ParentalEnforcementListener
    extends DefaultButtonListener {
        private ParentalEnforcementListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            TvSdisManager.this.service.enforceTV();
        }
    }
}

