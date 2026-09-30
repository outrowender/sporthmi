/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class sApplicationSoftwareVersionNumber {
    public long msg_id;
    public String number;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String string) {
        this.number = string;
    }

    public sApplicationSoftwareVersionNumber() {
    }

    public sApplicationSoftwareVersionNumber(long l, String string) {
        this.msg_id = l;
        this.number = string;
    }

    public String toString() {
        return "sApplicationSoftwareVersionNumber{" + "msg_id=" + this.msg_id + ", number=" + this.number + "}";
    }
}

