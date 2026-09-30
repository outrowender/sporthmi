/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.atip.audio.AudioConnection;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTone;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceToneListener;
import de.audi.atip.interapp.def.NullCombiBAPServiceTone;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.audio.AudioEnv;
import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.audio.services.BaseAudioService;
import de.audi.audio.store.ConnectionStore;

public class CombiServiceHandler
extends DefaultAudioListener
implements CombiBAPServiceToneListener {
    private static final int UNKNOWN = -1;
    public final ISoundListener soundListener = new SoundListenerExt();
    private final LogChannel lc;
    private final BaseAudioService audioService;
    private final Timer combiHideTimer = new Timer("Combi Volume Popup Timer", 3000L, true, new HideTimerListener());
    private CombiBAPServiceTone combiService;
    private NullCombiBAPServiceTone combiServiceSnapshot;
    private Boolean userMuteCurrentlyActive;
    private Boolean phoneCurrentlyActive;
    private volatile int maxVolume = -1;
    private volatile int currentVolume;
    private volatile int volumeType = -1;
    private volatile boolean showVolumePopup;
    private volatile boolean volumeLockActive;
    private AudioEnv env;

    public CombiServiceHandler(AudioEnv audioEnv, BaseAudioService baseAudioService) {
        this.env = audioEnv;
        this.lc = audioEnv.lcMain;
        this.combiServiceSnapshot = new NullCombiBAPServiceTone(this.lc);
        this.combiService = this.combiServiceSnapshot;
        this.audioService = baseAudioService;
    }

    public void register(CombiBAPServiceTone combiBAPServiceTone) {
        this.lc.log(10000000, "[CombiServiceHandler.register] %1", (Object)combiBAPServiceTone);
        this.combiService = combiBAPServiceTone;
        this.combiService.updateMuteState(this.combiServiceSnapshot.isMuted(), this.combiServiceSnapshot.isMutedDueToActivePhoneCall());
        if (this.volumeType != -1) {
            this.updateVolume(this.currentVolume, this.volumeType, this.showVolumePopup);
        }
        if (this.maxVolume != -1) {
            this.updateVolumeProperties(this.maxVolume);
        }
    }

    public void deregister() {
        this.lc.log(10000000, "[CombiServiceHandler.deregister]");
        this.combiService = this.combiServiceSnapshot;
    }

    public void setVolume(int n) {
        this.currentVolume = n;
        this.updateVolume(n, this.volumeType, this.showVolumePopup);
    }

    public void showVolumePopup(boolean bl) {
        this.lc.log(10000000, "[CombiServiceHandler.showVolumePopup] show:%1", bl);
        this.showVolumePopup = bl;
        if (bl) {
            this.combiHideTimer.restart();
        } else {
            this.combiHideTimer.cancel();
        }
        this.updateVolume(this.currentVolume, this.volumeType, this.showVolumePopup);
    }

    public void setVolumePopupText(int n) {
        switch (n) {
            case 0: {
                this.volumeType = 1;
                break;
            }
            case 1: {
                this.volumeType = 3;
                break;
            }
            case 2: {
                this.volumeType = 8;
                break;
            }
            case 4: {
                this.volumeType = 2;
                break;
            }
            case 5: {
                this.volumeType = 7;
                break;
            }
            case 6: {
                this.volumeType = 16;
                break;
            }
            case 7: {
                this.volumeType = 4;
                break;
            }
            case 8: {
                this.volumeType = 9;
                break;
            }
            case 9: {
                this.volumeType = 6;
                break;
            }
            default: {
                this.lc.log(100000, "[CombiServiceHandler.setVolumePopupText] Unknown text ID %1 -> fall back entertainment", (long)n);
                this.volumeType = 1;
            }
        }
        this.updateVolume(this.currentVolume, this.volumeType, this.showVolumePopup);
    }

    public void setVolumeLockActive(boolean bl) {
        this.volumeLockActive = bl;
        if (this.volumeType == 1) {
            this.updateVolume(this.currentVolume, this.volumeType, this.showVolumePopup);
        }
    }

    private void updateVolume(int n, int n2, boolean bl) {
        this.lc.log(10000000, "[CombiServiceHandler.updateVolume] vol:%1 type:%2 show:%3", (long)n, (long)n2, bl);
        this.combiService.updateVolume(n, this.maxVolume, n2, bl, this.volumeLockActive);
    }

    public void updateConnStatus(int n, int n2, int n3) {
        if (n3 != 0) {
            return;
        }
        boolean bl = this.isUserMuteActive();
        boolean bl2 = this.isPhoneActive();
        if (this.equals(this.userMuteCurrentlyActive, bl) && this.equals(this.phoneCurrentlyActive, bl2)) {
            return;
        }
        this.userMuteCurrentlyActive = bl;
        this.phoneCurrentlyActive = bl2;
        this.combiServiceSnapshot.updateMuteState(bl, bl2);
        this.lc.log(10000000, "[CombiServiceHandler.updateConnStatus] userMuteActive:%1 phoneActive:%2", bl, bl2);
        this.combiService.updateMuteState(bl, bl2);
    }

    private boolean equals(Boolean bl, boolean bl2) {
        if (bl == null) {
            return false;
        }
        return bl == bl2;
    }

    private boolean isUserMuteActive() {
        return ConnectionStore.INSTANCE.isInUse(8, 1) && ConnectionStore.INSTANCE.getStatus(8, 1) != 6;
    }

    private boolean isPhoneActive() {
        int[] nArray = ConnectionStore.INSTANCE.getConnectionsInUse(1);
        this.lc.log(10000000, "[CombiServiceHandler.isPhoneActive] connection:%1", (Object)nArray);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (AudioConnection.contains(AudioConnection.PHONE_CALL, nArray[i2]) && !this.stopOfMuteConnectionRequested(nArray[i2])) {
                return true;
            }
            if (!AudioConnection.contains(AudioConnection.PHONE_RINGING, nArray[i2])) continue;
            return true;
        }
        return false;
    }

    private boolean stopOfMuteConnectionRequested(int n) {
        boolean bl = AudioConnection.contains(AudioConnection.MUTE_RELEASE_CONNECTIONS, n);
        boolean bl2 = ConnectionStore.INSTANCE.getStatus(n, 1) == 6;
        this.lc.log(10000000, "[CombiServiceHandler.stopOfMuteConnectionRequested] isMuteReleaseConnection:%1 stopRequested:%2", bl, bl2);
        return bl && bl2;
    }

    public void setMuteState(boolean bl) {
        this.lc.log(10000000, "[CombiServiceHandler.setMuteState] muted:%1", bl);
        if (bl) {
            this.audioService.requestConnection(8);
        } else {
            this.audioService.releaseConnection(8);
        }
    }

    public void setVolume(int n, int n2) {
        this.lc.log(10000000, "[CombiServiceHandler.setVolume] Nothing to do here.");
    }

    private void updateVolumeProperties(int n) {
        this.maxVolume = n;
        boolean bl = this.env.framework.getSysConst(459) == 1;
        this.combiService.updateVolumeProperties((byte)n, true, bl, true, true, true, true, true, true);
    }

    private class SoundListenerExt
    extends DefaultSoundListener {
        private SoundListenerExt() {
        }

        public void updateVolumeRange(int n, int n2) {
            CombiServiceHandler.this.updateVolumeProperties(n2);
        }
    }

    private class HideTimerListener
    extends DefaultTimerListener {
        private HideTimerListener() {
        }

        public void fireTimer(Timer timer) {
            CombiServiceHandler.this.lc.log(10000000, "[CombiServiceHandler.HideTimerListener.fireTimer]");
            CombiServiceHandler.this.showVolumePopup(false);
        }
    }
}

