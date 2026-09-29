/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.RemoteHMIView;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$11
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$contextName;
    private final /* synthetic */ RemoteHMIView val$view;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$11(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, String string2, RemoteHMIView remoteHMIView) {
        this.this$0 = remoteHMIService;
        this.val$contextName = string2;
        this.val$view = remoteHMIView;
        super(string, logAppender);
    }

    @Override
    public void run() {
        RemoteHMIService.access$100(this.this$0, this.val$contextName);
        this.this$0.loadView(this.val$contextName, this.val$view);
    }
}

