/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.media;

public class sMediaRegionCodes {
    public long msg_id;
    public short numberSlots;
    public boolean[] slotActive;
    public short[] regionCodeType;
    public short[] regionCode;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getNumberSlots() {
        return this.numberSlots;
    }

    public void setNumberSlots(short s) {
        this.numberSlots = s;
    }

    public boolean[] getSlotActive() {
        return this.slotActive;
    }

    public void setSlotActive(boolean[] blArray) {
        this.slotActive = blArray;
    }

    public short[] getRegionCodeType() {
        return this.regionCodeType;
    }

    public void setRegionCodeType(short[] sArray) {
        this.regionCodeType = sArray;
    }

    public short[] getRegionCode() {
        return this.regionCode;
    }

    public void setRegionCode(short[] sArray) {
        this.regionCode = sArray;
    }

    public sMediaRegionCodes() {
    }

    public sMediaRegionCodes(long l, short s, boolean[] blArray, short[] sArray, short[] sArray2) {
        this.msg_id = l;
        this.numberSlots = s;
        this.slotActive = blArray;
        this.regionCodeType = sArray;
        this.regionCode = sArray2;
    }

    public String toString() {
        return "sMediaRegionCodes{" + "msg_id=" + this.msg_id + ", numberSlots=" + this.numberSlots + ", slotActive=" + "[" + (this.slotActive == null ? "null" : "size=" + this.slotActive.length) + "]" + ", regionCodeType=" + "[" + (this.regionCodeType == null ? "null" : "size=" + this.regionCodeType.length) + "]" + ", regionCode=" + "[" + (this.regionCode == null ? "null" : "size=" + this.regionCode.length) + "]" + "}";
    }
}

