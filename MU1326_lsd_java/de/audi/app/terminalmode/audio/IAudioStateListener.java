/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;

public interface IAudioStateListener {
    default public void audioStateChanged(AudioConnectionState audioConnectionState) {
    }

    default public void audioFocusChanged(boolean bl) {
    }
}

