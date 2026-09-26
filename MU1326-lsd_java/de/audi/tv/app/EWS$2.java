/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tv.app.EWS;

class EWS$2
extends DefaultChoiceListener {
    private final /* synthetic */ EWS this$0;

    EWS$2(EWS eWS) {
        this.this$0 = eWS;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        EWS.access$300(this.this$0).log(1078071040, "[EWS.itemFocused] cancel timeout");
        EWS.access$400(this.this$0).setStatus(1);
        EWS.access$400(this.this$0).setStatus(0);
    }
}

