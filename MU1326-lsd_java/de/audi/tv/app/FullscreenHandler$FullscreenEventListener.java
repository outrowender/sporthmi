/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.FullscreenHandler;
import de.audi.tv.app.FullscreenHandler$1;
import de.audi.tv.app.base.TVEventDefaultListener;

class FullscreenHandler$FullscreenEventListener
extends TVEventDefaultListener {
    private final /* synthetic */ FullscreenHandler this$0;

    private FullscreenHandler$FullscreenEventListener(FullscreenHandler fullscreenHandler) {
        this.this$0 = fullscreenHandler;
    }

    @Override
    public void onFullscreenEntered(int n) {
        FullscreenHandler.access$100(this.this$0).setValue(1);
    }

    @Override
    public void onFullscreenLeft(int n) {
        FullscreenHandler.access$100(this.this$0).setValue(0);
    }

    /* synthetic */ FullscreenHandler$FullscreenEventListener(FullscreenHandler fullscreenHandler, FullscreenHandler$1 fullscreenHandler$1) {
        this(fullscreenHandler);
    }
}

