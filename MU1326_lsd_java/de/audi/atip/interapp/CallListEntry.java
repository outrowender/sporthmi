/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.metrics.DateMetric;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Date;
import java.util.GregorianCalendar;

public class CallListEntry {
    private static final int MONTH_JANUARY = 0;
    private static final int MONTH_DECEMBER = 11;
    private int callListID;
    private long entryID;
    private String number;
    private String name;
    private int storageTypeIconID;
    private int numberTypeIconID;
    private long phoneNumberType = -1L;
    private DateMetric dateMetric;
    private DateMetric timeMetric;

    public CallListEntry() {
        this.number = "";
        this.name = "";
        this.dateMetric = null;
        this.timeMetric = null;
    }

    public CallListEntry(int n, long l, String string, String string2, int n2, int n3, long l2, short s, short s2, short s3, short s4, short s5, short s6) {
        this.callListID = n;
        this.entryID = l;
        this.number = string;
        this.name = string2;
        this.storageTypeIconID = n2;
        this.numberTypeIconID = n3;
        this.phoneNumberType = l2;
        if (s == 0 && s2 == 0 && s3 == 0 && s4 == 0 && s5 == 0 && s6 == 0) {
            return;
        }
        int n4 = s2 - 1;
        if (n4 < 0 || n4 > 11) {
            throw new IllegalArgumentException("CallListEntry: gcMonth not in valid range: " + n4);
        }
        Date date = new GregorianCalendar(s, n4, s3, s4, s5, s6).getTime();
        this.dateMetric = new DateMetric(date, 0);
        this.timeMetric = new DateMetric(date, 6);
    }

    public String toString() {
        Buffer buffer = new Buffer().append("CallListEntry(" + this.callListID + ',' + this.entryID + ',');
        buffer.append(this.number + ',' + this.name + ',');
        buffer.append(this.storageTypeIconID + 44);
        buffer.append(this.numberTypeIconID + 44);
        buffer.append(this.phoneNumberType + 44L);
        buffer.append("Date: " + this.getDateStamp() + ", Time: " + this.getTimeStamp() + ',');
        return buffer.toString();
    }

    public boolean hasValidTimeStamp() {
        return this.dateMetric != null && this.timeMetric != null;
    }

    public int getCallListID() {
        return this.callListID;
    }

    public long getEntryID() {
        return this.entryID;
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public int getStorageTypeIconID() {
        return this.storageTypeIconID;
    }

    public int getNumberTypeIconID() {
        return this.numberTypeIconID;
    }

    public long getPhoneNumberType() {
        return this.phoneNumberType;
    }

    public String getDateStamp() {
        if (this.dateMetric == null) {
            return "";
        }
        return this.dateMetric.format();
    }

    public String getTimeStamp() {
        if (this.timeMetric == null) {
            return "";
        }
        return this.timeMetric.format();
    }
}

