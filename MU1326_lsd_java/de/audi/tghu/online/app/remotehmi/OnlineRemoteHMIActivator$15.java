/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$15
extends AbstractRemoteHMITask {
    private final /* synthetic */ IRemoteHMIMediaOnlineServiceListener val$remoteHMIMediaOnlineServiceListener;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$15(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IRemoteHMIMediaOnlineServiceListener iRemoteHMIMediaOnlineServiceListener) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$remoteHMIMediaOnlineServiceListener = iRemoteHMIMediaOnlineServiceListener;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setRemoteHMIMediaOnlineServiceListener(this.val$remoteHMIMediaOnlineServiceListener);
    }
}

