/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent;
import de.audi.atip.hmi.model.MetricsListener;
import java.util.Date;

public class AbstractAuxheaterComponent$AuxHeaterMetricsListener
implements MetricsListener {
    private final /* synthetic */ AbstractAuxheaterComponent this$0;

    protected AbstractAuxheaterComponent$AuxHeaterMetricsListener(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        this.this$0 = abstractAuxheaterComponent;
    }

    @Override
    public void metricsUpdated(int n, int n2) {
        AbstractAuxheaterComponent.access$2100(this.this$0, "metricsUpdated", n, 0, true);
        switch (n) {
            case 600725: {
                this.setTimer(1, AbstractAuxheaterComponent.access$2200(this.this$0, n).getDate());
                break;
            }
            case 600729: {
                this.setTimer(2, AbstractAuxheaterComponent.access$2300(this.this$0, n).getDate());
                break;
            }
            case 600733: {
                this.setTimer(3, AbstractAuxheaterComponent.access$2400(this.this$0, n).getDate());
                break;
            }
            default: {
                AbstractAuxheaterComponent.access$2500(this.this$0, "metricsUpdated", n, 0, false);
            }
        }
    }

    public void setTimer(int n, Date date) {
        this.this$0.setTimer(n, date);
    }
}

