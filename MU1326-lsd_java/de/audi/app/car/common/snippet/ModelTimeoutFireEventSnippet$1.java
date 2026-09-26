/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.snippet;

import de.audi.app.car.common.snippet.ModelTimeoutFireEventSnippet;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class ModelTimeoutFireEventSnippet$1
implements TimerListener {
    private final /* synthetic */ ModelTimeoutFireEventSnippet this$0;

    ModelTimeoutFireEventSnippet$1(ModelTimeoutFireEventSnippet modelTimeoutFireEventSnippet) {
        this.this$0 = modelTimeoutFireEventSnippet;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(ModelTimeoutFireEventSnippet.access$000(this.this$0))) {
            Object object = ModelTimeoutFireEventSnippet.access$100(this.this$0);
            synchronized (object) {
                ModelTimeoutFireEventSnippet.access$300(this.this$0).fireEvent(ModelTimeoutFireEventSnippet.access$200(this.this$0));
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

