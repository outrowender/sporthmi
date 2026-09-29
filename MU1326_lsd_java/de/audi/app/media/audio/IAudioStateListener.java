/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioState;

public interface IAudioStateListener {
    default public void audioStateChanged(AudioState audioState) {
    }

    default public void audioFocusChanged(boolean bl) {
    }

    default public void rearSeatAudioFocusChanged(boolean bl) {
    }
}

