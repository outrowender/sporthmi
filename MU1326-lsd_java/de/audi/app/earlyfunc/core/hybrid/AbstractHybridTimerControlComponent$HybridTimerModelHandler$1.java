/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler;
import de.audi.atip.hmi.model.DefaultButtonListener;

class AbstractHybridTimerControlComponent$HybridTimerModelHandler$1
extends DefaultButtonListener {
    private final /* synthetic */ AbstractHybridTimerControlComponent$HybridTimerModelHandler this$1;

    AbstractHybridTimerControlComponent$HybridTimerModelHandler$1(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        this.this$1 = abstractHybridTimerControlComponent$HybridTimerModelHandler;
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).getLogChannel().log(-2137614336, "[HybridTimerModelHandler.DefaultButtonListener#keyReleased] modelID='%1', keyID='%2'", (long)n, (long)n2);
        if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$100(this.this$1)) {
            boolean bl = AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$200(this.this$1);
            AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).dsiSetBatteryControlTimer(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$400(this.this$1, bl), bl);
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$500(this.this$1)) {
            boolean bl;
            boolean bl2 = bl = AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$200(this.this$1);
            if (bl) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).dsiSetBatteryControlTimerType(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), 0);
            }
        } else if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$600(this.this$1)) {
            boolean bl;
            boolean bl3 = bl = AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$200(this.this$1);
            if (!bl) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).dsiSetBatteryControlTimerType(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), 1);
            }
        } else {
            AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).getLogChannel().log(-1601830656, "[HybridTimerModelHandler.DefaultButtonListener#keyReleased] ModelID='%1' not supported.", (long)n);
        }
    }
}

