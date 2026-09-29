/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class AudioFocusClient$ActionProxyListener
extends TunerActionProxyListener {
    private final /* synthetic */ AudioFocusClient this$0;

    AudioFocusClient$ActionProxyListener(AudioFocusClient audioFocusClient) {
        this.this$0 = audioFocusClient;
    }

    @Override
    public void hmiActivatedTuner() {
        AudioFocusClient.access$000(this.this$0).setActiveAudioApp(0, 1);
    }
}

