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

    @Override
    public void play() {
        this.lc.log(-2137614336, "[SMSBeepPlayer.play]");
        this.systemTonePlayer.playTone(1, 12);
    }

    @Override
    public void stop() {
        this.lc.log(-2137614336, "[SMSBeepPlayer.stop]");
        this.systemTonePlayer.abort();
    }

    @Override
    public void registerService(Object object) {
        if (object instanceof SystemTonePlayer) {
            this.lc.log(-2137614336, "[SMSBeepPlayer.registerService] %1", object);
            this.systemTonePlayer = (SystemTonePlayer)object;
        }
    }

    @Override
    public void deregisterService(Object object) {
        if (object instanceof SystemTonePlayer) {
            this.lc.log(-2137614336, "[SMSBeepPlayer.deregisterService] %1", object);
            this.systemTonePlayer = new NullSystemTonePlayer(this.lc);
        }
    }
}

