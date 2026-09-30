/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class SDSAudioHandler
implements HMIAudioServiceListener {
    private LogChannel lc = Logger.getAudioLog();
    private HMIAudioService audioService;
    private AudioDrawerContext audioDrawerContextService = new NullAudioDrawerContext(this.lc);
    private final AppSDSManager sdsManager;
    private SystemSDSHandler systemHandler;
    private SDSAdapter sdsAdapter;
    private boolean sdsAudioActive = false;
    private boolean keepDownlink = false;
    private byte downlinkStatus = 0;
    private boolean uplinkActive = false;
    private int requestingType = 0;
    private final SDSAudioHelper sdsAudioHelper;
    private final MobileSpeechRecognitionHandler mobileSRHandler;
    private final DispatcherBase audioDrawerContextDispatcher;
    private volatile AudioDrawerContext.Source currentAudioDrawerContext = AudioDrawerContext.SOURCE_NONE;
    private final IFrameworkAccess framework;

    protected SDSAudioHandler(IFrameworkAccess iFrameworkAccess, AppSDSManager appSDSManager, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler) {
        this.sdsAudioHelper = new SDSAudioHelper();
        this.framework = iFrameworkAccess;
        this.sdsManager = appSDSManager;
        this.mobileSRHandler = mobileSpeechRecognitionHandler;
        this.audioDrawerContextDispatcher = iFrameworkAccess.getDispatcherManager().createDispatcher("[SDSAudioHandler.audioDrawerContextDispatcher]", new JobLogger(this.lc));
        this.audioDrawerContextDispatcher.start();
        this.lc.log(10000000, "SDSAudioHandler started.");
    }

    void stop() {
        this.lc.log(10000000, "SDSAudioHandler#stop: Releasing audio connections!");
        this.releaseSDSAudioConnections(true);
        this.audioDrawerContextDispatcher.stop();
        this.framework.getDispatcherManager().destroyDispatcher(this.audioDrawerContextDispatcher.getDispatcherName());
    }

    void setAudioService(HMIAudioService hMIAudioService) {
        this.lc.log(10000000, "SDSAudioHandler#setAudioService: audioService=%1", (Object)hMIAudioService);
        this.audioService = hMIAudioService;
    }

    void unsetAudioService() {
        this.audioService = null;
    }

    void setAudioDrawerContextService(AudioDrawerContext audioDrawerContext) {
        if (audioDrawerContext == null) {
            this.lc.log(10000, "SDSAudioHandler#setAudioDrawerContextService: audioDrawerContext-Service is null!");
            return;
        }
        this.audioDrawerContextService = audioDrawerContext;
    }

    void unsetAudioDrawerContextService() {
        this.audioDrawerContextService = new NullAudioDrawerContext(this.lc);
    }

    public void switchToSDSAudioDrawerContext(int n) {
        if (this.audioDrawerContextService == null) {
            this.lc.log(10000, "SDSAudioHandler#switchToSDSAudioDrawerContext: audioDrawerContextService is null!");
            return;
        }
        final AudioDrawerContext.Source source = SDSAudioHandler.getAudioDrawerContextForDialogContext(n);
        this.lc.log(10000000, "SDSAudioHandler#switchToSDSAudioDrawerContext: sdsDialogContext=%2 => audioDrawerContext=%1!", (Object)source.toString(), (long)n);
        if (source == AudioDrawerContext.SOURCE_NONE) {
            return;
        }
        this.audioDrawerContextDispatcher.execute(new Runnable(){

            public void run() {
                if (SDSAudioHandler.this.currentAudioDrawerContext.equals(source)) {
                    SDSAudioHandler.this.lc.log(10000000, "SDSAudioHandler#switchToSDSAudioDrawerContext: audio drawer context %1 is already active => NOP!", (Object)source.toString());
                    return;
                }
                SDSAudioHandler.this.lc.log(10000000, "SDSAudioHandler#switchToSDSAudioDrawerContext: Enable new audio drawer context %1!", (Object)source.toString());
                SDSAudioHandler.this.audioDrawerContextService.setContext(source, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
                SDSAudioHandler.this.lc.log(10000000, "SDSAudioHandler#switchToSDSAudioDrawerContext: Disable old audio drawer context %1!", (Object)SDSAudioHandler.this.currentAudioDrawerContext.toString());
                SDSAudioHandler.this.audioDrawerContextService.setContext(SDSAudioHandler.this.currentAudioDrawerContext, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                SDSAudioHandler.this.currentAudioDrawerContext = source;
            }
        });
    }

    public void switchToSDSAudioDrawerContextMain() {
        this.switchToSDSAudioDrawerContext(0);
    }

    public void disableCurrentSDSAudioDrawerContext() {
        if (this.audioDrawerContextService == null) {
            this.lc.log(10000, "SDSAudioHandler#disableCurrentSDSAudioDrawerContext: audioDrawerContextService is null!");
            return;
        }
        this.audioDrawerContextDispatcher.execute(new Runnable(){

            public void run() {
                if (SDSAudioHandler.this.currentAudioDrawerContext == AudioDrawerContext.SOURCE_NONE) {
                    SDSAudioHandler.this.lc.log(10000000, "SDSAudioHandler#disableCurrentSDSAudioDrawerContext: current audio drawer context is already set back to SOURCE_NONE => NOP!");
                    return;
                }
                SDSAudioHandler.this.lc.log(10000000, "SDSAudioHandler#disableCurrentSDSAudioDrawerContext: Disable current audio drawer context %1!", (Object)SDSAudioHandler.this.currentAudioDrawerContext.toString());
                SDSAudioHandler.this.audioDrawerContextService.setContext(SDSAudioHandler.this.currentAudioDrawerContext, AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
                SDSAudioHandler.this.currentAudioDrawerContext = AudioDrawerContext.SOURCE_NONE;
            }
        });
    }

    private static AudioDrawerContext.Source getAudioDrawerContextForDialogContext(int n) {
        SDSUtils.DialogContextToPopupToAudioDrawerTriplet dialogContextToPopupToAudioDrawerTriplet = null;
        for (int i2 = 0; i2 < SDSUtils.DialogContextToPopupToAudioDrawerTriplet.TRIPLET_DATA.length; ++i2) {
            dialogContextToPopupToAudioDrawerTriplet = SDSUtils.DialogContextToPopupToAudioDrawerTriplet.TRIPLET_DATA[i2];
            if (dialogContextToPopupToAudioDrawerTriplet.dialogContext != n) continue;
            return dialogContextToPopupToAudioDrawerTriplet.audioDrawerContextSource;
        }
        return AudioDrawerContext.SOURCE_NONE;
    }

    private void requestAudioConnection(int n) {
        this.lc.log(10000000, "SDSAudioHandler#requestAudioConnection: connection=%1 ", (long)n);
        if (this.audioService == null) {
            this.lc.log(10000, "SDSAudioHandler#requestAudioConnection: No audio service available!");
            return;
        }
        this.audioService.requestConnection(n);
    }

    public void requestSDSAudioConnections() {
        this.lc.log(10000000, "SDSAudioHandler#requestSDSAudioConnections: downlinkStatus=%1", (long)this.downlinkStatus);
        this.sdsAudioHelper.cancelTimer();
        this.requestingType = 1;
        this.requestAudioConnection(113);
        if (this.downlinkStatus == 0 || this.downlinkStatus == 4) {
            this.downlinkStatus = 1;
            this.requestAudioConnection(112);
        } else if (this.downlinkStatus == 3) {
            this.lc.log(100000, "SDSAudioHandler#requestSDSAudioConnections: Downlink not requested because it is paused, NOT triggering response!");
        } else {
            this.lc.log(100000, "SDSAudioHandler#requestSDSAudioConnections: Downlink not requested, triggering response!");
            this.triggerResponseAudio(this.downlinkStatus == 1 || this.downlinkStatus == 2);
        }
    }

    private void fadeToAudioConnection(int n) {
        this.lc.log(10000000, "SDSAudioHandler#fadeToAudioConnection: connection=%1 ", (long)n);
        if (this.audioService == null) {
            this.lc.log(10000, "SDSAudioHandler#fadeToAudioConnection: No audio service available!");
            return;
        }
        this.audioService.fadeToConnection(n);
    }

    private void releaseAudioConnection(int n) {
        this.lc.log(10000000, "SDSAudioHandler#releaseAudioConnection: connection=%1 ", (long)n);
        if (this.audioService == null) {
            this.lc.log(10000, "SDSAudioHandler#releaseAudioConnection: No audio service available!");
            return;
        }
        this.audioService.releaseConnection(n);
    }

    private void releaseSDSAudioConnections(boolean bl) {
        this.lc.log(10000000, "SDSAudioHandler#releaseSDSAudioConnections: aborting=%1, keepDownlink=%2", bl, this.keepDownlink);
        this.requestingType = 2;
        if (bl) {
            this.lc.log(10000000, "SDSAudioHandler#releaseSDSAudioConnections: Aborting in progress, releasing SDS downlink!");
            this.downlinkStatus = (byte)4;
            this.releaseAudioConnection(112);
        } else if (this.keepDownlink) {
            this.lc.log(10000000, "SDSAudioHandler#releaseSDSAudioConnections: Keeping SDS downlink, resetting flag and starting timer!");
            this.setKeepDownlink(false);
            this.sdsAudioHelper.startTimer();
        } else if (this.sdsAdapter.isSDSPaused()) {
            this.lc.log(100000, "SDSAudioHandler#releaseSDSAudioConnections: SDS paused, flag already reset, keeping SDS downlink, triggering response!");
            this.triggerResponseAudio(false);
        } else if (this.downlinkStatus != 0 && this.downlinkStatus != 4) {
            this.lc.log(10000000, "SDSAudioHandler#releaseSDSAudioConnections: downlinkStatus=%1, releasing SDS downlink!", (long)this.downlinkStatus);
            this.downlinkStatus = (byte)4;
            this.releaseAudioConnection(112);
        } else {
            this.lc.log(100000, "SDSAudioHandler#releaseSDSAudioConnections: SDS downlink inactive, triggering response!");
            this.triggerResponseAudio(false);
        }
        this.releaseAudioConnection(113);
    }

    public void releaseSDSAudioConnections() {
        this.lc.log(10000000, "SDSAudioHandler#releaseSDSAudioConnections: sdsAudioActive=%1, uplinkActive=%2, downlinkStatus=%3", (Object)this.sdsAudioActive, (Object)this.uplinkActive, (long)this.downlinkStatus);
        if (!(this.downlinkStatus != 0 && this.downlinkStatus != 4 || this.uplinkActive)) {
            this.lc.log(10000000, "SDSAudioHandler#releaseSDSAudioConnections: Audio connections already released, closing drawer and triggering response!");
            this.disableCurrentSDSAudioDrawerContext();
            this.requestingType = 2;
            this.triggerResponseAudio(false);
            return;
        }
        this.releaseSDSAudioConnections(false);
    }

    public void errorConnection(int n, int n2, int n3) {
        if (!SDSAudioHandler.isSDSConnection(n)) {
            return;
        }
        this.lc.log(10000, "SDSAudioHandler#errorConnection: connection=%1, errorCode=%2", (long)n, (long)n3);
        switch (n) {
            case 112: {
                this.lc.log(10000000, "SDSAudioHandler#errorConnection: SDS downlink stopped due to an error!");
                this.downlinkStatus = 0;
                break;
            }
            case 113: {
                this.lc.log(10000000, "SDSAudioHandler#errorConnection: SDS uplink stopped due to an error!");
                this.uplinkActive = false;
                break;
            }
            default: {
                this.lc.log(10000000, "SDSAudioHandler#errorConnection: Unhandled connection %1!", (long)n);
                return;
            }
        }
        this.triggerResponseAudio(false);
        this.lc.log(10000000, "SDSAudioHandler#errorConnection: Error for SDS connection, aborting session!");
        this.sdsManager.abortSDSSession();
    }

    public void stopConnection(int n, int n2) {
        if (!SDSAudioHandler.isSDSConnection(n)) {
            return;
        }
        this.lc.log(10000000, "SDSAudioHandler#stopConnection: connection=%1", (long)n);
        boolean bl = this.sdsAdapter.isSDSPaused();
        switch (n) {
            case 112: {
                this.lc.log(10000000, "SDSAudioHandler#stopConnection: SDS downlink stopped!");
                if (!this.mobileSRHandler.isMobileSpeechRecognitionActive() && !bl) {
                    this.disableCurrentSDSAudioDrawerContext();
                }
                this.downlinkStatus = 0;
                break;
            }
            case 113: {
                this.lc.log(10000000, "SDSAudioHandler#stopConnection: SDS uplink stopped!");
                this.uplinkActive = false;
                break;
            }
            default: {
                this.lc.log(10000000, "SDSAudioHandler#stopConnection: Unhandled connection %1!", (long)n);
                return;
            }
        }
        boolean bl2 = this.sdsAdapter.isSDSActive();
        boolean bl3 = this.sdsAdapter.isSDSAborting();
        boolean bl4 = this.sdsAdapter.isSDSEnding();
        this.lc.log(10000000, "SDSAudioHandler#stopConnection: sdsPaused=%1, sdsActive=%2!", bl, bl2);
        this.lc.log(10000000, "SDSAudioHandler#stopConnection: sdsAborting=%1, sdsEnding=%2!", bl3, bl4);
        if (this.mobileSRHandler.isMobileSpeechRecognitionActive() && this.sdsAdapter.isExternalSDSRequested()) {
            this.lc.log(10000000, "SDSAudioHandler#stopConnection: Mobile speech recognition active, NOT aborting session!");
        } else if (bl || !bl2 || bl3 || bl4) {
            this.lc.log(10000000, "SDSAudioHandler#stopConnection: SDS paused or inactive or aborting or ending, NOT aborting session!");
        } else if (this.sdsAdapter.isSDSNumberDialingActive()) {
            this.lc.log(10000000, "SDSAudioHandler#stopConnection: Number dialing active, NOT aborting session!");
        } else {
            this.lc.log(10000000, "SDSAudioHandler#stopConnection: SDS NOT (paused or inactive or aborting or ending), aborting session!");
            this.sdsManager.abortSDSSession(true);
            return;
        }
        if (this.downlinkStatus != 0 || this.uplinkActive) {
            this.lc.log(10000000, "SDSAudioHandler#stopConnection: downlinkStatus=%2, uplinkActive=%1, NOT triggering response!", this.uplinkActive, (long)this.downlinkStatus);
            return;
        }
        this.triggerResponseAudio(false);
    }

    public void pauseConnection(int n, int n2) {
        if (!SDSAudioHandler.isSDSConnection(n)) {
            return;
        }
        this.lc.log(10000000, "SDSAudioHandler#pauseConnection: connection=%1", (long)n);
        if (n == 112) {
            this.lc.log(10000000, "SDSAudioHandler#pauseConnection: SDS downlink paused!");
            this.downlinkStatus = (byte)3;
        }
        this.triggerResponseAudio(false);
        if (this.sdsAdapter.isSDSPaused()) {
            this.lc.log(10000000, "SDSAudioHandler#pauseConnection: SDS paused, NOT aborting session!");
        } else if (this.sdsAdapter.isSDSNumberDialingActive()) {
            this.lc.log(10000000, "SDSAudioHandler#pauseConnection: Number dialing active, NOT aborting session, releasing connection!");
            this.releaseAudioConnection(n);
        } else if (this.sdsAdapter.isSDSEnding() || !this.sdsManager.isSDSActive()) {
            this.lc.log(10000000, "SDSAudioHandler#pauseConnection: SDS session ending or inactive, NOT aborting session, releasing connection!");
            this.releaseAudioConnection(n);
        } else {
            this.lc.log(10000000, "SDSAudioHandler#pauseConnection: SDS NOT paused, aborting session AND releasing connection!");
            this.sdsManager.abortSDSSession();
            this.releaseAudioConnection(n);
        }
    }

    public void startConnection(int n, int n2) {
        if (SDSAudioHandler.isPhoneDownlink(n)) {
            this.lc.log(10000000, "SDSAudioHandler#startConnection: Phone downlink started => unsetting keepDownlink!");
            this.setKeepDownlink(false);
            return;
        }
        if (!SDSAudioHandler.isSDSConnection(n)) {
            return;
        }
        this.lc.log(10000000, "SDSAudioHandler#startConnection: connection=%1, downlinkStatus=%2", (long)n, (long)this.downlinkStatus);
        switch (n) {
            case 112: {
                this.lc.log(10000000, "SDSAudioHandler#startConnection: SDS downlink started!");
                if (!this.sdsAdapter.isSDSPaused()) {
                    this.switchToSDSAudioDrawerContextMain();
                }
                SDSModelAccess.setRecognizer(1);
                this.startConnectionDownlink();
                break;
            }
            case 113: {
                this.lc.log(10000000, "SDSAudioHandler#startConnection: SDS uplink started, setting flag!");
                this.uplinkActive = true;
                break;
            }
            default: {
                this.lc.log(10000000, "SDSAudioHandler#startConnection: Unhandled connection %1!", (long)n);
            }
        }
    }

    private void startConnectionDownlink() {
        this.setKeepDownlink(false);
        switch (this.downlinkStatus) {
            case 1: {
                this.lc.log(10000000, "SDSAudioHandler#startConnectionDownlink: SDS downlink was requested!");
                break;
            }
            case 3: {
                this.lc.log(10000000, "SDSAudioHandler#startConnectionDownlink: SDS downlink was paused!");
                break;
            }
            case 2: {
                this.lc.log(10000000, "SDSAudioHandler#startConnectionDownlink: SDS downlink was started and is started again!");
                break;
            }
            default: {
                this.lc.log(10000000, "SDSAudioHandler#startConnectionDownlink: SDS downlink started unexpectedly, releasing it!");
                this.downlinkStatus = (byte)4;
                this.releaseAudioConnection(112);
                return;
            }
        }
        this.lc.log(10000000, "SDSAudioHandler#startConnectionDownlink: Fading required, fading in...");
        this.fadeToAudioConnection(112);
    }

    public void fadedIn(int n, int n2) {
        if (n != 112) {
            return;
        }
        this.lc.log(10000000, "SDSAudioHandler#fadedIn: SDS downlink faded in => SDS audio ready!");
        this.downlinkStatus = (byte)2;
        this.triggerResponseAudio(true);
    }

    public void updateAMAvailable(boolean bl) {
        this.lc.log(10000000, "updateAMAvailable: Audio management is %1!", (Object)(bl ? " available!" : "unavailable!"));
    }

    private static boolean isPhoneDownlink(int n) {
        return n == 99 || n == 104 || n == 103 || n == 98;
    }

    private static boolean isSDSConnection(int n) {
        return n == 112 || n == 113;
    }

    private void triggerResponseAudio(boolean bl) {
        this.lc.log(10000000, "SDSAudioHandler#triggerResponseAudio: started=%1, requestingType=%2", (Object)bl, (long)this.requestingType);
        this.setSDSAudioActive(bl);
        switch (this.requestingType) {
            case 1: {
                this.systemHandler.responseRequestAudioConnections(bl);
                break;
            }
            case 2: {
                this.systemHandler.responseReleaseAudioConnections(!bl);
                break;
            }
            default: {
                this.lc.log(100000, "SDSAudioHandler#triggerResponseAudio: Unhandled requestingType %1!", (long)this.requestingType);
            }
        }
        this.requestingType = 0;
    }

    public boolean isSDSAudioActive() {
        this.lc.log(10000000, "SDSAudioHandler#isSDSAudioActive: sdsAudioActive=%1!", this.sdsAudioActive);
        return this.sdsAudioActive;
    }

    private void setSDSAudioActive(boolean bl) {
        this.sdsAudioActive = bl;
        this.lc.log(10000000, "SDSAudioHandler#setSDSAudioActive: sdsAudioActive=%1!", this.sdsAudioActive);
    }

    public void setKeepDownlink(boolean bl) {
        this.lc.log(10000000, "SDSAudioHandler#setKeepDownlink: value=%1 ", bl);
        this.keepDownlink = bl;
    }

    void setSDSAdapter(SDSAdapter sDSAdapter) {
        this.sdsAdapter = sDSAdapter;
    }

    void setSystemSDSHandler(SystemSDSHandler systemSDSHandler) {
        this.systemHandler = systemSDSHandler;
    }

    public byte getDownlinkStatus() {
        return this.downlinkStatus;
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }

    private class SDSAudioHelper
    implements TimerListener {
        private static final String SYSTEM_PROPERTY_SDS_AUDIO_TIMER_VALUE = "sdsAudioTimerValue";
        private Timer releaseTimer = new Timer("ReleaseTimer", this.getTimerValue(), true, this);

        private SDSAudioHelper() {
            SDSAudioHandler.this.lc.log(10000000, "[SDSAudioHandler.SDSAudioHelper#ctor] Called.");
        }

        private void startTimer() {
            SDSAudioHandler.this.lc.log(10000000, "[SDSAudioHandler.SDSAudioHelper#startTimer] Called.");
            this.releaseTimer.restart();
        }

        private void cancelTimer() {
            SDSAudioHandler.this.lc.log(10000000, "[SDSAudioHandler.SDSAudioHelper#cancelTimer] Called.");
            this.releaseTimer.cancel();
        }

        private long getTimerValue() {
            String string = System.getProperty(SYSTEM_PROPERTY_SDS_AUDIO_TIMER_VALUE, "5000");
            Long l = Long.getLong(string);
            if (l == null) {
                return 5000L;
            }
            return l;
        }

        public void cancelTimer(Timer timer) {
            SDSAudioHandler.this.lc.log(10000000, "[SDSAudioHandler.SDSAudioHelper#cancelTimer] Called.");
        }

        public void fireTimer(Timer timer) {
            SDSAudioHandler.this.lc.log(10000000, "[SDSAudioHandler.SDSAudioHelper#fireTimer] Called, release DOWNLINK connection.");
            SDSAudioHandler.this.releaseAudioConnection(112);
        }
    }
}

