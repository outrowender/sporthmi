/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sUsbOvercurrent {
    public long msg_id;
    public int state;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public sUsbOvercurrent() {
    }

    public sUsbOvercurrent(long l, int n) {
        this.msg_id = l;
        this.state = n;
    }

    public String toString() {
        return "sUsbOvercurrent{" + "msg_id=" + this.msg_id + ", state=" + this.state + "}";
    }
}

