/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;
import de.audi.atip.interapp.online.OnlineServiceProvider;

class OnlineServicesStateProvider$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ OnlineServiceProvider val$pService;
    private final /* synthetic */ OnlineServicesStateProvider this$0;

    OnlineServicesStateProvider$3(OnlineServicesStateProvider onlineServicesStateProvider, String string, OnlineServiceProvider onlineServiceProvider) {
        this.this$0 = onlineServicesStateProvider;
        this.val$pService = onlineServiceProvider;
        super(string);
    }

    @Override
    public void run() {
        OnlineServicesStateProvider.access$000(this.this$0).log(1078071040, "[%1.updateRemoteHMIService] '%2'", (Object)"OnlineServicesStateProvider", (Object)this.val$pService);
        OnlineServicesStateProvider.access$300(this.this$0).updateSourceState(new SourceStateUpdate(9, this.val$pService));
    }
}

