/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;

public class NullRingTonePlayer
extends NullService
implements RingTonePlayer {
    public NullRingTonePlayer(LogChannel logChannel) {
        super(logChannel, "RingTonePlayer");
    }

    protected NullRingTonePlayer(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    @Override
    public void playTone(int n, int n2) {
        this.log();
    }

    @Override
    public void playDefault(int n) {
        this.log();
    }

    @Override
    public void abort() {
        this.log();
    }

    @Override
    public void setListener(WavePlayerListener wavePlayerListener) {
        this.log();
    }

    @Override
    public void removeListener(WavePlayerListener wavePlayerListener) {
        this.log();
    }
}

