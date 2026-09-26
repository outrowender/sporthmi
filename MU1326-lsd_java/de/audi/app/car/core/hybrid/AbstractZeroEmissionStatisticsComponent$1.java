/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.AbstractZeroEmissionStatisticsComponent;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class AbstractZeroEmissionStatisticsComponent$1
implements TimerListener {
    private long intervalTimeCounter;
    private final /* synthetic */ AbstractZeroEmissionStatisticsComponent this$0;

    AbstractZeroEmissionStatisticsComponent$1(AbstractZeroEmissionStatisticsComponent abstractZeroEmissionStatisticsComponent) {
        this.this$0 = abstractZeroEmissionStatisticsComponent;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(AbstractZeroEmissionStatisticsComponent.access$400(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                this.intervalTimeCounter += 0;
                if (AbstractZeroEmissionStatisticsComponent.access$500(this.this$0)) {
                    double d2 = this.this$0.currentZeroEmissionInterval.getZeroEmissionValue() + 1000.0;
                    AbstractZeroEmissionStatisticsComponent.access$600(this.this$0, d2);
                }
                if (0 <= this.intervalTimeCounter) {
                    AbstractZeroEmissionStatisticsComponent.access$700(this.this$0);
                    this.intervalTimeCounter = 0L;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void cancelTimer(Timer timer) {
        if (timer.equals(AbstractZeroEmissionStatisticsComponent.access$400(this.this$0))) {
            Object object = this.this$0.mutex;
            synchronized (object) {
                this.intervalTimeCounter = 0L;
            }
        }
    }
}

