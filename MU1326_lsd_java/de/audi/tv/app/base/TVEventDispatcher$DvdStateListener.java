/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.tv.app.base.TVEventDispatcher$Properties
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.DefaultMessageListener;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TVEventDispatcher$1;

class TVEventDispatcher$DvdStateListener
extends DefaultMessageListener {
    private final /* synthetic */ TVEventDispatcher this$0;

    private TVEventDispatcher$DvdStateListener(TVEventDispatcher tVEventDispatcher) {
        this.this$0 = tVEventDispatcher;
    }

    @Override
    public void sourceDvdActivated() {
        TVEventDispatcher.Properties.access$1600((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(false));
    }

    @Override
    public void sourceMediaDeactivated() {
        TVEventDispatcher.Properties.access$1600((TVEventDispatcher.Properties)TVEventDispatcher.access$1100(this.this$0)).accept(new Boolean(true));
    }

    /* synthetic */ TVEventDispatcher$DvdStateListener(TVEventDispatcher tVEventDispatcher, TVEventDispatcher$1 tVEventDispatcher$1) {
        this(tVEventDispatcher);
    }
}

