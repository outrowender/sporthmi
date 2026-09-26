/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$5
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$5(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: state STATE_SERVICELIST_UPDATE");
        if (this.this$0.licensingCollector != null) {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: refreshing licenses after SL update");
            this.this$0.licensingCollector.refreshLicensesDependingOnServiceList();
        } else {
            this.this$0.logChannel.log(1078071040, "RemoteHMIService#indicateCommand: license collector == null");
        }
    }
}

