/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.tm;

import de.audi.tv.app.ap.TVActionProxyDefaultListenerEvo;
import de.audi.tv.app.tm.TouchPadHandler;
import de.audi.tv.app.tm.TouchPadHandler$1;

class TouchPadHandler$ActionProxyListener
extends TVActionProxyDefaultListenerEvo {
    private final /* synthetic */ TouchPadHandler this$0;

    private TouchPadHandler$ActionProxyListener(TouchPadHandler touchPadHandler) {
        this.this$0 = touchPadHandler;
    }

    @Override
    public void tvCasDisclaimerEntered(int n) {
        this.this$0.changeUserInputMode(0);
    }

    @Override
    public void tvDataBroadcastEntered(int n) {
        this.this$0.changeUserInputMode(0);
    }

    @Override
    public void tvEngineeringEntered(int n) {
        this.this$0.changeUserInputMode(0);
    }

    @Override
    public void tvEPGEntered(int n) {
        this.this$0.changeUserInputMode(0);
    }

    @Override
    public void tvTeletextEntered(int n) {
        this.this$0.changeUserInputMode(0);
    }

    @Override
    public void tvVisualAudioEntered(int n) {
        this.this$0.changeUserInputMode(0);
    }

    /* synthetic */ TouchPadHandler$ActionProxyListener(TouchPadHandler touchPadHandler, TouchPadHandler$1 touchPadHandler$1) {
        this(touchPadHandler);
    }
}

