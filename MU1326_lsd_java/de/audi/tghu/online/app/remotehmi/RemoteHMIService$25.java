/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.RemoteHMIAction;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$25
extends AbstractRemoteHMITask {
    private final /* synthetic */ RemoteHMIAction val$action;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$25(RemoteHMIService remoteHMIService, String string, RemoteHMIAction remoteHMIAction) {
        this.this$0 = remoteHMIService;
        this.val$action = remoteHMIAction;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.invokeAction(this.val$action);
    }
}

