/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.ExtendedResourceBundle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public abstract class Calendar
implements Serializable,
Cloneable {
    private static final long serialVersionUID = -1807547505821590642L;
    protected boolean areFieldsSet = false;
    protected int[] fields = new int[17];
    protected boolean[] isSet = new boolean[17];
    protected boolean isTimeSet = false;
    protected long time;
    transient int lastTimeFieldSet;
    transient int lastDateFieldSet;
    private boolean lenient;
    private int firstDayOfWeek;
    private int minimalDaysInFirstWeek;
    private TimeZone zone;
    public static final int JANUARY = 0;
    public static final int FEBRUARY = 1;
    public static final int MARCH = 2;
    public static final int APRIL = 3;
    public static final int MAY = 4;
    public static final int JUNE = 5;
    public static final int JULY = 6;
    public static final int AUGUST = 7;
    public static final int SEPTEMBER = 8;
    public static final int OCTOBER = 9;
    public static final int NOVEMBER = 10;
    public static final int DECEMBER = 11;
    public static final int UNDECIMBER = 12;
    public static final int SUNDAY = 1;
    public static final int MONDAY = 2;
    public static final int TUESDAY = 3;
    public static final int WEDNESDAY = 4;
    public static final int THURSDAY = 5;
    public static final int FRIDAY = 6;
    public static final int SATURDAY = 7;
    public static final int ERA = 0;
    public static final int YEAR = 1;
    public static final int MONTH = 2;
    public static final int WEEK_OF_YEAR = 3;
    public static final int WEEK_OF_MONTH = 4;
    public static final int DATE = 5;
    public static final int DAY_OF_MONTH = 5;
    public static final int DAY_OF_YEAR = 6;
    public static final int DAY_OF_WEEK = 7;
    public static final int DAY_OF_WEEK_IN_MONTH = 8;
    public static final int AM_PM = 9;
    public static final int HOUR = 10;
    public static final int HOUR_OF_DAY = 11;
    public static final int MINUTE = 12;
    public static final int SECOND = 13;
    public static final int MILLISECOND = 14;
    public static final int ZONE_OFFSET = 15;
    public static final int DST_OFFSET = 16;
    public static final int FIELD_COUNT = 17;
    public static final int AM = 0;
    public static final int PM = 1;
    private static String[] fieldNames = new String[]{"ERA=", "YEAR=", "MONTH=", "WEEK_OF_YEAR=", "WEEK_OF_MONTH=", "DAY_OF_MONTH=", "DAY_OF_YEAR=", "DAY_OF_WEEK=", "DAY_OF_WEEK_IN_MONTH=", "AM_PM=", "HOUR=", "HOUR_OF_DAY", "MINUTE=", "SECOND=", "MILLISECOND=", "ZONE_OFFSET=", "DST_OFFSET="};
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;

    static {
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[11];
        objectStreamFieldArray[0] = new ObjectStreamField("areFieldsSet", Boolean.TYPE);
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("[I");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[1] = new ObjectStreamField("fields", clazz);
        objectStreamFieldArray[2] = new ObjectStreamField("firstDayOfWeek", Integer.TYPE);
        Class clazz2 = class$1;
        if (clazz2 == null) {
            try {
                clazz2 = class$1 = Class.forName("[Z");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[3] = new ObjectStreamField("isSet", clazz2);
        objectStreamFieldArray[4] = new ObjectStreamField("isTimeSet", Boolean.TYPE);
        objectStreamFieldArray[5] = new ObjectStreamField("lenient", Boolean.TYPE);
        objectStreamFieldArray[6] = new ObjectStreamField("minimalDaysInFirstWeek", Integer.TYPE);
        objectStreamFieldArray[7] = new ObjectStreamField("nextStamp", Integer.TYPE);
        objectStreamFieldArray[8] = new ObjectStreamField("serialVersionOnStream", Integer.TYPE);
        objectStreamFieldArray[9] = new ObjectStreamField("time", Long.TYPE);
        Class clazz3 = class$2;
        if (clazz3 == null) {
            try {
                clazz3 = class$2 = Class.forName("java.util.TimeZone");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[10] = new ObjectStreamField("zone", clazz3);
        serialPersistentFields = objectStreamFieldArray;
    }

    protected Calendar() {
        this(TimeZone.getDefault(), Locale.getDefault());
    }

    Calendar(TimeZone timeZone) {
        this.setLenient(true);
        this.setTimeZone(timeZone);
    }

    protected Calendar(TimeZone timeZone, Locale locale) {
        this(timeZone);
        ExtendedResourceBundle extendedResourceBundle = (ExtendedResourceBundle)Locale.getBundle("Locale", locale);
        this.setFirstDayOfWeek((Integer)extendedResourceBundle.getObject(com.ibm.oti.locale.Locale.FIRST_DAY));
        this.setMinimalDaysInFirstWeek((Integer)extendedResourceBundle.getObject(com.ibm.oti.locale.Locale.MINIMAL_DAYS));
    }

    public abstract void add(int var1, int var2);

    public boolean after(Object object) {
        if (!(object instanceof Calendar)) {
            return false;
        }
        return this.getTimeInMillis() > ((Calendar)object).getTimeInMillis();
    }

    public boolean before(Object object) {
        if (!(object instanceof Calendar)) {
            return false;
        }
        return this.getTimeInMillis() < ((Calendar)object).getTimeInMillis();
    }

    public final void clear() {
        int n = 0;
        while (n < 17) {
            this.fields[n] = 0;
            this.isSet[n] = false;
            ++n;
        }
        this.isTimeSet = false;
        this.areFieldsSet = false;
    }

    public final void clear(int n) {
        this.fields[n] = 0;
        this.isSet[n] = false;
        this.isTimeSet = false;
        this.areFieldsSet = false;
    }

    public Object clone() {
        try {
            Calendar calendar = (Calendar)super.clone();
            calendar.fields = (int[])this.fields.clone();
            calendar.isSet = (boolean[])this.isSet.clone();
            return calendar;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    protected void complete() {
        if (!this.isTimeSet) {
            this.computeTime();
            this.isTimeSet = true;
        }
        if (this.areFieldsSet) {
            int n = 0;
            while (n < this.isSet.length) {
                this.isSet[n] = true;
                ++n;
            }
        } else {
            this.computeFields();
            this.areFieldsSet = true;
        }
    }

    protected abstract void computeFields();

    protected abstract void computeTime();

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar calendar = (Calendar)object;
        return this.getTimeInMillis() == calendar.getTimeInMillis() && this.isLenient() == calendar.isLenient() && this.getFirstDayOfWeek() == calendar.getFirstDayOfWeek() && this.getMinimalDaysInFirstWeek() == calendar.getMinimalDaysInFirstWeek() && this.getTimeZone().equals(calendar.getTimeZone());
    }

    public int get(int n) {
        this.complete();
        return this.fields[n];
    }

    public int getActualMaximum(int n) {
        int n2;
        int n3 = this.getLeastMaximum(n);
        if (this.getMaximum(n) == n3) {
            return n3;
        }
        this.complete();
        long l = this.time;
        this.set(n, n3);
        do {
            n2 = n3;
            this.roll(n, true);
        } while ((n3 = this.get(n)) > n2);
        this.time = l;
        this.areFieldsSet = false;
        return n2;
    }

    public int getActualMinimum(int n) {
        int n2;
        int n3 = this.getGreatestMinimum(n);
        if (this.getMinimum(n) == n3) {
            return n3;
        }
        this.complete();
        long l = this.time;
        this.set(n, n3);
        do {
            n2 = n3;
            this.roll(n, false);
        } while ((n3 = this.get(n)) < n2);
        this.time = l;
        this.areFieldsSet = false;
        return n2;
    }

    public static synchronized Locale[] getAvailableLocales() {
        return Locale.getAvailableLocales();
    }

    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public abstract int getGreatestMinimum(int var1);

    public static synchronized Calendar getInstance() {
        return new GregorianCalendar();
    }

    public static synchronized Calendar getInstance(Locale locale) {
        return new GregorianCalendar(locale);
    }

    public static synchronized Calendar getInstance(TimeZone timeZone) {
        return new GregorianCalendar(timeZone);
    }

    public static synchronized Calendar getInstance(TimeZone timeZone, Locale locale) {
        return new GregorianCalendar(timeZone, locale);
    }

    public abstract int getLeastMaximum(int var1);

    public abstract int getMaximum(int var1);

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDaysInFirstWeek;
    }

    public abstract int getMinimum(int var1);

    public final Date getTime() {
        return new Date(this.getTimeInMillis());
    }

    public long getTimeInMillis() {
        if (!this.isTimeSet) {
            this.computeTime();
            this.isTimeSet = true;
        }
        return this.time;
    }

    public TimeZone getTimeZone() {
        return this.zone;
    }

    public int hashCode() {
        return (this.isLenient() ? 1237 : 1231) + this.getFirstDayOfWeek() + this.getMinimalDaysInFirstWeek() + this.getTimeZone().hashCode();
    }

    protected final int internalGet(int n) {
        return this.fields[n];
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public final boolean isSet(int n) {
        return this.isSet[n];
    }

    public void roll(int n, int n2) {
        boolean bl = n2 >= 0;
        int n3 = bl ? n2 : -n2;
        int n4 = 0;
        while (n4 < n3) {
            this.roll(n, bl);
            ++n4;
        }
    }

    public abstract void roll(int var1, boolean var2);

    public void set(int n, int n2) {
        this.fields[n] = n2;
        this.isSet[n] = true;
        this.isTimeSet = false;
        this.areFieldsSet = false;
        if (n > 2 && n < 9) {
            this.lastDateFieldSet = n;
        }
        if (n == 10 || n == 11) {
            this.lastTimeFieldSet = n;
        }
    }

    public final void set(int n, int n2, int n3) {
        this.set(1, n);
        this.set(2, n2);
        this.set(5, n3);
    }

    public final void set(int n, int n2, int n3, int n4, int n5) {
        this.set(n, n2, n3);
        this.set(11, n4);
        this.set(12, n5);
    }

    public final void set(int n, int n2, int n3, int n4, int n5, int n6) {
        this.set(n, n2, n3, n4, n5);
        this.set(13, n6);
    }

    public void setFirstDayOfWeek(int n) {
        this.firstDayOfWeek = n;
    }

    public void setLenient(boolean bl) {
        this.lenient = bl;
    }

    public void setMinimalDaysInFirstWeek(int n) {
        this.minimalDaysInFirstWeek = n;
    }

    public final void setTime(Date date) {
        this.setTimeInMillis(date.getTime());
    }

    public void setTimeInMillis(long l) {
        this.time = l;
        this.isTimeSet = true;
        this.areFieldsSet = false;
        this.complete();
    }

    public void setTimeZone(TimeZone timeZone) {
        this.zone = timeZone;
        this.areFieldsSet = false;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(new StringBuffer(String.valueOf(this.getClass().getName())).append("[time=").append(this.isTimeSet ? String.valueOf(this.time) : "?").append(",areFieldsSet=").append(this.areFieldsSet).append(",lenient=").append(this.lenient).append(",zone=").append(this.zone).append(",firstDayOfWeek=").append(this.firstDayOfWeek).append(",minimalDaysInFirstWeek=").append(this.minimalDaysInFirstWeek).toString());
        int n = 0;
        while (n < 17) {
            stringBuffer.append(',');
            stringBuffer.append(fieldNames[n]);
            stringBuffer.append('=');
            if (this.isSet[n]) {
                stringBuffer.append(this.fields[n]);
            } else {
                stringBuffer.append('?');
            }
            ++n;
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        this.complete();
        ObjectOutputStream.PutField putField = objectOutputStream.putFields();
        putField.put("areFieldsSet", this.areFieldsSet);
        putField.put("fields", this.fields);
        putField.put("firstDayOfWeek", this.firstDayOfWeek);
        putField.put("isSet", this.isSet);
        putField.put("isTimeSet", this.isTimeSet);
        putField.put("lenient", this.lenient);
        putField.put("minimalDaysInFirstWeek", this.minimalDaysInFirstWeek);
        putField.put("nextStamp", 2);
        putField.put("serialVersionOnStream", 1);
        putField.put("time", this.time);
        putField.put("zone", this.zone);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField getField = objectInputStream.readFields();
        this.areFieldsSet = getField.get("areFieldsSet", false);
        this.fields = (int[])getField.get("fields", null);
        this.firstDayOfWeek = getField.get("firstDayOfWeek", 1);
        this.isSet = (boolean[])getField.get("isSet", null);
        this.isTimeSet = getField.get("isTimeSet", false);
        this.lenient = getField.get("lenient", true);
        this.minimalDaysInFirstWeek = getField.get("minimalDaysInFirstWeek", 1);
        this.time = getField.get("time", 0L);
        this.zone = (TimeZone)getField.get("zone", null);
    }
}

