/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigationAW;

public class sInfraredBeaconStateVICS {
    public long msg_id;
    public boolean available;
    public short yearLastMsg;
    public short monthLastMsg;
    public short dayLastMsg;
    public short hourLastMsg;
    public short minuteLastMsg;
    public short secondsLastMsg;
    public short idLastMsg;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean bl) {
        this.available = bl;
    }

    public short getYearLastMsg() {
        return this.yearLastMsg;
    }

    public void setYearLastMsg(short s) {
        this.yearLastMsg = s;
    }

    public short getMonthLastMsg() {
        return this.monthLastMsg;
    }

    public void setMonthLastMsg(short s) {
        this.monthLastMsg = s;
    }

    public short getDayLastMsg() {
        return this.dayLastMsg;
    }

    public void setDayLastMsg(short s) {
        this.dayLastMsg = s;
    }

    public short getHourLastMsg() {
        return this.hourLastMsg;
    }

    public void setHourLastMsg(short s) {
        this.hourLastMsg = s;
    }

    public short getMinuteLastMsg() {
        return this.minuteLastMsg;
    }

    public void setMinuteLastMsg(short s) {
        this.minuteLastMsg = s;
    }

    public short getSecondsLastMsg() {
        return this.secondsLastMsg;
    }

    public void setSecondsLastMsg(short s) {
        this.secondsLastMsg = s;
    }

    public short getIdLastMsg() {
        return this.idLastMsg;
    }

    public void setIdLastMsg(short s) {
        this.idLastMsg = s;
    }

    public sInfraredBeaconStateVICS() {
    }

    public sInfraredBeaconStateVICS(long l, boolean bl, short s, short s2, short s3, short s4, short s5, short s6, short s7) {
        this.msg_id = l;
        this.available = bl;
        this.yearLastMsg = s;
        this.monthLastMsg = s2;
        this.dayLastMsg = s3;
        this.hourLastMsg = s4;
        this.minuteLastMsg = s5;
        this.secondsLastMsg = s6;
        this.idLastMsg = s7;
    }

    public String toString() {
        return "sInfraredBeaconStateVICS{" + "msg_id=" + this.msg_id + ", available=" + this.available + ", yearLastMsg=" + this.yearLastMsg + ", monthLastMsg=" + this.monthLastMsg + ", dayLastMsg=" + this.dayLastMsg + ", hourLastMsg=" + this.hourLastMsg + ", minuteLastMsg=" + this.minuteLastMsg + ", secondsLastMsg=" + this.secondsLastMsg + ", idLastMsg=" + this.idLastMsg + "}";
    }
}

