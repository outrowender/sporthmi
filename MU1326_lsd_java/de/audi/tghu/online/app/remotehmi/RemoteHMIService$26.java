/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$26
extends AbstractRemoteHMITask {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$26(RemoteHMIService remoteHMIService, String string, LogAppender logAppender) {
        this.this$0 = remoteHMIService;
        super(string, logAppender);
    }

    @Override
    public void run() {
        this.this$0.flushModelGroup();
    }
}

