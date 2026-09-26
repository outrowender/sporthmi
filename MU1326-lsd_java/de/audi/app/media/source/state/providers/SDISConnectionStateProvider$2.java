/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.SDISConnectionStateProvider;

class SDISConnectionStateProvider$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$newSDISConnectedState;
    private final /* synthetic */ SDISConnectionStateProvider this$0;

    SDISConnectionStateProvider$2(SDISConnectionStateProvider sDISConnectionStateProvider, String string, boolean bl) {
        this.this$0 = sDISConnectionStateProvider;
        this.val$newSDISConnectedState = bl;
        super(string);
    }

    @Override
    public void run() {
        SDISConnectionStateProvider.access$000(this.this$0).updateSourceState(new SourceStateUpdate(16, this.val$newSDISConnectedState));
    }
}

