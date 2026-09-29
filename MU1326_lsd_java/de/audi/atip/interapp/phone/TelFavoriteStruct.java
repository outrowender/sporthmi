/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

import de.esolutions.fw.util.commons.Buffer;

public class TelFavoriteStruct {
    final String name;
    final String number;
    final int phoneNumberType;

    public TelFavoriteStruct(String string, String string2, int n) {
        this.name = string;
        this.number = string2;
        this.phoneNumberType = n;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public int getPhoneNumberType() {
        return this.phoneNumberType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelFavoriteStruct: name=");
        buffer.append(this.name);
        buffer.append(", number=");
        buffer.append(this.number);
        buffer.append(", phoneNumberType=");
        buffer.append(this.phoneNumberType);
        return buffer.toString();
    }
}

