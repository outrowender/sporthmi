/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class OnlineEvoActionProxyImpl$5
extends AbstractRemoteHMITask {
    private final /* synthetic */ OnlineEvoActionProxyImpl this$0;

    OnlineEvoActionProxyImpl$5(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, String string) {
        this.this$0 = onlineEvoActionProxyImpl;
        super(string);
    }

    @Override
    public void run() {
        RemoteHMIAction remoteHMIAction = OnlineEvoActionProxyImpl.access$000(this.this$0).getAction(104);
        OnlineEvoActionProxyImpl.access$000(this.this$0).invokeAction(remoteHMIAction);
    }
}

