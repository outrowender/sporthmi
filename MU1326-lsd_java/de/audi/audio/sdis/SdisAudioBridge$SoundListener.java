/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio.sdis;

import de.audi.audio.intra.DefaultSoundListener;
import de.audi.audio.sdis.SdisAudioBridge;
import de.audi.audio.sdis.SdisAudioBridge$1;

class SdisAudioBridge$SoundListener
extends DefaultSoundListener {
    private final /* synthetic */ SdisAudioBridge this$0;

    private SdisAudioBridge$SoundListener(SdisAudioBridge sdisAudioBridge) {
        this.this$0 = sdisAudioBridge;
    }

    @Override
    public void updateVolume(int n, int n2, int n3) {
        SdisAudioBridge.access$200(this.this$0);
    }

    /* synthetic */ SdisAudioBridge$SoundListener(SdisAudioBridge sdisAudioBridge, SdisAudioBridge$1 sdisAudioBridge$1) {
        this(sdisAudioBridge);
    }
}

