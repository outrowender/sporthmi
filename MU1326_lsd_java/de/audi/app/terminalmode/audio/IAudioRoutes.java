/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.atip.interapp.audio.ATIPAudioRoute;

public interface IAudioRoutes {
    public ATIPAudioRoute[] getAudioRoutes(AudioConnectionState var1);
}

