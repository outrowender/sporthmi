/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.callback;

import de.audi.app.messaging.core.callback.CallbackNumberList;
import de.audi.app.messaging.core.callback.CallbackNumberList$1;
import de.audi.atip.hmi.model.DefaultListListener;

class CallbackNumberList$MyListListener
extends DefaultListListener {
    private final /* synthetic */ CallbackNumberList this$0;

    private CallbackNumberList$MyListListener(CallbackNumberList callbackNumberList) {
        this.this$0 = callbackNumberList;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        CallbackNumberList.access$200(this.this$0).log(1078071040, "[CallbackNumberList#itemSelected] row = %1, col = %2", (long)n2, (long)n3);
        CallbackNumberList.access$300(this.this$0, n2, n3);
    }

    /* synthetic */ CallbackNumberList$MyListListener(CallbackNumberList callbackNumberList, CallbackNumberList$1 callbackNumberList$1) {
        this(callbackNumberList);
    }
}

