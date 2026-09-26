/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$7
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$7(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: state STATE_RECEIVED_SUBSCRIBE_MESSAGES_COUNT");
        if (this.this$0.getDiagnosisComponent() != null) {
            this.this$0.getDiagnosisComponent().update(object, 6);
        }
    }
}

