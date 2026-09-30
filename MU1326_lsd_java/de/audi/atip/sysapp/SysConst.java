/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

public class SysConst {
    public static final int EOLFLAG_PHONE_INDEX = 24;
    public static final int TIMER_MEDIA_SCAN_INDEX = 202;
    public static final int EOLFLAG_PHONE_PRESENT = 1;
    public static final int MAX_CONST_INDEX = 303;
    private static final int[] data = new int[303];

    public static final int getSysConst(int n) {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        System.out.println("ERROR: " + stackTraceElementArray[1].getClassName() + "::" + stackTraceElementArray[1].getMethodName() + " # SysConst.getSysConst(" + n + ")");
        return data[n];
    }

    protected static final void reset() {
        SysConst.data[24] = 1;
        SysConst.data[202] = 30;
    }

    public static final int[] getSysConstData() {
        return data;
    }

    private SysConst() {
    }
}

