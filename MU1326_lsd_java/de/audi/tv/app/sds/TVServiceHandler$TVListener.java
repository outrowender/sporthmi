/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.sds;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.sds.TVServiceHandler;
import de.audi.tv.app.sds.TVServiceHandler$1;
import org.dsi.ifc.tvtuner.StartUpConfig;

class TVServiceHandler$TVListener
extends DefaultTVListener {
    private final /* synthetic */ TVServiceHandler this$0;

    private TVServiceHandler$TVListener(TVServiceHandler tVServiceHandler) {
        this.this$0 = tVServiceHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        Object object = TVServiceHandler.access$300(this.this$0);
        synchronized (object) {
            TVServiceHandler.access$402(this.this$0, startUpConfig.avSrcAvail);
            TVServiceHandler.access$500(this.this$0);
        }
    }

    /* synthetic */ TVServiceHandler$TVListener(TVServiceHandler tVServiceHandler, TVServiceHandler$1 tVServiceHandler$1) {
        this(tVServiceHandler);
    }
}

