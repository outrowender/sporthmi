/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class HeartbeatPlayer
implements ISamplePlayer {
    private RingTonePlayer ringTonePlayer;
    private final LogChannel lc;
    private final int playMode;

    public HeartbeatPlayer(LogChannel logChannel, int n) {
        this.lc = logChannel;
        this.playMode = n;
        this.ringTonePlayer = new NullRingTonePlayer(logChannel);
    }

    public void registerService(Object object) {
        if (object instanceof RingTonePlayer) {
            this.ringTonePlayer = (RingTonePlayer)object;
        }
    }

    public void deregisterService(Object object) {
        if (object instanceof RingTonePlayer) {
            this.ringTonePlayer = new NullRingTonePlayer(this.lc);
        }
    }

    public void play() {
        this.lc.log(10000000, "[HeartbeatPlayer.play]");
        this.ringTonePlayer.playTone(this.playMode, 10);
    }

    public void stop() {
        this.lc.log(10000000, "[HeartbeatPlayer.stop]");
        this.ringTonePlayer.abort();
    }
}

