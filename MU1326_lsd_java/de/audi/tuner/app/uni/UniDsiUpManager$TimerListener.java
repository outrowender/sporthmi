/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.uni.UniDsiUpManager;
import de.audi.tuner.app.uni.UniDsiUpManager$1;

class UniDsiUpManager$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ UniDsiUpManager this$0;

    private UniDsiUpManager$TimerListener(UniDsiUpManager uniDsiUpManager) {
        this.this$0 = uniDsiUpManager;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(UniDsiUpManager.access$200(this.this$0))) {
            Object object = UniDsiUpManager.access$300(this.this$0);
            synchronized (object) {
                UniDsiUpManager.access$400(this.this$0);
            }
        } else if (timer.equals(UniDsiUpManager.access$500(this.this$0))) {
            Object object = UniDsiUpManager.access$300(this.this$0);
            synchronized (object) {
                if (!UniDsiUpManager.access$600(this.this$0)) {
                    UniDsiUpManager.access$700(this.this$0, null);
                } else if (UniDsiUpManager.access$800(this.this$0) != null) {
                    UniDsiUpManager.access$500(this.this$0).restart();
                }
            }
        } else if (timer.equals(UniDsiUpManager.access$900(this.this$0))) {
            UniDsiUpManager.access$1000(this.this$0).reNotification(4);
        }
    }

    /* synthetic */ UniDsiUpManager$TimerListener(UniDsiUpManager uniDsiUpManager, UniDsiUpManager$1 uniDsiUpManager$1) {
        this(uniDsiUpManager);
    }
}

