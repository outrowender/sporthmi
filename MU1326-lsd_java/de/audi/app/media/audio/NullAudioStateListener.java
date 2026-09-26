/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioStateListener;

public class NullAudioStateListener
implements IAudioStateListener {
    @Override
    public void audioStateChanged(AudioState audioState) {
    }

    @Override
    public void audioFocusChanged(boolean bl) {
    }

    @Override
    public void rearSeatAudioFocusChanged(boolean bl) {
    }
}

