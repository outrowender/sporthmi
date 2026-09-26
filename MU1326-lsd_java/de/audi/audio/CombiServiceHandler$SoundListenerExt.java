/*
 * Decompiled with CFR 0.152.
 */
package de.audi.audio;

import de.audi.audio.CombiServiceHandler;
import de.audi.audio.CombiServiceHandler$1;
import de.audi.audio.intra.DefaultSoundListener;

class CombiServiceHandler$SoundListenerExt
extends DefaultSoundListener {
    private final /* synthetic */ CombiServiceHandler this$0;

    private CombiServiceHandler$SoundListenerExt(CombiServiceHandler combiServiceHandler) {
        this.this$0 = combiServiceHandler;
    }

    @Override
    public void updateVolumeRange(int n, int n2) {
        CombiServiceHandler.access$300(this.this$0, n2);
    }

    /* synthetic */ CombiServiceHandler$SoundListenerExt(CombiServiceHandler combiServiceHandler, CombiServiceHandler$1 combiServiceHandler$1) {
        this(combiServiceHandler);
    }
}

