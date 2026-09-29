/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$1;
import de.audi.atip.hmi.model.MetricsListener;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

final class AbstractAuxACComponent$AuxCoolerMetricsListener
implements MetricsListener {
    private final /* synthetic */ AbstractAuxACComponent this$0;

    private AbstractAuxACComponent$AuxCoolerMetricsListener(AbstractAuxACComponent abstractAuxACComponent) {
        this.this$0 = abstractAuxACComponent;
    }

    @Override
    public void metricsUpdated(int n, int n2) {
        AbstractAuxACComponent.access$1000(this.this$0, "metricsUpdated", n, 0, true);
        switch (n) {
            case 2100363: {
                this.setTimer(3, AbstractAuxACComponent.access$1100(this.this$0, n).getDate());
                break;
            }
            case 2100364: {
                this.setTimer(4, AbstractAuxACComponent.access$1200(this.this$0, n).getDate());
                break;
            }
            default: {
                AbstractAuxACComponent.access$1300(this.this$0, "metricsUpdated", n, 0, false);
            }
        }
    }

    private void setTimer(int n, Date date) {
        int n2;
        Calendar calendar = TimerHelper.getCorrectCalendarFromDate(date);
        switch (n) {
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                this.this$0.getLogChannel().log(-2137614336, "[AbstractAuxACComponent.AuxCoolerMetricsListener#setTimer] invalid timerID=%1", (long)n);
                return;
            }
        }
        AbstractAuxACComponent.access$500(this.this$0, n2);
        this.this$0.getLogChannel().log(1078071040, "setTimer: dsi.setBatteryControlTimer(timerID=%2, profileID=%3, date=%1)", (Object)date, (long)n, (long)n2);
        this.this$0.getDSI().setBatteryControlTimer(n, calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), new BatteryControlWeekdays(), n2);
        if (AbstractAuxACComponent.access$1400(this.this$0) != null) {
            AbstractAuxACComponent.access$1400(this.this$0).climateTimerMetricsUpdated(n);
        }
    }

    /* synthetic */ AbstractAuxACComponent$AuxCoolerMetricsListener(AbstractAuxACComponent abstractAuxACComponent, AbstractAuxACComponent$1 abstractAuxACComponent$1) {
        this(abstractAuxACComponent);
    }
}

