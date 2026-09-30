/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.preset;

import de.esolutions.fw.util.commons.Buffer;
import java.io.Serializable;

public class TelPresetDefinitionContainer
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final String number;
    private final short telPhoneType;
    private final boolean isADBMatch;

    public TelPresetDefinitionContainer(String string, String string2, short s) {
        this.isADBMatch = string2 != null && string2.length() > 0;
        this.number = string;
        this.name = string2;
        this.telPhoneType = s;
    }

    public boolean isADBMatch() {
        return this.isADBMatch;
    }

    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public short getTelPhoneType() {
        return this.telPhoneType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelPresetDefinitionContainer: ");
        buffer.append("isADBMatch=");
        buffer.append(this.isADBMatch);
        buffer.append(", ");
        buffer.append("name=");
        buffer.append(this.name);
        buffer.append(", ");
        buffer.append("number=");
        buffer.append(this.number);
        buffer.append(", ");
        buffer.append("telPhoneType=");
        buffer.append(this.telPhoneType);
        return buffer.toString();
    }
}

