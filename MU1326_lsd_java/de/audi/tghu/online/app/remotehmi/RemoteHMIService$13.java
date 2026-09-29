/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.remotehmi.RemoteHMITask;

class RemoteHMIService$13
extends AbstractRemoteHMITask {
    private final /* synthetic */ RemoteHMITask val$commandHandlerTask;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$13(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, RemoteHMITask remoteHMITask) {
        this.this$0 = remoteHMIService;
        this.val$commandHandlerTask = remoteHMITask;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.execute(this.val$commandHandlerTask);
    }
}

