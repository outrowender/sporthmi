/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$19
extends AbstractRemoteHMITask {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$19(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#processMsg: units changed");
        this.this$0.invokeActionImmediately(this.this$0.getAction(1));
    }
}

