/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.remotehmi.drawers;

import de.audi.app.online.evo.remotehmi.drawers.RightDrawerHandler;
import de.audi.remotehmi.ui.mib2.grid.ICursor;
import de.audi.remotehmi.ui.mib2.grid.ICursorComponent;
import de.audi.remotehmi.util.LogAppender;
import de.audi.tghu.online.app.remotehmi.AbstractHMIViewListener;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;

class RightDrawerHandler$7
extends AbstractRemoteHMITask {
    private final /* synthetic */ int val$menuItemID;
    private final /* synthetic */ RightDrawerHandler this$0;

    RightDrawerHandler$7(RightDrawerHandler rightDrawerHandler, String string, LogAppender logAppender, int n) {
        this.this$0 = rightDrawerHandler;
        this.val$menuItemID = n;
        super(string, logAppender);
    }

    @Override
    public void run() {
        if (RightDrawerHandler.access$700(this.this$0) != null && RightDrawerHandler.access$800(this.this$0) != null) {
            int n = RightDrawerHandler.access$800(this.this$0).getIndexFromId(this.val$menuItemID);
            this.this$0.log.log(1078071040, "RightDrawerHandler#itemFocused: mainGridList not null and current focused right drawer index is '%1'", (long)n);
            ICursor iCursor = RightDrawerHandler.access$700(this.this$0).getCurrentCursor();
            ICursorComponent iCursorComponent = iCursor.getFocus();
            RightDrawerHandler.access$700(this.this$0).setCurrentFocus(iCursorComponent.withRightDrawerIndex(n));
            AbstractHMIViewListener abstractHMIViewListener = RightDrawerHandler.access$900(this.this$0).getCurrentView();
            if (abstractHMIViewListener != null) {
                abstractHMIViewListener.setNewCursor(iCursor);
            }
        }
    }
}

