/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import org.dsi.ifc.global.ResourceLocator;

public class TelAdbEntryStruct {
    public final String clNumber;
    public final String clName;
    public final ResourceLocator adbPictureID;
    public final long adbEntryID;
    public final int adbPhoneDataIndex;
    public final int adbPhoneDataCount;
    public final int adbNumberType;

    public TelAdbEntryStruct() {
        this.clNumber = null;
        this.clName = null;
        this.adbPictureID = null;
        this.adbEntryID = 0L;
        this.adbPhoneDataIndex = 0;
        this.adbPhoneDataCount = 0;
        this.adbNumberType = 0;
    }

    public TelAdbEntryStruct(String string, String string2, ResourceLocator resourceLocator, long l, int n, int n2, int n3) {
        this.clNumber = string;
        this.clName = string2;
        this.adbPictureID = resourceLocator;
        this.adbEntryID = l;
        this.adbPhoneDataIndex = n;
        this.adbPhoneDataCount = n2;
        this.adbNumberType = n3;
    }

    public String getClNumber() {
        return this.clNumber;
    }

    public String getClName() {
        return this.clName;
    }

    public ResourceLocator getAdbPictureID() {
        return this.adbPictureID;
    }

    public long getAdbEntryID() {
        return this.adbEntryID;
    }

    public int getAdbPhoneDataIndex() {
        return this.adbPhoneDataIndex;
    }

    public int getAdbPhoneDataCount() {
        return this.adbPhoneDataCount;
    }

    public int getAdbNumberType() {
        return this.adbNumberType;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1900);
        stringBuffer.append("CallStackEntry");
        stringBuffer.append('(');
        stringBuffer.append("clNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.clNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("clName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.clName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("adbPictureID");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPictureID);
        stringBuffer.append(',');
        stringBuffer.append("adbEntryID");
        stringBuffer.append('=');
        stringBuffer.append(this.adbEntryID);
        stringBuffer.append(',');
        stringBuffer.append("adbPhoneDataIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPhoneDataIndex);
        stringBuffer.append(',');
        stringBuffer.append("adbPhoneDataCount");
        stringBuffer.append('=');
        stringBuffer.append(this.adbPhoneDataCount);
        stringBuffer.append(',');
        stringBuffer.append("adbNumberType");
        stringBuffer.append('=');
        stringBuffer.append(this.adbNumberType);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

