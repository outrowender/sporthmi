/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class OnlineEvoActionProxyImpl$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ OnlineEvoActionProxyImpl this$0;

    OnlineEvoActionProxyImpl$6(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, String string, int n) {
        this.this$0 = onlineEvoActionProxyImpl;
        this.val$terminalID = n;
        super(string);
    }

    @Override
    public void run() {
        OnlineEvoActionProxyImpl.access$000(this.this$0).getBrowserController().remoteHmiBrowserLeft(this.val$terminalID);
    }
}

