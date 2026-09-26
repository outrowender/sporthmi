/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.audio;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.audio.INaviAudioHandler;
import de.audi.tghu.waveplayer.WavePlayer;

public class NaviNullAudioHandler
implements INaviAudioHandler {
    private final LogChannel logChannel;

    public NaviNullAudioHandler(NavigationEnv navigationEnv) {
        this.logChannel = navigationEnv.getNaviAudioLogChannel();
    }

    @Override
    public void setWavePlayer(WavePlayer wavePlayer) {
        this.logChannel.log(-2137614336, "NaviNullAudioHandler#setWavePlayer( %1 )", (Object)wavePlayer);
    }

    @Override
    public void audioConnectionFadedIn() {
        this.logChannel.log(-2137614336, "NaviNullAudioHandler#audioConnectionFadedIn()");
    }

    @Override
    public void requestBeepTone(int n, int n2) {
        this.logChannel.log(-2137614336, "NaviNullAudioHandler#requestBeepTone(audioConnectionType: %1 -- toneID: %2)", (long)n, (long)n2);
    }

    @Override
    public void state(int n) {
        this.logChannel.log(-2137614336, "NaviNullAudioHandler#state( status: %1 )", (long)n);
    }

    @Override
    public void playToneInfo(int n) {
    }

    @Override
    public boolean isBeepTonePlaying() {
        return false;
    }
}

