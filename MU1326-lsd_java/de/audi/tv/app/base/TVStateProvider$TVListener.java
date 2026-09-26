/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.tv.app.base.TVStateProvider;
import de.audi.tv.app.base.TVStateProvider$1;
import de.audi.tv.app.dsi.DefaultTVListener;
import org.dsi.ifc.tvtuner.StartUpConfig;

class TVStateProvider$TVListener
extends DefaultTVListener {
    private final /* synthetic */ TVStateProvider this$0;

    private TVStateProvider$TVListener(TVStateProvider tVStateProvider) {
        this.this$0 = tVStateProvider;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateStartUpMUConfig(StartUpConfig startUpConfig) {
        Object object = TVStateProvider.access$200(this.this$0);
        synchronized (object) {
            if (!TVStateProvider.access$500(this.this$0)) {
                int[] nArray;
                TVStateProvider.access$502(this.this$0, true);
                if (startUpConfig.avSrcAvail) {
                    int[] nArray2 = new int[2];
                    nArray2[0] = 0;
                    nArray = nArray2;
                    nArray2[1] = 1;
                } else {
                    int[] nArray3 = new int[1];
                    nArray = nArray3;
                    nArray3[0] = 0;
                }
                TVStateProvider.access$602(this.this$0, nArray);
                TVStateProvider.access$400(this.this$0);
            }
        }
    }

    /* synthetic */ TVStateProvider$TVListener(TVStateProvider tVStateProvider, TVStateProvider$1 tVStateProvider$1) {
        this(tVStateProvider);
    }
}

