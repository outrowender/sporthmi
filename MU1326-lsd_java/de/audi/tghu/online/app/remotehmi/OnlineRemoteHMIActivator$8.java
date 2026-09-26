/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.IConnectivityRHMIStateListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$8
extends AbstractRemoteHMITask {
    private final /* synthetic */ IConnectivityRHMIStateListener val$connectivityStateListener;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$8(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IConnectivityRHMIStateListener iConnectivityRHMIStateListener) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$connectivityStateListener = iConnectivityRHMIStateListener;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).setConnectivtyStateListener(this.val$connectivityStateListener);
    }
}

