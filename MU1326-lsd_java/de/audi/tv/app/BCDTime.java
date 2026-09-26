/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.metrics.DateMetric;
import de.audi.tv.app.TVUtil;
import java.util.GregorianCalendar;
import org.dsi.ifc.tvtuner.Time;

public final class BCDTime {
    public static boolean isValid(Time time) {
        return time != null && time.hour >= 0 && time.hour <= 35 && time.minute >= 0 && time.minute <= 89;
    }

    static DateMetric[] getDateMetrics(Time time, Time time2) {
        if (BCDTime.isValid(time) && BCDTime.isValid(time2)) {
            return new DateMetric[]{BCDTime.getDateMetric(time), BCDTime.getDateMetric(time2)};
        }
        return new DateMetric[0];
    }

    static DateMetric getDateMetric(Time time) {
        if (BCDTime.isValid(time)) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.clear();
            gregorianCalendar.set(11, TVUtil.singleByteBCDToDual(time.hour));
            gregorianCalendar.set(12, TVUtil.singleByteBCDToDual(time.minute));
            gregorianCalendar.set(13, TVUtil.singleByteBCDToDual(time.second));
            return new DateMetric(gregorianCalendar.getTime(), 1);
        }
        return null;
    }

    private BCDTime() {
        throw new IllegalStateException("This is a static helper class!");
    }
}

