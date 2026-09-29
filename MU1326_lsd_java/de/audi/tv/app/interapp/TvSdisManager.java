/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.BCDTime;
import de.audi.tv.app.TVUtil;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.interapp.IInterappConnectionListener;
import de.audi.tv.app.interapp.ISourceActivator;
import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.ITVInterappListener$ActiveStationInfo;
import de.audi.tv.app.interapp.ITVInterappListener$AudioChannel;
import de.audi.tv.app.interapp.ITVInterappListener$ProgramInfo;
import de.audi.tv.app.interapp.ITVInterappListener$ServiceInfo;
import de.audi.tv.app.interapp.ITVInterappListener$TvTunerConfig;
import de.audi.tv.app.interapp.ITVInterappService;
import de.audi.tv.app.interapp.InterappUtil;
import de.audi.tv.app.interapp.NullTVInterappListener;
import de.audi.tv.app.interapp.TvSdisManager$CallListener;
import de.audi.tv.app.interapp.TvSdisManager$ListListener;
import de.audi.tv.app.interapp.TvSdisManager$ParentalEnforcementListener;
import de.audi.tv.app.interapp.TvSdisManager$TVEventListener;
import de.audi.tv.app.interapp.TvSdisManager$TVListener;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import org.dsi.ifc.tvtuner.AudioChannel;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.Time;

