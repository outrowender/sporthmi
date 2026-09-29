/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;
import de.audi.tv.app.lists.IListFocusListener;

class TVEventDispatcher$ListFocusListener
implements IListFocusListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$ListFocusListener(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void onFocusedListChanged(int n) {
        TVEventDispatcher.access$900(this.this$0).log(-2137614336, "[TVEventDispatcher.onFocusedListChanged] %1", (long)n);
        for (int i2 = 0; i2 < TVEventDispatcher.access$1000(this.this$0).size(); ++i2) {
            ((ITVEventListener)TVEventDispatcher.access$1000(this.this$0).get(i2)).onFocusedListChanged(n);
        }
    }

    /* synthetic */ TVEventDispatcher$ListFocusListener(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

