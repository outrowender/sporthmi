/*
 * Decompiled with CFR 0.152.
 */
package java.text;

import com.ibm.oti.locale.Locale;
import com.ibm.oti.util.ExtendedResourceBundle;
import com.ibm.oti.util.Msg;
import java.io.InvalidObjectException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public abstract class DateFormat
extends Format {
    private static final long serialVersionUID = 7218322306649953788L;
    protected Calendar calendar;
    protected NumberFormat numberFormat;
    public static final int DEFAULT = 2;
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;
    public static final int ERA_FIELD = 0;
    public static final int YEAR_FIELD = 1;
    public static final int MONTH_FIELD = 2;
    public static final int DATE_FIELD = 3;
    public static final int HOUR_OF_DAY1_FIELD = 4;
    public static final int HOUR_OF_DAY0_FIELD = 5;
    public static final int MINUTE_FIELD = 6;
    public static final int SECOND_FIELD = 7;
    public static final int MILLISECOND_FIELD = 8;
    public static final int DAY_OF_WEEK_FIELD = 9;
    public static final int DAY_OF_YEAR_FIELD = 10;
    public static final int DAY_OF_WEEK_IN_MONTH_FIELD = 11;
    public static final int WEEK_OF_YEAR_FIELD = 12;
    public static final int WEEK_OF_MONTH_FIELD = 13;
    public static final int AM_PM_FIELD = 14;
    public static final int HOUR1_FIELD = 15;
    public static final int HOUR0_FIELD = 16;
    public static final int TIMEZONE_FIELD = 17;

    protected DateFormat() {
    }

    public Object clone() {
        DateFormat dateFormat = (DateFormat)super.clone();
        dateFormat.calendar = (Calendar)this.calendar.clone();
        dateFormat.numberFormat = (NumberFormat)this.numberFormat.clone();
        return dateFormat;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DateFormat)) {
            return false;
        }
        DateFormat dateFormat = (DateFormat)object;
        return this.numberFormat.equals(dateFormat.numberFormat) && this.calendar.getTimeZone().equals(dateFormat.calendar.getTimeZone()) && this.calendar.getFirstDayOfWeek() == dateFormat.calendar.getFirstDayOfWeek() && this.calendar.getMinimalDaysInFirstWeek() == dateFormat.calendar.getMinimalDaysInFirstWeek() && this.calendar.isLenient() == dateFormat.calendar.isLenient();
    }

    public final StringBuffer format(Object object, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (object instanceof Date) {
            return this.format((Date)object, stringBuffer, fieldPosition);
        }
        if (object instanceof Number) {
            return this.format(new Date(((Number)object).longValue()), stringBuffer, fieldPosition);
        }
        throw new IllegalArgumentException();
    }

    public final String format(Date date) {
        return this.format(date, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public abstract StringBuffer format(Date var1, StringBuffer var2, FieldPosition var3);

    public static java.util.Locale[] getAvailableLocales() {
        return java.util.Locale.getAvailableLocales();
    }

    public Calendar getCalendar() {
        return this.calendar;
    }

    public static final DateFormat getDateInstance() {
        return DateFormat.getDateInstance(2);
    }

    public static final DateFormat getDateInstance(int n) {
        return DateFormat.getDateInstance(n, java.util.Locale.getDefault());
    }

    public static final DateFormat getDateInstance(int n, java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)DateFormat.getBundle(locale);
        String string = "";
        switch (n) {
            case 3: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_SHORT);
                break;
            }
            case 2: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM);
                break;
            }
            case 1: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_LONG);
                break;
            }
            case 0: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_FULL);
                break;
            }
            default: {
                string = (String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM);
            }
        }
        return new SimpleDateFormat(string, locale);
    }

    public static final DateFormat getDateTimeInstance() {
        return DateFormat.getDateTimeInstance(2, 2);
    }

    public static final DateFormat getDateTimeInstance(int n, int n2) {
        return DateFormat.getDateTimeInstance(n, n2, java.util.Locale.getDefault());
    }

    public static final DateFormat getDateTimeInstance(int n, int n2, java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)DateFormat.getBundle(locale);
        StringBuffer stringBuffer = new StringBuffer();
        switch (n) {
            case 3: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_SHORT));
                break;
            }
            case 2: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM));
                break;
            }
            case 1: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_LONG));
                break;
            }
            case 0: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_FULL));
                break;
            }
            default: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.DATE_MEDIUM));
            }
        }
        stringBuffer.append(" ");
        switch (n2) {
            case 3: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_SHORT));
                break;
            }
            case 2: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM));
                break;
            }
            case 1: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_LONG));
                break;
            }
            case 0: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_FULL));
                break;
            }
            default: {
                stringBuffer.append((String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM));
            }
        }
        return new SimpleDateFormat(stringBuffer.toString(), locale);
    }

    public static final DateFormat getInstance() {
        return DateFormat.getDateTimeInstance(3, 3);
    }

    public NumberFormat getNumberFormat() {
        return this.numberFormat;
    }

    static String getStyleName(int n) {
        String string;
        switch (n) {
            case 3: {
                string = "SHORT";
                break;
            }
            case 2: {
                string = "MEDIUM";
                break;
            }
            case 1: {
                string = "LONG";
                break;
            }
            case 0: {
                string = "FULL";
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    public static final DateFormat getTimeInstance() {
        return DateFormat.getTimeInstance(2);
    }

    public static final DateFormat getTimeInstance(int n) {
        return DateFormat.getTimeInstance(n, java.util.Locale.getDefault());
    }

    public static final DateFormat getTimeInstance(int n, java.util.Locale locale) {
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)DateFormat.getBundle(locale);
        String string = "";
        switch (n) {
            case 3: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_SHORT);
                break;
            }
            case 2: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM);
                break;
            }
            case 1: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_LONG);
                break;
            }
            case 0: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_FULL);
                break;
            }
            default: {
                string = (String)extendedResourceBundle.getObject(Locale.TIME_MEDIUM);
            }
        }
        return new SimpleDateFormat(string, locale);
    }

    public TimeZone getTimeZone() {
        return this.calendar.getTimeZone();
    }

    public int hashCode() {
        return this.calendar.getFirstDayOfWeek() + this.calendar.getMinimalDaysInFirstWeek() + this.calendar.getTimeZone().hashCode() + (this.calendar.isLenient() ? 1231 : 1237) + this.numberFormat.hashCode();
    }

    public boolean isLenient() {
        return this.calendar.isLenient();
    }

    public Date parse(String string) throws ParseException {
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = this.parse(string, parsePosition);
        if (parsePosition.getErrorIndex() != -1 || parsePosition.getIndex() == 0) {
            throw new ParseException(null, parsePosition.getErrorIndex());
        }
        return date;
    }

    public abstract Date parse(String var1, ParsePosition var2);

    public Object parseObject(String string, ParsePosition parsePosition) {
        return this.parse(string, parsePosition);
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setLenient(boolean bl) {
        this.calendar.setLenient(bl);
    }

    public void setNumberFormat(NumberFormat numberFormat) {
        this.numberFormat = numberFormat;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.calendar.setTimeZone(timeZone);
    }

    public static class Field
    extends Format.Field {
        public static final Field ERA = new Field("era", 0);
        public static final Field YEAR = new Field("year", 1);
        public static final Field MONTH = new Field("month", 2);
        public static final Field HOUR_OF_DAY0 = new Field("hour of day", 11);
        public static final Field HOUR_OF_DAY1 = new Field("hour of day 1", -1);
        public static final Field MINUTE = new Field("minute", 12);
        public static final Field SECOND = new Field("second", 13);
        public static final Field MILLISECOND = new Field("millisecond", 14);
        public static final Field DAY_OF_WEEK = new Field("day of week", 7);
        public static final Field DAY_OF_MONTH = new Field("day of month", 5);
        public static final Field DAY_OF_YEAR = new Field("day of year", 6);
        public static final Field DAY_OF_WEEK_IN_MONTH = new Field("day of week in month", 8);
        public static final Field WEEK_OF_YEAR = new Field("week of year", 3);
        public static final Field WEEK_OF_MONTH = new Field("week of month", 4);
        public static final Field AM_PM = new Field("am pm", 9);
        public static final Field HOUR0 = new Field("hour", 10);
        public static final Field HOUR1 = new Field("hour 1", -1);
        public static final Field TIME_ZONE = new Field("time zone", -1);
        private static Field[] calendarFields;
        private int calendarField = -1;

        static {
            Field[] fieldArray = new Field[17];
            fieldArray[0] = ERA;
            fieldArray[1] = YEAR;
            fieldArray[2] = MONTH;
            fieldArray[3] = WEEK_OF_YEAR;
            fieldArray[4] = WEEK_OF_MONTH;
            fieldArray[5] = DAY_OF_MONTH;
            fieldArray[6] = DAY_OF_YEAR;
            fieldArray[7] = DAY_OF_WEEK;
            fieldArray[8] = DAY_OF_WEEK_IN_MONTH;
            fieldArray[9] = AM_PM;
            fieldArray[10] = HOUR0;
            fieldArray[11] = HOUR_OF_DAY0;
            fieldArray[12] = MINUTE;
            fieldArray[13] = SECOND;
            fieldArray[14] = MILLISECOND;
            calendarFields = fieldArray;
        }

        protected Field(String string, int n) {
            super(string);
            this.calendarField = n;
        }

        public int getCalendarField() {
            return this.calendarField;
        }

        public static Field ofCalendarField(int n) {
            if (n < 0 || n >= 17) {
                throw new IllegalArgumentException();
            }
            return calendarFields[n];
        }

        protected Object readResolve() throws InvalidObjectException {
            block8: {
                String string = this.getName();
                if (string == null) {
                    throw new InvalidObjectException(Msg.getString("K0344", "DateFormat.Field"));
                }
                if (this.calendarField != -1) {
                    try {
                        Field field = Field.ofCalendarField(this.calendarField);
                        if (field != null && string.equals(field.getName())) {
                            return field;
                        }
                        break block8;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        throw new InvalidObjectException(Msg.getString("K0344", "DateFormat.Field"));
                    }
                }
                if (string.equals(TIME_ZONE.getName())) {
                    return TIME_ZONE;
                }
                if (string.equals(HOUR1.getName())) {
                    return HOUR1;
                }
                if (string.equals(HOUR_OF_DAY1.getName())) {
                    return HOUR_OF_DAY1;
                }
            }
            throw new InvalidObjectException(Msg.getString("K0344", "DateFormat.Field"));
        }
    }
}

