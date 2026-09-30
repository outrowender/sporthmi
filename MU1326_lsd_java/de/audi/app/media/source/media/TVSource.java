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

public class TVSource
extends AbstractTVSource {
    public TVSource(IMediaTerminal iMediaTerminal, ISourceStateUpdater iSourceStateUpdater, ISourceActivationCallbackHandler iSourceActivationCallbackHandler) {
        super(iMediaTerminal, iSourceStateUpdater, 7, "TV", iSourceActivationCallbackHandler);
    }

    public int getExternalSourceType() {
        return 0;
    }

    protected MediaSourceSlot createSlot(int n, int n2) {
        return new MediaSourceSlot(this, n, 0, 16, 99L, 99L, "", "", MediaFlags.EMPTY_FLAGS, MediaCapabilities.EMPTY_CAPABILITIES, n2, -1, "");
    }
}

