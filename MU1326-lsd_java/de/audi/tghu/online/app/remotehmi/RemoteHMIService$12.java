/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechContext;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$12
extends AbstractRemoteHMITask {
    private final /* synthetic */ String val$contextName;
    private final /* synthetic */ IRemoteHMISpeechContext val$speechContext;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$12(RemoteHMIService remoteHMIService, String string, LogAppender logAppender, String string2, IRemoteHMISpeechContext iRemoteHMISpeechContext) {
        this.this$0 = remoteHMIService;
        this.val$contextName = string2;
        this.val$speechContext = iRemoteHMISpeechContext;
        super(string, logAppender);
    }

    @Override
    public void run() {
        RemoteHMIContext remoteHMIContext = this.this$0.contextManagerComponent.getContext(this.val$contextName);
        if (remoteHMIContext == null) {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateSpeechContext: context is null, not sending speechContext");
            return;
        }
        if (this.this$0.contextManagerComponent.isContextActive(remoteHMIContext)) {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateSpeechContext: updating SDS service for context %1.", (Object)(remoteHMIContext.getContextName() == null ? "" : remoteHMIContext.getContextName()));
            RemoteHMIService.access$200(this.this$0).indicateSpeechContext(this.val$speechContext);
        } else {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateSpeechContext: context %1 not active", (Object)(remoteHMIContext.getContextName() == null ? "" : remoteHMIContext.getContextName()));
        }
    }
}

