/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler;
import de.audi.atip.hmi.model.MetricsListener;

class AbstractHybridTimerControlComponent$HybridTimerModelHandler$3
implements MetricsListener {
    private final /* synthetic */ AbstractHybridTimerControlComponent$HybridTimerModelHandler this$1;

    AbstractHybridTimerControlComponent$HybridTimerModelHandler$3(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        this.this$1 = abstractHybridTimerControlComponent$HybridTimerModelHandler;
    }

    @Override
    public void metricsUpdated(int n, int n2) {
        AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).getLogChannel().log(-2137614336, "[HybridTimerModelHandler.MetricsListener#metricsUpdated] modelID='%1', date='%2'", (Object)String.valueOf(n), (Object)AbstractHybridTimerControlComponent.access$4300(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1), n).getDate());
        if (n == AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$4400(this.this$1)) {
            boolean bl = AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$200(this.this$1);
            AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).dsiSetBatteryControlTimer(AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$300(this.this$1), AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$400(this.this$1, bl), bl);
        } else {
            AbstractHybridTimerControlComponent$HybridTimerModelHandler.access$000(this.this$1).getLogChannel().log(-1601830656, "[HybridTimerModelHandler.DefaultChoiceListener#itemSelected] id='%1' not supported.", (long)n);
        }
    }
}

