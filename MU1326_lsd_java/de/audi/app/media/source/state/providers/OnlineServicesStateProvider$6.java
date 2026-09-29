/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider;

class OnlineServicesStateProvider$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$started;
    private final /* synthetic */ OnlineServicesStateProvider this$0;

    OnlineServicesStateProvider$6(OnlineServicesStateProvider onlineServicesStateProvider, String string, boolean bl) {
        this.this$0 = onlineServicesStateProvider;
        this.val$started = bl;
        super(string);
    }

    @Override
    public void run() {
        OnlineServicesStateProvider.access$300(this.this$0).updateSourceState(new SourceStateUpdate(13, this.val$started));
    }
}

