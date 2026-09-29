/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.storage;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.storage.TVLastmode;
import de.audi.tv.app.storage.TVLastmode$1;

class TVLastmode$OnDSIHandlerStateChangedListenerImpl
extends TVEventDefaultListener {
    private final /* synthetic */ TVLastmode this$0;

    private TVLastmode$OnDSIHandlerStateChangedListenerImpl(TVLastmode tVLastmode) {
        this.this$0 = tVLastmode;
    }

    @Override
    public void onDSILocked() {
    }

    @Override
    public void onDSIUnlocked() {
        TVLastmode.access$600(this.this$0, false);
    }

    /* synthetic */ TVLastmode$OnDSIHandlerStateChangedListenerImpl(TVLastmode tVLastmode, TVLastmode$1 tVLastmode$1) {
        this(tVLastmode);
    }
}

