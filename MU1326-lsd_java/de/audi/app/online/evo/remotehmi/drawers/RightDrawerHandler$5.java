/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$RightDrawerPayload;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.EntryPoint;
import de.audi.tghu.online.app.remotehmi.RemoteHMIContext;

class RightDrawerHandler$5
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$5(RightDrawerHandler rightDrawerHandler, String string, LogChannel logChannel) {
        this.this$0 = rightDrawerHandler;
        this.val$log = logChannel;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$RightDrawerPayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        RemoteHMIContext remoteHMIContext;
        this.val$log.log(1078071040, "RightDrawerHandler#indicateCommand: Commands.STATE_TOP_WIZARD_RIGHT_DRAWER_UPDATE called");
        if (!(object instanceof Commands$RightDrawerPayload)) {
            this.val$log.log(-1601830656, "RightDrawerHandler#indicateCommand: wrong payload provided");
            return;
        }
        Commands$RightDrawerPayload commands$RightDrawerPayload = (Commands$RightDrawerPayload)object;
        EntryPoint entryPoint = RightDrawerHandler.access$400(this.this$0) == null ? null : RightDrawerHandler.access$400(this.this$0).getCurrentEntryPoint();
        RemoteHMIContext remoteHMIContext2 = remoteHMIContext = entryPoint == null ? null : entryPoint.getCurrentContext();
        if (remoteHMIContext == null) {
            this.val$log.log(-1601830656, "RightDrawerHandler#indicateCommand: currentEntryPoint or currentContext is null");
            return;
        }
        if (remoteHMIContext.getContextName().equals("top_wizard") && entryPoint.getEntryPointId() == 1) {
            RightDrawerHandler.access$000(this.this$0).setRightDrawerTypes(commands$RightDrawerPayload);
        }
    }
}

