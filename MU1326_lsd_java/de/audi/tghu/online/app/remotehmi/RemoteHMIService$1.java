/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi;

import de.audi.remotehmi.ui.mib2.grid.IGridFactory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class RemoteHMIService$1
extends AbstractCommandHandler {
    private final /* synthetic */ RemoteHMIService this$0;

    RemoteHMIService$1(RemoteHMIService remoteHMIService, String string) {
        this.this$0 = remoteHMIService;
        super(string);
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.this$0.logChannel.log(1078071040, "RemoteHMIService#ctor (ICommandHandler): received IGridFactory.");
        this.this$0.gridFactory = (IGridFactory)object;
        this.this$0.frameworkAccess.getErrorMgr().registerDumpInfoProvider(this.this$0.gridFactory);
    }
}

