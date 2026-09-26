/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.audio.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPTMCInfoMessage {
    private byte priority;
    private String streetName;
    private String location;
    private String infotext;
    private long length;
    private int lengthUnit;

    public CombiBAPTMCInfoMessage(byte by, String string, String string2, String string3, long l, int n) {
        this.priority = by;
        this.streetName = string;
        this.location = string2;
        this.infotext = string3;
        this.length = l;
        this.lengthUnit = n;
    }

    public byte getPriority() {
        return this.priority;
    }

    public String getStreetName() {
        return this.streetName;
    }

    public String getLocation() {
        return this.location;
    }

    public String getInfotext() {
        return this.infotext;
    }

    public long getLength() {
        return this.length;
    }

    public int getLengthUnit() {
        return this.lengthUnit;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPTMCInfoMessage { priority=");
        buffer.append(this.priority);
        buffer.append(", streetName=");
        buffer.append(this.streetName);
        buffer.append(", location=");
        buffer.append(this.location);
        buffer.append(", infotext=");
        buffer.append(this.infotext);
        buffer.append(", length=");
        buffer.append(this.length);
        buffer.append(", lengthUnit=");
        buffer.append(this.lengthUnit);
        buffer.append("}");
        return buffer.toString();
    }
}

