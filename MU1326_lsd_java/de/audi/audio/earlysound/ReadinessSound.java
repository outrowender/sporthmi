/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.audio.AudioEnv;
import de.audi.audio.earlysound.ReadinessSound$AppAudioListener;
import de.audi.audio.earlysound.ReadinessSound$AutoReleaseTimerListener;
import de.audi.audio.earlysound.ReadinessSound$RSClampStateListener;
import de.audi.audio.earlysound.ReadinessSound$ReadinessSoundPlayer;
import de.audi.audio.earlysound.ReadinessSound$ReplayTimerListener;
import de.audi.audio.intra.IAudioListener;
import de.audi.audio.intra.ISoundListener;
import de.audi.tghu.waveplayer.DefaultWavePlayerListener;
import de.audi.tghu.waveplayer.RingTonePlayer;

public class ReadinessSound
extends DefaultWavePlayerListener {
    public final PowerEventListener powerEventListener = new ReadinessSound$RSClampStateListener(this, null);
    public static final int TIMEOUT_AM_AVAILABLE;
    public static final int TIMEOUT_RS_RELEASE;
    private final ReadinessSound$AppAudioListener audioListener;
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
    private ReadinessSound$ReadinessSoundPlayer player;

    public ReadinessSound(LogChannel logChannel, AudioEnv audioEnv, HMIAudioService hMIAudioService) {
        this.lc = logChannel;
        this.env = audioEnv;
        this.audioService = hMIAudioService;
        this.audioListener = new ReadinessSound$AppAudioListener(this, null);
        this.waveplayerInitialized = false;
        this.autoReleaseTimer = new Timer("Heartbeat autorelease timer", 0, true, new ReadinessSound$AutoReleaseTimerListener(this));
        this.rsReleaseTimer = new Timer("Readiness sound autorelease timer", 0, true, new ReadinessSound$ReplayTimerListener(this));
        this.amAvailableTimer = new Timer("Am Available timer", 0, true, new ReadinessSound$AutoReleaseTimerListener(this));
        this.player = new ReadinessSound$ReadinessSoundPlayer(this, logChannel, 0);
        this.waveplayerStatus = -1;
    }

    public void setService(RingTonePlayer ringTonePlayer) {
        this.waveplayerInitialized = !(ringTonePlayer instanceof NullRingTonePlayer);
        this.player.registerService(ringTonePlayer);
        ringTonePlayer.setListener(this);
        this.retryPlayReadinessSound("waveplayerInitialized");
    }

    @Override
    public void state(int n) {
        this.lc.log(1078071040, "[ReadinessSound.state] status:%1", (long)n);
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
        this.lc.log(1078071040, "[ReadinessSound.getSoundListener] listener:%1", (Object)this.audioListener);
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
        this.lc.log(-2137614336, "ReadinessSound.playReadinessSound]");
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
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] Readiness sound not coded, don\u00b4t play readiness sound!");
        } else if (!this.getAMAvailable()) {
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] AM not available, don\u00b4t play readiness sound!");
            this.startAmAvailableTimer();
        } else if (!this.waveplayerInitialized) {
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] WavePlayer not initialized, don\u00b4t play readiness sound!");
            this.startAmAvailableTimer();
        } else if (this.readinessSoundVolume <= this.minReadinessSoundVolume) {
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] readiness sound volume = 0, don\u00b4t play readiness sound! vol:%1, min:%2", (long)this.readinessSoundVolume, (long)this.minReadinessSoundVolume);
            if (!this.volumeInfoPresent) {
                this.startAmAvailableTimer();
            }
        } else if (this.waveplayerStatus == 0 || this.rsRequested) {
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] waveplayer still playing, don\u00b4t play readiness sound!");
        } else if (this.rsReleaseTimer.isRunning()) {
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] timer still running, don\u00b4t play readiness sound!");
        } else {
            bl = true;
            this.lc.log(-2137614336, "[ReadinessSound.updateClampState] play readiness sound!");
        }
        return bl;
    }

    private void startAmAvailableTimer() {
        if (this.amAvailableTimer.isCanceled()) {
            this.lc.log(-2137614336, "ReadinessSound.startDelayTimer]");
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
            this.lc.log(-2137614336, "ReadinessSound.retryPlayReadinessSound] replay triggered by %1.", (Object)string);
            this.playReadinessSound();
        }
    }

    static /* synthetic */ LogChannel access$200(ReadinessSound readinessSound) {
        return readinessSound.lc;
    }

    static /* synthetic */ int access$302(ReadinessSound readinessSound, int n) {
        readinessSound.readinessSoundVolume = n;
        return readinessSound.readinessSoundVolume;
    }

    static /* synthetic */ boolean access$402(ReadinessSound readinessSound, boolean bl) {
        readinessSound.volumeInfoPresent = bl;
        return readinessSound.volumeInfoPresent;
    }

    static /* synthetic */ void access$500(ReadinessSound readinessSound, String string) {
        readinessSound.retryPlayReadinessSound(string);
    }

    static /* synthetic */ int access$602(ReadinessSound readinessSound, int n) {
        readinessSound.minReadinessSoundVolume = n;
        return readinessSound.minReadinessSoundVolume;
    }

    static /* synthetic */ boolean access$700(ReadinessSound readinessSound) {
        return readinessSound.isReadinessSoundCoded();
    }

    static /* synthetic */ HMIAudioService access$800(ReadinessSound readinessSound) {
        return readinessSound.audioService;
    }

    static /* synthetic */ ReadinessSound$ReadinessSoundPlayer access$900(ReadinessSound readinessSound) {
        return readinessSound.player;
    }

    static /* synthetic */ boolean access$1002(ReadinessSound readinessSound, boolean bl) {
        readinessSound.amAvailable = bl;
        return readinessSound.amAvailable;
    }

    static /* synthetic */ Timer access$1100(ReadinessSound readinessSound) {
        return readinessSound.autoReleaseTimer;
    }

    static /* synthetic */ boolean access$1202(ReadinessSound readinessSound, boolean bl) {
        readinessSound.rsRequested = bl;
        return readinessSound.rsRequested;
    }

    static /* synthetic */ boolean access$1300(ReadinessSound readinessSound) {
        return readinessSound.checkConditions();
    }

    static /* synthetic */ void access$1400(ReadinessSound readinessSound) {
        readinessSound.playReadinessSound();
    }
}

