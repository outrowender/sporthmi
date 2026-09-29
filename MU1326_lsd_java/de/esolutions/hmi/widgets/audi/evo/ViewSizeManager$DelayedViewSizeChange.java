/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.ViewSizeManager;

class ViewSizeManager$DelayedViewSizeChange
implements Runnable {
    private int desiredViewSize;
    private final /* synthetic */ ViewSizeManager this$0;

    public ViewSizeManager$DelayedViewSizeChange(ViewSizeManager viewSizeManager, int n) {
        this.this$0 = viewSizeManager;
        this.desiredViewSize = n;
    }

    @Override
    public void run() {
        IWidgetLogChannel.logViewSize.log(-2137614336, "DelayedViewSizeChange#run Requesting stage %1", (long)this.desiredViewSize);
        if (this.desiredViewSize == 2) {
            this.this$0.requestViewSizeChange(this.desiredViewSize);
        } else if (this.desiredViewSize == 1 && ViewSizeManager.access$000(this.this$0) == 0) {
            this.this$0.requestViewSizeChange(this.desiredViewSize);
        } else {
            IWidgetLogChannel.logViewSize.log(-2137614336, "DelayedViewSizeChange#run Requesting stage %1, but new reasons appeared in the meantime.", (long)this.desiredViewSize);
        }
        ViewSizeManager.access$102(this.this$0, null);
    }

    static /* synthetic */ int access$400(ViewSizeManager$DelayedViewSizeChange viewSizeManager$DelayedViewSizeChange) {
        return viewSizeManager$DelayedViewSizeChange.desiredViewSize;
    }
}

