/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.LeftDrawerHandler;
import de.audi.remotehmi.ui.mib2.Commands$LeftDrawerIconUpdatePayload;
import de.audi.remotehmi.util.LogAppender;
import de.audi.remotehmi.util.LogAppender$Factory;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;

class LeftDrawerHandler$3
extends AbstractCommandHandler {
    private final /* synthetic */ LeftDrawerHandler this$0;

    LeftDrawerHandler$3(LeftDrawerHandler leftDrawerHandler, String string) {
        this.this$0 = leftDrawerHandler;
        super(string);
    }

    @Override
    protected LogAppender getParamsForDebugging(Object object) {
        return LogAppender$Factory.fromString(((Commands$LeftDrawerIconUpdatePayload)object).getContextName());
    }

    @Override
    public void indicateCommand(int n, Object object) {
        Commands$LeftDrawerIconUpdatePayload commands$LeftDrawerIconUpdatePayload = (Commands$LeftDrawerIconUpdatePayload)object;
        this.this$0.updateListModelEntry(commands$LeftDrawerIconUpdatePayload.getDrawerEntry(), commands$LeftDrawerIconUpdatePayload.getUpdateType(), commands$LeftDrawerIconUpdatePayload.getContextName());
    }
}

