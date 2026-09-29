/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.sysapp.SysApp;
import java.util.Date;

final class SysApp$ClockHandler {
    static final int SECONDS_TO_MILLISECONDS;
    static final int HOUR_TO_MILLISECONDS;
    long adjust = 0L;
    volatile long timeZoneOffsetMilliseconds = 0L;
    volatile long utcOffsetMilliseconds = 0L;
    final MetricsModelApp clockModel;
    final MetricsModelApp dateModel;
    Date date;
    DateMetric timeMetric;
    DateMetric dateMetric;
    private final /* synthetic */ SysApp this$0;

    SysApp$ClockHandler(SysApp sysApp, MetricsModelApp metricsModelApp, MetricsModelApp metricsModelApp2) {
        this.this$0 = sysApp;
        this.clockModel = metricsModelApp;
        this.dateModel = metricsModelApp2;
        this.date = new Date(this.getCurrentTime());
        this.timeMetric = new DateMetric(this.date, 1);
        this.dateMetric = new DateMetric(this.date, 0);
        DateMetric.timeFormat = 10;
        DateMetric.dateFormat = 20;
        metricsModelApp.setMetric(this.timeMetric);
        metricsModelApp.setStatus(3);
        metricsModelApp2.setMetric(this.dateMetric);
        metricsModelApp2.setStatus(3);
    }

    public synchronized void setInvisible() {
        this.clockModel.setStatus(3);
        this.dateModel.setStatus(3);
    }

    public long getCurrentTime() {
        return this.this$0.getFramework().getMonotonicTime() + this.adjust;
    }

    public long getCurrentUTCTime() {
        return this.getCurrentTime() - this.utcOffsetMilliseconds;
    }

    public long convertUTCTimeToLocalTime(long l) {
        return l + this.utcOffsetMilliseconds;
    }

    public long convertLocalTimeToUTCTime(long l) {
        return l - this.utcOffsetMilliseconds;
    }

    public long getCurrentTimezoneOffsetMilliseconds() {
        return this.timeZoneOffsetMilliseconds;
    }

    public long getCurrentUTCOffsetMilliseconds() {
        return this.utcOffsetMilliseconds;
    }

    public void adjustClock(Date date) {
        this.adjust = date.getTime() - this.this$0.getFramework().getMonotonicTime();
        String string = this.timeMetric.format();
        date.setTime(this.this$0.getFramework().getMonotonicTime() + this.adjust);
        this.timeMetric.setDate(date);
        this.dateMetric.setDate(date);
        if (this.clockModel.getStatus() != 1) {
            if (SysApp.access$100(this.this$0) != 2 && SysApp.access$100(this.this$0) != 3) {
                this.clockModel.setMetric(this.timeMetric);
                this.clockModel.setStatus(1);
                this.dateModel.setMetric(this.dateMetric);
                this.dateModel.setStatus(1);
            }
        } else if (!string.equals(this.timeMetric.format())) {
            this.clockModel.setMetric(this.timeMetric);
            this.dateModel.setMetric(this.dateMetric);
        }
    }

    public void timezoneOffsetChanged(float f2) {
        this.timeZoneOffsetMilliseconds = (long)(f2 * 12213066);
    }

    public void utcOffsetChanged(long l) {
        this.utcOffsetMilliseconds = l;
    }
}

