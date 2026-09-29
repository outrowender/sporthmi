/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.interapp.ITVInterappListener$ActiveStationInfo;
import de.audi.tv.app.interapp.ITVInterappListener$AudioChannel;
import de.audi.tv.app.interapp.ITVInterappListener$ProgramInfo;
import de.audi.tv.app.interapp.ITVInterappService;
import de.audi.tv.app.interapp.NullTVInterappService;
import de.audi.tv.app.sdis.InterappKeyPanelHandler;
import de.audi.tv.app.sdis.ParentalEnforcement;
import de.audi.tv.app.sdis.SDISOnOffLineHandler;
import de.audi.tv.app.sdis.TVASIProvider$BlockingListener;
import de.audi.tv.app.sdis.TVASIProvider$TVInterappListener;
import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.AudioChannel;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.ProgramInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ASIHMISyncTVService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;

public class TVASIProvider
extends ASIHMISyncTVAbstractBaseService
implements IASIProvider {
    public final TVASIProvider$TVInterappListener tvInterappListener = new TVASIProvider$TVInterappListener(this, null);
    public final TVASIProvider$BlockingListener blockingListener = new TVASIProvider$BlockingListener(this, null);
    public final ParentalEnforcement parentalEnforcement = new ParentalEnforcement();
    private final SDISOnOffLineHandler onOffHandler;
    private ITVInterappService tvInterappService;
    private final ASIHMISyncTVService tvService;
    private final LogChannel log;
    private boolean sdisBlocked = false;
    private volatile boolean tvIsUsed = false;
    private final Object tvUsageMutex = new Object();
    public static final byte[][] TERMINAL_MODE_MAP = new byte[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {9, 9}, {10, 10}, {11, 11}, {12, 12}, {13, 13}, {14, 14}, {15, 15}, {16, 16}, {17, 17}, {18, 18}, {19, 19}, {20, 20}, {21, 21}, {127, 127}};

    public TVASIProvider(LogChannel logChannel, int n) {
        this.tvService = new ASIHMISyncTVService(n, this);
        this.log = logChannel;
        this.tvInterappService = new NullTVInterappService();
        this.onOffHandler = new SDISOnOffLineHandler(logChannel);
        try {
            this.updateReplyIDs(new short[]{12, 14, 19, 20, 18, 15, 21, 22, 23, 24});
            this.updateRequestIDs(new short[]{0, 1, 2, 8, 9, 10, 3, 4, 6, 7, 11});
            this.updateASIVersion("3.4.00");
        }
        catch (MethodException methodException) {
            logChannel.log(10000, "TVASIProvider - could not register ASI version!");
        }
    }

    public void setTVInterappService(ITVInterappService iTVInterappService) {
        this.tvInterappService = iTVInterappService;
    }

    @Override
    public IService getService() {
        return this.tvService;
    }

    @Override
    public void attachStub(IStub iStub) {
        this.onOffHandler.registerStub();
        this.log.log(1078071040, "[TVASIProvider.attachStub] attaching stub: %1", (Object)iStub);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void detachStub(IStub iStub) {
        this.log.log(1078071040, "[TVASIProvider.detachStub] detaching stub: %1", (Object)iStub);
        Object object = this.tvUsageMutex;
        synchronized (object) {
            boolean bl = this.onOffHandler.unregisterStub();
            if (bl && this.tvIsUsed) {
                this.tvIsUsed = false;
                this.tvInterappService.logoffFromTV();
            }
        }
    }

    @Override
    public void setActiveStation(long l, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.log.log(-2137614336, "[TVASIProvider.activeStation] setting active station: %1", l);
        if (!this.sdisBlocked && this.tvIsUsed) {
            this.tvInterappService.setActiveStation(l);
        } else {
            this.log.log(1078071040, "[TVASIProvider.setActiveStation] blocked -> no action");
        }
    }

    @Override
    public void setTerminalMode(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.log.log(-2137614336, "[TVASIProvider.setTerminalMode] setting terminal mode: %1", (long)by);
        if (!this.sdisBlocked && this.tvIsUsed) {
            for (int i2 = 0; i2 < TERMINAL_MODE_MAP.length; ++i2) {
                byte[] byArray = TERMINAL_MODE_MAP[i2];
                if (byArray[1] != by) continue;
                this.tvInterappService.setTerminalMode(byArray[0]);
                break;
            }
        } else {
            this.log.log(1078071040, "[TVASIProvider.setTerminalMode] blocked -> no action");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void logonToTV(ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.log.log(-2137614336, "[TVASIProvider.logonToTV] device registers for TV.");
        Object object = this.tvUsageMutex;
        synchronized (object) {
            this.onOffHandler.logonToTV();
            if (!this.tvIsUsed) {
                this.tvIsUsed = true;
                this.tvInterappService.logonToTV();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void logoffFromTV(ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.log.log(-2137614336, "[TVASIProvider.logoffFromTV] device unregisters from TV.");
        Object object = this.tvUsageMutex;
        synchronized (object) {
            boolean bl = this.onOffHandler.logoffFromTV();
            if (bl && this.tvIsUsed) {
                this.tvIsUsed = false;
                this.tvInterappService.logoffFromTV();
            }
        }
    }

    @Override
    public void sendPressedPanelKey(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.log.log(-2137614336, "[TVASIProvider.sendPressedPanelKey] sending panel key: %1", (long)by);
        if (!this.sdisBlocked && this.tvIsUsed) {
            this.tvInterappService.sendPressedPanelKey(InterappKeyPanelHandler.mapToDSI(by));
        } else {
            this.log.log(1078071040, "[TVASIProvider.sendPressedPanelKey] blocked -> no action");
        }
    }

    @Override
    public void searchChannel(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) {
        this.log.log(1078071040, "[TVASIProvider.searchChannel] not supported");
    }

    @Override
    public void updateActiveStationInfo(ActiveStationInfo activeStationInfo) {
        this.log.log(-2137614336, "[TVASIProvider.updateActiveStationInfo] Updating active station: %1", activeStationInfo.id);
        try {
            super.updateActiveStationInfo(activeStationInfo);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateSeekStatus(byte by) {
        this.log.log(-2137614336, "[TVASIProvider.updateSeekStatus] Updating seek status: %1", (long)by);
        try {
            super.updateSeekStatus(by);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateStationInfo(StationInfo[] stationInfoArray) {
        this.log.log(-2137614336, "[TVASIProvider.updateStationInfo] Updating station list.");
        try {
            super.updateStationInfo(stationInfoArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTerminalMode(byte by) {
        this.log.log(-2137614336, "[TVASIProvider.updateTerminalMode] Updating terminal mode: %1", (long)by);
        try {
            super.updateTerminalMode(by);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updatePanelKeySet(KeySet[] keySetArray) {
        try {
            super.updatePanelKeySet(keySetArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateParentalSettings(ParentalSettings parentalSettings) {
        this.log.log(-2137614336, "[TVASIProvider.updateParentalSettings] parental management required: %1, parental level: %2", parentalSettings.isParentalManagementRequired, (long)parentalSettings.parentalLevel);
        try {
            super.updateParentalSettings(parentalSettings);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateActiveTVStationState(long l) {
        this.log.log(-2137614336, "[TVASIProvider.updateActiveTVStationState] state: 0x%1", l);
        try {
            super.updateActiveTVStationState(l);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateTunerConfig(long l) {
        this.log.log(-2137614336, "[TVASIProvider.updateTunerConfig] configuration: 0x%1", l);
        try {
            super.updateTunerConfig(l);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    private static ActiveStationInfo getAsiStationInfo(ITVInterappListener$ActiveStationInfo iTVInterappListener$ActiveStationInfo) {
        int[] nArray = new int[]{iTVInterappListener$ActiveStationInfo.normArea, iTVInterappListener$ActiveStationInfo.videoFormat, iTVInterappListener$ActiveStationInfo.selectedAudioChannel, iTVInterappListener$ActiveStationInfo.caDescriptor, iTVInterappListener$ActiveStationInfo.casStatus, iTVInterappListener$ActiveStationInfo.parentalRating};
        int[] nArray2 = new int[]{TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.epgFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.teletextFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.dataBroadcastFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.dataBroadcast1Flag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.dataBroadcast2Flag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.bwsFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.slsFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.txtFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.casFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.visualAudioFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.ewsFlag), TVASIProvider.translateServiceFlag(iTVInterappListener$ActiveStationInfo.subtitleFlag)};
        AudioChannel[] audioChannelArray = new AudioChannel[iTVInterappListener$ActiveStationInfo.audioChannels.length];
        for (int i2 = 0; i2 < audioChannelArray.length; ++i2) {
            ITVInterappListener$AudioChannel iTVInterappListener$AudioChannel = iTVInterappListener$ActiveStationInfo.audioChannels[i2];
            audioChannelArray[i2] = new AudioChannel(iTVInterappListener$AudioChannel.id, iTVInterappListener$AudioChannel.language, iTVInterappListener$AudioChannel.format, iTVInterappListener$AudioChannel.description);
        }
        return new ActiveStationInfo(iTVInterappListener$ActiveStationInfo.id, iTVInterappListener$ActiveStationInfo.stationName, iTVInterappListener$ActiveStationInfo.channelName, nArray, nArray2, TVASIProvider.getAsiProgramInfo(iTVInterappListener$ActiveStationInfo.currentProgram), TVASIProvider.getAsiProgramInfo(iTVInterappListener$ActiveStationInfo.nextProgram), audioChannelArray);
    }

    private static ProgramInfo getAsiProgramInfo(ITVInterappListener$ProgramInfo iTVInterappListener$ProgramInfo) {
        return new ProgramInfo(iTVInterappListener$ProgramInfo.name, iTVInterappListener$ProgramInfo.startHour, iTVInterappListener$ProgramInfo.startMinute, iTVInterappListener$ProgramInfo.startSecond, iTVInterappListener$ProgramInfo.endHour, iTVInterappListener$ProgramInfo.endMinute, iTVInterappListener$ProgramInfo.endSecond);
    }

    private static int translateServiceFlag(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    static /* synthetic */ ActiveStationInfo access$200(ITVInterappListener$ActiveStationInfo activeStationInfo) {
        return TVASIProvider.getAsiStationInfo(activeStationInfo);
    }

    static /* synthetic */ LogChannel access$300(TVASIProvider tVASIProvider) {
        return tVASIProvider.log;
    }

    static /* synthetic */ boolean access$402(TVASIProvider tVASIProvider, boolean bl) {
        tVASIProvider.sdisBlocked = bl;
        return tVASIProvider.sdisBlocked;
    }
}

