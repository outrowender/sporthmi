/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class SMSBeepPlayer
implements ISamplePlayer {
    private final LogChannel lc;
    private SystemTonePlayer systemTonePlayer;

    public SMSBeepPlayer(ToneEnv toneEnv) {
        this.lc = toneEnv.lcMain;
        this.systemTonePlayer = new NullSystemTonePlayer(this.lc);
    }

    public void play() {
        this.lc.log(10000000, "[SMSBeepPlayer.play]");
        this.systemTonePlayer.playTone(1, 12);
    }

    public void stop() {
        this.lc.log(10000000, "[SMSBeepPlayer.stop]");
        this.systemTonePlayer.abort();
    }

    public void registerService(Object object) {
        if (object instanceof SystemTonePlayer) {
            this.lc.log(10000000, "[SMSBeepPlayer.registerService] %1", object);
            this.systemTonePlayer = (SystemTonePlayer)object;
        }
    }

    public void deregisterService(Object object) {
        if (object instanceof SystemTonePlayer) {
            this.lc.log(10000000, "[SMSBeepPlayer.deregisterService] %1", object);
            this.systemTonePlayer = new NullSystemTonePlayer(this.lc);
        }
    }
}

