/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.atip.utils.collections.Predicate;

class AudioManager$12
implements Predicate {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$12(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public boolean apply(AudioConnectionState audioConnectionState) {
        return AudioManager.access$1700(this.this$0).isActiveAudioConnection(audioConnectionState.getConnection());
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((AudioConnectionState)object);
    }
}

