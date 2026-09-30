/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sdis;

import de.audi.atip.agent.IASIProvider;
import de.audi.atip.interapp.sdis.ISDISBlockingListener;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.ITVInterappService;
import de.audi.tv.app.interapp.NullTVInterappService;
import de.audi.tv.app.sdis.InterappKeyPanelHandler;
import de.audi.tv.app.sdis.ParentalEnforcement;
import de.audi.tv.app.sdis.SDISOnOffLineHandler;
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
import java.util.ArrayList;

public class TVASIProvider
extends ASIHMISyncTVAbstractBaseService
implements IASIProvider {
    public final TVInterappListener tvInterappListener = new TVInterappListener();
    public final BlockingListener blockingListener = new BlockingListener();
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

    public IService getService() {
        return this.tvService;
    }

    public void attachStub(IStub iStub) {
        this.onOffHandler.registerStub();
        this.log.log(1000000, "[TVASIProvider.attachStub] attaching stub: %1", (Object)iStub);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void detachStub(IStub iStub) {
        this.log.log(1000000, "[TVASIProvider.detachStub] detaching stub: %1", (Object)iStub);
        Object object = this.tvUsageMutex;
        synchronized (object) {
            boolean bl = this.onOffHandler.unregisterStub();
            if (bl && this.tvIsUsed) {
                this.tvIsUsed = false;
                this.tvInterappService.logoffFromTV();
            }
        }
    }

    public void setActiveStation(long l, ASIHMISyncTVReply aSIHMISyncTVReply) throws MethodException {
        this.log.log(10000000, "[TVASIProvider.activeStation] setting active station: %1", l);
        if (!this.sdisBlocked && this.tvIsUsed) {
            this.tvInterappService.setActiveStation(l);
        } else {
            this.log.log(1000000, "[TVASIProvider.setActiveStation] blocked -> no action");
        }
    }

    public void setTerminalMode(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) throws MethodException {
        this.log.log(10000000, "[TVASIProvider.setTerminalMode] setting terminal mode: %1", (long)by);
        if (!this.sdisBlocked && this.tvIsUsed) {
            for (int i2 = 0; i2 < TERMINAL_MODE_MAP.length; ++i2) {
                byte[] byArray = TERMINAL_MODE_MAP[i2];
                if (byArray[1] != by) continue;
                this.tvInterappService.setTerminalMode(byArray[0]);
                break;
            }
        } else {
            this.log.log(1000000, "[TVASIProvider.setTerminalMode] blocked -> no action");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void logonToTV(ASIHMISyncTVReply aSIHMISyncTVReply) throws MethodException {
        this.log.log(10000000, "[TVASIProvider.logonToTV] device registers for TV.");
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
    public void logoffFromTV(ASIHMISyncTVReply aSIHMISyncTVReply) throws MethodException {
        this.log.log(10000000, "[TVASIProvider.logoffFromTV] device unregisters from TV.");
        Object object = this.tvUsageMutex;
        synchronized (object) {
            boolean bl = this.onOffHandler.logoffFromTV();
            if (bl && this.tvIsUsed) {
                this.tvIsUsed = false;
                this.tvInterappService.logoffFromTV();
            }
        }
    }

    public void sendPressedPanelKey(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) throws MethodException {
        this.log.log(10000000, "[TVASIProvider.sendPressedPanelKey] sending panel key: %1", (long)by);
        if (!this.sdisBlocked && this.tvIsUsed) {
            this.tvInterappService.sendPressedPanelKey(InterappKeyPanelHandler.mapToDSI(by));
        } else {
            this.log.log(1000000, "[TVASIProvider.sendPressedPanelKey] blocked -> no action");
        }
    }

    public void searchChannel(byte by, ASIHMISyncTVReply aSIHMISyncTVReply) throws MethodException {
        this.log.log(1000000, "[TVASIProvider.searchChannel] not supported");
    }

    public void updateActiveStationInfo(ActiveStationInfo activeStationInfo) {
        this.log.log(10000000, "[TVASIProvider.updateActiveStationInfo] Updating active station: %1", activeStationInfo.id);
        try {
            super.updateActiveStationInfo(activeStationInfo);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateSeekStatus(byte by) {
        this.log.log(10000000, "[TVASIProvider.updateSeekStatus] Updating seek status: %1", (long)by);
        try {
            super.updateSeekStatus(by);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateStationInfo(StationInfo[] stationInfoArray) {
        this.log.log(10000000, "[TVASIProvider.updateStationInfo] Updating station list.");
        try {
            super.updateStationInfo(stationInfoArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateTerminalMode(byte by) {
        this.log.log(10000000, "[TVASIProvider.updateTerminalMode] Updating terminal mode: %1", (long)by);
        try {
            super.updateTerminalMode(by);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updatePanelKeySet(KeySet[] keySetArray) {
        try {
            super.updatePanelKeySet(keySetArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateParentalSettings(ParentalSettings parentalSettings) {
        this.log.log(10000000, "[TVASIProvider.updateParentalSettings] parental management required: %1, parental level: %2", parentalSettings.isParentalManagementRequired, (long)parentalSettings.parentalLevel);
        try {
            super.updateParentalSettings(parentalSettings);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateActiveTVStationState(long l) {
        this.log.log(10000000, "[TVASIProvider.updateActiveTVStationState] state: 0x%1", l);
        try {
            super.updateActiveTVStationState(l);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateTunerConfig(long l) {
        this.log.log(10000000, "[TVASIProvider.updateTunerConfig] configuration: 0x%1", l);
        try {
            super.updateTunerConfig(l);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    private static ActiveStationInfo getAsiStationInfo(ITVInterappListener.ActiveStationInfo activeStationInfo) {
        int[] nArray = new int[]{activeStationInfo.normArea, activeStationInfo.videoFormat, activeStationInfo.selectedAudioChannel, activeStationInfo.caDescriptor, activeStationInfo.casStatus, activeStationInfo.parentalRating};
        int[] nArray2 = new int[]{TVASIProvider.translateServiceFlag(activeStationInfo.epgFlag), TVASIProvider.translateServiceFlag(activeStationInfo.teletextFlag), TVASIProvider.translateServiceFlag(activeStationInfo.dataBroadcastFlag), TVASIProvider.translateServiceFlag(activeStationInfo.dataBroadcast1Flag), TVASIProvider.translateServiceFlag(activeStationInfo.dataBroadcast2Flag), TVASIProvider.translateServiceFlag(activeStationInfo.bwsFlag), TVASIProvider.translateServiceFlag(activeStationInfo.slsFlag), TVASIProvider.translateServiceFlag(activeStationInfo.txtFlag), TVASIProvider.translateServiceFlag(activeStationInfo.casFlag), TVASIProvider.translateServiceFlag(activeStationInfo.visualAudioFlag), TVASIProvider.translateServiceFlag(activeStationInfo.ewsFlag), TVASIProvider.translateServiceFlag(activeStationInfo.subtitleFlag)};
        AudioChannel[] audioChannelArray = new AudioChannel[activeStationInfo.audioChannels.length];
        for (int i2 = 0; i2 < audioChannelArray.length; ++i2) {
            ITVInterappListener.AudioChannel audioChannel = activeStationInfo.audioChannels[i2];
            audioChannelArray[i2] = new AudioChannel(audioChannel.id, audioChannel.language, audioChannel.format, audioChannel.description);
        }
        return new ActiveStationInfo(activeStationInfo.id, activeStationInfo.stationName, activeStationInfo.channelName, nArray, nArray2, TVASIProvider.getAsiProgramInfo(activeStationInfo.currentProgram), TVASIProvider.getAsiProgramInfo(activeStationInfo.nextProgram), audioChannelArray);
    }

    private static ProgramInfo getAsiProgramInfo(ITVInterappListener.ProgramInfo programInfo) {
        return new ProgramInfo(programInfo.name, programInfo.startHour, programInfo.startMinute, programInfo.startSecond, programInfo.endHour, programInfo.endMinute, programInfo.endSecond);
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

    private class BlockingListener
    implements ISDISBlockingListener {
        private BlockingListener() {
        }

        public void updateLockState(int n) {
        }

        public void updateBlockState(int n) {
            TVASIProvider.this.log.log(1000000, "[TVASIProvider.updateBlockState] %1", (long)n);
            if ((n & 1) == 1) {
                TVASIProvider.this.sdisBlocked = true;
            } else {
                TVASIProvider.this.sdisBlocked = false;
            }
        }
    }

    private class TVInterappListener
    implements ITVInterappListener {
        private byte activeTerminalMode = 0;

        private TVInterappListener() {
        }

        public void updateActiveStation(ITVInterappListener.ActiveStationInfo activeStationInfo) {
            TVASIProvider.this.updateActiveStationInfo(TVASIProvider.getAsiStationInfo(activeStationInfo));
        }

        public void updateSeekStatus(boolean bl) {
            TVASIProvider.this.updateSeekStatus(bl ? (byte)0 : 1);
        }

        public void updateTVStationList(ITVInterappListener.ServiceInfo[] serviceInfoArray) {
            ArrayList arrayList = new ArrayList(serviceInfoArray.length);
            for (int i2 = 0; i2 < serviceInfoArray.length; ++i2) {
                if (serviceInfoArray[i2] == null) continue;
                arrayList.add(new StationInfo(serviceInfoArray[i2].id, serviceInfoArray[i2].name, serviceInfoArray[i2].serviceType, serviceInfoArray[i2].contentGroup));
            }
            TVASIProvider.this.updateStationInfo((StationInfo[])arrayList.toArray(new StationInfo[0]));
        }

        public void enforceTV() {
            TVASIProvider.this.parentalEnforcement.enforceTV();
        }

        public void updateTerminalMode(byte by) {
            byte by2 = this.activeTerminalMode;
            for (int i2 = 0; i2 < TERMINAL_MODE_MAP.length; ++i2) {
                byte[] byArray = TERMINAL_MODE_MAP[i2];
                if (byArray[0] != by) continue;
                by2 = byArray[1];
                break;
            }
            if (by2 != this.activeTerminalMode) {
                this.activeTerminalMode = by2;
                TVASIProvider.this.updateTerminalMode(by2);
            }
        }

        public void updatePanelKeySet(short[] sArray) {
            boolean bl = true;
            int n = -1;
            int n2 = -1;
            ArrayList arrayList = new ArrayList(sArray.length);
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                KeySet keySet;
                if (bl) {
                    n = i2;
                    n2 = i2 + 2;
                    bl = false;
                    continue;
                }
                if (sArray[i2] != 255) continue;
                if (i2 == n2) {
                    keySet = InterappKeyPanelHandler.createKeySet(sArray[n], new short[0]);
                } else {
                    short[] sArray2 = new short[i2 - n2];
                    System.arraycopy((Object)sArray, n2, (Object)sArray2, 0, sArray2.length);
                    keySet = InterappKeyPanelHandler.createKeySet(sArray[n], sArray2);
                }
                arrayList.add(keySet);
                bl = true;
            }
            TVASIProvider.this.updatePanelKeySet((KeySet[])arrayList.toArray(new KeySet[0]));
        }

        public void updateParentalSettings(boolean bl, int n) {
            TVASIProvider.this.updateParentalSettings(new ParentalSettings(bl, n));
        }

        public void updateTvTunerConfig(ITVInterappListener.TvTunerConfig tvTunerConfig) {
            long l = 0L;
            if (tvTunerConfig.audioChannels) {
                l |= 8L;
            }
            if (tvTunerConfig.avFormat) {
                l |= 0x40L;
            }
            if (tvTunerConfig.avNorm) {
                l |= 0x20L;
            }
            if (tvTunerConfig.avSource) {
                l |= 2L;
            }
            if (tvTunerConfig.cas) {
                l |= 0x400L;
            }
            if (tvTunerConfig.ews) {
                l |= 0x100L;
            }
            if (tvTunerConfig.logoList) {
                l |= 0x200L;
            }
            if (tvTunerConfig.parentalControl) {
                l |= 0x4000L;
            }
            if (tvTunerConfig.serviceLinking) {
                l |= 1L;
            }
            if (tvTunerConfig.skip) {
                l |= 0x800L;
            }
            if (tvTunerConfig.sorting) {
                l |= 0x2000L;
            }
            if (tvTunerConfig.subtitle) {
                l |= 0x80L;
            }
            if (tvTunerConfig.tmAtsc) {
                l |= 0x100000L;
            }
            if (tvTunerConfig.tmBws) {
                l |= 0x800000L;
            }
            if (tvTunerConfig.tmCas) {
                l |= 0x4000000L;
            }
            if (tvTunerConfig.tmDb1) {
                l |= 0x200000L;
            }
            if (tvTunerConfig.tmDb2) {
                l |= 0x400000L;
            }
            if (tvTunerConfig.tmDmb) {
                l |= 0x80000L;
            }
            if (tvTunerConfig.tmDtmb) {
                l |= 0x40000L;
            }
            if (tvTunerConfig.tmDvb) {
                l |= 0x10000L;
            }
            if (tvTunerConfig.tmEpg) {
                l |= 0x8000000L;
            }
            if (tvTunerConfig.tmIsdb) {
                l |= 0x20000L;
            }
            if (tvTunerConfig.tmSls) {
                l |= 0x1000000L;
            }
            if (tvTunerConfig.tmTeletext) {
                l |= 0x8000L;
            }
            if (tvTunerConfig.tmTxt) {
                l |= 0x2000000L;
            }
            if (tvTunerConfig.tmVisualAudio) {
                l |= 0x10000000L;
            }
            if (tvTunerConfig.tvNorm) {
                l |= 4L;
            }
            if (tvTunerConfig.videoFormat) {
                l |= 0x10L;
            }
            if (tvTunerConfig.visualAudio) {
                l |= 0x1000L;
            }
            TVASIProvider.this.updateTunerConfig(l);
        }

        public void updateTvState(ITVInterappListener.TvState tvState) {
            long l = 0L;
            switch (tvState.muteState) {
                case 1: {
                    l |= 1L;
                    break;
                }
                case 2: {
                    l |= 2L;
                    break;
                }
                case 3: {
                    l |= 3L;
                    break;
                }
                default: {
                    l |= 0L;
                }
            }
            TVASIProvider.this.updateActiveTVStationState(l);
        }
    }
}

