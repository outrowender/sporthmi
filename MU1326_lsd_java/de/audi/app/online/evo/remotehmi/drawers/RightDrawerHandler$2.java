/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.ui.mib2.Commands$RightDrawerStatePayload;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class RightDrawerHandler$2
extends AbstractCommandHandler {
    private final /* synthetic */ LogChannel val$log;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$2(RightDrawerHandler rightDrawerHandler, String string, LogChannel logChannel) {
        this.this$0 = rightDrawerHandler;
        this.val$log = logChannel;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$RightDrawerStatePayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        this.val$log.log(1078071040, "RightDrawerHandler#indicateCommand: Commands.STATE_UPDATE_RIGHT_DRAWER_STATE called");
        if (!(object instanceof Commands$RightDrawerStatePayload)) {
            this.val$log.log(-1601830656, "RightDrawerHandler#indicateCommand: wrong payload provided");
            return;
        }
        Commands$RightDrawerStatePayload commands$RightDrawerStatePayload = (Commands$RightDrawerStatePayload)object;
        String string = commands$RightDrawerStatePayload.entryId;
        String string2 = commands$RightDrawerStatePayload.value;
        String string3 = commands$RightDrawerStatePayload.getContextName();
        RightDrawerHandler.access$200(this.this$0, string, string2, string3);
    }
}

