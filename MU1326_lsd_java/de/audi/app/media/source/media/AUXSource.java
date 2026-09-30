/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;

public class AUXSource
extends AbstractMediaSource {
    private final int AUDIO_CONNECTION_GENERIC;
    private final int AUDIO_CONNECTION_DATA;

    public AUXSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, String string) {
        super(iMediaTerminal, iMediaDSIPlayerController, n, string);
        switch (this.getTerminal().getTerminalID()) {
            case 3: 
            case 4: {
                this.AUDIO_CONNECTION_GENERIC = 0;
                this.AUDIO_CONNECTION_DATA = 0;
                break;
            }
            default: {
                this.AUDIO_CONNECTION_GENERIC = 16;
                this.AUDIO_CONNECTION_DATA = 17;
            }
        }
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        switch (iSourceSlot.getContentType()) {
            case 1: {
                return this.AUDIO_CONNECTION_DATA;
            }
        }
        return this.AUDIO_CONNECTION_GENERIC;
    }
}

