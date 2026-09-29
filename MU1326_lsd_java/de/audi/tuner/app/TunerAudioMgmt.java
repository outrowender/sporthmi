/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.audio.AudioGroup;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.tuner.app.AudioInfo;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt$TunerAnnouncementConnectionMngr;
import de.audi.tuner.app.TunerAudioMgmt$UserMuteConnectionMngr;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.ifc.IRadioAudioService;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerAnnounce;
import de.audi.tuner.ifc.NullTunerAnnounce;

public class TunerAudioMgmt
implements HMIAudioServiceListener,
IRadioAudioService {
    private static final int TUNER_DEFAULT_SOURCE;
    private static final AudioGroup TUNER_FM;
    private static final String LOGCLASS;
    private int activeAnnouncementConnection = -1;
    private boolean sdsUplinkActive = false;
    private boolean sdsDownlinkActive = false;
    private boolean audioServiceFound = false;
    private int lastActiveEntConnection = -1;
    private HMIAudioService audioService;
    private volatile boolean amAvailable = false;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final IScanHandler scanHandler;
    private ITunerAnnounce announcement = new NullTunerAnnounce();
    private IRadioCmdManager cmdManager;
    private final TunerAudioMgmt$TunerAnnouncementConnectionMngr announcementController = new TunerAudioMgmt$TunerAnnouncementConnectionMngr(this, null);
    private final TunerAudioMgmt$UserMuteConnectionMngr userMuteConnectionMngr = new TunerAudioMgmt$UserMuteConnectionMngr(this, null);
    private AudioInfo[] listeners = new AudioInfo[0];
    private boolean isStartup;

    TunerAudioMgmt(TunerBasics tunerBasics, IScanHandler iScanHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.scanHandler = iScanHandler;
        this.audioService = new NullHMIAudioService(this.logger.audio);
        this.cmdManager = new NullRadioCmdManager(tunerBasics);
    }

    void register(IRadioCmdManager iRadioCmdManager) {
        this.cmdManager = iRadioCmdManager;
    }

    public void register(AudioInfo audioInfo) {
        AudioInfo[] audioInfoArray = new AudioInfo[this.listeners.length + 1];
        System.arraycopy((Object)this.listeners, 0, (Object)audioInfoArray, 0, this.listeners.length);
        audioInfoArray[this.listeners.length] = audioInfo;
        this.listeners = audioInfoArray;
    }

    void init() {
    }

    void deinit() {
        this.audioService.releaseConnection(13);
        this.audioService.releaseConnection(12);
        this.audioService.releaseConnection(26);
        this.audioService.releaseConnection(28);
    }

    public void setDeviceService(HMIAudioService hMIAudioService) {
        this.audioService = hMIAudioService;
        this.audioServiceFound = hMIAudioService != null;
    }

    @Override
    public boolean isActive(int n) {
        return this.audioService.isActive(n);
    }

    @Override
    public int getStatus(int n) {
        return this.audioService.getStatus(n);
    }

    public boolean isSDSActive() {
        return this.sdsDownlinkActive || this.sdsUplinkActive;
    }

    public boolean isTunerActiveAudioSrc(int n) {
        boolean bl = this.isNotStopped(13, n) || this.isNotStopped(12, n) || this.isNotStopped(26, n) || this.isNotStopped(28, n);
        return bl;
    }

    @Override
    public void requestAudioChannel(int n, int n2) {
        if (!this.isAMAvailable()) {
            return;
        }
        if (n == 13 || n == 12 || n == 26 || n == 28) {
            this.lastActiveEntConnection = n;
        } else if (this.isAnnouncementConnection(n)) {
            this.activeAnnouncementConnection = n;
        }
        if (this.status.hasAudioFocus(0) && !this.isAnnouncementConnection(n)) {
            this.logger.main.log(-2137614336, "[%1.requestAudioChannel] Release TIM connection!", (Object)"TunerAudioMgmt");
            this.audioService.releaseConnection(114);
            this.audioService.releaseConnection(115);
        }
        this.logger.audio.log(-2137614336, "[%1.requestAudioChannel] AC:%2 HT:%3", (Object)"TunerAudioMgmt", (long)n, (long)n2);
        if (this.status.hasAudioFocus(n2) || this.isAnnouncementConnection(n)) {
            if (!this.isAnnouncementConnection(n)) {
                this.releaseConnectionIfNotTarget(301, 2, n, n2);
                this.releaseConnectionIfNotTarget(300, 2, n, n2);
                this.releaseConnectionIfNotTarget(302, 2, n, n2);
                this.releaseConnectionIfNotTarget(304, 2, n, n2);
                this.releaseConnectionIfNotTarget(303, 2, n, n2);
            }
            this.audioService.requestConnection(n, n2, TUNER_FM.getID());
            this.requestOtherTerminals(n, n2);
        }
    }

    private void releaseConnectionIfNotTarget(int n, int n2, int n3, int n4) {
        if (n == n3 && n2 == n4) {
            return;
        }
        this.audioService.releaseConnection(n, n2);
    }

    private void requestOtherTerminals(int n, int n2) {
        this.logger.audio.log(-2137614336, "[%1.requestOtherTerminals] AC:%2 HT:%3", (Object)"TunerAudioMgmt", (long)n, (long)n2);
        if (this.isTunerAudioConnection(n)) {
            int n3 = n2 == 0 ? 2 : 0;
            boolean bl = this.status.hasAudioFocus(n3);
            this.logger.audio.log(-2137614336, "[%1.requestOtherTerminals] hasFocus:%2 otherTerm:%3", (Object)"TunerAudioMgmt", (Object)(bl ? "true" : "false"), (long)n3);
            if (bl) {
                int n4 = this.getBandByConnection(n);
                this.audioService.requestConnection(Utilities.getConnectionByBand(n4, n3), n3, TUNER_FM.getID());
            }
        }
    }

    void requestAndFadeIn(int n) {
        if (!this.isAMAvailable()) {
            return;
        }
        this.audioService.requestAndFadeToConnection(n);
        this.logger.audio.log(-2137614336, "[%1.requestAndFadeIn] request and fadeIn for AC:%2", (Object)"TunerAudioMgmt", (long)n);
    }

    public void releaseAudioChannel(int n, int n2) {
        if (!this.isAMAvailable()) {
            return;
        }
        this.audioService.releaseConnection(n, n2);
        this.logger.audio.log(-2137614336, "[%1.releaseAudio] AC:%2", (Object)"TunerAudioMgmt", (long)n);
    }

    @Override
    public void demute() {
        this.demute(0);
    }

    public void demute(int n) {
        if (!this.isAMAvailable()) {
            return;
        }
        if (this.isStartup) {
            this.logger.audio.log(-2137614336, "[%1.demute] we are in Startup => ignore demute", (Object)"TunerAudioMgmt");
            this.setStartup(false);
            return;
        }
        if (this.status.hasAudioFocus(n)) {
            this.logger.audio.log(1078071040, "[%1.demute] release MUTE_ENT for HT:%2", (Object)"TunerAudioMgmt", (long)n);
            this.audioService.releaseConnection(8, n);
            this.audioService.releaseA2LSConnection();
        } else {
            this.logger.main.log(1078071040, "[%1.demute] Tuner has no audio focus for HT:%2, ignore demute", (Object)"TunerAudioMgmt", (long)n);
        }
    }

    public void toggleUserMute() {
        if (this.userMuteConnectionMngr.userMuteConnectionActive) {
            this.logger.audio.log(1078071040, "[%1.toggleUserMute] release MUTE_ENT", (Object)"TunerAudioMgmt");
            this.audioService.releaseConnection(8, 0);
        } else {
            this.logger.audio.log(1078071040, "[%1.toggleUserMute] requeste MUTE_ENT", (Object)"TunerAudioMgmt");
            this.audioService.requestConnection(8, 0);
        }
    }

    public void lockVolume(int n, Object object) {
        this.lockVolume(n, 0, object);
    }

    public void unlockVolume(int n, Object object) {
        this.unlockVolume(n, 0, object);
    }

    public void returnAnnouncementAudio(int n) {
        this.logger.audio.log(-2137614336, "[%1.returnAnnouncementAudio] release AC:%2", (Object)"TunerAudioMgmt", (long)n);
        this.audioService.releaseConnection(n);
    }

    @Override
    public int getConnectionForActiveTuner(int n) {
        return Utilities.getConnectionByBand(this.models.getActiveTuner(), n);
    }

    public int getConnectionByBand(int n) {
        int n2 = -1;
        switch (n) {
            case 5: 
            case 11: {
                n2 = 26;
                break;
            }
            case 1: {
                n2 = 12;
                break;
            }
            case 4: {
                n2 = 13;
                break;
            }
            case 10: {
                n2 = 15;
                break;
            }
            case 7: {
                n2 = 28;
                break;
            }
        }
        return n2;
    }

    @Override
    public void fadeTo(int n, int n2) {
        this.logger.audio.log(1078071040, "[%1.fadeTo] AC:%2", (Object)"TunerAudioMgmt", (long)n);
        this.audioService.fadeToConnection(n);
    }

    public boolean isAudioServiceFound() {
        return this.audioServiceFound;
    }

    public int getActiveAnnouncementConnection() {
        return this.activeAnnouncementConnection;
    }

    @Override
    public void startConnection(int n, int n2) {
        this.logger.audio.log(1078071040, "[%1.startConnection] AC:%2 HT:%3", (Object)"TunerAudioMgmt", (long)n, (long)n2);
        if (n == 113) {
            this.sdsUplinkActive = true;
            this.scanHandler.abortScan();
        } else if (n == 112) {
            this.sdsDownlinkActive = true;
            this.scanHandler.abortScan();
        } else if (this.isTunerAudioConnection(n)) {
            if (this.cmdManager.isControlledbyCmd(n)) {
                this.logger.audio.log(1078071040, "[%1.startConnection] AC:%2 is controlled by a command", (Object)"TunerAudioMgmt", (long)n);
            } else {
                this.audioService.fadeToConnection(n, n2);
            }
        } else if (this.isAnnouncementConnection(n)) {
            this.announcementController.announcementConnStarted();
            this.activeAnnouncementConnection = n;
            this.audioService.fadeToConnection(n, n2);
        }
        if (n == 8) {
            this.scanHandler.abortScan();
            this.userMuteConnectionMngr.userMuteConnStarted();
        }
    }

    private int getBandByConnection(int n) {
        switch (n) {
            case 12: 
            case 300: {
                return 1;
            }
            case 13: 
            case 301: {
                return 4;
            }
            case 26: 
            case 302: {
                if (this.models.getActiveTuner() == 5) {
                    return 5;
                }
                return 11;
            }
            case 28: 
            case 304: {
                return 7;
            }
            case 15: 
            case 303: {
                return 10;
            }
        }
        return 8;
    }

    @Override
    public void stopConnection(int n, int n2) {
        if (n == 113) {
            this.sdsUplinkActive = false;
        } else if (n == 112) {
            this.sdsDownlinkActive = false;
        } else if (this.isTunerAudioConnection(n)) {
            this.logger.audio.log(1078071040, "[%1.stopConnection]Tuner AC:%2 closed ", (Object)"TunerAudioMgmt", (long)n);
        } else if (this.isAnnouncementConnection(n) && n == this.activeAnnouncementConnection) {
            this.announcementController.announcementConnectionStopped();
            this.activeAnnouncementConnection = -1;
            if (this.status.hasAudioFocus(2)) {
                this.audioService.requestConnection(this.getConnectionForActiveTuner(2), 2, TUNER_FM.getID());
            }
        }
        if (n == 8) {
            this.userMuteConnectionMngr.userMuteConnectionStopped();
        }
    }

    @Override
    public void pauseConnection(int n, int n2) {
        switch (n) {
            case 12: 
            case 13: 
            case 26: {
                this.logger.audio.log(1078071040, "[%1.pauseConnection] Tuner AC:%2 paused ", (Object)"TunerAudioMgmt", (long)n);
                break;
            }
            case 31: 
            case 32: 
            case 33: 
            case 34: 
            case 35: {
                this.logger.audio.log(1078071040, "[%1.pauseConnection] Tuner announcement AC:%2 paused", (Object)"TunerAudioMgmt", (long)n);
                this.announcementController.announcementConnectionStopped();
                break;
            }
        }
    }

    @Override
    public void fadedIn(int n, int n2) {
        if (this.isTunerAudioConnection(n)) {
            this.logger.audio.log(1078071040, "[%1.fadedIn] Tuner AC:%2 is audible.", (Object)"TunerAudioMgmt", (long)n);
            Utilities.getFramework().getLastmodeHandler().triggerFirstAudio(n2);
            AudioInfo[] audioInfoArray = this.listeners;
            for (int i2 = 0; i2 < audioInfoArray.length; ++i2) {
                audioInfoArray[i2].fadedInConnForBand(this.getBandByConnection(n));
            }
        } else if (this.isAnnouncementConnection(n)) {
            if (this.announcement.getActiveAnnouncement() == 20) {
                this.returnAnnouncementAudio(n);
                return;
            }
            this.logger.audio.log(1078071040, "[%1.fadedIn] Tuner annoncement AC:%2 is audible.", (Object)"TunerAudioMgmt", (long)n);
            Utilities.getFramework().getLastmodeHandler().triggerFirstAudio(n2);
        } else {
            AudioInfo[] audioInfoArray = this.listeners;
            for (int i3 = 0; i3 < audioInfoArray.length; ++i3) {
                audioInfoArray[i3].handleFadedIn(n);
            }
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.logger.audio.log(10000, "[%1.errorConnection] AC:%2, errorCode:%3", (Object)"TunerAudioMgmt", (long)n, (long)n3);
        this.stopConnection(n, 0);
        if (this.amAvailable && n3 == 2 && n == this.getConnectionForActiveTuner(n2) && this.status.hasAudioFocus(n2)) {
            this.logger.main.log(1078071040, "[%1.errorConnection] ERRORCODE_RR_REQUEST_NOT_POSSIBLE -> request AC:%2 again", (Object)"TunerAudioMgmt", (long)n);
            this.audioService.requestConnection(n, n2);
        }
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.logger.audio.log(-2137614336, "[%1.updateAMAvailable] amAvailable:%2", (Object)"TunerAudioMgmt", (Object)(bl ? "true" : "false"));
        this.amAvailable = bl;
        this.announcement.setAudioAvailable(bl);
        if (bl) {
            TunerProxyManager.getInstance().getAmFmTuner().audioManagementJustBecameAvailable();
            TunerProxyManager.getInstance().getDABTuner().audioManagementJustBecameAvailable();
            TunerProxyManager.getInstance().getUnifiedTuner().audioManagementJustBecameAvailable();
            TunerProxyManager.getInstance().getSDARSTuner().audioManagementJustBecameAvailable();
            boolean[] blArray = this.status.getAudioFocus();
            for (int i2 = 0; i2 < blArray.length; ++i2) {
                if (!blArray[i2]) continue;
                this.restoreActiveAudio(i2);
            }
        }
    }

    void restoreActiveAudio(int n) {
        RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdRestoreAudio(n));
        this.cmdManager.enqueue(radioCommandList);
    }

    private boolean isNotStopped(int n, int n2) {
        if (this.status.isIgnoreAudioConnection()) {
            return true;
        }
        return this.audioService.getStatus(n, n2) != 5;
    }

    private boolean isAnnouncementConnection(int n) {
        return n == 31 || n == 33 || n == 32 || n == 34 || n == 35;
    }

    @Override
    public boolean isTunerAudioConnection(int n) {
        return n == 28 || n == 26 || n == 12 || n == 13 || n == 15 || n == 301 || n == 300 || n == 302 || n == 304 || n == 303;
    }

    private void lockVolume(int n, int n2, Object object) {
        int n3 = this.getConnectionByBand(n);
        this.audioService.setVolumelock(n3, n2, true, object);
    }

    private void unlockVolume(int n, int n2, Object object) {
        int n3 = this.getConnectionByBand(n);
        this.audioService.setVolumelock(n3, n2, false, object);
    }

    @Override
    public boolean isAMAvailable() {
        if (!this.amAvailable) {
            this.logger.audio.log(-1601830656, "[%1.isAMAvailable] amAvailable: false", (Object)"TunerAudioMgmt");
        } else {
            this.logger.audio.log(-2137614336, "[%1.isAMAvailable] amAvailable: true", (Object)"TunerAudioMgmt");
        }
        return this.amAvailable;
    }

    public void setTunerAnnouncement(ITunerAnnounce iTunerAnnounce) {
        this.announcement = iTunerAnnounce;
        iTunerAnnounce.setAudioAvailable(this.amAvailable);
    }

    public void setLastMode(int n) {
        this.logger.audio.log(1078071040, "[%1.setLastMode] lastMode:%2", (Object)"TunerAudioMgmt", (long)n);
        if (this.lastActiveEntConnection == -1) {
            this.lastActiveEntConnection = this.getConnectionByBand(n);
        }
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.logger.audio.log(1078071040, "[%1.updateVolumeLock] VL:%2", (Object)"TunerAudioMgmt", (Object)(bl ? "true" : "false"));
    }

    public void setStartup(boolean bl) {
        this.isStartup = bl;
    }

    static /* synthetic */ AudioInfo[] access$200(TunerAudioMgmt tunerAudioMgmt) {
        return tunerAudioMgmt.listeners;
    }

    static {
        TUNER_FM = new AudioGroup(3, 1, 1, 2, 0);
    }
}

