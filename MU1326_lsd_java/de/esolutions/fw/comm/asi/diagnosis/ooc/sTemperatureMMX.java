/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ooc;

public class sTemperatureMMX {
    public long msg_id;
    public short current;
    public short min;
    public short max;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getCurrent() {
        return this.current;
    }

    public void setCurrent(short s) {
        this.current = s;
    }

    public short getMin() {
        return this.min;
    }

    public void setMin(short s) {
        this.min = s;
    }

    public short getMax() {
        return this.max;
    }

    public void setMax(short s) {
        this.max = s;
    }

    public sTemperatureMMX() {
    }

    public sTemperatureMMX(long l, short s, short s2, short s3) {
        this.msg_id = l;
        this.current = s;
        this.min = s2;
        this.max = s3;
    }

    public String toString() {
        return "sTemperatureMMX{" + "msg_id=" + this.msg_id + ", current=" + this.current + ", min=" + this.min + ", max=" + this.max + "}";
    }
}

