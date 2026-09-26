/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.tv.app.audio.MuteHandler;
import de.audi.tv.app.audio.MuteHandler$1;
import de.audi.tv.app.dsi.DSICallListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

class MuteHandler$DSICallListenerExt
extends DSICallListener {
    private final /* synthetic */ MuteHandler this$0;

    private MuteHandler$DSICallListenerExt(MuteHandler muteHandler) {
        this.this$0 = muteHandler;
    }

    @Override
    public void selectService(ServiceInfo serviceInfo, boolean bl) {
        MuteHandler.access$500(this.this$0, 0);
        if (bl) {
            MuteHandler.access$600(this.this$0).demute();
        }
    }

    @Override
    public void switchSource(int n, boolean bl) {
        if (bl) {
            MuteHandler.access$600(this.this$0).demute();
        }
    }

    /* synthetic */ MuteHandler$DSICallListenerExt(MuteHandler muteHandler, MuteHandler$1 muteHandler$1) {
        this(muteHandler);
    }
}

