/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

class ModelStatistics$CriticalMethodCall {
    String methodName;
    long processingTime;
    long[] sleepTimes;
    Exception ex;

    public ModelStatistics$CriticalMethodCall(String string, long l, long[] lArray, Exception exception) {
        this.methodName = string;
        this.processingTime = l;
        this.sleepTimes = new long[lArray.length];
        System.arraycopy((Object)lArray, 0, (Object)this.sleepTimes, 0, lArray.length);
        this.ex = exception;
    }
}

