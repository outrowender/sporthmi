/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;

public class DiscDriveSource
extends AbstractMediaSource {
    public final int AUDIO_CONNECTION_DATA;
    public final int AUDIO_CONNECTION_DVD_VIDEO;
    public final int AUDIO_CONNECTION_CDA;

    public DiscDriveSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController, int n, String string) {
        super(iMediaTerminal, iMediaDSIPlayerController, n, string);
        block0 : switch (this.getTerminal().getTerminalID()) {
            case 3: 
            case 4: {
                switch (n) {
                    case 0: {
                        this.AUDIO_CONNECTION_DATA = 0;
                        this.AUDIO_CONNECTION_DVD_VIDEO = 0;
                        this.AUDIO_CONNECTION_CDA = 0;
                        break block0;
                    }
                }
                this.AUDIO_CONNECTION_DATA = 0;
                this.AUDIO_CONNECTION_DVD_VIDEO = 0;
                this.AUDIO_CONNECTION_CDA = 0;
                break;
            }
            default: {
                switch (n) {
                    case 0: {
                        this.AUDIO_CONNECTION_DATA = 20;
                        this.AUDIO_CONNECTION_DVD_VIDEO = 19;
                        this.AUDIO_CONNECTION_CDA = 18;
                        break block0;
                    }
                }
                this.AUDIO_CONNECTION_DATA = 20;
                this.AUDIO_CONNECTION_DVD_VIDEO = 19;
                this.AUDIO_CONNECTION_CDA = 18;
            }
        }
    }

    @Override
    public int getAudioConnection(ISourceSlot iSourceSlot) {
        switch (iSourceSlot.getContentType()) {
            case 2: {
                return this.AUDIO_CONNECTION_DVD_VIDEO;
            }
            case 0: {
                return this.AUDIO_CONNECTION_CDA;
            }
        }
        return this.AUDIO_CONNECTION_DATA;
    }

    @Override
    public boolean isActivateable(ISourceSlot iSourceSlot) {
        return iSourceSlot.isLoaded() && (iSourceSlot.getError() == 0 || iSourceSlot.getError() == 3);
    }
}

