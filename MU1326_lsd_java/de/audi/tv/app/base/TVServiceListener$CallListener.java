/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TVServiceListener;
import de.audi.tv.app.base.TVServiceListener$1;
import de.audi.tv.app.dsi.DSICallListener;

class TVServiceListener$CallListener
extends DSICallListener {
    private final /* synthetic */ TVServiceListener this$0;

    private TVServiceListener$CallListener(TVServiceListener tVServiceListener) {
        this.this$0 = tVServiceListener;
    }

    @Override
    public void switchSource(int n, boolean bl) {
        TVServiceListener.access$700(this.this$0, n == 0 ? 0 : 1);
    }

    /* synthetic */ TVServiceListener$CallListener(TVServiceListener tVServiceListener, TVServiceListener$1 tVServiceListener$1) {
        this(tVServiceListener);
    }
}

