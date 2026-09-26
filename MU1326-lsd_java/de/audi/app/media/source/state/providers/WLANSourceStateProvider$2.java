/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider;
import de.audi.app.media.source.state.providers.WLANState;

class WLANSourceStateProvider$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ WLANState val$newWlanState;
    private final /* synthetic */ WLANSourceStateProvider this$0;

    WLANSourceStateProvider$2(WLANSourceStateProvider wLANSourceStateProvider, String string, WLANState wLANState) {
        this.this$0 = wLANSourceStateProvider;
        this.val$newWlanState = wLANState;
        super(string);
    }

    @Override
    public void run() {
        WLANSourceStateProvider.access$000(this.this$0).updateSourceState(new SourceStateUpdate(4, this.val$newWlanState));
    }
}

