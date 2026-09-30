/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.audio.AudioEnv;
import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.tghu.waveplayer.DefaultWavePlayerListener;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class ReadinessSound
extends DefaultWavePlayerListener {
    public final PowerEventListener powerEventListener = new RSClampStateListener();
    public static final int TIMEOUT_AM_AVAILABLE = 3000;
    public static final int TIMEOUT_RS_RELEASE = 59000;
    private final AppAudioListener audioListener;
    private final LogChannel lc;
    private final HMIAudioService audioService;
    private volatile int minReadinessSoundVolume;
    private volatile int readinessSoundVolume;
    private volatile boolean volumeInfoPresent;
    private volatile boolean waveplayerInitialized;
    private volatile boolean amAvailable;
    private Timer autoReleaseTimer;
    protected Timer rsReleaseTimer;
    protected Timer amAvailableTimer;
    private AudioEnv env;
    private int waveplayerStatus;
    private boolean rsRequested = false;
    private ReadinessSoundPlayer player;

    public ReadinessSound(LogChannel logChannel, AudioEnv audioEnv, HMIAudioService hMIAudioService) {
        this.lc = logChannel;
        this.env = audioEnv;
        this.audioService = hMIAudioService;
        this.audioListener = new AppAudioListener();
        this.waveplayerInitialized = false;
        this.autoReleaseTimer = new Timer("Heartbeat autorelease timer", 10000L, true, new AutoReleaseTimerListener());
        this.rsReleaseTimer = new Timer("Readiness sound autorelease timer", 59000L, true, new ReplayTimerListener());
        this.amAvailableTimer = new Timer("Am Available timer", 3000L, true, new AutoReleaseTimerListener());
        this.player = new ReadinessSoundPlayer(logChannel, 0);
        this.waveplayerStatus = -1;
    }

    public void setService(RingTonePlayer ringTonePlayer) {
        this.waveplayerInitialized = !(ringTonePlayer instanceof NullRingTonePlayer);
        this.player.registerService(ringTonePlayer);
        ringTonePlayer.setListener(this);
        this.retryPlayReadinessSound("waveplayerInitialized");
    }

    public void state(int n) {
        this.lc.log(1000000, "[ReadinessSound.state] status:%1", (long)n);
        if (!this.isReadinessSoundCoded()) {
            return;
        }
        if (n != 0 && this.isNotStopped(48)) {
            this.autoReleaseTimer.cancel();
            this.rsReleaseTimer.restart();
            this.audioService.releaseConnection(48);
            this.rsRequested = false;
        }
        this.waveplayerStatus = n;
    }

    public ISoundListener getSoundListener() {
        this.lc.log(1000000, "[ReadinessSound.getSoundListener] listener:%1", (Object)this.audioListener);
        return this.audioListener;
    }

    public IAudioListener getAudioListener() {
        return this.audioListener;
    }

    private boolean getAMAvailable() {
        return this.amAvailable;
    }

    public boolean isNotStopped(int n) {
        return this.audioService.getStatus(n) != 5;
    }

    private void playReadinessSound() {
        this.amAvailableTimer.cancel();
        this.lc.log(10000000, "ReadinessSound.playReadinessSound]");
        this.audioService.requestConnection(48, 0);
        this.rsRequested = true;
        this.autoReleaseTimer.restart();
    }

    public void setRsRequested(boolean bl) {
        this.rsRequested = bl;
    }

    private boolean checkConditions() {
        boolean bl = false;
        if (!this.isReadinessSoundCoded()) {
            this.lc.log(10000000, "[ReadinessSound.updateClampState] Readiness sound not coded, don\u00b4t play readiness sound!");
        } else if (!this.getAMAvailable()) {
            this.lc.log(10000000, "[ReadinessSound.updateClampState] AM not available, don\u00b4t play readiness sound!");
            this.startAmAvailableTimer();
        } else if (!this.waveplayerInitialized) {
            this.lc.log(10000000, "[ReadinessSound.updateClampState] WavePlayer not initialized, don\u00b4t play readiness sound!");
            this.startAmAvailableTimer();
        } else if (this.readinessSoundVolume <= this.minReadinessSoundVolume) {
            this.lc.log(10000000, "[ReadinessSound.updateClampState] readiness sound volume = 0, don\u00b4t play readiness sound! vol:%1, min:%2", (long)this.readinessSoundVolume, (long)this.minReadinessSoundVolume);
            if (!this.volumeInfoPresent) {
                this.startAmAvailableTimer();
            }
        } else if (this.waveplayerStatus == 0 || this.rsRequested) {
            this.lc.log(10000000, "[ReadinessSound.updateClampState] waveplayer still playing, don\u00b4t play readiness sound!");
        } else if (this.rsReleaseTimer.isRunning()) {
            this.lc.log(10000000, "[ReadinessSound.updateClampState] timer still running, don\u00b4t play readiness sound!");
        } else {
            bl = true;
            this.lc.log(10000000, "[ReadinessSound.updateClampState] play readiness sound!");
        }
        return bl;
    }

    private void startAmAvailableTimer() {
        if (this.amAvailableTimer.isCanceled()) {
            this.lc.log(10000000, "ReadinessSound.startDelayTimer]");
            this.amAvailableTimer.start();
        }
    }

    private boolean isReadinessSoundCoded() {
        return this.env.getSysConst(4596) == 1;
    }

    public void setVolumeInfoPresent(boolean bl) {
        this.volumeInfoPresent = bl;
    }

    private void retryPlayReadinessSound(String string) {
        if (this.amAvailableTimer.isRunning() && this.checkConditions()) {
            this.lc.log(10000000, "ReadinessSound.retryPlayReadinessSound] replay triggered by %1.", (Object)string);
            this.playReadinessSound();
        }
    }

    private class AppAudioListener
    extends DefaultSoundListener
    implements IAudioListener {
        private AppAudioListener() {
        }

        public void updateVolume(int n, int n2, int n3) {
            ReadinessSound.this.lc.log(1000000, "[ReadinessSound.AppAudioListener.updateVolume] connection: %1", (long)n);
            if (n == 82 || n == 48) {
                ReadinessSound.this.lc.log(1000000, "[ReadinessSound.AppAudioListener.updateVolume] volume: %1", (long)n3);
                ReadinessSound.this.readinessSoundVolume = n3;
                ReadinessSound.this.volumeInfoPresent = true;
                ReadinessSound.this.retryPlayReadinessSound("updateVolume");
            }
        }

        public void menuVolumeRange(int n, int n2, int n3, int n4) {
            ReadinessSound.this.lc.log(1000000, "[ReadinessSound.AppAudioListener.menuVolumeRange] connection: %1", (long)n);
            if (n == 82) {
                ReadinessSound.this.lc.log(1000000, "[ReadinessSound.AppAudioListener.menuVolumeRange] min: %1", (long)n3);
                ReadinessSound.this.minReadinessSoundVolume = n3;
            }
        }

        public void updateConnStatus(int n, int n2, int n3) {
            if (n == 48 && ReadinessSound.this.isReadinessSoundCoded()) {
                switch (n2) {
                    case 2: {
                        ReadinessSound.this.audioService.fadeToConnection(n, 0);
                        break;
                    }
                    case 0: {
                        ReadinessSound.this.player.play();
                        break;
                    }
                    case 5: {
                        ReadinessSound.this.player.stop();
                        break;
                    }
                }
            }
        }

        public void updateAMAvailable(boolean bl) {
            ReadinessSound.this.amAvailable = bl;
            if (bl) {
                ReadinessSound.this.retryPlayReadinessSound("updateAMAvailable");
            }
        }

        public void updateActiveConnection(int n, int n2) {
        }

        public void updateActiveEntertainmentConnection(int n, int n2) {
        }
    }

    class ReplayTimerListener
    extends DefaultTimerListener {
        ReplayTimerListener() {
        }

        public void fireTimer(Timer timer) {
            ReadinessSound.this.lc.log(10000000, "ReadinessSound.ReplayTimerListener.fireTimer] Readiness Sound may be played again.");
        }

        public void cancelTimer(Timer timer) {
            ReadinessSound.this.lc.log(10000000, "ReadinessSound.ReplayTimerListener.cancelTimer] called.");
        }
    }

    private class RSClampStateListener
    implements PowerEventListener {
        private boolean clamp15 = true;

        private RSClampStateListener() {
        }

        public void notifyPowerListenerOnEnterState(int n, int n2) {
        }

        public void notifyPowerListenerOnExitState(int n, int n2) {
        }

        public void notifyPowerTriggerAction(int n, int n2) {
        }

        public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
            ReadinessSound.this.lc.log(10000000, "[ReadinessSound.updateClampState] clamp15: %1 -> %2", this.clamp15, bl2);
            if (!ReadinessSound.this.isReadinessSoundCoded()) {
                ReadinessSound.this.lc.log(10000000, "[ReadinessSound.updateClampState] ReadinessSound not coded -> do nothing");
                return;
            }
            if (this.clamp15 == bl2) {
                return;
            }
            this.clamp15 = bl2;
            if (!this.clamp15) {
                ReadinessSound.this.audioService.releaseConnection(48);
                return;
            }
            if (ReadinessSound.this.checkConditions()) {
                ReadinessSound.this.playReadinessSound();
            }
        }
    }

    private class ReadinessSoundPlayer {
        private RingTonePlayer ringTonePlayer;
        private final LogChannel lc;
        private final int playMode;

        public ReadinessSoundPlayer(LogChannel logChannel, int n) {
            this.lc = logChannel;
            this.playMode = n;
            this.ringTonePlayer = new NullRingTonePlayer(logChannel);
        }

        public void registerService(Object object) {
            if (object instanceof RingTonePlayer) {
                this.ringTonePlayer = (RingTonePlayer)object;
            }
        }

        public void play() {
            this.lc.log(10000000, "[ReadinessSoundPlayer.play]");
            this.ringTonePlayer.playTone(this.playMode, 10);
        }

        public void stop() {
            this.lc.log(10000000, "[ReadinessSoundPlayer.stop]");
            this.ringTonePlayer.abort();
        }
    }

    public class AutoReleaseTimerListener
    extends DefaultTimerListener {
        public void fireTimer(Timer timer) {
            if (timer != null && timer.equals(ReadinessSound.this.autoReleaseTimer)) {
                ReadinessSound.this.lc.log(10000000, "[ReadinessSound.AutoReleaseTimerListener.fireTimer] release heartbeat connection ");
                ReadinessSound.this.audioService.releaseConnection(48);
                ReadinessSound.this.rsRequested = false;
            }
        }

        public void cancelTimer(Timer timer) {
            ReadinessSound.this.lc.log(10000000, "[ReadinessSound.AutoReleaseTimerListener.cancelTimer] called ");
        }
    }
}

