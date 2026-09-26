/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sds;

import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.sds.TVServiceImpl;
import de.audi.tv.app.sds.TVServiceImpl$1;

class TVServiceImpl$EventListener
extends TVEventDefaultListener {
    private final /* synthetic */ TVServiceImpl this$0;

    private TVServiceImpl$EventListener(TVServiceImpl tVServiceImpl) {
        this.this$0 = tVServiceImpl;
    }

    @Override
    public void onMuGotTvAudioFocus() {
        TVServiceImpl.access$102(this.this$0, true);
    }

    @Override
    public void onMuLostTvAudioFocus() {
        TVServiceImpl.access$102(this.this$0, false);
    }

    /* synthetic */ TVServiceImpl$EventListener(TVServiceImpl tVServiceImpl, TVServiceImpl$1 tVServiceImpl$1) {
        this(tVServiceImpl);
    }
}

