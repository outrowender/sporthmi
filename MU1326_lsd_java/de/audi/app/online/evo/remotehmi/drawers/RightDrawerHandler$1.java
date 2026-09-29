/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.RemoteHMIServiceEvo;
import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$RightDrawerPayload;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

class RightDrawerHandler$1
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ RemoteHMIServiceEvo val$remoteHMIService;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$1(RightDrawerHandler rightDrawerHandler, String string, LogChannel logChannel, RemoteHMIServiceEvo remoteHMIServiceEvo) {
        this.this$0 = rightDrawerHandler;
        this.val$log = logChannel;
        this.val$remoteHMIService = remoteHMIServiceEvo;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$RightDrawerPayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$log.log(1078071040, "RightDrawerHandler#indicateCommand: Commands.STATE_RIGHT_DRAWER called");
        if (!(object instanceof Commands$RightDrawerPayload)) {
            this.val$log.log(-1601830656, "RightDrawerHandler#indicateCommand: wrong payload provided");
            return;
        }
        Commands$RightDrawerPayload commands$RightDrawerPayload = (Commands$RightDrawerPayload)object;
        String string = commands$RightDrawerPayload.getContextName();
        RemoteHMIContext remoteHMIContext = this.val$remoteHMIService.getContextManagerComponent().getCurrentContext();
        if (remoteHMIContext != null && remoteHMIContext.getContextName().equals(string)) {
            RightDrawerHandler.access$000(this.this$0).setRightDrawerTypes(commands$RightDrawerPayload);
        } else {
            this.val$log.log(-2137614336, "RightDrawerHandler#indicateCommand: RightDrawerPayload saved as payloadLastRecieved");
            RightDrawerHandler.access$102(this.this$0, commands$RightDrawerPayload);
        }
    }
}

