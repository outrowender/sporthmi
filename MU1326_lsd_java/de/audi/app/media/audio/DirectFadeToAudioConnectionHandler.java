/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.AbstractMediaTerminalComponent;
import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.audio.AudioState;
import de.audi.app.media.audio.IAudioStateListener;

public class DirectFadeToAudioConnectionHandler
extends AbstractMediaTerminalComponent
implements IAudioStateListener {
    public DirectFadeToAudioConnectionHandler(IMediaTerminal iMediaTerminal) {
        super(iMediaTerminal);
    }

    public void audioStateChanged(AudioState audioState) {
        if (audioState.getState() == 2) {
            this.getTerminal().getAudioManager().fadeTo();
        }
    }

    public void audioFocusChanged(boolean bl) {
    }

    public void rearSeatAudioFocusChanged(boolean bl) {
    }
}

