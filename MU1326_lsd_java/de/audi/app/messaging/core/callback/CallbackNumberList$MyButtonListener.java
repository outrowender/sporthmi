/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.callback;

import de.audi.app.messaging.core.callback.CallbackNumberList;
import de.audi.app.messaging.core.callback.CallbackNumberList$1;
import de.audi.atip.hmi.model.DefaultButtonListener;

class CallbackNumberList$MyButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ CallbackNumberList this$0;

    private CallbackNumberList$MyButtonListener(CallbackNumberList callbackNumberList) {
        this.this$0 = callbackNumberList;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == 1804738816 || n == 1049829632 || n == 1653809408) {
            CallbackNumberList.access$400(this.this$0, n, n3, n != 1653809408);
        } else {
            CallbackNumberList.access$500(this.this$0).log(10000, "[CallbackNumberList#keyTyped] Unexpected modelID = %1", (long)n);
        }
    }

    /* synthetic */ CallbackNumberList$MyButtonListener(CallbackNumberList callbackNumberList, CallbackNumberList$1 callbackNumberList$1) {
        this(callbackNumberList);
    }
}

