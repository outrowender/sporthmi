/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.tv.app.TVPresetHandler;
import de.audi.tv.app.TVPresetHandler$1;
import de.audi.tv.app.dsi.DSICallListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TVPresetHandler$DSIDownListener
extends DSICallListener {
    private final /* synthetic */ TVPresetHandler this$0;

    private TVPresetHandler$DSIDownListener(TVPresetHandler tVPresetHandler) {
        this.this$0 = tVPresetHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void switchSource(int n, boolean bl) {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            TVPresetHandler.access$1202(this.this$0, n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        Object object = TVPresetHandler.access$600(this.this$0);
        synchronized (object) {
            TVPresetHandler.access$702(this.this$0, serviceInfo);
        }
    }

    /* synthetic */ TVPresetHandler$DSIDownListener(TVPresetHandler tVPresetHandler, TVPresetHandler$1 tVPresetHandler$1) {
        this(tVPresetHandler);
    }
}

