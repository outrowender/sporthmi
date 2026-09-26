/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.tuner.app.amfm.FunctionWheelHandler;
import de.audi.tuner.app.amfm.FunctionWheelHandler$1;

class FunctionWheelHandler$MyRangeListener
extends DefaultRangeListener {
    private final /* synthetic */ FunctionWheelHandler this$0;

    private FunctionWheelHandler$MyRangeListener(FunctionWheelHandler functionWheelHandler) {
        this.this$0 = functionWheelHandler;
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        FunctionWheelHandler.access$500((FunctionWheelHandler)this.this$0).benchmark.log(-2137614336, "decrement %1", (long)n2);
        if (n2 != 0) {
            FunctionWheelHandler.access$600(this.this$0).abortScan();
            FunctionWheelHandler.access$700(this.this$0).restart();
            FunctionWheelHandler.access$800(this.this$0).restart();
            FunctionWheelHandler.access$902(this.this$0, FunctionWheelHandler.access$1000(this.this$0) - (long)n2);
            if (FunctionWheelHandler.access$900(this.this$0) < FunctionWheelHandler.access$1100((FunctionWheelHandler)this.this$0).lowerLimit) {
                FunctionWheelHandler.access$902(this.this$0, FunctionWheelHandler.access$1100((FunctionWheelHandler)this.this$0).upperLimit);
            }
            FunctionWheelHandler.access$1002(this.this$0, FunctionWheelHandler.access$900(this.this$0));
            FunctionWheelHandler.access$1200(this.this$0);
            FunctionWheelHandler.access$1300(this.this$0).restart();
        }
        FunctionWheelHandler.access$500((FunctionWheelHandler)this.this$0).benchmark.log(-2137614336, "decrement left");
    }

    @Override
    public void increment(int n, int n2, int n3) {
        FunctionWheelHandler.access$500((FunctionWheelHandler)this.this$0).benchmark.log(-2137614336, "increment %1", (long)n2);
        if (n2 != 0) {
            FunctionWheelHandler.access$600(this.this$0).abortScan();
            FunctionWheelHandler.access$700(this.this$0).restart();
            FunctionWheelHandler.access$800(this.this$0).restart();
            FunctionWheelHandler.access$902(this.this$0, FunctionWheelHandler.access$1000(this.this$0) + (long)n2);
            if (FunctionWheelHandler.access$900(this.this$0) > FunctionWheelHandler.access$1100((FunctionWheelHandler)this.this$0).upperLimit) {
                FunctionWheelHandler.access$902(this.this$0, FunctionWheelHandler.access$1100((FunctionWheelHandler)this.this$0).lowerLimit);
            }
            FunctionWheelHandler.access$1002(this.this$0, FunctionWheelHandler.access$900(this.this$0));
            FunctionWheelHandler.access$1200(this.this$0);
            FunctionWheelHandler.access$1300(this.this$0).restart();
        }
        FunctionWheelHandler.access$500((FunctionWheelHandler)this.this$0).benchmark.log(-2137614336, "increment left");
    }

    /* synthetic */ FunctionWheelHandler$MyRangeListener(FunctionWheelHandler functionWheelHandler, FunctionWheelHandler$1 functionWheelHandler$1) {
        this(functionWheelHandler);
    }
}

