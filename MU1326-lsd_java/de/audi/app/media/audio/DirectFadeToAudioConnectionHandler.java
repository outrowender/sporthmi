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

    @Override
    public void audioStateChanged(AudioState audioState) {
        if (audioState.getState() == 2) {
            this.getTerminal().getAudioManager().fadeTo();
        }
    }

    @Override
    public void audioFocusChanged(boolean bl) {
    }

    @Override
    public void rearSeatAudioFocusChanged(boolean bl) {
    }
}

