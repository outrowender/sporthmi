/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.rse.TabletServiceHandler;
import de.audi.tuner.app.rse.TabletServiceHandler$1;

class TabletServiceHandler$ParentalEnforcementListener
extends DefaultButtonListener {
    private final /* synthetic */ TabletServiceHandler this$0;

    private TabletServiceHandler$ParentalEnforcementListener(TabletServiceHandler tabletServiceHandler) {
        this.this$0 = tabletServiceHandler;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        TabletServiceHandler.access$400((TabletServiceHandler)this.this$0).rse.log(-2137614336, "[TabletServiceHandler#ParentalEnforcementListener#keyPressed] activate radio on RSE");
        TabletServiceHandler.access$500(this.this$0).enforceRadio();
    }

    /* synthetic */ TabletServiceHandler$ParentalEnforcementListener(TabletServiceHandler tabletServiceHandler, TabletServiceHandler$1 tabletServiceHandler$1) {
        this(tabletServiceHandler);
    }
}

