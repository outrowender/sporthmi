/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.RadioMenuModelListener;

class MemoryListHandler$MenuModelListener
extends RadioMenuModelListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$MenuModelListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        super.itemFocused(n, n2, l, n3);
        if (n != 1938292992) {
            MemoryListHandler.access$4200(this.this$0, -1);
            MemoryListHandler.access$3800(this.this$0);
        }
    }

    /* synthetic */ MemoryListHandler$MenuModelListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

