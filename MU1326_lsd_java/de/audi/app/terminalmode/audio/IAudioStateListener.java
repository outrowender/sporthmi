/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;

public interface IAudioStateListener {
    public void audioStateChanged(AudioConnectionState var1);

    public void audioFocusChanged(boolean var1);
}

