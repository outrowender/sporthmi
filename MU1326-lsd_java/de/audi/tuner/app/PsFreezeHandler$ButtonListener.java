/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.PsFreezeHandler;
import de.audi.tuner.app.PsFreezeHandler$1;

class PsFreezeHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ PsFreezeHandler this$0;

    private PsFreezeHandler$ButtonListener(PsFreezeHandler psFreezeHandler) {
        this.this$0 = psFreezeHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.this$0.freezeDefreze();
    }

    /* synthetic */ PsFreezeHandler$ButtonListener(PsFreezeHandler psFreezeHandler, PsFreezeHandler$1 psFreezeHandler$1) {
        this(psFreezeHandler);
    }
}

