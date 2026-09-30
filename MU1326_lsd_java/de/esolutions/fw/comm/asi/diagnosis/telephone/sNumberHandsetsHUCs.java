/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone;

public class sNumberHandsetsHUCs {
    public long msg_id;
    public short numberHandsets;
    public short numberHUCs;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getNumberHandsets() {
        return this.numberHandsets;
    }

    public void setNumberHandsets(short s) {
        this.numberHandsets = s;
    }

    public short getNumberHUCs() {
        return this.numberHUCs;
    }

    public void setNumberHUCs(short s) {
        this.numberHUCs = s;
    }

    public sNumberHandsetsHUCs() {
    }

    public sNumberHandsetsHUCs(long l, short s, short s2) {
        this.msg_id = l;
        this.numberHandsets = s;
        this.numberHUCs = s2;
    }

    public String toString() {
        return "sNumberHandsetsHUCs{" + "msg_id=" + this.msg_id + ", numberHandsets=" + this.numberHandsets + ", numberHUCs=" + this.numberHUCs + "}";
    }
}

