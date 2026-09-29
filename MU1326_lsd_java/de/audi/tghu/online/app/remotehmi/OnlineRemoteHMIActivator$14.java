/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.media.IMediaService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$14
extends AbstractRemoteHMITask {
    private final /* synthetic */ IMediaService val$mediaService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$14(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IMediaService iMediaService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$mediaService = iMediaService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setMediaService(this.val$mediaService);
    }
}

