/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.media.IMediaOnlinePlayerService;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$13
extends AbstractRemoteHMITask {
    private final /* synthetic */ IMediaOnlinePlayerService val$mediaService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$13(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IMediaOnlinePlayerService iMediaOnlinePlayerService) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$mediaService = iMediaOnlinePlayerService;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setOnlineMediaService(this.val$mediaService);
    }
}

