/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$18
extends AbstractRemoteHMITask {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$18(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    @Override
    public void run() {
        this.this$0.logChannel.log(-2137614336, "RemoteHMIService#processMsg(): message \"RESET_NAV_MEMORY_SETTINGS\" received");
        this.this$0.dsiAccess.resetToFactorySettings();
        this.this$0.getBrowserController().resetToFactorySettings();
    }
}

