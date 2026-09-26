/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.waveplayer.DefaultWavePlayerListener;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.dsi.AudioServiceHandler;
import de.audi.tone.app.intra.AbstractAppListener;
import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.msg.Heartbeat$AppAudioListener;
import de.audi.tone.app.msg.Heartbeat$AutoReleaseTimerListener;
import de.audi.tone.app.msg.Heartbeat$MsgListener;
import de.audi.tone.app.volume.samples.HeartbeatPlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class Heartbeat
extends DefaultWavePlayerListener {
    public final DefaultMsgListener audioMsgListener = new Heartbeat$MsgListener(this, null);
    public final AbstractAppListener appAudioListener = new Heartbeat$AppAudioListener(this, null);
    public static final int TIMEOUT_AM_AVAILABLE;
    public static final int TIMEOUT_RS_RELEASE;
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
        this.autoReleaseTimer = new Timer("Heartbeat autorelease timer", 0, true, new Heartbeat$AutoReleaseTimerListener(this));
        this.player = new HeartbeatPlayer(logChannel, 0);
    }

    public void setService(RingTonePlayer ringTonePlayer) {
        this.waveplayerInitialized = !(ringTonePlayer instanceof NullRingTonePlayer);
        this.player.registerService(ringTonePlayer);
        ringTonePlayer.setListener(this);
    }

    @Override
    public void state(int n) {
        if (this.isReadinessSoundCoded()) {
            this.lc.log(1078071040, "[Heartbeat.playHeartbeat] readinessSound coded do nothing");
            return;
        }
        this.lc.log(1078071040, "[Heartbeat.state] status:%1", (long)n);
        if (n != 0 && this.audioService.isNotStopped(48)) {
            this.autoReleaseTimer.cancel();
            this.audioService.releaseConnection(48);
        }
    }

    private boolean isReadinessSoundCoded() {
        return this.env.getSysConst(4596) == 1;
    }

    static /* synthetic */ LogChannel access$200(Heartbeat heartbeat) {
        return heartbeat.lc;
    }

    static /* synthetic */ int access$302(Heartbeat heartbeat, int n) {
        heartbeat.heartbeatVolume = n;
        return heartbeat.heartbeatVolume;
    }

    static /* synthetic */ boolean access$400(Heartbeat heartbeat) {
        return heartbeat.isReadinessSoundCoded();
    }

    static /* synthetic */ AudioServiceHandler access$500(Heartbeat heartbeat) {
        return heartbeat.audioService;
    }

    static /* synthetic */ ISamplePlayer access$600(Heartbeat heartbeat) {
        return heartbeat.player;
    }

    static /* synthetic */ int access$702(Heartbeat heartbeat, int n) {
        heartbeat.minHeartbeatVolume = n;
        return heartbeat.minHeartbeatVolume;
    }

    static /* synthetic */ int access$300(Heartbeat heartbeat) {
        return heartbeat.heartbeatVolume;
    }

    static /* synthetic */ int access$700(Heartbeat heartbeat) {
        return heartbeat.minHeartbeatVolume;
    }

    static /* synthetic */ boolean access$800(Heartbeat heartbeat) {
        return heartbeat.waveplayerInitialized;
    }

    static /* synthetic */ Timer access$900(Heartbeat heartbeat) {
        return heartbeat.autoReleaseTimer;
    }
}

