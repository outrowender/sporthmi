/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.os;

public class OS {
    private static OS instance;
    private static boolean libLoadingSuccessful;

    private OS() {
    }

    public static synchronized OS getInstance() {
        if (libLoadingSuccessful && instance == null) {
            instance = new OS();
        }
        return instance;
    }

    public native int kill(long var1, int var3);

    public native long getpid();

    public native int createKernelUserEvent(String var1);

    public native int createKernelUserEvent(int var1, String var2);

    public native int createKernelUserEvent(int var1, byte[] var2);

    public native boolean pinThread(int var1);

    public native long sum(long var1);

    static {
        try {
            System.loadLibrary("jni_fw_util_os");
            libLoadingSuccessful = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            System.out.println("Native Library not found: fw_util_os");
            libLoadingSuccessful = false;
        }
    }
}

