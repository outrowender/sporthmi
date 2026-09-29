/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.GlobalOptionsMngr;
import de.audi.tuner.app.GlobalOptionsMngr$1;
import de.audi.tuner.ifc.listener.MessageListener;

class GlobalOptionsMngr$MyMessageListener
extends MessageListener {
    private final /* synthetic */ GlobalOptionsMngr this$0;

    private GlobalOptionsMngr$MyMessageListener(GlobalOptionsMngr globalOptionsMngr) {
        this.this$0 = globalOptionsMngr;
    }

    @Override
    public void resetToDefaultSettings() {
        int n = GlobalOptionsMngr.getDefaultPreferedImgType();
        GlobalOptionsMngr.access$800(this.this$0).itemSelected(-997719808, n, 0, 0);
    }

    /* synthetic */ GlobalOptionsMngr$MyMessageListener(GlobalOptionsMngr globalOptionsMngr, GlobalOptionsMngr$1 globalOptionsMngr$1) {
        this(globalOptionsMngr);
    }
}

