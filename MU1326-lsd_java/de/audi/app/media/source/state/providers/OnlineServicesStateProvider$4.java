/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;
import java.util.List;

class OnlineServicesStateProvider$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ List val$onlineServices;
    private final /* synthetic */ OnlineServicesStateProvider this$0;

    OnlineServicesStateProvider$4(OnlineServicesStateProvider onlineServicesStateProvider, String string, List list) {
        this.this$0 = onlineServicesStateProvider;
        this.val$onlineServices = list;
        super(string);
    }

    @Override
    public void run() {
        OnlineServicesStateProvider.access$300(this.this$0).updateSourceState(new SourceStateUpdate(8, this.val$onlineServices));
    }
}

