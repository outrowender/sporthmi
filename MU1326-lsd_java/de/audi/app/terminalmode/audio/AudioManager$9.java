/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.atip.utils.generics.Consumer;

class AudioManager$9
implements Consumer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$9(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public void accept(Boolean bl) {
        if (bl.booleanValue()) {
            AudioManager.access$900(this.this$0);
        }
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((Boolean)object);
    }
}

