/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.earlysound;

import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.audio.earlysound.ReadinessSound;
import de.audi.tghu.waveplayer.RingTonePlayer;

class ReadinessSound$ReadinessSoundPlayer {
    private RingTonePlayer ringTonePlayer;
    private final LogChannel lc;
    private final int playMode;
    private final /* synthetic */ ReadinessSound this$0;

    public ReadinessSound$ReadinessSoundPlayer(ReadinessSound readinessSound, LogChannel logChannel, int n) {
        this.this$0 = readinessSound;
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
        this.lc.log(-2137614336, "[ReadinessSoundPlayer.play]");
        this.ringTonePlayer.playTone(this.playMode, 10);
    }

    public void stop() {
        this.lc.log(-2137614336, "[ReadinessSoundPlayer.stop]");
        this.ringTonePlayer.abort();
    }
}

