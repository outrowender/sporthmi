/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.gracenote;

import de.audi.tuner.app.gracenote.CoverArtHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.gracenote.IGracenoteResponse;
import org.dsi.ifc.media.CoverartInfo;

class CoverArtHandler$1
implements IGracenoteRequest {
    private final /* synthetic */ CoverArtHandler this$0;

    CoverArtHandler$1(CoverArtHandler coverArtHandler) {
        this.this$0 = coverArtHandler;
    }

    @Override
    public int gracenoteRequest(CoverartInfo coverartInfo, IGracenoteResponse iGracenoteResponse) {
        return 0;
    }
}

