/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes;

public class sTestStatus {
    public long internalDtc;
    public int testResult;
    public short[] envData;

    public long getInternalDtc() {
        return this.internalDtc;
    }

    public void setInternalDtc(long l) {
        this.internalDtc = l;
    }

    public int getTestResult() {
        return this.testResult;
    }

    public void setTestResult(int n) {
        this.testResult = n;
    }

    public short[] getEnvData() {
        return this.envData;
    }

    public void setEnvData(short[] sArray) {
        this.envData = sArray;
    }

    public sTestStatus() {
    }

    public sTestStatus(long l, int n, short[] sArray) {
        this.internalDtc = l;
        this.testResult = n;
        this.envData = sArray;
    }

    public String toString() {
        return "sTestStatus{" + "internalDtc=" + this.internalDtc + ", testResult=" + this.testResult + ", envData=" + "[" + (this.envData == null ? "null" : "size=" + this.envData.length) + "]" + "}";
    }
}

