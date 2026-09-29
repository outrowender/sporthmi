/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$16
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$speechContext;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$16(RemoteHMIService remoteHMIService, String string, String string2) {
        this.this$0 = remoteHMIService;
        this.val$speechContext = string2;
        super(string);
    }

    @Override
    public void run() {
        if (RemoteHMIService.access$200(this.this$0) != null) {
            RemoteHMIService.access$200(this.this$0).indicateCurrentSpeechHelpContext(this.val$speechContext);
        }
    }
}

