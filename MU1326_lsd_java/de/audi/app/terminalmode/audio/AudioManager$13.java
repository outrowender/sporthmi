/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.atip.utils.generics.Consumer;

class AudioManager$13
implements Consumer {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$13(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public void accept(AudioConnectionState audioConnectionState) {
        AudioManager.access$300(this.this$0).log(1078071040, "[%1.restoreCurrentAudioContext] Restoring requested media connection:%2", (Object)"AudioManager", (Object)audioConnectionState);
        AudioManager.access$1800(this.this$0).requestConnection(audioConnectionState.getConnection(), 0, 0);
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((AudioConnectionState)object);
    }
}

