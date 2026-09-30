/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.dsi.media.IMediaDSIPlayerController;
import de.audi.app.media.source.ISourceSlot;
import de.audi.app.media.source.media.AbstractMediaSource;

public class FilePlayerSource
extends AbstractMediaSource {
    private static final String LOGCLASS = "FilePlayerSource";
    private volatile int audioConnection = 20;

    public FilePlayerSource(IMediaTerminal iMediaTerminal, IMediaDSIPlayerController iMediaDSIPlayerController) {
        super(iMediaTerminal, iMediaDSIPlayerController, 4, "FILEPLAYER");
    }

    public boolean pausePlaybackOnDeactivation() {
        return false;
    }

    public void setAudioConnection(int n) {
        this.logger.main().log(1000000, "[%1.setAudioConnection] '%2'", (Object)LOGCLASS, (long)n);
        this.audioConnection = n == 0 ? 20 : n;
    }

    public int getAudioConnection(ISourceSlot iSourceSlot) {
        if (this.getTerminal().getConfiguration().isAudioIndepend()) {
            return 20;
        }
        return this.audioConnection;
    }

    public void setSourceIcon(boolean bl) {
    }
}

