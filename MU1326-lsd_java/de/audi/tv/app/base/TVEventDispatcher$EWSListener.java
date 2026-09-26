/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.IEWSListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;

class TVEventDispatcher$EWSListener
implements IEWSListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$EWSListener(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void onEWSInfosActivated() {
        TVEventDispatcher.access$800(this.this$0, true);
    }

    @Override
    public void onEWSInfosDeactivated() {
        TVEventDispatcher.access$800(this.this$0, false);
    }

    /* synthetic */ TVEventDispatcher$EWSListener(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

