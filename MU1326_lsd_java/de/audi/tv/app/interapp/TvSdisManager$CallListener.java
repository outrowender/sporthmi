/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.interapp.ITVInterappListener$TvState;
import de.audi.tv.app.interapp.TvSdisManager;
import de.audi.tv.app.interapp.TvSdisManager$1;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TvSdisManager$CallListener
extends DSICallListener {
    private final /* synthetic */ TvSdisManager this$0;

    private TvSdisManager$CallListener(TvSdisManager tvSdisManager) {
        this.this$0 = tvSdisManager;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        TvSdisManager.access$1202(this.this$0, new ProgramInfo());
        TvSdisManager.access$1200((TvSdisManager)this.this$0).serviceInfo = serviceInfo;
        TvSdisManager.access$1300(this.this$0, TvSdisManager.access$1200(this.this$0));
        TvSdisManager.access$800(this.this$0).updateTvState(new ITVInterappListener$TvState(0));
    }

    /* synthetic */ TvSdisManager$CallListener(TvSdisManager tvSdisManager, TvSdisManager$1 tvSdisManager$1) {
        this(tvSdisManager);
    }
}

