/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class OnlineEvoActionProxyImpl$2
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$entryPointID;
    private final /* synthetic */ OnlineEvoActionProxyImpl this$0;

    OnlineEvoActionProxyImpl$2(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, String string, int n) {
        this.this$0 = onlineEvoActionProxyImpl;
        this.val$entryPointID = n;
        super(string);
    }

    @Override
    public void run() {
        OnlineEvoActionProxyImpl.access$100(this.this$0).setEntryPoint(this.val$entryPointID);
    }
}

