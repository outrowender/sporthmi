/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.PowerEventSourceStateProvider;

class PowerEventSourceStateProvider$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ Boolean val$newClampS;
    private final /* synthetic */ PowerEventSourceStateProvider this$0;

    PowerEventSourceStateProvider$2(PowerEventSourceStateProvider powerEventSourceStateProvider, String string, Boolean bl) {
        this.this$0 = powerEventSourceStateProvider;
        this.val$newClampS = bl;
        super(string);
    }

    @Override
    public void run() {
        PowerEventSourceStateProvider.access$000(this.this$0).updateSourceState(new SourceStateUpdate(3, this.val$newClampS));
    }
}