public class TvSdisManager
implements ITVInterappService {
    private StationMapper mapper;
    public final TvSdisManager$TVListener tvListener = new TvSdisManager$TVListener(this, null);
    public final ITVListsListener listsListener = new TvSdisManager$ListListener(this, null);
    public final ITVEventListener eventListener = new TvSdisManager$TVEventListener(this, null);
    public final DSICallListener callListener = new TvSdisManager$CallListener(this, null);
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
    private ITVInterappListener$TvTunerConfig tvConfig = new ITVInterappListener$TvTunerConfig();
    private ITVInterappListener$ServiceInfo[] services = new ITVInterappListener$ServiceInfo[0];
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
        tVEnv.getChoiceModel(-760469760).setStatus(0);
        tVEnv.getButtonModel(-1699993856).setButtonListener(new TvSdisManager$ParentalEnforcementListener(this, null));
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

    @Override
    public void setActiveStation(long l) {
        AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)this.env.getBaseListModel(1085024000).getRowByUniqueID(l);
        this.env.lcHMI.log(-2137614336, "[TVInterappManager.setActiveStation] %1", (Object)abstractTVStationRow);
        this.dsi.selectService(abstractTVStationRow.service, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
                this.env.getChoiceModel(-760469760).setStatus(1);
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
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(-760469760);
        int n2 = CONTEXT_SYNCHRONIZATION_MAP.get(n);
        if (n2 != -1) {
            choiceModelApp.setValue(n2);
        } else {
            choiceModelApp.setValue(0);
        }
    }

    @Override
    public void sendPressedPanelKey(short s) {
        this.keyPanelHandler.externalKeyPressed(s);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
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
    @Override
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
            this.service.updateActiveStation(new ITVInterappListener$ActiveStationInfo(l, programInfo.serviceInfo.name, programInfo.channelName, programInfo.normArea, programInfo.videoFormat, programInfo.selectedAudioChannel, programInfo.caDescriptor, programInfo.casStatus, TVUtil.singleByteBCDToDual(programInfo.parentalRating), InterappUtil.translateTvTunerFlag(programInfo.epgFlag), InterappUtil.translateTvTunerFlag(programInfo.teletextFlag), InterappUtil.translateTvTunerFlag(programInfo.variantDatabroadcastFlag), InterappUtil.translateTvTunerFlag(programInfo.databroadcastFlag1), InterappUtil.translateTvTunerFlag(programInfo.databroadcastFlag2), InterappUtil.translateTvTunerFlag(programInfo.bwsFlag), InterappUtil.translateTvTunerFlag(programInfo.slsFlag), InterappUtil.translateTvTunerFlag(programInfo.txtFlag), InterappUtil.translateTvTunerFlag(programInfo.casFlag), InterappUtil.translateTvTunerFlag(programInfo.visAudioFlag), InterappUtil.translateTvTunerFlag(programInfo.announcement), InterappUtil.translateTvTunerFlag(programInfo.subtitleFlag), TvSdisManager.getSdisProgramInfo(programInfo.nowProgramInfo, programInfo.nowStartTime, programInfo.nowEndTime), TvSdisManager.getSdisProgramInfo(programInfo.nextProgramInfo, programInfo.nextStartTime, programInfo.nextEndTime), TvSdisManager.getSdisAudioChannels(programInfo.availableAudioChannels)));
        }
    }

    private static ITVInterappListener$ProgramInfo getSdisProgramInfo(String string, Time time, Time time2) {
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
        return new ITVInterappListener$ProgramInfo(string, n, n2, n3, n4, n5, n6);
    }

    private static ITVInterappListener$AudioChannel[] getSdisAudioChannels(AudioChannel[] audioChannelArray) {
        ITVInterappListener$AudioChannel[] iTVInterappListener$AudioChannelArray = new ITVInterappListener$AudioChannel[audioChannelArray == null ? 0 : audioChannelArray.length];
        for (int i2 = 0; i2 < iTVInterappListener$AudioChannelArray.length; ++i2) {
            AudioChannel audioChannel = audioChannelArray[i2];
            iTVInterappListener$AudioChannelArray[i2] = new ITVInterappListener$AudioChannel(audioChannel.channelID, audioChannel.audioLanguage, audioChannel.audioFormat, audioChannel.audioDescription);
        }
        return iTVInterappListener$AudioChannelArray;
    }

    public void updateSdisTerminalMode(byte by) {
        this.service.updateTerminalMode(by);
    }

    static /* synthetic */ Object access$500(TvSdisManager tvSdisManager) {
        return tvSdisManager.stateUsageMutex;
    }

    static /* synthetic */ int access$602(TvSdisManager tvSdisManager, int n) {
        tvSdisManager.currentTerminalMode = n;
        return tvSdisManager.currentTerminalMode;
    }

    static /* synthetic */ byte access$700(TvSdisManager tvSdisManager) {
        return tvSdisManager.getSdisTerminalMode();
    }

    static /* synthetic */ ITVInterappListener access$800(TvSdisManager tvSdisManager) {
        return tvSdisManager.service;
    }

    static /* synthetic */ boolean access$902(TvSdisManager tvSdisManager, boolean bl) {
        tvSdisManager.muHasAudioFocus = bl;
        return tvSdisManager.muHasAudioFocus;
    }

    static /* synthetic */ int access$1002(TvSdisManager tvSdisManager, int n) {
        tvSdisManager.parentalLevel = n;
        return tvSdisManager.parentalLevel;
    }

    static /* synthetic */ boolean access$1100(TvSdisManager tvSdisManager) {
        return tvSdisManager.isParentalManagementRequired;
    }

    static /* synthetic */ ProgramInfo access$1202(TvSdisManager tvSdisManager, ProgramInfo programInfo) {
        tvSdisManager.currentProgram = programInfo;
        return tvSdisManager.currentProgram;
    }

    static /* synthetic */ void access$1300(TvSdisManager tvSdisManager, ProgramInfo programInfo) {
        tvSdisManager.sendSdisActiveStation(programInfo);
    }

    static /* synthetic */ boolean access$1400(TvSdisManager tvSdisManager) {
        return tvSdisManager.isSearchRunning;
    }

    static /* synthetic */ boolean access$1402(TvSdisManager tvSdisManager, boolean bl) {
        tvSdisManager.isSearchRunning = bl;
        return tvSdisManager.isSearchRunning;
    }

    static /* synthetic */ short[] access$1502(TvSdisManager tvSdisManager, short[] sArray) {
        tvSdisManager.keyPanel = sArray;
        return sArray;
    }

    static /* synthetic */ boolean access$1102(TvSdisManager tvSdisManager, boolean bl) {
        tvSdisManager.isParentalManagementRequired = bl;
        return tvSdisManager.isParentalManagementRequired;
    }

    static /* synthetic */ int access$1000(TvSdisManager tvSdisManager) {
        return tvSdisManager.parentalLevel;
    }

    static /* synthetic */ ITVInterappListener$TvTunerConfig access$1602(TvSdisManager tvSdisManager, ITVInterappListener$TvTunerConfig tvTunerConfig) {
        tvSdisManager.tvConfig = tvTunerConfig;
        return tvSdisManager.tvConfig;
    }

    static /* synthetic */ ITVInterappListener$TvTunerConfig access$1600(TvSdisManager tvSdisManager) {
        return tvSdisManager.tvConfig;
    }

    static /* synthetic */ int access$1702(TvSdisManager tvSdisManager, int n) {
        tvSdisManager.currentSource = n;
        return tvSdisManager.currentSource;
    }

    static /* synthetic */ void access$1800(TvSdisManager tvSdisManager, int n) {
        tvSdisManager.setApplicationContext(n);
    }

    static /* synthetic */ boolean access$1902(TvSdisManager tvSdisManager, boolean bl) {
        tvSdisManager.isTunerInEsm = bl;
        return tvSdisManager.isTunerInEsm;
    }

    static /* synthetic */ ProgramInfo access$1200(TvSdisManager tvSdisManager) {
        return tvSdisManager.currentProgram;
    }

    static /* synthetic */ TVEnv access$2000(TvSdisManager tvSdisManager) {
        return tvSdisManager.env;
    }

    static /* synthetic */ ITVInterappListener$ServiceInfo[] access$2102(TvSdisManager tvSdisManager, ITVInterappListener$ServiceInfo[] iTVInterappListener$ServiceInfoArray) {
        tvSdisManager.services = iTVInterappListener$ServiceInfoArray;
        return iTVInterappListener$ServiceInfoArray;
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
}

