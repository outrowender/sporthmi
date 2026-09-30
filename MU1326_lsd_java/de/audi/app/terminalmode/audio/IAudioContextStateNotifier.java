/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;

public interface IAudioContextStateNotifier {
    public void notifyAudioStateChanged(AudioConnectionState var1);
}

