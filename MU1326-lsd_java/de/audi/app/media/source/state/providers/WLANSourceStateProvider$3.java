/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider;

class WLANSourceStateProvider$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$numberOfClients;
    private final /* synthetic */ WLANSourceStateProvider this$0;

    WLANSourceStateProvider$3(WLANSourceStateProvider wLANSourceStateProvider, String string, int n) {
        this.this$0 = wLANSourceStateProvider;
        this.val$numberOfClients = n;
        super(string);
    }

    @Override
    public void run() {
        WLANSourceStateProvider.access$000(this.this$0).updateSourceState(new SourceStateUpdate(14, this.val$numberOfClients > 0));
    }
}

