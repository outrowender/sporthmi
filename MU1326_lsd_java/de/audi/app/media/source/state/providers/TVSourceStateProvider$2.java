/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.TVSourceStateProvider;
import de.audi.atip.interapp.tv.ITVService;

class TVSourceStateProvider$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ITVService val$service;
    private final /* synthetic */ TVSourceStateProvider this$0;

    TVSourceStateProvider$2(TVSourceStateProvider tVSourceStateProvider, String string, ITVService iTVService) {
        this.this$0 = tVSourceStateProvider;
        this.val$service = iTVService;
        super(string);
    }

    @Override
    public void run() {
        TVSourceStateProvider.access$000(this.this$0).log(1078071040, "[%1.updateTVService]", (Object)"TVSourceStateProvider");
        TVSourceStateProvider.access$200(this.this$0).updateSourceState(new SourceStateUpdate(10, this.val$service));
    }
}

