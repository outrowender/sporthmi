/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume.samples;

import de.audi.atip.interapp.PhoneService;
import de.audi.atip.interapp.def.NullPhoneService;
import de.audi.atip.interapp.def.NullRingTonePlayer;
import de.audi.tghu.waveplayer.RingTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.volume.samples.ISamplePlayer;

public class RingtoneSamplePlayer
implements ISamplePlayer {
    private final ToneEnv env;
    private volatile RingTonePlayer ringTonePlayer;
    private volatile PhoneService phoneService;

    public RingtoneSamplePlayer(ToneEnv toneEnv) {
        this.env = toneEnv;
        this.phoneService = new NullPhoneService(toneEnv.lcMain);
        this.ringTonePlayer = new NullRingTonePlayer(toneEnv.lcMain);
    }

    @Override
    public void registerService(Object object) {
        this.env.lcMain.log(-2137614336, "[RingtoneSamplePlayer.registerService] %1", object);
        if (object instanceof PhoneService) {
            this.phoneService = (PhoneService)object;
        } else if (object instanceof RingTonePlayer) {
            this.ringTonePlayer = (RingTonePlayer)object;
        }
    }

    @Override
    public void deregisterService(Object object) {
        this.env.lcMain.log(1078071040, "[RingtoneSamplePlayer.deregisterService] %1", object);
        if (object instanceof PhoneService) {
            this.phoneService = new NullPhoneService(this.env.lcMain);
        } else if (object instanceof WavePlayer) {
            this.ringTonePlayer = new NullRingTonePlayer(this.env.lcMain);
        }
    }

    @Override
    public void play() {
        this.env.lcMain.log(-2137614336, "[RingtoneSamplePlayer.start]");
        boolean bl = this.phoneService.isDefaultRingingActive();
        if (bl) {
            this.ringTonePlayer.playDefault(1);
        } else {
            short s = (short)this.env.getSystemChoiceModel(338).getValue();
            this.ringTonePlayer.playTone(1, s);
        }
    }

    @Override
    public void stop() {
        this.env.lcMain.log(-2137614336, "[RingtoneSamplePlayer.stop]");
        this.ringTonePlayer.abort();
    }
}

