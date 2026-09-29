/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.atip.interapp.IConnectivityOnlineStateListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.OnlineRemoteHMIActivator;

class OnlineRemoteHMIActivator$9
extends AbstractRemoteHMITask {
    private final /* synthetic */ IConnectivityOnlineStateListener val$connectivityOnlineStateListener;
    private final /* synthetic */ OnlineRemoteHMIActivator this$0;

    OnlineRemoteHMIActivator$9(OnlineRemoteHMIActivator onlineRemoteHMIActivator, String string, IConnectivityOnlineStateListener iConnectivityOnlineStateListener) {
        this.this$0 = onlineRemoteHMIActivator;
        this.val$connectivityOnlineStateListener = iConnectivityOnlineStateListener;
        super(string);
    }

    @Override
    public void run() {
        OnlineRemoteHMIActivator.access$000(this.this$0).getPhoneComponent().setConnectivityOnlineStateListener(this.val$connectivityOnlineStateListener);
    }
}

