/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tools.profiling;

public final class NativeProfAdapter {
    private static NativeProfAdapter instance;
    private static boolean libLoadingSuccessful;

    private NativeProfAdapter() {
    }

    public static synchronized NativeProfAdapter getInstance() {
        if (libLoadingSuccessful && instance == null) {
            instance = new NativeProfAdapter();
        }
        return instance;
    }

    native void createKernelUserEvent(String var1);

    native void createKernelUserEvent(int var1, String var2);

    static {
        try {
            System.loadLibrary("jprof");
            libLoadingSuccessful = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            System.out.println("Native Library not found.");
            libLoadingSuccessful = false;
        }
    }
}

