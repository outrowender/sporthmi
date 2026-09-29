/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

import de.esolutions.fw.util.commons.Buffer;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.global.ResourceLocator;

public class TelServiceCallStackEntry {
    private final int clEntryID;
    private final String number;
    private final String name;
    private final long adbEntryID;
    private final short phoneType;
    private final short adbEntryLocationType;
    private final ResourceLocator picture;
    private final int phoneNumberIndex;
    private final int phoneDataCount;
    private final Date timestamp;

    public TelServiceCallStackEntry(int n, String string, String string2, long l, short s, short s2, ResourceLocator resourceLocator, int n2, int n3, Date date) {
        this.clEntryID = n;
        this.number = string2;
        this.name = string;
        this.adbEntryID = l;
        this.phoneType = s;
        this.adbEntryLocationType = s2;
        this.picture = resourceLocator;
        this.phoneNumberIndex = n2;
        this.phoneDataCount = n3;
        this.timestamp = date;
    }

    public int getClEntryID() {
        return this.clEntryID;
    }

    public String getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public long getAdbEntryID() {
        return this.adbEntryID;
    }

    public short getPhoneType() {
        return this.phoneType;
    }

    public short getAdbEntryLocationType() {
        return this.adbEntryLocationType;
    }

    public ResourceLocator getPicture() {
        return this.picture;
    }

    public int getPhoneNumberIndex() {
        return this.phoneNumberIndex;
    }

    public int getPhoneDataCount() {
        return this.phoneDataCount;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelServiceCallStackEntry[");
        buffer.append("csID=");
        buffer.append(this.clEntryID);
        buffer.append(", ");
        buffer.append("number=");
        buffer.append(this.number);
        buffer.append(", ");
        buffer.append("name=");
        buffer.append(this.name);
        buffer.append(", ");
        buffer.append("adbEntryID=");
        buffer.append(this.adbEntryID);
        buffer.append(", ");
        buffer.append("phoneType=");
        buffer.append(this.phoneType);
        buffer.append(", ");
        buffer.append("adbEntryLocationType=");
        buffer.append(this.adbEntryLocationType);
        buffer.append(", ");
        buffer.append("picture=");
        buffer.append(this.picture);
        buffer.append(", ");
        buffer.append("phoneNumberIndex=");
        buffer.append(this.phoneNumberIndex);
        buffer.append(", ");
        buffer.append("phoneDataCount=");
        buffer.append(this.phoneDataCount);
        buffer.append(", ");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.timestamp);
        buffer.append("timestamp=");
        buffer.append(calendar);
        buffer.append("]");
        return buffer.toString();
    }
}

