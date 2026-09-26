/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.audi.atip.interapp.combi.bap.data.CombiBAPArrayElement;
import de.audi.atip.interapp.phone.TelAdbEntryStruct;
import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPCallStackEntry
implements CombiBAPArrayElement {
    private int posID;
    private String pbName;
    private String telNumber;
    private int numberType;
    private int callMode;
    private short day;
    private short month;
    private short year;
    private short hour;
    private short minute;
    private short second;
    private TelAdbEntryStruct telAdbEntry;

    public CombiBAPCallStackEntry(int n, String string, String string2, int n2, int n3) {
        this(n, string, string2, n2, n3, 0, 0, 0, 0, 0, 0, new TelAdbEntryStruct());
    }

    public CombiBAPCallStackEntry(int n, String string, String string2, int n2, int n3, short s, short s2, short s3, short s4, short s5, short s6, TelAdbEntryStruct telAdbEntryStruct) {
        this.posID = n;
        this.pbName = string;
        this.telNumber = string2;
        this.numberType = n2;
        this.callMode = n3;
        this.day = s;
        this.month = s2;
        this.year = s3;
        this.hour = s4;
        this.minute = s5;
        this.second = s6;
        this.telAdbEntry = telAdbEntryStruct;
    }

    @Override
    public int getPosID() {
        return this.posID;
    }

    public String getPbName() {
        return this.pbName;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public int getNumberType() {
        return this.numberType;
    }

    public int getCallMode() {
        return this.callMode;
    }

    public short getDay() {
        return this.day;
    }

    public short getMonth() {
        return this.month;
    }

    public short getYear() {
        return this.year;
    }

    public short getHour() {
        return this.hour;
    }

    public short getMinute() {
        return this.minute;
    }

    public short getSecond() {
        return this.second;
    }

    public TelAdbEntryStruct getCallStackEntry() {
        return this.telAdbEntry;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPCallStackEntry {");
        buffer.append("posID=");
        buffer.append(this.posID);
        buffer.append(" (0x");
        buffer.append(Integer.toHexString(this.posID));
        buffer.append("), pbName=");
        buffer.append(this.pbName);
        buffer.append(", ");
        buffer.append("telNumber=");
        buffer.append(this.telNumber);
        buffer.append(", ");
        buffer.append("numberType=");
        buffer.append(this.numberType);
        buffer.append(", ");
        buffer.append("callMode=");
        buffer.append(this.callMode);
        buffer.append(", ");
        buffer.append("date=");
        buffer.append(this.day).append(".").append(this.month).append(".").append(this.year);
        buffer.append(", ");
        buffer.append("time=");
        buffer.append(this.hour).append(":").append(this.minute).append(":").append(this.second);
        buffer.append("}");
        return buffer.toString();
    }

    @Override
    public boolean hasSameContent(CombiBAPArrayElement combiBAPArrayElement) {
        if (combiBAPArrayElement == this) {
            return true;
        }
        if (combiBAPArrayElement instanceof CombiBAPCallStackEntry) {
            CombiBAPCallStackEntry combiBAPCallStackEntry = (CombiBAPCallStackEntry)combiBAPArrayElement;
            return this.posID == combiBAPCallStackEntry.posID && this.pbName.equals(combiBAPCallStackEntry.pbName) && this.telNumber.equals(combiBAPCallStackEntry.telNumber) && this.numberType == combiBAPCallStackEntry.numberType && this.callMode == combiBAPCallStackEntry.callMode && this.day == combiBAPCallStackEntry.day && this.month == combiBAPCallStackEntry.month && this.year == combiBAPCallStackEntry.year && this.hour == combiBAPCallStackEntry.hour && this.minute == combiBAPCallStackEntry.minute && this.second == combiBAPCallStackEntry.second;
        }
        return false;
    }

    @Override
    public int getDiffRecordAddress(CombiBAPArrayElement combiBAPArrayElement) {
        int n = 0;
        if (this.hasSameContent(combiBAPArrayElement)) {
            n = -1;
        } else if (combiBAPArrayElement instanceof CombiBAPCallStackEntry) {
            CombiBAPCallStackEntry combiBAPCallStackEntry = (CombiBAPCallStackEntry)combiBAPArrayElement;
            n = CombiBAPCallStackEntry.getRecordAddress(this.posID != combiBAPCallStackEntry.posID, !this.pbName.equals(combiBAPCallStackEntry.pbName), !this.telNumber.equals(combiBAPCallStackEntry.telNumber), this.numberType != combiBAPCallStackEntry.numberType, this.callMode != combiBAPCallStackEntry.callMode, this.day != combiBAPCallStackEntry.day, this.month != combiBAPCallStackEntry.month, this.year != combiBAPCallStackEntry.year, this.hour != combiBAPCallStackEntry.hour, this.minute != combiBAPCallStackEntry.minute, this.second != combiBAPCallStackEntry.second);
        }
        return n;
    }

    public static int getRecordAddress(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11) {
        int n = 0;
        if (bl) {
            ++n;
        }
        if (bl2) {
            ++n;
        }
        if (bl3) {
            ++n;
        }
        if (bl4) {
            ++n;
        }
        if (bl5) {
            ++n;
        }
        if (bl6) {
            ++n;
        }
        if (bl7) {
            ++n;
        }
        if (bl8) {
            ++n;
        }
        if (bl9) {
            ++n;
        }
        if (bl10) {
            ++n;
        }
        if (bl11) {
            ++n;
        }
        int n2 = n == 0 ? -1 : (n == 1 && bl ? 15 : (n <= 3 && !bl && !bl3 && !bl6 && !bl7 && !bl8 && !bl9 && !bl10 && !bl11 ? 1 : (n <= 7 && !bl && !bl2 && !bl4 && !bl5 ? 2 : 0)));
        return n2;
    }
}

