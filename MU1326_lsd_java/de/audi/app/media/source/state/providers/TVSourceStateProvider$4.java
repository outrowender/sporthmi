/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.source.state.providers.TVSourceStateProvider;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.tv.ITVService;

class TVSourceStateProvider$4
implements ITVService {
    private final /* synthetic */ TVSourceStateProvider this$0;

    TVSourceStateProvider$4(TVSourceStateProvider tVSourceStateProvider) {
        this.this$0 = tVSourceStateProvider;
    }

    @Override
    public void deactivate() {
        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[ITVService.deactivate]");
    }

    @Override
    public void activate(int n, IMediaDrawerContext iMediaDrawerContext) {
        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[ITVService.activate]");
    }
}

