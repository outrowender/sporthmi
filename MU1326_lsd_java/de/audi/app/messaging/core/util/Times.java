/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.metrics.DateMetric;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class Times {
    public static final int TIMESTAMP_TODAY = 0;
    public static final int TIMESTAMP_THIS_YEAR = 1;
    public static final int TIMESTAMP_NOT_THIS_YEAR = 2;

    public static long getCurrentTime(IFrameworkAccess iFrameworkAccess) {
        return iFrameworkAccess.getKombiTime();
    }

    public static boolean isTimeStampValid(long l) {
        return l != 0L;
    }

    public static String formatMsgTimeStamp(long l, long l2) {
        String string = "";
        if (Times.isTimeStampValid(l)) {
            boolean bl = Times.getTimestampCategory(l, l2) == 0;
            return bl ? Times.formatTime(l) : Times.formatDate(l);
        }
        return string;
    }

    public static int getTimestampCategory(long l, long l2) {
        boolean bl;
        int n = 0;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(l2);
        int n2 = gregorianCalendar.get(1);
        int n3 = gregorianCalendar.get(2);
        int n4 = gregorianCalendar.get(5);
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(n2, 0, 1, 0, 0, 0);
        GregorianCalendar gregorianCalendar3 = new GregorianCalendar(n2 + 1, 0, 1, 0, 0, 0);
        GregorianCalendar gregorianCalendar4 = new GregorianCalendar(n2, n3, n4, 0, 0, 0);
        GregorianCalendar gregorianCalendar5 = new GregorianCalendar(n2, n3, n4, 0, 0, 0);
        ((Calendar)gregorianCalendar5).add(5, 1);
        GregorianCalendar gregorianCalendar6 = new GregorianCalendar();
        gregorianCalendar6.setTimeInMillis(l);
        boolean bl2 = gregorianCalendar6.before(gregorianCalendar2);
        boolean bl3 = gregorianCalendar6.before(gregorianCalendar4);
        boolean bl4 = !gregorianCalendar6.before(gregorianCalendar3);
        boolean bl5 = bl = !gregorianCalendar6.before(gregorianCalendar5);
        if (bl2 || bl4) {
            n = 2;
        } else if (bl3 || bl) {
            n = 1;
        }
        return n;
    }

    public static String formatDate(long l) {
        String string = "";
        if (Times.isTimeStampValid(l)) {
            return new DateMetric(new Date(l), 0).format();
        }
        return string;
    }

    public static String formatTime(long l) {
        String string = "";
        if (Times.isTimeStampValid(l)) {
            return new DateMetric(new Date(l), 1).format();
        }
        return string;
    }
}

