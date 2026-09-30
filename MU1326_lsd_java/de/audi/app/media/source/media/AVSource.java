/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.IMediaTerminal;
import de.audi.app.media.source.ISourceActivationCallbackHandler;
import de.audi.app.media.source.MediaCapabilities;
import de.audi.app.media.source.MediaFlags;
import de.audi.app.media.source.MediaSourceSlot;
import de.audi.app.media.source.media.AbstractTVSource;
import de.audi.app.media.source.state.ISourceStateUpdater;

public class AVSource
extends AbstractTVSource {
    public AVSource(IMediaTerminal iMediaTerminal, ISourceStateUpdater iSourceStateUpdater, ISourceActivationCallbackHandler iSourceActivationCallbackHandler) {
        super(iMediaTerminal, iSourceStateUpdater, 8, "AV", iSourceActivationCallbackHandler);
    }

    public int getExternalSourceType() {
        return 1;
    }

    protected MediaSourceSlot createSlot(int n, int n2) {
        return new MediaSourceSlot(this, n, 0, 17, 99L, 99L, "", "", MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n2, -1, "");
    }
}

