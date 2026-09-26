/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$23
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$contextName;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$23(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, String string2) {
        this.this$0 = remoteHMIService;
        this.val$contextName = string2;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.contextManagerComponent.contextSuspended(this.val$contextName);
    }
}

