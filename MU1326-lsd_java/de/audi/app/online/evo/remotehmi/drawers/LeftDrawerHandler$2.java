/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$LeftDrawerPayload;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;

class LeftDrawerHandler$2
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ RemoteHMIService val$remoteHMIService;
    private final /* synthetic */ LeftDrawerHandler this$0;

    LeftDrawerHandler$2(LeftDrawerHandler leftDrawerHandler, String string, LogChannel logChannel, RemoteHMIService remoteHMIService) {
        this.this$0 = leftDrawerHandler;
        this.val$log = logChannel;
        this.val$remoteHMIService = remoteHMIService;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$LeftDrawerPayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$log.log(1078071040, "LeftDrawerHandler#indicateCommand: Commands.STATE_LEFT_DRAWER called");
        if (!(object instanceof Commands$LeftDrawerPayload)) {
            this.val$log.log(-1601830656, "LeftDrawerPayload#indicateCommand: wrong payload provided");
            return;
        }
        Commands$LeftDrawerPayload commands$LeftDrawerPayload = (Commands$LeftDrawerPayload)object;
        String string = commands$LeftDrawerPayload.getContextName();
        RemoteHMIContext remoteHMIContext = this.val$remoteHMIService.getContextManagerComponent().getCurrentContext();
        if (remoteHMIContext != null && remoteHMIContext.getContextName().equals(string)) {
            this.this$0.setMenuEntriesForContext(commands$LeftDrawerPayload);
        } else {
            this.val$log.log(-2137614336, "LeftDrawerPayload#indicateCommand: LeftDrawerPayload saved as payloadLastRecieved");
            LeftDrawerHandler.access$602(this.this$0, commands$LeftDrawerPayload);
        }
    }
}

