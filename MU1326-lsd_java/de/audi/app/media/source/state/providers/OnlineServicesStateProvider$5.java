/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;

class OnlineServicesStateProvider$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$idx;
    private final /* synthetic */ OnlineServicesStateProvider this$0;

    OnlineServicesStateProvider$5(OnlineServicesStateProvider onlineServicesStateProvider, String string, int n) {
        this.this$0 = onlineServicesStateProvider;
        this.val$idx = n;
        super(string);
    }

    @Override
    public void run() {
        OnlineServicesStateProvider.access$300(this.this$0).updateSourceState(new SourceStateUpdate(11, new Integer(this.val$idx)));
    }
}

