/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.TVPresetHandler;
import de.audi.tv.app.TVPresetHandler$1;
import de.audi.tv.app.dsi.DefaultTVListener;

class TVPresetHandler$TVListener
extends DefaultTVListener {
    private final /* synthetic */ TVPresetHandler this$0;

    private TVPresetHandler$TVListener(TVPresetHandler tVPresetHandler) {
        this.this$0 = tVPresetHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void switchSource(int n) {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            if (n == 1 && TVPresetHandler.access$1400(this.this$0) != null && TVPresetHandler.access$1200(this.this$0) == 0) {
                TVPresetHandler.access$1300(this.this$0).changeService(TVPresetHandler.access$1400(this.this$0), true);
                TVPresetHandler.access$1402(this.this$0, null);
            }
        }
    }

    /* synthetic */ TVPresetHandler$TVListener(TVPresetHandler tVPresetHandler, TVPresetHandler$1 tVPresetHandler$1) {
        this(tVPresetHandler);
    }
}

