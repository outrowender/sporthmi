/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app;

import de.audi.atip.interapp.audio.AmplifierListener;
import de.audi.tone.app.NullAmplifierListener;
import de.audi.tone.app.ToneEnv;
import de.audi.tone.app.intra.AbstractAppListener;

public class AmplifierProvider
extends AbstractAppListener {
    private final ToneEnv env;
    private AmplifierListener amplifierListener;
    private volatile int cachedAmplifier = -1;

    public AmplifierProvider(ToneEnv toneEnv) {
        this.env = toneEnv;
        this.amplifierListener = new NullAmplifierListener(toneEnv.lcMain, "AmplifierListener");
    }

    public void updateAmplifier(int n) {
        this.env.lcMain.log(1000000, "[AmplifierProvider.updateAmplifier] amplifier: %1", (long)n);
        this.cachedAmplifier = n;
        this.amplifierListener.updateAmplifier(this.cachedAmplifier);
    }

    public void registerService(AmplifierListener amplifierListener) {
        this.env.lcMain.log(10000000, "[AmplifierProvider.registerService] service  registered: %1", (Object)amplifierListener);
        this.amplifierListener = amplifierListener;
        if (this.cachedAmplifier != -1) {
            this.amplifierListener.updateAmplifier(this.cachedAmplifier);
        }
    }

    public void deregisterService(AmplifierListener amplifierListener) {
        this.env.lcMain.log(10000000, "[AmplifierProvider.deregisterService] service  registered: %1", (Object)amplifierListener);
        this.amplifierListener = new NullAmplifierListener(this.env.lcMain, "AmplifierListener");
    }
}

