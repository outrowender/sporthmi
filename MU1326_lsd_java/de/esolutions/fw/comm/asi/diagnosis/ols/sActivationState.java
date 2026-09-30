/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.ols;

public class sActivationState {
    public long msg_id;
    public short serviceCounter;
    public short[] serviceID;
    public int[] statusCode;
    public short[] activationYear;
    public short[] activationMonth;
    public short[] activationDay;
    public short[] activationHour;
    public short[] activationMinute;
    public int[] activationState;
    public short[] exptLicenceYear;
    public short[] exptLicenceMonth;
    public short[] exptLicenceDay;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getServiceCounter() {
        return this.serviceCounter;
    }

    public void setServiceCounter(short s) {
        this.serviceCounter = s;
    }

    public short[] getServiceID() {
        return this.serviceID;
    }

    public void setServiceID(short[] sArray) {
        this.serviceID = sArray;
    }

    public int[] getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int[] nArray) {
        this.statusCode = nArray;
    }

    public short[] getActivationYear() {
        return this.activationYear;
    }

    public void setActivationYear(short[] sArray) {
        this.activationYear = sArray;
    }

    public short[] getActivationMonth() {
        return this.activationMonth;
    }

    public void setActivationMonth(short[] sArray) {
        this.activationMonth = sArray;
    }

    public short[] getActivationDay() {
        return this.activationDay;
    }

    public void setActivationDay(short[] sArray) {
        this.activationDay = sArray;
    }

    public short[] getActivationHour() {
        return this.activationHour;
    }

    public void setActivationHour(short[] sArray) {
        this.activationHour = sArray;
    }

    public short[] getActivationMinute() {
        return this.activationMinute;
    }

    public void setActivationMinute(short[] sArray) {
        this.activationMinute = sArray;
    }

    public int[] getActivationState() {
        return this.activationState;
    }

    public void setActivationState(int[] nArray) {
        this.activationState = nArray;
    }

    public short[] getExptLicenceYear() {
        return this.exptLicenceYear;
    }

    public void setExptLicenceYear(short[] sArray) {
        this.exptLicenceYear = sArray;
    }

    public short[] getExptLicenceMonth() {
        return this.exptLicenceMonth;
    }

    public void setExptLicenceMonth(short[] sArray) {
        this.exptLicenceMonth = sArray;
    }

    public short[] getExptLicenceDay() {
        return this.exptLicenceDay;
    }

    public void setExptLicenceDay(short[] sArray) {
        this.exptLicenceDay = sArray;
    }

    public sActivationState() {
    }

    public sActivationState(long l, short s, short[] sArray, int[] nArray, short[] sArray2, short[] sArray3, short[] sArray4, short[] sArray5, short[] sArray6, int[] nArray2, short[] sArray7, short[] sArray8, short[] sArray9) {
        this.msg_id = l;
        this.serviceCounter = s;
        this.serviceID = sArray;
        this.statusCode = nArray;
        this.activationYear = sArray2;
        this.activationMonth = sArray3;
        this.activationDay = sArray4;
        this.activationHour = sArray5;
        this.activationMinute = sArray6;
        this.activationState = nArray2;
        this.exptLicenceYear = sArray7;
        this.exptLicenceMonth = sArray8;
        this.exptLicenceDay = sArray9;
    }

    public String toString() {
        return "sActivationState{" + "msg_id=" + this.msg_id + ", serviceCounter=" + this.serviceCounter + ", serviceID=" + "[" + (this.serviceID == null ? "null" : "size=" + this.serviceID.length) + "]" + ", statusCode=" + "[" + (this.statusCode == null ? "null" : "size=" + this.statusCode.length) + "]" + ", activationYear=" + "[" + (this.activationYear == null ? "null" : "size=" + this.activationYear.length) + "]" + ", activationMonth=" + "[" + (this.activationMonth == null ? "null" : "size=" + this.activationMonth.length) + "]" + ", activationDay=" + "[" + (this.activationDay == null ? "null" : "size=" + this.activationDay.length) + "]" + ", activationHour=" + "[" + (this.activationHour == null ? "null" : "size=" + this.activationHour.length) + "]" + ", activationMinute=" + "[" + (this.activationMinute == null ? "null" : "size=" + this.activationMinute.length) + "]" + ", activationState=" + "[" + (this.activationState == null ? "null" : "size=" + this.activationState.length) + "]" + ", exptLicenceYear=" + "[" + (this.exptLicenceYear == null ? "null" : "size=" + this.exptLicenceYear.length) + "]" + ", exptLicenceMonth=" + "[" + (this.exptLicenceMonth == null ? "null" : "size=" + this.exptLicenceMonth.length) + "]" + ", exptLicenceDay=" + "[" + (this.exptLicenceDay == null ? "null" : "size=" + this.exptLicenceDay.length) + "]" + "}";
    }
}

