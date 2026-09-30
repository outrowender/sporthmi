/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeException;
import com.ibm.oti.vm.JxeOutputStream;
import java.io.InputStream;

public final class JxeUtil {
    static {
        try {
            System.loadLibrary("iverel" + System.getProperty("com.ibm.oti.vm.library.version", "23"));
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            try {
                System.loadLibrary("j9vmall" + System.getProperty("com.ibm.oti.vm.library.version", "23"));
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError2) {}
        }
    }

    private static native long nativeGetRomImagePointerFromJxePointer(long var0);

    private static native String nativeGetRelocationMessage(int var0);

    static String getRelocationMessage(int n) {
        return JxeUtil.nativeGetRelocationMessage(n);
    }

    public static byte[] getRomClass(Jxe jxe, String string) {
        byte[] byArray = new byte[40];
        if (jxe.romSegmentPointer == 0L) {
            return null;
        }
        if (!JxeUtil.nativeGetRomClassCookie(jxe.romSegmentPointer, jxe.getJxePointer(), string, byArray)) {
            return null;
        }
        return byArray;
    }

    private static native boolean nativeGetRomClassCookie(long var0, long var2, String var4, byte[] var5);

    private static native long nativeRomImageLoad(long var0, ClassLoader var2, long var3, long var5);

    public static void romImageLoad(Jxe jxe, ClassLoader classLoader) throws JxeException {
        if (jxe.romSegmentPointer != 0L) {
            throw new JxeException(Msg.getString("K0228"));
        }
        long l = JxeUtil.nativeGetRomImagePointerFromJxePointer(jxe.getJxePointer());
        if (0L == l) {
            throw new JxeException(Msg.getString("K01a1"));
        }
        long l2 = JxeUtil.nativeRomImageLoad(l, classLoader, jxe.getJxePointer(), jxe.getJxeAlloc());
        if (0L == l2) {
            throw new JxeException(Msg.getString("K01a2"));
        }
        jxe.romSegmentPointer = l2;
    }

    private static native int nativeRelocateJxeInPlace(long var0);

    static void relocateJxeInPlace(long l) throws JxeException {
        int n = JxeUtil.nativeRelocateJxeInPlace(l);
        if (n != 0) {
            throw JxeException.jxeExceptionFromRelocationReturnCode(n);
        }
    }

    private static native int nativeRelocateJxeStreaming(InputStream var0, JxeOutputStream var1, int var2, int var3, long var4);

    public static void relocateJxeStreaming(InputStream inputStream, JxeOutputStream jxeOutputStream, int n, int n2, long l) throws JxeException {
        int n3 = JxeUtil.nativeRelocateJxeStreaming(inputStream, jxeOutputStream, n, n2, l);
        if (n3 != 0) {
            throw JxeException.jxeExceptionFromRelocationReturnCode(n3);
        }
    }

    private static native String nativeGetEnvironmentVariable(String var0);

    public static String getEnvironmentVariable(String string) {
        return JxeUtil.nativeGetEnvironmentVariable(string);
    }

    private static native int nativeVerifyJxe(long var0);

    public static void verifyJxe(long l) throws JxeException {
        int n = JxeUtil.nativeVerifyJxe(l);
        if (n != 0) {
            throw JxeException.jxeExceptionFromRelocationReturnCode(n);
        }
    }

    private static native int nativeGetCurrentRomImageVersion();

    public static long getCurrentRomImageVersion() {
        return JxeUtil.nativeGetCurrentRomImageVersion();
    }

    private static native int nativeGetLowestRomImageVersion();

    public static long getLowestRomImageVersion() {
        return JxeUtil.nativeGetLowestRomImageVersion();
    }

    public static native String[] nativeGetClassList(byte[] var0);

    public static String[] getClassList(String string) {
        byte[] byArray = Util.getBytes(string);
        return JxeUtil.nativeGetClassList(byArray);
    }

    static boolean registerJxe(Jxe jxe) {
        long l = JxeUtil.nativeGetRomImagePointerFromJxePointer(jxe.getJxePointer());
        if (0L == l) {
            return false;
        }
        JxeUtil.nativeRegisterJxe(l, jxe.getJxePointer(), jxe.getJxeAlloc());
        return true;
    }

    static native void nativeRegisterJxe(long var0, long var2, long var4);

    static boolean unregisterJxe(Jxe jxe) {
        long l = JxeUtil.nativeGetRomImagePointerFromJxePointer(jxe.getJxePointer());
        if (0L == l) {
            return false;
        }
        JxeUtil.nativeUnregisterJxe(l);
        return true;
    }

    static native void nativeUnregisterJxe(long var0);
}

