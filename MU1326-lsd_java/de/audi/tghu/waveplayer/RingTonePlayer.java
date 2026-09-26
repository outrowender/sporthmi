/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.waveplayer;

import de.audi.tghu.waveplayer.WavePlayerListener;

public interface RingTonePlayer {
    public static final int PLAY_ONCE;
    public static final int PLAY_REPEATEDLY;

    default public void playTone(int n, int n2) {
    }

    default public void playDefault(int n) {
    }

    default public void abort() {
    }

    default public void setListener(WavePlayerListener wavePlayerListener) {
    }

    default public void removeListener(WavePlayerListener wavePlayerListener) {
    }
}

