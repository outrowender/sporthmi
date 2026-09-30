/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.waveplayer.DefaultWavePlayerListener;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.AudioServiceHandler;
import de.audi.tone.app.intra.AbstractAppListener;
import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.volume.samples.HeartbeatPlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class Heartbeat
extends DefaultWavePlayerListener {
    public final DefaultMsgListener audioMsgListener = new MsgListener();
    public final AbstractAppListener appAudioListener = new AppAudioListener();
    public static final int TIMEOUT_AM_AVAILABLE = 3000;
    public static final int TIMEOUT_RS_RELEASE = 59000;
    private final ISamplePlayer player;
    private final LogChannel lc;
    private final AudioServiceHandler audioService;
    private volatile int minHeartbeatVolume;
    private volatile int heartbeatVolume;
    private volatile boolean waveplayerInitialized;
    private Timer autoReleaseTimer;
    private ToneEnv env;

    public Heartbeat(LogChannel logChannel, AudioServiceHandler audioServiceHandler, ToneEnv toneEnv) {
        this.lc = logChannel;
        this.env = toneEnv;
        this.audioService = audioServiceHandler;
        this.waveplayerInitialized = false;
        this.autoReleaseTimer = new Timer("Heartbeat autorelease timer", 10000L, true, new AutoReleaseTimerListener());
        this.player = new HeartbeatPlayer(logChannel, 0);
    }

    public void setService(RingTonePlayer ringTonePlayer) {
        this.waveplayerInitialized = !(ringTonePlayer instanceof NullRingTonePlayer);
        this.player.registerService(ringTonePlayer);
        ringTonePlayer.setListener(this);
    }

    public void state(int n) {
        if (this.isReadinessSoundCoded()) {
            this.lc.log(1000000, "[Heartbeat.playHeartbeat] readinessSound coded do nothing");
            return;
        }
        this.lc.log(1000000, "[Heartbeat.state] status:%1", (long)n);
        if (n != 0 && this.audioService.isNotStopped(48)) {
            this.autoReleaseTimer.cancel();
            this.audioService.releaseConnection(48);
        }
    }

    private boolean isReadinessSoundCoded() {
        return this.env.getSysConst(4596) == 1;
    }

    private class MsgListener
    extends DefaultMsgListener {
        private MsgListener() {
        }

        protected void playHeartbeat() {
            if (Heartbeat.this.isReadinessSoundCoded()) {
                Heartbeat.this.lc.log(1000000, "[Heartbeat.playHeartbeat] readinessSound coded do not play heartbeat");
                return;
            }
            if (Heartbeat.this.heartbeatVolume > Heartbeat.this.minHeartbeatVolume && Heartbeat.this.waveplayerInitialized) {
                Heartbeat.this.lc.log(1000000, "[Heartbeat.playHeartbeat]");
                Heartbeat.this.audioService.requestConnection(0, 48);
                Heartbeat.this.autoReleaseTimer.restart();
            } else {
                Heartbeat.this.lc.log(1000000, "[Heartbeat.playHeartbeat] waveplayerInitialized: %1", Heartbeat.this.waveplayerInitialized);
                Heartbeat.this.lc.log(1000000, "[Heartbeat.playHeartbeat] do not play heartbeat currentHeartbeatVolume: %1, minHeartbeatVolume: %2", (long)Heartbeat.this.heartbeatVolume, (long)Heartbeat.this.minHeartbeatVolume);
            }
        }
    }

    private class AppAudioListener
    extends AbstractAppListener {
        private AppAudioListener() {
        }

        public void updateVolume(int n, int n2, int n3) {
            if (n2 == 82) {
                Heartbeat.this.lc.log(1000000, "[AppAudioListener.updateVolume] volume: %1", (long)n3);
                Heartbeat.this.heartbeatVolume = n3;
            }
        }

        public void updateConnectionStatus(int n, int n2, int n3) {
            if (Heartbeat.this.isReadinessSoundCoded()) {
                Heartbeat.this.lc.log(1000000, "[Heartbeat.playHeartbeat] readinessSound coded do not play heartbeat");
                return;
            }
            if (n == 48) {
                switch (n2) {
                    case 2: {
                        Heartbeat.this.audioService.fadeToConnection(0, n);
                        break;
                    }
                    case 0: {
                        Heartbeat.this.player.play();
                        break;
                    }
                }
            }
        }

        public void menuVolumeRange(int n, int n2, int n3) {
            if (n == 82) {
                Heartbeat.this.lc.log(1000000, "[AppAudioListener.menuVolumeRange] min: %1", (long)n2);
                Heartbeat.this.minHeartbeatVolume = n2;
            }
        }
    }

    public class AutoReleaseTimerListener
    extends DefaultTimerListener {
        public void fireTimer(Timer timer) {
            if (timer != null && timer.equals(Heartbeat.this.autoReleaseTimer)) {
                Heartbeat.this.lc.log(10000000, "[Heartbeat.AutoReleaseTimerListener.fireTimer] release heartbeat connection ");
                Heartbeat.this.audioService.releaseConnection(48);
            }
        }

        public void cancelTimer(Timer timer) {
            Heartbeat.this.lc.log(10000000, "[Heartbeat.AutoReleaseTimerListener.cancelTimer] called ");
        }
    }
}

