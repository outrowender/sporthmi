/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$22
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$contextName;
    private final /* synthetic */ int val$entryPointId;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$22(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, String string2, int n) {
        this.this$0 = remoteHMIService;
        this.val$contextName = string2;
        this.val$entryPointId = n;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.contextManagerComponent.contextCreated(this.val$contextName, this.val$entryPointId);
    }
}

