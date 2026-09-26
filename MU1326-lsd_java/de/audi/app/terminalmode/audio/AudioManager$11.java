/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.utils.collections.Predicate;

class AudioManager$11
implements Predicate {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$11(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    public boolean apply(AudioConnectionState audioConnectionState) {
        return audioConnectionState.getTMConnection().is(TMAudioConnection.MEDIA);
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((AudioConnectionState)object);
    }
}

