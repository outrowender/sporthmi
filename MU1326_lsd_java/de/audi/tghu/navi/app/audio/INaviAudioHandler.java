/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tghu.waveplayer.WavePlayerListener;

public interface INaviAudioHandler
extends WavePlayerListener {
    public void setWavePlayer(WavePlayer var1);

    public void audioConnectionFadedIn();

    public void requestBeepTone(int var1, int var2);

    public boolean isBeepTonePlaying();
}

