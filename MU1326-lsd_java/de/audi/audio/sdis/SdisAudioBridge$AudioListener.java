/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.intra.DefaultAudioListener;
import de.audi.audio.sdis.SdisAudioBridge;
import de.audi.audio.sdis.SdisAudioBridge$1;

class SdisAudioBridge$AudioListener
extends DefaultAudioListener {
    private final /* synthetic */ SdisAudioBridge this$0;

    private SdisAudioBridge$AudioListener(SdisAudioBridge sdisAudioBridge) {
        this.this$0 = sdisAudioBridge;
    }

    @Override
    public void updateActiveEntertainmentConnection(int n, int n2) {
        SdisAudioBridge.access$200(this.this$0);
    }

    /* synthetic */ SdisAudioBridge$AudioListener(SdisAudioBridge sdisAudioBridge, SdisAudioBridge$1 sdisAudioBridge$1) {
        this(sdisAudioBridge);
    }
}

