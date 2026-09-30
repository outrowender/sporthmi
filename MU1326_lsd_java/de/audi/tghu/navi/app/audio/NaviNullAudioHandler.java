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

    public void setWavePlayer(WavePlayer wavePlayer) {
        this.logChannel.log(10000000, "NaviNullAudioHandler#setWavePlayer( %1 )", (Object)wavePlayer);
    }

    public void audioConnectionFadedIn() {
        this.logChannel.log(10000000, "NaviNullAudioHandler#audioConnectionFadedIn()");
    }

    public void requestBeepTone(int n, int n2) {
        this.logChannel.log(10000000, "NaviNullAudioHandler#requestBeepTone(audioConnectionType: %1 -- toneID: %2)", (long)n, (long)n2);
    }

    public void state(int n) {
        this.logChannel.log(10000000, "NaviNullAudioHandler#state( status: %1 )", (long)n);
    }

    public void playToneInfo(int n) {
    }

    public boolean isBeepTonePlaying() {
        return false;
    }
}

