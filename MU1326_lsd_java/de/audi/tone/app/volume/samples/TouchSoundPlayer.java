/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class TouchSoundPlayer
implements ISamplePlayer {
    private SystemTonePlayer systemTonePlayer;
    private final LogChannel lc;
    private final int playMode;

    public TouchSoundPlayer(LogChannel logChannel, int n) {
        this.lc = logChannel;
        this.playMode = n;
        this.systemTonePlayer = new NullSystemTonePlayer(logChannel);
    }

    public void registerService(Object object) {
        if (object instanceof SystemTonePlayer) {
            this.systemTonePlayer = (SystemTonePlayer)object;
        }
    }

    public void deregisterService(Object object) {
        if (object instanceof SystemTonePlayer) {
            this.systemTonePlayer = new NullSystemTonePlayer(this.lc);
        }
    }

    public void play() {
        this.lc.log(10000000, "[TouchSoundPlayer.play]");
        this.systemTonePlayer.playTone(this.playMode, 20);
    }

    public void stop() {
        this.lc.log(10000000, "[TouchSoundPlayer.stop]");
        this.systemTonePlayer.abort();
    }
}

