/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$16
extends AbstractRemoteHMITask {
    private final /* synthetic */ IMediaDrawerContext val$mediaDrawerContext;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$16(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IMediaDrawerContext iMediaDrawerContext) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$mediaDrawerContext = iMediaDrawerContext;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setMediaDrawerContext(this.val$mediaDrawerContext);
    }
}

