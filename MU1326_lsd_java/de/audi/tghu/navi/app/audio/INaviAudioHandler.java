/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;

public interface INaviAudioHandler
extends WavePlayerListener {
    default public void setWavePlayer(WavePlayer wavePlayer) {
    }

    default public void audioConnectionFadedIn() {
    }

    default public void requestBeepTone(int n, int n2) {
    }

    default public boolean isBeepTonePlaying() {
    }
}

