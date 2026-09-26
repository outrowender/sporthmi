/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.OnlineServiceListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$7
extends AbstractRemoteHMITask {
    private final /* synthetic */ OnlineServiceListener val$onlineService;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$7(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, OnlineServiceListener onlineServiceListener) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$onlineService = onlineServiceListener;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setSDSOnlineServiceListener(this.val$onlineService);
    }
}

