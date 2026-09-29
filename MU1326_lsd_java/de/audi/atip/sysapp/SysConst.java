/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

public class SysConst {
    public static final int EOLFLAG_PHONE_INDEX;
    public static final int TIMER_MEDIA_SCAN_INDEX;
    public static final int EOLFLAG_PHONE_PRESENT;
    public static final int MAX_CONST_INDEX;
    private static final int[] data;

    public static final int getSysConst(int n) {
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTraceElementArray = throwable.getStackTrace();
        System.out.println(new StringBuffer().append("ERROR: ").append(stackTraceElementArray[1].getClassName()).append("::").append(stackTraceElementArray[1].getMethodName()).append(" # SysConst.getSysConst(").append(n).append(")").toString());
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

    static {
        data = new int[303];
    }
}

