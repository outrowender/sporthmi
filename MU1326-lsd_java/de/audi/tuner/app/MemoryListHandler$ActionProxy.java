/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.ap.TunerActionProxyListener;

class MemoryListHandler$ActionProxy
extends TunerActionProxyListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$ActionProxy(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void tunerGuidedStoreLeft() {
        MemoryListHandler.access$2902(this.this$0, -1);
        MemoryListHandler.access$2702(this.this$0, 0);
        MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(0);
    }

    @Override
    public void tunerFavoritesEntered() {
        MemoryListHandler.access$2902(this.this$0, -1);
        MemoryListHandler.access$2702(this.this$0, 0);
        MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(0);
        MemoryListHandler.access$5102(this.this$0, true);
    }

    @Override
    public void tunerFavoritesLeft() {
        MemoryListHandler.access$5102(this.this$0, false);
    }

    /* synthetic */ MemoryListHandler$ActionProxy(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

