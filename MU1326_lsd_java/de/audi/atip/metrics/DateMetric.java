/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.metrics;

import de.audi.atip.hmi.combi.ddp2.CombiSignConverter;
import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateMetric
extends AbstractMetrics {
    public static final int DECORATION_24 = 0;
    public static final int DECORATION_AM = 1;
    public static final int DECORATION_PM = 2;
    public static final int TYPE_DATE = 0;
    public static final int TYPE_TIME = 1;
    public static final int TYPE_DATE_AND_TIME = 2;
    public static final int TYPE_DURATION = 3;
    public static final int TYPE_DATE_AND_TIME_LONG = 4;
    public static final int TYPE_DURATION_HOUR_MIN = 5;
    public static final int TYPE_TIME_LONG = 6;
    public static final int TYPE_DURATION_TRAFFIC_OFFSET = 7;
    public static final int TYPE_DAY_OF_WEEK = 8;
    public static final int TYPE_DATE_DAY_AND_MONTH = 9;
    public static final int TYPE_SECONDS_ONLY = 10;
    public static final int TYPE_DURATION_HOUR_MIN_0 = 11;
    public static final int TYPE_DATE_AND_TIME_SHORT = 12;
    public static final int TYPE_DATE_SHORT = 13;
    public static final int TYPE_DURATION_LONG = 14;
    public static final int TYPE_DURATION_HOUR_ONLY = 15;
    public static final int TYPE_DURATION_MINUTE_ONLY = 16;
    public static final int TYPE_DURATION_IN_MINUTES = 17;
    public static final int TYPE_DATE_AND_TIME_SHORTYEAR = 21;
    public static final int TYPE_DURATION_DAYS_ONLY = 18;
    public static final int TYPE_DURATION_DAYS_HOUR_MIN_0 = 19;
    public static final int TYPE_DURATION_DAYS_HOUR_MIN = 20;
    public static final int TYPE_DURATION_WITHOUT_APPEND_ZERO_HOUR = 22;
    public static final int TYPE_DURATION_DELAY_ON_ROUTE = 23;
    public static final int TYPE_DURATION_TRAFFIC_OFFSET0 = 24;
    public static final int TYPE_DURATION_WITH_UNIT = 25;
    public static final int TYPE_COUNT = 26;
    public static final int FORMAT_TIME_24 = 10;
    public static final int FORMAT_TIME_AM_PM = 11;
    public static final int FORMAT_DATE_DAYS_FIRST = 20;
    public static final int FORMAT_DATE_DAYS_FIRST_WEEKDAY_SHORT = 21;
    public static final int FORMAT_DATE_DAYS_FIRST_WEEKDAY_FULL = 22;
    public static final int FORMAT_DATE_MONTH_FIRST = 23;
    public static final int FORMAT_DATE_MONTH_FIRST_WEEKDAY_SHORT = 24;
    public static final int FORMAT_DATE_MONTH_FIRST_WEEKDAY_FULL = 25;
    public static final int FORMAT_DATE_YEARS_FIRST = 26;
    public static final int FORMAT_DATE_YEARS_FIRST_WEEKDAY_SHORT = 27;
    public static final int FORMAT_DATE_YEARS_FIRST_WEEKDAY_FULL = 28;
    public static final int UNIT_AMPM = 0;
    public static final int UNIT_NO_AMPM = 1;
    public static final int UNIT_AMPM_ONLY = 2;
    public static int timeFormat = 10;
    public static int dateFormat = 20;
    private static final String TEXT_DATE_PM = " PM";
    private static final String TEXT_DATE_AM = " AM";
    private static final String TEXT_UNIT_DAYS = " d";
    private static final String TEXT_UNIT_MINUTES = " min";
    private static final String TEXT_UNIT_HOURS = " h";
    private static final String TEXT_UNIT_SECONDS = "s";
    private static final String TEXT_SEPARATOR_SLASH = "/";
    private static final String TEXT_SEPARATOR_MINUS = "-";
    public static final String TEXT_TIME_NOT_APPLICABLE = "--:--";
    private Calendar cal;
    private Date date;
    private Buffer sb;
    private int type;
    private long[] hoursAndMinutesAndSeconds;

    public DateMetric(Date date, int n) throws IllegalArgumentException {
        super(-1.0f, -1);
        if (date == null) {
            throw new IllegalArgumentException("Given Date object is null!");
        }
        if (n < 0 || n >= 26) {
            throw new IllegalArgumentException("Type [" + n + "] is not valid!");
        }
        if (!(n != 0 && n != 2 && n != 4 && n != 12 && n != 21 || dateFormat >= 20 && dateFormat <= 28)) {
            throw new IllegalArgumentException("Date format [" + dateFormat + "] is not valid!");
        }
        if (!(n != 1 && n != 2 && n != 4 && n != 6 && n != 12 || timeFormat >= 10 && timeFormat <= 11)) {
            throw new IllegalArgumentException("Time format [" + timeFormat + "] is not valid!");
        }
        this.date = date;
        this.type = n;
        this.initCalendar();
        this.hoursAndMinutesAndSeconds = new long[3];
        this.validateMetric();
    }

    private final void validateMetric() {
        this.isMetricValid = this.date.getTime() >= 0L;
    }

    public void setValue(float f2) {
        throw new UnsupportedOperationException("setValue(float) unsupported for DateMetric! Use setDate(long)");
    }

    public float getValue() {
        return this.date.getTime();
    }

    public float getValue(int n) {
        return this.getValue();
    }

    public void setDate(Date date) {
        this.date = date;
        this.validateMetric();
        this.initCalendar();
    }

    public void setDate(long l) {
        this.date.setTime(l);
        this.validateMetric();
        this.initCalendar();
    }

    public void setDateValid(boolean bl) {
        this.setMetricValid(bl);
    }

    public Date getDate() {
        return this.date;
    }

    public int getType() {
        return this.type;
    }

    public int getDayOfWeek() {
        if (this.cal != null) {
            return this.cal.get(7);
        }
        return -1;
    }

    public int getDecoration() {
        if (timeFormat == 10) {
            return 0;
        }
        if (this.cal.get(9) == 0) {
            return 1;
        }
        return 2;
    }

    public int getDateFormat() {
        return dateFormat;
    }

    public int getTimeFormat() {
        return timeFormat;
    }

    public String format() {
        return this.format(0);
    }

    public String format(int n) {
        return this.format(n, 0);
    }

    public String format(int n, boolean bl) {
        if (bl) {
            return this.format(n);
        }
        return this.format(n, timeFormat, 0, bl);
    }

    public String format(int n, int n2) {
        return this.format(n, timeFormat, n2, true);
    }

    public String format(int n, int n2, int n3) {
        return this.format(n, n2, n3, true);
    }

    public String format(int n, int n2, int n3, boolean bl) {
        this.initBuffer();
        switch (this.type) {
            case 3: {
                this.appendDuration();
                break;
            }
            case 25: {
                this.appendDurationWithUnit();
                break;
            }
            case 14: {
                this.appendDurationLong();
                break;
            }
            case 7: 
            case 24: {
                this.appendDurationTrafficOffset(n3, this.type == 24);
                break;
            }
            case 1: 
            case 6: {
                this.appendTime(n, n2, n3);
                break;
            }
            case 0: {
                this.appendDate(true, false, bl);
                break;
            }
            case 9: {
                this.appendDate(false, false, bl);
                break;
            }
            case 12: {
                this.appendDate(false, false, bl);
                this.sb.append(DateMetric.getText(25));
                this.appendTime(n, n2, n3);
                break;
            }
            case 21: {
                this.appendDate(true, true, bl);
                this.sb.append(DateMetric.getText(25));
                this.appendTime(n, n2, n3);
                break;
            }
            case 13: {
                this.appendDate(true, true, bl);
                break;
            }
            case 2: 
            case 4: {
                this.appendDate(true, false, bl);
                this.sb.append(DateMetric.getText(25));
                this.appendTime(n, n2, n3);
                break;
            }
            case 5: 
            case 11: {
                this.appendDurationHourMin(n3);
                break;
            }
            case 19: 
            case 20: {
                this.appendDurationDayHourMin(n3);
                break;
            }
            case 10: {
                this.appendSecondsOnly(n3);
                break;
            }
            case 17: {
                this.appendDurationInMinutes(n3);
                break;
            }
            case 22: {
                this.appendDurationWithoutAppendZeroHour(n3);
                break;
            }
            case 23: {
                this.appendDurationDelayOnRoute(n3);
                break;
            }
        }
        return this.isMetricvalid() ? this.sb.toString() : this.getInvalidText();
    }

    private void appendDate(boolean bl, boolean bl2, boolean bl3) {
        if (bl3) {
            this.appendDateLTR(bl, bl2);
        } else {
            this.appendDateRTL(bl, bl2);
        }
    }

    private void appendDateRTL(boolean bl, boolean bl2) {
        int n = this.cal.get(5);
        int n2 = this.cal.get(2) + 1;
        int n3 = this.cal.get(1);
        if (dateFormat == 20 || dateFormat == 22 || dateFormat == 21) {
            if (bl) {
                if (bl2) {
                    this.sb.append(Integer.toString(n3).substring(2));
                } else {
                    this.sb.append(n3);
                }
                this.sb.append(DateMetric.getText(24));
            }
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
            this.sb.append(DateMetric.getText(24));
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
        } else if (dateFormat == 23 || dateFormat == 24 || dateFormat == 25) {
            if (bl) {
                if (bl2) {
                    this.sb.append(Integer.toString(n3).substring(2));
                } else {
                    this.sb.append(n3);
                }
                this.sb.append(DateMetric.getText(23));
            }
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
            this.sb.append(DateMetric.getText(23));
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
        } else {
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
            this.sb.append(DateMetric.getText(22));
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
            if (bl) {
                this.sb.append(DateMetric.getText(22));
                if (bl2) {
                    this.sb.append(Integer.toString(n3).substring(2));
                } else {
                    this.sb.append(n3);
                }
            }
        }
    }

    private void appendDateLTR(boolean bl, boolean bl2) {
        int n = this.cal.get(5);
        int n2 = this.cal.get(2) + 1;
        int n3 = this.cal.get(1);
        if (dateFormat == 20 || dateFormat == 22 || dateFormat == 21) {
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
            this.sb.append(DateMetric.getText(24));
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
            if (bl) {
                this.sb.append(DateMetric.getText(24));
                if (bl2) {
                    this.sb.append(Integer.toString(n3).substring(2));
                } else {
                    this.sb.append(n3);
                }
            }
        } else if (dateFormat == 23 || dateFormat == 24 || dateFormat == 25) {
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
            this.sb.append(DateMetric.getText(23));
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
            if (bl) {
                this.sb.append(DateMetric.getText(23));
                if (bl2) {
                    this.sb.append(Integer.toString(n3).substring(2));
                } else {
                    this.sb.append(n3);
                }
            }
        } else {
            if (bl) {
                if (bl2) {
                    this.sb.append(Integer.toString(n3).substring(2));
                } else {
                    this.sb.append(n3);
                }
                this.sb.append(DateMetric.getText(22));
            }
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
            this.sb.append(DateMetric.getText(22));
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
        }
    }

    private void appendTime(int n, int n2, int n3) {
        if (n2 == 11 && this.isMetricValid) {
            this.appendTimeAMPM(n, n3);
        } else {
            this.appendTime24();
        }
    }

    private void appendTime(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n, int n2, int n3) {
        if (n2 == 11 && this.isMetricValid) {
            this.appendTimeAMPM(stringBuffer, stringBuffer2, n, n3);
        } else {
            this.appendTime24(stringBuffer, stringBuffer2);
        }
    }

    private void appendTime24() {
        if (this.isDateValid()) {
            int n = this.cal.get(11);
            int n2 = this.cal.get(12);
            this.sb.append(n);
            this.sb.append(DateMetric.getText(21));
            if (n2 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n2);
            this.appendSeconds();
        } else {
            this.sb.append(TEXT_TIME_NOT_APPLICABLE);
        }
    }

    private void appendTime24(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        if (this.isMetricValid) {
            int n = this.cal.get(11);
            int n2 = this.cal.get(12);
            stringBuffer.append(n);
            stringBuffer.append(DateMetric.getText(21));
            if (n2 < 10) {
                stringBuffer.append(0);
            }
            stringBuffer.append(n2);
            this.appendSeconds(stringBuffer, stringBuffer2);
        } else {
            stringBuffer.append(TEXT_TIME_NOT_APPLICABLE);
        }
    }

    private void appendTimeAMPM(int n, int n2) {
        if (n != 2) {
            int n3 = this.cal.get(12);
            int n4 = this.cal.get(10);
            if (n4 == 0) {
                n4 = 12;
            }
            this.sb.append(n4);
            this.sb.append(DateMetric.getText(20));
            if (n3 < 10) {
                this.sb.append(0);
            }
            this.sb.append(n3);
            this.appendSeconds();
        }
        if (n == 0 || n == 2) {
            if (this.cal.get(9) == 0) {
                if (n2 == 1) {
                    this.sb.append(CombiSignConverter.convertSign(14));
                } else {
                    this.sb.append(this.getText(18, n2));
                }
            } else if (n2 == 1) {
                this.sb.append(CombiSignConverter.convertSign(15));
            } else {
                this.sb.append(this.getText(19, n2));
            }
        }
    }

    private void appendTimeAMPM(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n, int n2) {
        if (n != 2) {
            int n3 = this.cal.get(12);
            int n4 = this.cal.get(10);
            if (n4 == 0) {
                n4 = 12;
            }
            stringBuffer.append(n4);
            stringBuffer.append(DateMetric.getText(20));
            if (n3 < 10) {
                stringBuffer.append(0);
            }
            stringBuffer.append(n3);
            this.appendSeconds(stringBuffer, stringBuffer2);
        }
        if (n == 0 || n == 2) {
            if (this.cal.get(9) == 0) {
                stringBuffer2.append(n2 == 1 ? CombiSignConverter.convertSign(14) : DateMetric.getText(18));
            } else {
                stringBuffer2.append(n2 == 1 ? CombiSignConverter.convertSign(15) : DateMetric.getText(19));
            }
        }
    }

    private void appendSeconds() {
        if (this.type == 4 || this.type == 6) {
            this.sb.append(DateMetric.getText(17));
            int n = this.cal.get(13);
            if (n < 10) {
                this.sb.append(0);
            }
            this.sb.append(n);
        }
    }

    private void appendSeconds(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        if (this.type == 4 || this.type == 6) {
            stringBuffer.append(DateMetric.getText(17));
            int n = this.cal.get(13);
            if (n < 10) {
                stringBuffer.append(0);
            }
            stringBuffer.append(n);
        }
    }

    private void appendSecondsOnly(int n) {
        long l = this.cal.getTimeInMillis();
        long l2 = l / 1000L;
        long l3 = (l - l2 * 1000L) / 100L;
        this.sb.append(l2);
        this.sb.append(this.getText(68, n));
        this.sb.append(l3);
        this.sb.append(this.getText(69, n));
    }

    private void appendDurationWithoutAppendZeroHour(int n) {
        this.getHoursAndMinutes(this.getTotalMinutes());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        this.sb.append(l);
        this.sb.append(this.getText(16, n));
        if (l2 < 10L) {
            this.sb.append(0);
        }
        this.sb.append(l2);
        this.sb.append(this.getText(15, n));
    }

    private void appendDurationWithoutAppendZeroHour(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n) {
        this.getHoursAndMinutes(this.getTotalMinutes());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        stringBuffer.append(l);
        stringBuffer.append(this.getText(16, n));
        if (l2 < 10L) {
            stringBuffer.append(0);
        }
        stringBuffer.append(l2);
        stringBuffer2.append(this.getText(15, n));
    }

    private void appendDurationDelayOnRoute(int n) {
        long l = this.getRoundedUpMinutesForDelayOnRoute();
        if (l > 90L) {
            this.sb.append("> 90 ");
        } else {
            this.sb.append("+ ");
            this.sb.append(l);
            this.sb.append(" ");
        }
        this.sb.append(this.getText(14, n));
    }

    private void appendDurationDelayOnRoute(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n) {
        long l = this.getRoundedUpMinutesForDelayOnRoute();
        if (l > 90L) {
            stringBuffer.append("> 90 ");
        } else {
            stringBuffer.append("+ ");
            stringBuffer.append(l);
            stringBuffer.append(' ');
        }
        stringBuffer2.append(this.getText(14, n));
    }

    private void appendDuration() {
        this.getHoursAndMinutes(this.getTotalMinutes());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        if (l < 10L) {
            this.sb.append(0);
        }
        this.sb.append(l);
        this.sb.append(DateMetric.getText(16));
        if (l2 < 10L) {
            this.sb.append(0);
        }
        this.sb.append(l2);
    }

    private void appendDurationWithUnit() {
        this.getHoursAndMinutes(this.getTotalMinutes());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        if (l < 1L) {
            this.sb.append(l2);
            this.sb.append(DateMetric.getText(14));
        } else {
            this.sb.append(l);
            this.sb.append(DateMetric.getText(16));
            if (l2 < 10L) {
                this.sb.append(0);
            }
            this.sb.append(l2);
            this.sb.append(DateMetric.getText(96));
        }
    }

    private void appendDurationLong() {
        this.getHoursAndMinutesandSeconds(this.getTotalSeconds());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        long l3 = this.hoursAndMinutesAndSeconds[2];
        if (l < 10L) {
            this.sb.append(0);
        }
        this.sb.append(l);
        this.sb.append(DateMetric.getText(16));
        if (l2 < 10L) {
            this.sb.append(0);
        }
        this.sb.append(l2);
        this.sb.append(DateMetric.getText(17));
        if (l3 < 10L) {
            this.sb.append(0);
        }
        this.sb.append(l3);
    }

    private void appendDurationHourMin(int n, long l, long l2) {
        if (l > 0L) {
            this.sb.append(l);
            this.sb.append(this.getText(15, n));
        }
        if (l2 > 0L) {
            if (l > 0L) {
                this.sb.append(this.getText(13, n));
            }
            this.sb.append(l2);
            this.sb.append(this.getText(14, n));
        }
    }

    private void appendDurationDayHourMin(int n, long l, long l2, long l3) {
        if (l > 0L) {
            this.sb.append(l);
            this.sb.append(this.getText(94, n));
        }
        if (l > 0L || l2 > 0L) {
            if (l > 0L) {
                this.sb.append(this.getText(95, n));
            }
            this.sb.append(l2);
            this.sb.append(this.getText(15, n));
        }
        if (l3 >= 0L) {
            if (l2 > 0L || l > 0L) {
                this.sb.append(this.getText(13, n));
            }
            this.sb.append(l3);
            this.sb.append(this.getText(14, n));
        }
    }

    private void appendDurationHourMin(int n) {
        this.getHoursAndMinutes(this.getTotalMinutes());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        if (this.type == 5 || l > 0L || l2 >= 1L) {
            this.appendDurationHourMin(n, l, l2);
        } else if (this.type == 11) {
            this.appendDurationBelow1Min(n);
        }
    }

    private void appendDurationDayHourMin(int n) {
        this.getDaysHoursAndMinutes(this.getTotalMinutes());
        long l = this.hoursAndMinutesAndSeconds[0];
        long l2 = this.hoursAndMinutesAndSeconds[1];
        long l3 = this.hoursAndMinutesAndSeconds[2];
        if (this.type == 20 || l > 0L || l2 > 0L || l3 >= 1L) {
            this.appendDurationDayHourMin(n, l, l2, l3);
        } else if (this.type == 19) {
            this.appendDurationBelow1Min(n);
        }
    }

    private void appendDurationBelow1Min(int n) {
        if (!this.isMetricValid) {
            this.sb.append(TEXT_TIME_NOT_APPLICABLE);
        } else {
            this.sb.append(0);
            this.sb.append(this.getText(14, n));
        }
    }

    private void appendDurationTrafficOffset(int n, boolean bl) {
        long l = this.getTotalMinutes();
        this.getHoursAndMinutes(l);
        long l2 = this.hoursAndMinutesAndSeconds[0];
        long l3 = this.hoursAndMinutesAndSeconds[1];
        if (l < 1L && !bl) {
            this.sb.append("--");
            this.sb.append(this.getText(14, n));
        } else if (l < 60L) {
            this.sb.append(l);
            this.sb.append(this.getText(14, n));
        } else if (l < 600L) {
            this.sb.append(l2);
            this.sb.append(this.getText(16, n));
            if (l3 < 10L) {
                this.sb.append(0);
            }
            this.sb.append(l3);
            this.sb.append(this.getText(15, n));
        } else if (l < 5940L) {
            this.sb.append("> 10");
            this.sb.append(this.getText(15, n));
        } else {
            this.sb.append("> 99");
            this.sb.append(this.getText(15, n));
        }
    }

    private void appendDurationTrafficOffset(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n, boolean bl) {
        long l = this.getTotalMinutes();
        this.getHoursAndMinutes(l);
        long l2 = this.hoursAndMinutesAndSeconds[0];
        long l3 = this.hoursAndMinutesAndSeconds[1];
        if (l < 1L && !bl) {
            stringBuffer.append("--");
            stringBuffer2.append(this.getText(14, n));
        } else if (l < 60L) {
            stringBuffer.append(l);
            stringBuffer2.append(this.getText(14, n));
        } else if (l < 600L) {
            stringBuffer.append(l2);
            stringBuffer.append(this.getText(16, n));
            if (l3 < 10L) {
                stringBuffer.append(0);
            }
            stringBuffer.append(l3);
            stringBuffer2.append(this.getText(15, n));
        } else if (l < 5940L) {
            stringBuffer.append("> 10");
            stringBuffer2.append(this.getText(15, n));
        } else {
            stringBuffer.append("> 99");
            stringBuffer2.append(this.getText(15, n));
        }
    }

    private void appendDurationInMinutes(int n) {
        long l = this.getTotalMinutes();
        if (l >= 1L) {
            this.sb.append(l);
            this.sb.append(this.getText(14, n));
        }
    }

    private void appendDurationInMinutes(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n) {
        long l = this.getTotalMinutes();
        if (l >= 1L) {
            stringBuffer.append(l);
            stringBuffer2.append(this.getText(14, n));
        }
    }

    private long getTotalMinutes() {
        return this.date.getTime() / 60000L;
    }

    private long getTotalSeconds() {
        return this.date.getTime() / 1000L;
    }

    private long getTotalDays() {
        return this.date.getTime() / 86400000L;
    }

    private long getRoundedUpMinutesForDelayOnRoute() {
        long l = this.getTotalMinutes();
        long l2 = this.getTotalSeconds();
        return l2 % 60L == 0L ? l : l + 1L;
    }

    private void getHoursAndMinutes(long l) {
        long l2;
        this.hoursAndMinutesAndSeconds[0] = l2 = l / 60L;
        this.hoursAndMinutesAndSeconds[1] = l - l2 * 60L;
    }

    private void getDaysHoursAndMinutes(long l) {
        long l2 = l / 60L / 24L;
        long l3 = (l - l2 * 60L * 24L) / 60L;
        this.hoursAndMinutesAndSeconds[0] = l2;
        this.hoursAndMinutesAndSeconds[1] = l3;
        this.hoursAndMinutesAndSeconds[2] = l - l2 * 60L * 24L - l3 * 60L;
    }

    private void getHoursAndMinutesandSeconds(long l) {
        long l2 = l / 3600L;
        long l3 = (l - l2 * 3600L) / 60L;
        this.hoursAndMinutesAndSeconds[0] = l2;
        this.hoursAndMinutesAndSeconds[1] = l3;
        this.hoursAndMinutesAndSeconds[2] = l - l2 * 3600L - l3 * 60L;
    }

    private void initBuffer() {
        this.sb = new Buffer(40);
    }

    private void initCalendar() {
        if (this.cal == null) {
            this.cal = GregorianCalendar.getInstance();
        }
        this.cal.setTime(this.date);
    }

    public boolean isDateValid() {
        return this.isMetricValid;
    }

    public String toString() {
        return "DateMetric(" + this.cal + "," + this.date + "," + this.type + "," + this.sb + ")";
    }

    public String getTextClusterMIB2(int n) {
        Buffer buffer = new Buffer();
        switch (n) {
            case 18: {
                buffer.append("|").append(DateMetric.getText(18).trim()).append("|");
                break;
            }
            case 19: {
                buffer.append("|").append("|").append(DateMetric.getText(19).trim());
                break;
            }
            case 15: {
                buffer.append("|").append(DateMetric.getText(15).trim());
                break;
            }
            case 14: {
                buffer.append("|").append(DateMetric.getText(14).trim());
                break;
            }
            case 69: {
                buffer.append("|").append(DateMetric.getText(69).trim());
                break;
            }
            default: {
                buffer.append(DateMetric.getText(n));
            }
        }
        return buffer.toString();
    }

    public static String getText(int n) {
        String string = AbstractMetrics.getText(n);
        if (string == null) {
            switch (n) {
                case 25: {
                    string = " ";
                    break;
                }
                case 13: {
                    string = " ";
                    break;
                }
                case 95: {
                    string = " ";
                    break;
                }
                case 24: {
                    string = ".";
                    break;
                }
                case 23: {
                    string = TEXT_SEPARATOR_SLASH;
                    break;
                }
                case 22: {
                    string = TEXT_SEPARATOR_MINUS;
                    break;
                }
                case 21: {
                    string = ":";
                    break;
                }
                case 20: {
                    string = ":";
                    break;
                }
                case 17: {
                    string = ":";
                    break;
                }
                case 16: {
                    string = ":";
                    break;
                }
                case 18: {
                    string = TEXT_DATE_AM;
                    break;
                }
                case 19: {
                    string = TEXT_DATE_PM;
                    break;
                }
                case 15: {
                    string = TEXT_UNIT_HOURS;
                    break;
                }
                case 14: {
                    string = TEXT_UNIT_MINUTES;
                    break;
                }
                case 94: {
                    string = TEXT_UNIT_DAYS;
                    break;
                }
                case 68: {
                    string = ".";
                    break;
                }
                case 69: {
                    string = TEXT_UNIT_SECONDS;
                    break;
                }
                default: {
                    string = "";
                }
            }
        }
        return string;
    }

    public String getText(int n, int n2) {
        if (n2 == 2) {
            return this.getTextClusterMIB2(n);
        }
        return DateMetric.getText(n);
    }

    public String[] getStringValueAndUnit() {
        return this.getStringValueAndUnit(0);
    }

    public String[] getStringValueAndUnit(int n) {
        return this.getStringValueAndUnit(n, 0);
    }

    public String[] getStringValueAndUnit(int n, int n2) {
        return this.getStringValueAndUnit(n, timeFormat, n2);
    }

    public String[] getStringValueAndUnit(int n, int n2, int n3) {
        StringBuffer stringBuffer = new StringBuffer(20);
        StringBuffer stringBuffer2 = new StringBuffer(5);
        this.formatValueAndUnit(stringBuffer, stringBuffer2, n, n2, n3);
        return new String[]{this.isMetricvalid() ? stringBuffer.toString() : this.getInvalidText(), stringBuffer2.toString()};
    }

    private void formatValueAndUnit(StringBuffer stringBuffer, StringBuffer stringBuffer2, int n, int n2, int n3) {
        switch (this.type) {
            case 3: 
            case 14: {
                stringBuffer.append(this.format(0));
                stringBuffer2.append(DateMetric.getText(15));
                break;
            }
            case 15: {
                int n4 = this.cal.get(11);
                if (n4 <= 0) break;
                stringBuffer.append(n4);
                stringBuffer2.append(DateMetric.getText(15));
                break;
            }
            case 16: {
                stringBuffer.append(this.cal.get(12));
                stringBuffer2.append(DateMetric.getText(14));
                break;
            }
            case 18: {
                int n5 = (int)this.getTotalDays();
                if (n5 <= 0) break;
                stringBuffer.append(n5);
                stringBuffer2.append(DateMetric.getText(94));
                break;
            }
            case 7: 
            case 24: {
                this.appendDurationTrafficOffset(stringBuffer, stringBuffer2, n3, this.type == 24);
                break;
            }
            case 17: {
                this.appendDurationInMinutes(stringBuffer, stringBuffer2, n3);
                break;
            }
            case 23: {
                this.appendDurationDelayOnRoute(stringBuffer, stringBuffer2, n3);
                break;
            }
            case 1: 
            case 6: {
                this.appendTime(stringBuffer, stringBuffer2, n, n2, n3);
                break;
            }
            case 22: {
                this.appendDurationWithoutAppendZeroHour(stringBuffer, stringBuffer2, n3);
                break;
            }
            case 0: {
                stringBuffer.append(this.format(n, n2, n3));
                break;
            }
            case 9: {
                break;
            }
            case 2: 
            case 4: {
                break;
            }
            case 5: {
                break;
            }
        }
    }

    public String getFormattedMetricUnit() {
        return this.getFormattedUnit(0);
    }

    public String getFormattedUnit(int n) {
        if (7 == this.type || 1 == this.type || 6 == this.type || 3 == this.type || 14 == this.type) {
            StringBuffer stringBuffer = new StringBuffer(20);
            StringBuffer stringBuffer2 = new StringBuffer(5);
            this.formatValueAndUnit(stringBuffer, stringBuffer2, n, timeFormat, 0);
            return stringBuffer2.toString().trim();
        }
        if (0 == this.type) {
            return "";
        }
        return this.format(n);
    }

    public String getFormattedValue() {
        return this.getFormattedValue(0);
    }

    public String getFormattedValue(int n) {
        if (7 == this.type || 1 == this.type || 6 == this.type) {
            StringBuffer stringBuffer = new StringBuffer(20);
            StringBuffer stringBuffer2 = new StringBuffer(5);
            this.formatValueAndUnit(stringBuffer, stringBuffer2, n, timeFormat, 0);
            return stringBuffer.toString().trim();
        }
        return this.isMetricvalid() ? this.format(n) : this.getInvalidText();
    }

    public String getInvalidText() {
        return TEXT_TIME_NOT_APPLICABLE;
    }
}

