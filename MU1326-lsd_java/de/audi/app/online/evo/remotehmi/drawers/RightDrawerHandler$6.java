/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class RightDrawerHandler$6
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$modelID;
    private final /* synthetic */ int val$itemID;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$6(RightDrawerHandler rightDrawerHandler, String string, LogAppender logAppender, int n, int n2) {
        this.this$0 = rightDrawerHandler;
        this.val$modelID = n;
        this.val$itemID = n2;
        super(string, logAppender);
    }

    @Override
    public void run() {
        if (this.val$modelID == 2048664320) {
            int n = this.val$itemID & 3;
            if (n == 1) {
                this.this$0.log.log(1078071040, "RightDrawerHandler#itemSelected: drawer was closed, resetting focus. For modelID=%1, itemID=%2.", (long)this.val$modelID, (long)this.val$itemID);
                RightDrawerHandler.access$502(this.this$0, null);
            } else {
                this.this$0.log.log(1078071040, "RightDrawerHandler#itemSelected: ignoring focus event=%3 for modelID=%1, itemID=%2.", (long)this.val$modelID, (long)this.val$itemID, (long)n);
            }
            return;
        }
        this.this$0.log.log(1078071040, "RightDrawerHandler#itemSelected: invoking action for modelID=%1, itemID=%2.", (long)this.val$modelID, (long)this.val$itemID);
        RightDrawerHandler.access$600(this.this$0, this.val$modelID, this.val$itemID);
    }
}

