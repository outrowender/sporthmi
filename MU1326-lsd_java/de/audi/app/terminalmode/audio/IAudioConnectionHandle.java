/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.IAudioConnectionHandle$IAudioConnectionListener;
import de.audi.tghu.command.Command;

public interface IAudioConnectionHandle {
    default public Command createRequestCommand(boolean bl) {
    }

    default public Command createReleaseCommand() {
    }

    default public void registerListener(IAudioConnectionHandle$IAudioConnectionListener iAudioConnectionHandle$IAudioConnectionListener) {
    }

    default public void unregisterListener(IAudioConnectionHandle$IAudioConnectionListener iAudioConnectionHandle$IAudioConnectionListener) {
    }
}

