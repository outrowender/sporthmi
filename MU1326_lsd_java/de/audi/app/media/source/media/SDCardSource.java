/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;

public class SDCardSource
extends AbstractMediaSource {
    private final int AUDIO_CONNECTION;

    public SDCardSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iMediaDSIPlayerController, 5, "SDCARD");
        switch (this.getTerminal().getTerminalID()) {
            case 3: 
            case 4: {
                this.AUDIO_CONNECTION = 0;
                break;
            }
            default: {
                this.AUDIO_CONNECTION = 20;
            }
        }
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        return this.AUDIO_CONNECTION;
    }
}

