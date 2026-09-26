/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService$20$1;

class RemoteHMIService$20
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$contextName;
    private final /* synthetic */ int val$entryPointId;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$20(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, String string2, int n) {
        this.this$0 = remoteHMIService;
        this.val$contextName = string2;
        this.val$entryPointId = n;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.getParamsForDebugging();
        this.this$0.contextManagerComponent.setContext(this.val$contextName, this.val$entryPointId);
    }

    @Override
    public LogAppender getParamsForDebugging() {
        this.this$0.logChannel.log(-2137614336, "RemoteHMIService#indicateContext: %1", (Object)this.val$contextName);
        RemoteHMIService$20$1 remoteHMIService$20$1 = new RemoteHMIService$20$1(this);
        return remoteHMIService$20$1;
    }

    static /* synthetic */ String access$400(RemoteHMIService$20 remoteHMIService$20) {
        return remoteHMIService$20.val$contextName;
    }
}

