/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioState;

public interface IAudioStateListener {
    public void audioStateChanged(AudioState var1);

    public void audioFocusChanged(boolean var1);

    public void rearSeatAudioFocusChanged(boolean var1);
}

