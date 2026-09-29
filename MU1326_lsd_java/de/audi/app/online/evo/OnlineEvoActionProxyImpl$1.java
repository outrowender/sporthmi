/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo;

import de.audi.app.online.evo.OnlineEvoActionProxyImpl;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class OnlineEvoActionProxyImpl$1
extends AbstractRemoteHMITask {
    private final /* synthetic */ OnlineEvoActionProxyImpl this$0;

    OnlineEvoActionProxyImpl$1(OnlineEvoActionProxyImpl onlineEvoActionProxyImpl, String string) {
        this.this$0 = onlineEvoActionProxyImpl;
        super(string);
    }

    @Override
    public void run() {
        OnlineEvoActionProxyImpl.access$000(this.this$0).onEnter();
    }
}

