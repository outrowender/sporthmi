/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;

public class NaviService$OneshotData {
    private final String text;
    private final long id;
    private final String stringID;

    public NaviService$OneshotData(String string, String string2, long l) {
        this.text = string;
        this.stringID = string2;
        this.id = l;
    }

    public NaviService$OneshotData(String string, String string2) {
        this.text = string;
        this.stringID = string2;
        this.id = -1L;
    }

    public String getText() {
        return this.text;
    }

    public long getObjId() {
        return this.id;
    }

    public String getStringId() {
        return this.stringID;
    }

    public final String toString() {
        return new Buffer().append(this.text).append(" (").append(this.id).append(", ").append(this.stringID).append(")").toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (int)(this.id ^ this.id >>> 32);
        n = 31 * n + (this.stringID == null ? 0 : this.stringID.hashCode());
        n = 31 * n + (this.text == null ? 0 : this.text.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        NaviService$OneshotData naviService$OneshotData = (NaviService$OneshotData)object;
        if (this.text != naviService$OneshotData.getText()) {
            return false;
        }
        if (this.stringID != naviService$OneshotData.getStringId()) {
            return false;
        }
        return this.id == naviService$OneshotData.getObjId();
    }
}

