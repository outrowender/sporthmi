/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.IRemoteHMISpeechCommandSDS;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$15
extends AbstractRemoteHMITask {
    private final /* synthetic */ IRemoteHMISpeechCommandSDS[] val$speechEntities;
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$15(RemoteHMIService remoteHMIService, String string, IRemoteHMISpeechCommandSDS[] iRemoteHMISpeechCommandSDSArray) {
        this.this$0 = remoteHMIService;
        this.val$speechEntities = iRemoteHMISpeechCommandSDSArray;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateSpeechGlobalCommands: updating SDS service.");
        RemoteHMIService.access$200(this.this$0).indicateSpeechGlobalCommands(this.val$speechEntities);
    }
}

