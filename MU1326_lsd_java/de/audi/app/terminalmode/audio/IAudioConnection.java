/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.IAudioRoutes;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.atip.utils.collections.Optional;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface IAudioConnection
extends IAudioRoutes {
    public Optional<Integer> getAudioConnection(TMAudioConnection var1);

    public boolean isActiveAudioConnection(int var1);
}

